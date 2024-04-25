package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;
import vo.UserVO;

public class UserDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	public UserVO getUser(String id, String password) {
		UserVO vo = null;
		try {
			conn = DBConnection.getConnection();
			//3. 질의문 준비
			String sql = "select * from users where id = ? and password =?";
			stmt = conn.prepareStatement(sql);
			//4. 질의문 세팅
			stmt.setString(1, id);
			stmt.setString(2, password);
			//5. 질의문 실행 
			rs = stmt.executeQuery();
			if(rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setRole(rs.getString("role"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBConnection.close(rs, stmt, conn);
		}
		return vo;
	}
}
