package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBConnection;
import vo.BoardVO;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public int deleteBoard(String seq) {
		int result = 0;
		try {
			//1. 2
			conn = DBConnection.getConnection();
			//3.
			String sql = "delete board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			//4.
			stmt.setString(1, seq);
			
			//5.
			result = stmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(stmt, conn);
		}
		return result;
	}
	
	public int addBoard(BoardVO vo) {
		int result = 0;
		try {
			//1. 2
			conn = DBConnection.getConnection();
			//3.
			String sql = "insert into board values( (select nvl(max(seq), 0)+1 from board),?,?,?,sysdate,0,?)";
			stmt = conn.prepareStatement(sql);
			
			//4.
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getNickname());
			stmt.setString(3, vo.getContent());
			stmt.setString(4, vo.getUserid());
			
			//5.
			result = stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(stmt, conn);
		}
		return result;
	}
	
	public int updateBoard(BoardVO vo) {
		int result = 0;
		
		//DBdptj seq에 해당하는 자료 수정
		try {
			//1. 2
			conn = DBConnection.getConnection();
			//3.
			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			//4.
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getSeq());
			
			//5.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(stmt, conn);
		}
		
		return result;
	}
	public BoardVO getBoard(String seq) {
		BoardVO vo = null;
		
		try {
			//1.2
			conn = DBConnection.getConnection();
			//3.
			//조회시
			String sql = "update board set cnt = cnt + 1 where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, seq);
			
			stmt.executeUpdate();
			stmt.close();
			
			sql = "select * from board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			//4.
			stmt.setString(1, seq);
			
			//5.
			rs =stmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNickname(rs.getString("nickname"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, stmt, conn);
		}
		
		return vo;
	}

	public ArrayList<BoardVO> getBoardList(String searchCondition, String searchKeyword) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			// 1. 2
			conn = DBConnection.getConnection();
			// 3.질의문 준비
			String sql;
			if (searchCondition == "TITLE")
				sql = "select * from board where title like '%'||?||'%' order by seq desc";
			else
				sql = "select * from board where content like '%'||?||'%' order by seq desc";
			stmt = conn.prepareStatement(sql);
			
			//4.질의문 세팅
			stmt.setString(1, searchKeyword);
			
			//5.질의문 실행
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNickname(rs.getString("nickname"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setUserid(rs.getString("userid"));
				
				list.add(vo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	finally {
			//6.닫기
			DBConnection.close(rs, stmt, conn);
		}
		return list;
	}
}
