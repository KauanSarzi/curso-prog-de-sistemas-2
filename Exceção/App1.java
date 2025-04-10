import java.util.InputMismatchException;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            String [] vet = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vet[position]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("POSIÇÃO INVALIDA");   
        }
        catch(InputMismatchException e){
            System.out.println("ERRO NA ENTRADA DE DADOS");
        }
        
        System.out.println("FIM DO PROGRAMA!");
        sc.close();

    }
}