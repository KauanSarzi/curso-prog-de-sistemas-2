import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class Deletar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.zcesyhesrgaysrlwrewz&password=evTw1ObbKmU9J2iF";
        
        try{
            System.out.println("DELETA A CONTA: ");
            long nro = sc.nextLong();
            Connection conexao = DriverManager.getConnection(URL); 
            String sql = "DELETE FROM contas WHERE nro_conta = ?"; //Instrução a ser executada

            PreparedStatement st = conexao.prepareStatement(sql); // recebe a instrução(sql) a ser executada

            st.setLong(1, nro); // O nro da conta indicado pelo usuario sera deletado , substitui o nro_conta= ?

            int ret = st.executeUpdate();

            System.out.println("CONTA DELETADA, quantidade de deletaçoes: "+ ret);

            conexao.close();
            sc.close();
            st.close();
            

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
