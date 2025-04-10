import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ProgramaArquivos {
    public static void main(String[] args) {
        File file = new File("in.txt");
        Scanner sc = null;

        try{
            sc = new Scanner(file); // fazendo o scanner ler o arquivo
            while (sc.hasNextLine()) {// hasnextline testa se ainda existe uma nova linha no arquivo
                System.out.println(sc.nextLine()); // se extistir essa proxima linha irei mandar imprimir essa linha
                
            }

            //se der algum erro de leitura ou qualquer coisa, e o sc.close estiver aqui o bloco try sera cortado e ira direto para o catch e o escaner não sera fechado
        }
        catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }

        finally{ // ocorre independente de qulaquer coisa
            if(sc != null){
              sc.close(); // interessante sempre fazer isso nesses casos
            }
        }  
        
    }
    
}
