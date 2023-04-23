package kr.ac.kopo.member.vo;

public class MemberVO {

	private String id;
	private String pass;
	private String name;
	private int bday;
	private String mail;
	private int phone;
	
	
	
	public MemberVO(String id2) {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBday() {
		return bday;
	}
	public void setBday(int bday) {
		this.bday = bday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public MemberVO(String id, String pass, String name, int bday, String mail, int phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.bday = bday;
		this.mail = mail;
		this.phone = phone;
	}
	public MemberVO() {
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", bday=" + bday + ", mail=" + mail
				+ ", phone=" + phone + ", getId()=" + getId() + ", getPass()=" + getPass() + ", getName()=" + getName()
				+ ", getBday()=" + getBday() + ", getMail()=" + getMail() + ", getPhone()=" + getPhone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public static int indexOf(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

		
	}
	

	
	
	
	




