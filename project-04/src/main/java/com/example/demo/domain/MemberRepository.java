package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 가짜 저장소 만들기
public class MemberRepository {

	// 회원 목록을 저장할 Map
	static  Map<Integer,Member> store = new HashMap<>();
	
	// 새로운 회원 번호를 발급하기 위한 시퀀스
	static int sequence = 0;

	// 새로운 회원을 등록하는 메소드
	public Member save(Member member) {
		member.setNo(++sequence);
		store.put(member.getNo(), member);
		
		return member;
		}
	
	// 회원 단건 조회 메소드
    public Member findById(int id) {
        return store.get(id);
    }
	
	// 회원 목록 조회
	public List<Member> findAll() {
		return new ArrayList<>(store.values()); // map을 List로 변환
	}
	
	// 회원 전체 삭제
	public void clearStore() {
		store.clear();
	}
	
}

