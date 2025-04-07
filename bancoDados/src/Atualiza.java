import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;

public class Atualiza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.zcesyhesrgaysrlwrewz&password=evTw1ObbKmU9J2iF";
        try{
            System.out.println("DIGITE O NUMERO DA CONTA");
            long nro = sc.nextLong();
            Connection conexao = DriverManager.getConnection(URL);
            String sql = "UPDATE contas SET nro_conta = ? where (valor = ?)";
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setLong(1, nro);

            int ret = st.executeUpdate();
            System.out.println(ret);

            conexao.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
    
}
