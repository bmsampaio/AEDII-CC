
//Arquivo ExemploArq02LeituraRaf
import java.io.*;

class ExemploArq02LeituraRaf {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");
        int inteiro = raf.readInt();
        double real = raf.readDouble();
        char caractere = raf.readChar();
        boolean boleano = raf.readBoolean();
        String str = raf.readLine();
        raf.close();
        System.out.println(inteiro + "" + real + "" + caractere + "" + boleano + "" + str);
    }
}
