package modeloDAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class DAO {  
     
  public Connection getConexao() throws SQLException {
        Connection conexao = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@200.132.53.144:1521/XEPDB1", "usr95", "usr95");
           
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("não foi possível conectar ao banco" + e.getMessage());
        }
        return conexao;
    }
}  

