import java.io.File;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("INSIRA UM CAMINHO DE PASTA: ");  /// /workspaces/curso-java2/Excessao
        String strPath = sc.nextLine(); // usuario digita o caminho da pasta

        File caminho = new File(strPath); //passo o caminho da pasta 

        File [] pastas = caminho.listFiles(File::isDirectory);    //isDirectory filtra a lista de pastas  
        System.out.println("PASTAS: ");

        for(File pasta : pastas ){  //para cada pasta na lista de pastas eu vou executar o codigo dentro do for
            System.out.println(pasta);

        }

        File [] arquivos = caminho.listFiles(File::isFile); // isFile filtra a lista de arquivos apenas
        System.out.println("ARQUIVOS: ");

        for(File arquivo : arquivos){ //para cada arquivo na lista de arquivos vai ser executado o codigo dentro do for(printar o arquivo)
            System.out.println(arquivo);
        }



        sc.close();


    }
}
