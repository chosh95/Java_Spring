package com.bs.lec21.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bs.lec21.member.Member;

@Repository
public class MemberDao implements IMemberDao {

	private String driver = "orale.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin@localhost:1521:xe";
	private String userid = "c##scott";
	private String userpw = "tiger";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private HashMap<String, Member> dbMap;
	
	public MemberDao() {
		//dbMap = new HashMap<String, Member>();
	}
	
	@Override
	public int memberInsert(Member member) {
		int result = 0;
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userid,userpw);
			String sql = "INSERT INTO member(memId,memPw,memMail) values (?, ?, ?)";
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2,member.getMemPw());
			pstmt.setString(3, member.getMemMail());
			result = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		//dbMap.put(member.getMemId(), member);
		
		return result;
		
	}

	@Override
	public Member memberSelect(Member member) {
		
		Member mem = dbMap.get(member.getMemId());
		return mem;
		
	}

	@Override
	public Member memberUpdate(Member member) {
		
		dbMap.put(member.getMemId(), member);
		return dbMap.get(member.getMemId());
		
	}

	@Override
	public Map<String, Member> memberDelete(Member member) {
		
		dbMap.remove(member.getMemId());
		return dbMap;
		
	}

}
