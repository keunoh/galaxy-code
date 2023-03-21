package com.kaltz.galaxy.service;

import com.kaltz.galaxy.config.AppConfig;
import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class MemberServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);

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