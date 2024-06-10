package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //드라이버 로드
            Class.forName("oracle.jdbc.OracleDriver");
            //연결설정
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url,"hr","1234");
        } catch (Exception e) {
            // 예외 처리 추가
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        } catch (Exception e) {
            // 예외 처리 추가
            e.printStackTrace();
        }
    }
    
    // 메서드 시그니처 변경
    public static void close(PreparedStatement stmt, Connection conn) {
        try {
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        } catch (Exception e) {
            // 예외 처리 추가
            e.printStackTrace();
        }
    }
}
