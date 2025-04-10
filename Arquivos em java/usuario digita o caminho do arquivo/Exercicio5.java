import java.io.File;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        

        System.out.println("INSIRA UM CAMINHO DE PASTA: "); ////   /workspaces/curso-java2/Excessao
        String strPath = sc.nextLine(); // usuario digita o caminho da pasta

        File caminho = new File(strPath); //passo o caminho da pasta 
        

        System.out.println("getName: " + caminho.getName()); // somente o nome do arquivo
        System.out.println("getParent: " + caminho.getParent()); // apenas o caminho sem o nome do arquivo
        System.out.println("getPath: " + caminho.getPath()); // caminho completo

        sc.close();
    }
    
}
