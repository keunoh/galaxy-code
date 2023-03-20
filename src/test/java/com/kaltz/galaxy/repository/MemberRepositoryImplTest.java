package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryImplTest {

    MemberRepository memberRepository = new MemberRepositoryImpl();

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