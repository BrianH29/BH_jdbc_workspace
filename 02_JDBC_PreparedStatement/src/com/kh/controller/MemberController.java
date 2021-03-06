package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {

	/**
	 * 사용자가 회원 가입 요청시 실행되는 메소드 
	 * @param m --> 회원가입 입력한 회원 정보들이 다 담겨있는 객체 
	 */
	public void insertMember(Member m) {
		int result = new MemberDao().insertMember(m);
		
		if(result > 0) {	//성공 
			new MemberMenu().displaySuccess("성공적으로 회원 가입 되었습니다.");
		} else {
			new MemberMenu().displayFail("회원 가입 실패했습니다.");
		}
		
		
	} //e.insertMember
	
	public void selectList() {
		ArrayList<Member> list = new MemberDao().selectList();
		
		if(list.isEmpty()) { 
			new MemberMenu().displayNoData("파일이 없습니다.");
		}else {
			new MemberMenu().displayMemberList(list);
		}
	} // e.selectList
	
	public void searchById(String userId) {
		Member m = new MemberDao().searchById(userId);
		
		if(m == null) {
			new MemberMenu().displayFail("검색된 정보가 없습니다");
		}else {
			new MemberMenu().displayMember(m);
		}
		
	}//e.searchById
	
	public void searchByName(String keyword) {
		ArrayList<Member> list = new MemberDao().searchByName(keyword);
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("검색된 정보가 없습니다.");
		}else {
			new MemberMenu().displayMemberList(list);
		}
		
	} //e.searchByName
	
	public void updateMember(Member m) {
		int result = new MemberDao().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("정보 수정 성공했습니다.");
			
		} else {
			new MemberMenu().displayFail("정보 수정을 실패했습니다.");
		}
		
	}//e.updateMember
	
	public void deleteMember(String userId) {
		int result = new MemberDao().deleteMember(userId);
		
		if(result>0) {
			new MemberMenu().displaySuccess("회원 정보 삭제 성고했습니다.");
		}else {
			new MemberMenu().displayFail("회원 정보 삭제 실패했습니다.");
		}
			
		
	}
}






