package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.service.MemberServiceFactory;
import kr.ac.kopo.member.ui.FoundationUI;


public class viewPersonal extends FoundationUI {
	
	private MemberService memberService;

	public viewPersonal() {
			memberService = MemberServiceFactory.getInstance();
		}
	
	@Override
	public void execute() throws Exception {

	System.out.print("확인을 위해 비밀번호를 입력해주세요: ");
	Scanner sc = new Scanner(System.in);
	String pass = sc.nextLine();
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT * FROM mem_table WHERE pass = ?");
	
	

	
	
	}

}
