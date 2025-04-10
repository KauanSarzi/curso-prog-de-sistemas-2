import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ProgramaFinally {
    public static void main(String[] args) {
        File file = new File("in.txt");
        Scanner sc = null;

        try{
            sc = new Scanner(file); // tento instanciar o scanner apontando para o arquivo file, se o arquivo não existir vai ter uma exceçao de arquivo nao encontrado
            while (sc.hasNextLine()) { // CASO O ARQUIVO EXISTA
                System.out.println(sc.nextLine()); // percorre as linhas do arquivo
            }
        }
        catch(FileNotFoundException e){
            System.out.println("ERRO ABRINDO O ARQUIVO: " + e.getMessage()); // caso o arquivo nao exista
        }
        finally {
            if (sc != null) {
                sc.close();   // fecha o scanner e consequentemente o arquivo       
            }
            System.out.println("BLOCO FINALLY EXECUTADO");
        }
    } 
}

/// CRIAR ARQUIVO .TXT