public class teste {
     // funcao para encontrar o menor valor de um array
    // retorna o menor valor
    public static int minimo(int array[]) {
        int n = array.length;
        int min = array[0];
        for (int i = 1; i < n; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
    // funcao para encontrar o maior valor de um array
    // retorna o maior valor
    public static int maximo(int array[]) {
        int n = array.length;
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {3,7,9,12,2,5};
        System.out.println(minimo(array) + "," + maximo(array));
    }// end main
}
