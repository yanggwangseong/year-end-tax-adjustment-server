package com.seater.community.domain.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    @GetMapping
    public ResponseEntity<?> getMembers() {

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<?> getMember(@PathVariable Long memberId) {

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody Object memberRequest) {

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<?> updateMember(@PathVariable Long memberId,
            @RequestBody Object memberRequest) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable Long memberId) {

        return ResponseEntity.ok().build();
    }
}
