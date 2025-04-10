import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio2 {
    public static void main(String[] args) {
        String patch = "in.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(patch); //estabeleci uma sequencia de leitura a partir do arquivo que estiver no caminho patch
            br = new BufferedReader(fr); // instanciado a partir do file reader, deixa a leitura mais rapida e tem uma abstraçao maior

            String linha = br.readLine(); // o read line vai ler uma linha do arquivo se o arquivo ja estiver no final o read line vai retornar nulo 

            // enquanto esse linha for diferente de nulo
            while (linha != null) {
                System.out.println(linha); // imprime a linha lida na tela
                linha = br.readLine(); // novamente manda ler outra linha 

                
            }

        }

        catch(IOException e){
            System.out.println("ERRO " + e.getMessage());
        }

        finally{
            try{
                if (br != null) {
                    br.close(); 
                }
                if (fr != null) {
                    fr.close();   
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    
    }
    
}
