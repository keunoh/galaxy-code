package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.page.SearchDto;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    List<Member> findAll();

    List<Member> findAll(SearchDto params);

    Member findOne(Long id);

    int getCount();

    boolean findByName(String name);

    void clear();
}
