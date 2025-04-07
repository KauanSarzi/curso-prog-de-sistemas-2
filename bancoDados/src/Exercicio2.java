import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercicio2 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.zcesyhesrgaysrlwrewz&password=evTw1ObbKmU9J2iF";
        try{
             int nroConta = 0;
             double saldo = 1110.0;
             Connection conexao = DriverManager.getConnection(URL); //CRIO A CONEXAO COM MEU BANCO DE DADOS/ INSTANCIEI UM OBJETO DO TIPO CONNECTION
             String sql = " INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)"; // INSERIR EM CONTAS (NRO CONTA, SALDO) O VALOR ("?" QUE FICA EM ABERTO PARA O USUARIO INSERIR)

             PreparedStatement st = conexao.prepareStatement(sql); //recebe a instruçao a ser executada
             st.setInt(1, nroConta); // vai entrar no lugar do 1 interrogção
             st.setDouble(2, saldo); // vai entrar no lugar do 2 interrogção

             int ret = st.executeUpdate(); // executa os comandos, ALTERA OS DADOS
             System.out.println("NUMERO DE REGISTROS INSERIDOS: " + ret);
        }
        catch(SQLException e){
            e.printStackTrace();
        }


        }
 }
    

