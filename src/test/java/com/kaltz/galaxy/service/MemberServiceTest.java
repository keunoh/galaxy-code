package com.kaltz.galaxy.service;

import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService = new MemberService(new MemberRepositoryImpl());

    @Test
    void join() {
        //given
        Member member1 = new Member("James");
        Member member2 = new Member("James");

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }
}