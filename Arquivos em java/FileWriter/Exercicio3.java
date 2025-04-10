import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio3 {
    public static void main(String[] args) {
        String [] linhas = new String[] {"BOM DIA", "BOA TARDE", "BUON GIUORNO"};
        String path = "out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { // true faz com que apenas acrescente, inves de recriar

            for(String linha : linhas){ //para cada string linha contido no meu vetor linhas
                bw.write(linha); //vou escrever essa linha la no meu arquivo
                bw.newLine(); // quebra de linha
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

//criou o arquivo