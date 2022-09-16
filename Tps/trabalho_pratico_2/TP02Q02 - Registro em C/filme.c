#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_FIELD_SIZE 100

typedef struct {
    char nome[MAX_FIELD_SIZE];
    char dataLancamento[MAX_FIELD_SIZE];
    char genero[MAX_FIELD_SIZE];
    char duracao[MAX_FIELD_SIZE];
    char tituloOriginal[MAX_FIELD_SIZE];
    char situacao[MAX_FIELD_SIZE];
    char idioma[MAX_FIELD_SIZE];
    float orcamento;
    int palavrasChave;
} Filme;

char *remove_line_break(char *line) {
    while (*line != '\r' && *line != '\n') line++;
    *line = '\0';
    return line;
}

char *freadline(char *line, int max_size, FILE *file) {
    return remove_line_break(fgets(line, max_size, file));
}

char *readline(char *line, int max_size) {
    return freadline(line, max_size, stdin);
}


void print_filme(Filme *filme) {
    printf("oi3");
    printf("%s %s %s %s %s %s %s %f %d\n",
        filme->nome,
        filme->tituloOriginal,
        filme->dataLancamento,
        filme->duracao,
        filme->genero,
        filme->idioma,
        filme->situacao,
        filme->orcamento,
        filme->palavrasChave
    );
}

// Retorna o tamanho em bytes de um arquivo.
long tam_arquivo(FILE *file) {
    fseek(file, 0L, SEEK_END);
    long size = ftell(file);
    rewind(file);
    return size;
}

// Retorna todo o conteúdo do arquivo numa string.
char *ler_html(char filename[]) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        fprintf(stderr, "Falha ao abrir arquivo %s\n", filename);
        exit(1);
    }
    long tam = tam_arquivo(file);
    char *html = (char *) malloc(sizeof(char) * (tam + 1));
    fread(html, 1, tam, file);
    fclose(file);
    html[tam] = '\0';
    return html;
}

/**
 * @brief Extrai os textos de uma tag html.
 * 
 * @param html Ponteiro para o caractere que abre a tag '<'.
 * @param texto Ponteiro para onde o texto deve ser colocado.
 * 
 * @return Ponteiro para o texto extraído.
 */
char *extrair_texto(char *html, char *texto) {
    printf("oi2.5");
    char *start = texto;
    int contagem = 0;
    while (*html != '\0') {
        if (*html == '<') {
            if (
                (*(html + 1) == 'p') ||
                (*(html + 1) == 'b' && *(html + 2) == 'r') ||
                (*(html + 1) == '/' && *(html + 2) == 'h' && *(html + 3) == '1') ||
                (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'h') ||
                (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'd')
            ) break;
            else contagem++;
        }
        else if (*html == '>') contagem--;
        else if (contagem == 0 && *html != '"') {
            if (*html == '&') html = strchr(html, ';');
            else if (*html != '\r' && *html != '\n') *texto++ = *html;
        }
        html++;
    }
    *texto = '\0';
    return *start == ' ' ? start + 1 : start;
}

/**
 * @brief Lê o HTML da série e popula os campos da struct.
 * 
 * @param filme Struct Filme que vai receber os dados.
 * @param html String contendo todo o HTML do arquivo.
*/
void ler_filme(Filme *filme, char *html) {
    printf("oi2");
    char texto[MAX_FIELD_SIZE];

    char *ptr = strstr(html, "<h1");
    extrair_texto(ptr, texto);

    char *parenteses_ptr = strchr(texto, '(');
    if (parenteses_ptr != NULL) *(parenteses_ptr - 1) = '\0';

    strcpy(filme->nome, texto);

    ptr = strstr(ptr, "class=\"release\"");
    strcpy(filme->dataLancamento, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "class=\"genres\"");
    strcpy(filme->genero, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "class=\"runtime\"");
    strcpy(filme->duracao, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Título original");
    strcpy(filme->tituloOriginal, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "<bdi>Situação</bdi>");
    strcpy(filme->situacao, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Idioma original");
    strcpy(filme->idioma, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Orçamento");
    sscanf(extrair_texto(ptr, texto), "%f", &filme->orcamento);

    ptr = strstr(ptr, "Palavras-chave");
    sscanf(extrair_texto(ptr, texto), "%d", &filme->palavrasChave);
}


#define MAX_LINE_SIZE 250
#define PREFIXO "tmp/filmes/"
// #define PREFIXO "../entrada e saida/tp02/filmes/"

int isFim(char line[]) {
    return line[0] == 'F' && line[1] == 'I' && line[2] == 'M';
}

int main() {
    printf(PREFIXO);
    Filme filme;
    size_t tam_prefixo = strlen(PREFIXO);
    char line[MAX_LINE_SIZE];

    strcpy(line, PREFIXO);
    readline(line + tam_prefixo, MAX_LINE_SIZE);

    while (!isFim(line + tam_prefixo)) {
        printf("cheguei");
        char *html = ler_html(line);
        ler_filme(&filme, html);
        //free(html);
        //print_filme(&filme);
        //readline(line + tam_prefixo, MAX_LINE_SIZE);
    }
printf(PREFIXO);
    return EXIT_SUCCESS;
}
