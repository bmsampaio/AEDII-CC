class ExemploArq03Exercicio {
    public static void main(String[] args) {
        Arq.openRead("exemplo.txt");
        String str = "";
        str = Arq.readAll();
        Arq.close();
        Arq.openWrite("copia.txt");
        Arq.print(str);
        Arq.close();
    }
}