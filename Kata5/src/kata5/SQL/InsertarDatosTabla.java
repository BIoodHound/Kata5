package kata5.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatosTabla {
    private Connection connect() {
        String url = "jdbc:sqlite:D:\\Users\\gonca\\Documents\\DB\\Kata5\\mail.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
    public void insert(String email){
        String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
