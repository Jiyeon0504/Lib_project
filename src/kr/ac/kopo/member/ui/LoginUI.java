package kr.ac.kopo.member.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.ac.kopo.book.ui.BookMainUI;
import kr.ac.kopo.util.ConnectionFactory;


public class LoginUI extends FoundationUI {
	static String loginId;

	@Override
	public void execute() throws Exception {

		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t    [로그인]");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("아이디를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM mem_table WHERE id = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");

				if (id.equals(Id)) {
					System.out.println("비밀번호를 입력하세요");
					String pass = sc.nextLine();

					String resultPass = rs.getString("pass");
					if (pass.equals(resultPass)) {
						System.out.println("로그인 성공");
						System.out.println("---------------------------------------------------------------------------------------------------------------");
						System.out.println("\t\t\t\t\t\t   ["+id+"님 환영합니다]");
						System.out.println("---------------------------------------------------------------------------------------------------------------");
						
						boolean login = true;
						loginId = id;
//						System.out.println(id);
						ILibraryUI ui = null;
						ui = new BookMainUI();
						ui.execute();

						
						
					} else {
						System.out.println("비밀번호가 틀렸습니다");
					
					}
				}
			}
			System.out.println("해당 사용자를 찾을 수 없습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	}




