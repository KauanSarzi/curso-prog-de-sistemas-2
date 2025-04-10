import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        metodo1();
          
        System.out.println("FIM DO PROGRAMA!");
       

    }

    public static void metodo1(){
        System.out.println("***INICIO DO METODO1***");
        metodo2();
        System.out.println("***FIM DO METODO1***");
        
    }


    public static void metodo2(){
        System.out.println("***INICIO DO METODO2***");
        Scanner sc = new Scanner(System.in);

        try{
            String [] vet = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vet[position]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("POSIÇÃO INVALIDA");  
            e.printStackTrace(); //imprime o tipo da exceção, a mensagem que gerou a exceção e a sequencia de chamadas que gerou a exceção. bom para saber oq acarretou a exceção e tratar
            sc.next();
        }
        catch(InputMismatchException e){
            System.out.println("ERRO NA ENTRADA DE DADOS");
        }

        sc.close();
        System.out.println("***FIM DO METODO2***");
    }

}
