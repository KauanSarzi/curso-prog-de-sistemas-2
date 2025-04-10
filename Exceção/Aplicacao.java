import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Aplicacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        
        try{
            System.out.print("NUMERO DO QUARTO: ");
            int numeroQuarto = sc.nextInt();

            System.out.print("DATA DE CHECK-IN (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("DATA DE CHECK-OUT (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);  // instancio a reserva com a coleta dos dados
            System.out.println("RESERVA: " +reserva);


            System.out.println();
            System.out.println("INSIRA OS DADOS PARA ATUALIZAR A RESERVA: ");
            System.out.print("DATA DE CHECK-IN (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.print("DATA DE CHECK-OUT (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizacaoDatas(checkIn, checkOut);
            System.out.println("RESERVA: " +reserva);
        }
        catch(ParseException e){ 
            System.out.println("FORMATO DE DATA INVALIDO");
        }
        catch(DomainException e){
            System.out.println(e.getMessage()); /// mostro a msg do throw instanciado na classe reserva, atualizacaoDatas.
        }  

        sc.close();
    }
    
}