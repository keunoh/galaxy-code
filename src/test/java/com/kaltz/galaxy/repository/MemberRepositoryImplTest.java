package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.config.AppConfig;
import com.kaltz.galaxy.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryImplTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    @BeforeEach
    void beforeEach() {
        memberRepository.clear();
    }

    @Test
    void save() {

    }

    @Test
    void findAll() {


    }

    @Test
    void findOne() {
    }

    @Test
    void findByName() {
        //given
        Member member1 = new Member("James");
        Member member2 = new Member("Paul");
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        boolean doesNameExists = memberRepository.findByName("James");

        //then
        assertThat(doesNameExists).isTrue();
    }
}