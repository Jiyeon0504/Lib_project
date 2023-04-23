package kr.ac.kopo.member.ui;

import java.util.Scanner;

public abstract class  FoundationUI implements ILibraryUI{

	private Scanner sc;
	static boolean login = false;
	protected String loginId;
	
	public FoundationUI() {
		sc = new Scanner(System.in);
	}
	
	protected int scanInt(String msg) {
		System.out.println(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	
	}
	
}
