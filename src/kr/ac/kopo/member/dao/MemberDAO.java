package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.util.ConnectionFactory;


public class MemberDAO {

	private List<MemberVO> memberList;

	public static void insertMember(MemberVO member) {
		 StringBuilder sql = new StringBuilder();
		 sql.append("insert into  mem_table(id, pass, name, bday, mail, phone)");
		 sql.append(" values(?, ?, ?, ?, ?, ?) ");
		
		 try(
				 Connection conn = new ConnectionFactory().getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				 ) {
			 pstmt.setString(1, member.getId());
			 pstmt.setString(2, member.getPass());
			 pstmt.setString(3, member.getName());
			 pstmt.setInt(4, member.getBday());
			 pstmt.setString(5, member.getMail());
			 pstmt.setInt(6, member.getPhone());
			 
		 	pstmt.executeUpdate();   //종료메소드 자동호출해서 close쓸 필요없음
		} catch (Exception e) {
			e.printStackTrace();
		
	}
	}
	
	
public List<MemberVO>selectAllmember(){
		
		List<MemberVO> boardList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
	      sql.append("select no, title, writer ");
	      sql.append(" , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	      sql.append("  from t_board ");
	      sql.append(" order by no desc");
		
//		String sql = "select * from t_board ";
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			)
		{
			ResultSet rs = pstmt.executeQuery();    //resultset 리턴이 필요함
			while(rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int bday = rs.getInt("bday");   
				String mail = rs.getString("mail");   
				int phone = rs.getInt("phone");   
//				String regDate = rs.getString("4");  4번째꺼 가져와
			
//				BoardVO board = new BoardVO(no,title,writer,regDate);
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPass(pass);
				member.setName(name);
				member.setBday(bday);
				member.setMail(mail);
				member.setPhone(phone);
//				System.out.println(board);
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return memberList;
	
	}
	
	
	
	
	public MemberVO selectMemberByID(String m_id){
			MemberVO member = null;
		
			StringBuilder sql = new StringBuilder();
		    sql.append("select id, pass, name, bday, mail, phone ");
		    sql.append("  from mem_table ");
		    sql.append(" where id = ? ");
		
	      
	      try (    		  
	    		  Connection conn = new ConnectionFactory().getConnection();
	    		  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    		  ResultSet rs = pstmt.executeQuery();   
	    	  )
	      {
				while(rs.next()) {
					String id = rs.getString("id");
					String pass = rs.getString("pass");
					String name = rs.getString("name");
					int bday = rs.getInt("bday");   
					String mail = rs.getString("mail");
					int phone = rs.getInt("phone");   
				
					member = new MemberVO(id, pass, name, bday, mail, phone);
					
				
	    	  
	    	  
				}
	    	  
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return member;
	      
	}
}
