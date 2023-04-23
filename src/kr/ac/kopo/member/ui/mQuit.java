package kr.ac.kopo.member.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.service.MemberServiceFactory;
import kr.ac.kopo.util.ConnectionFactory;

public class mQuit extends LibraryModeUI {

private MemberService memberService;
	
	public mQuit() {
		
		memberService = MemberServiceFactory.getInstance();
	}
	
	
	@Override
	public void execute() throws Exception {
		
		System.out.println("아이디를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM mem_table WHERE id = ?");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
	            String Id = rs.getString("id");
				
				if (id.equals(Id)) {
					System.out.println("비밀번호를 입력하세요");
					 String pass1= sc.nextLine();
		             String resultPass = rs.getString("pass");
		             
		             if (!pass1.equals(resultPass)) {
		                 System.out.println("비밀번호가 틀렸습니다.");
		                 return;
		             }
		             
		             System.out.println("비밀번호를 한 번 더 입력하세요.");
		             String pass2 = sc.nextLine();
		             
		             if (pass1.equals(pass2)) {
		            	 // 비밀번호가 일치할 경우 삭제 작업 수행
		            	 sql = new StringBuilder();
		            	 sql.append("DELETE FROM mem_table WHERE id = ?");
		                 try (PreparedStatement pstmt2 = conn.prepareStatement(sql.toString())) {
		                     pstmt2.setString(1, id);
		                     pstmt2.executeUpdate();
		                     System.out.println("탈퇴되었습니다");
		                     System.out.println("감사합니다");
		                     super.execute();
		     				break;
		                 }
		                }
		                else {
		                    System.out.println("비밀번호가 일치하지 않습니다");
		                    return;
		                }
		            }
		        }
					System.out.println("해당 사용자를 찾을 수 없습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

}
