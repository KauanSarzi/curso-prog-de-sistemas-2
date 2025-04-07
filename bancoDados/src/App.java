import java.sql.*;

public class App{
    static final String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.zcesyhesrgaysrlwrewz&password=evTw1ObbKmU9J2iF";
   
  
    public static void main(String[] args) {
        
        try{

            Connection conexao = DriverManager.getConnection(URL); //CRIO A CONEXAO COM MEU BANCO DE DADOS/ INSTANCIEI UM OBJETO DO TIPO CONNECTION
            String sql = "SELECT * FROM contas"; // COMANDO SQL
            PreparedStatement st = conexao.prepareStatement(sql);// INSIRO O COMANDO/INSTRUÇÃO SQL
            ResultSet rs = st.executeQuery(); //executa a instruçao sql

            while (rs.next()) { //enquanto existir o proximo (nao for false) executa o comando dentro do laço
                System.out.println(rs.getString("nro_conta")); //print nos nro_conta da tabela
                
            }

            conexao.close();
            st.close();
            rs.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    } 
}