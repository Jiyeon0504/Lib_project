package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDao;
	
	public MemberService() {
		memberDao = new MemberDAO();
		
	}
	
	public List<MemberVO> memberAll(){
		List<MemberVO> memberList = memberDao.selectAllmember();
		
		return memberList;
		
	}
	
	
	
	public void insertMember(MemberVO member) {
		MemberDAO.insertMember(member);
	}


}
