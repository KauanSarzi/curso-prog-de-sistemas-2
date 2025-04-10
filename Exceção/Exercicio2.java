import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        String msg;
        double[] notas = {8.5, 7.5, 9.53};
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Qual nota deseja consultar? (0, 1 ou 2): ");
            String s = scanner.nextLine();

            int i = Integer.parseInt(s);
            double n = notas[i];
            msg = "Nota: " + n;
            System.out.println(msg);
        }


        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("VALOR INVALIDO");
        }
        catch(NumberFormatException e){
            System.out.println("POR FAVOR, DIGITE APENAS NUMEROS");
        }
        

        scanner.close();
    }
}
