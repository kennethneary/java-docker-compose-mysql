package com.example.members.controllers;

import com.example.members.models.Member;
import com.example.members.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public List<Member> all() {
        return this.memberService.getAllMembers();
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@Valid @RequestBody final Member member) {
        return ResponseEntity.ok(this.memberService.saveMember(member));
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@Valid @RequestBody final Member member,
                                               @PathVariable final Long id) {
        return ResponseEntity.ok(this.memberService.updateMember(member, id));
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable final Long id) {
        final Member member = this.memberService.getMember(id);
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/members/email/{email}")
    public ResponseEntity<Member> updateMember(@PathVariable final String email) {
        final Member member = this.memberService.findMemberByEmail(email);
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable final Long id) {
        if (this.memberService.deleteMember(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/members/email/{email}")
    public ResponseEntity<?> deleteMemberByEmail(@PathVariable final String email) {
        if (this.memberService.deleteMemberWithEmail(email)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}