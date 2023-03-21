package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    List<Member> findAll();

    Member findOne(Long id);

    boolean findByName(String name);

    void clear();
}
