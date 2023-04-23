package kr.ac.kopo.member.ui;

import java.util.Scanner;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.service.MemberServiceFactory;
import kr.ac.kopo.member.vo.MemberVO;

public class mJoin extends FoundationUI {

private MemberService memberService;
	
	public mJoin() {
		
		memberService = MemberServiceFactory.getInstance();
	}
	
	
	@Override
	public void execute() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String id = null;
		System.out.println("ID: ");
		id = sc.nextLine();
		

		System.out.println("psssword: ");
		String pass = sc.nextLine();

		System.out.println("이름: ");
		String name = sc.nextLine();

		System.out.println("생년월일 6자: ");
		int bday = sc.nextInt();
		sc.nextLine();

		System.out.println("메일: ");
		String mail = sc.nextLine();
		
		
		System.out.println("연락처: ");
		int phone = sc.nextInt();
		
				
		MemberVO member  = new MemberVO();
		
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setBday(bday);
		member.setMail(mail);
		member.setPhone(phone);
		
		memberService.insertMember(member);
		System.out.println("회원등록이 완료되었습니다");
		
		
	}

}
