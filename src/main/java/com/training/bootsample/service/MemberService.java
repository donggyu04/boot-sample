package com.training.bootsample.service;

import com.training.bootsample.entity.Member;
import com.training.bootsample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void testTransaction() {
        Member member = new Member();
        member.setAge(20);
        member.setName("tester");
        memberRepository.save(member);

        try {
            throwRuntimeException();
        } catch (Exception e) {
            log.info("Catch exception, rollback some task", e);
            throw new RuntimeException(e);
        }
    }

    private void throwRuntimeException() {
        throw new RuntimeException("Runtime exception");
    }
}
