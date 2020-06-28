package com.example.members.services;

import com.example.members.models.Member;

import java.util.List;

public interface MemberService {
    public Member findMemberByEmail(String email);
    public List<Member> getAllMembers();
    public Member getMember(Long id);
    public Member saveMember(Member member);
    public Member updateMember(Member member, Long id);
    public Boolean deleteMember(Long id);
    public Boolean deleteMemberWithEmail(String email);
}