package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBConnection;
import vo.BoardVO;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement stmt =null;
	ResultSet rs =null;
	public ArrayList<BoardVO> getBoardList(String searchCondition, String searchKeyword){
		ArrayList<BoardVO> list = null;
		
		try {
			//1. 2
			conn = DBConnection.getConnection();
			//3.질의문 준비
			String sql;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
