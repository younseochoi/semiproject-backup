package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	//member 테이블 crud 
	public int selectMember(String id,String userpassword) {
		Connection conn= null;
		int condition = 0;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2"); //메모리 많이 차지 
		 
		 String sql = "select id, password from member where id = ? ";
		 PreparedStatement pt = conn.prepareStatement(sql);
		 pt.setString(1, id);
		 ResultSet rs = pt.executeQuery();
		 
		 String dbid = null, dbpassword=null;
		 if(rs.next()) {
			 condition =1;// id 존재한다.
			 dbid = rs.getString("id");
			 dbpassword = rs.getString("password");
			 if(dbpassword.equals(userpassword)) { //비밀 번호 일치 
				condition = 2;
			 }
		 }else { //id 존재하지 않음 .
			 condition = 3;
		 }
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close(); //메모리 정리시간 
			}catch(SQLException e) {
				
			}
		}
		 return condition;
	} //select member end
	
	public int insertMember(MemberDTO dto) {
		Connection conn= null;
		int condition = 0; //insert한 행의 개수 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
		 
//		 dto값 getter, regdate now(), 
		 //String sql = "insert into member values('"+dto.getId()+"',"+dto.getPassword()+",'"+dto.getName()+"','"+dto.getPhone()+"','"+dto.getEmail()+"',now());";
		 String sql = "insert into member values(?,?,?,?,?,now())";
		 PreparedStatement pt = conn.prepareStatement(sql);
		 pt.setString(1, dto.getId());
		 pt.setInt(2, dto.getPassword());
		 pt.setString(3,dto.getName());
		 pt.setString(4, dto.getPhone());
		 pt.setString(5, dto.getEmail());
		 
		 condition = pt.executeUpdate();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
		 return condition;
	
	} //insert member end



	
	public int deleteMember(String id, String pw) {
		Connection conn= null;
		int condition = 0; //delete한 행의 개수 
		try {
	
		// 1. context.xml 파일 정의 내용 읽어올 준비 
		Context initContext = new InitialContext();
						
		//2. <Resourse 이름 설정 태그 읽어와 - 항상 고정 
		Context envContext = (Context) initContext.lookup("java:/comp/env") ; //java - component -  environment
						
		//3. jdbc/mydb 설정 태그만 읽어와 connection pooling 클래스 객체 생성 
		// tomcat 시작 미리 생성 - 배열 형태 관리 반납 - 빌려주고 반납 
		DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");	
		conn = ds.getConnection();
			
		 String sql = "delete from member where id=? and password=?";
		 PreparedStatement pt = conn.prepareStatement(sql);
		 pt.setString(1,id);
		 pt.setInt(2, Integer.parseInt(pw));

		 condition = pt.executeUpdate();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
		 return condition;
	
	} //insert member end

}
