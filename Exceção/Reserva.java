import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;



public class Reserva {
        private Integer numeroQuarto;
        private Date checkIn;
        private Date checkOut;

        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut){
            this.numeroQuarto = numeroQuarto;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
             
        }
        public Integer getNumeroQuarto() {
            return numeroQuarto;
        }
    
        public void setNumeroQuarto(Integer numeroQuarto) {
            this.numeroQuarto = numeroQuarto;
        }
    
        public Date getCheckIn() {
            return checkIn;
        }
    
        public Date getCheckOut() {
            return checkOut;
        }

        public long duracao(){
            long diferenca = checkOut.getTime() - checkIn.getTime(); // DIFERENÇA ENTRE AS DATAS EM MILI SEGUNDOS
            return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
        }

        public void atualizacaoDatas(Date checkIn, Date checkOut) throws DomainException{ //PROPAGUEI A EXCEÇÃO AQUI NA ASSINATURA DO METODO, SE TORNANDO UM METODO QUE PODE LANÇAR UMA EXCEÇÃO
            Date now = new Date(0);
            
            if(checkIn.before(now) || checkOut.before(now)){ // datas antes da data atual
               throw new DomainException("DATAS DE RESERVA PARA ATUALIZAÇÃO DEVEM SER DATAS FUTURAS"); //instancio uma exceção com essa mensagem para funcionar como um if else quase mas se a cond nao for verdadeia ira gerar um erro real
            }
            if (!checkOut.after(checkIn)) {
                throw new DomainException("DATA DE CHECK-OUT DEVEM SER DEPOIS DA DATA DE CHECK-IN");
                
            }
            this.checkIn = checkIn; //checkin do meu objeto recebe o checkin que veio como argumento do metodo
            this.checkOut = checkOut; // MESMA COISA QUE EM CIMA
        
            // SE PASSAR PELOS DOIS IFS ELE NAO DARA NENHUMA EXCEÇÃO E IRA PULAR PARA O METODO ABAIXO
        }

        @Override
        public String toString(){
            return "QUARTO " + numeroQuarto + ", CHECK-IN: " + sdf.format(checkIn) + ", CHECK-OUT: " + sdf.format(checkOut) + ","  + duracao() + " noites";
        }
    
    
        
}