package com.example.members.services;

import com.example.members.models.Member;
import com.example.members.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member findMemberByEmail(final String email) {
        return memberRepository.findByEmail(email).orElse(null);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(final Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member saveMember(final Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(final Member member, final Long id) {
        final Member updateMember = this.getMember(id);
        if (updateMember == null) {
           return null;
        }
        updateMember.setFirstName(member.getFirstName());
        updateMember.setLastName(member.getLastName());
        updateMember.setEmail(member.getEmail());
        final Member objMember = memberRepository.save(updateMember);
        return objMember;
    }

    public Boolean deleteMember(final Long id) {
        final Member delMember = memberRepository.findById(id).orElse(null);
        if (delMember != null) {
            memberRepository.delete(delMember);
            return true;
        }
        return false;
    }

    public Boolean deleteMemberWithEmail(final String email) {
        final Member delMember = memberRepository.findByEmail(email).orElse(null);
        if (delMember != null) {
            memberRepository.delete(delMember);
            return true;
        }
        return false;
    }
}
