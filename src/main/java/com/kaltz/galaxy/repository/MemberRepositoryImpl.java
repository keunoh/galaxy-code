package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final static Map<Long, Member> store = new HashMap<>();

    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Member findOne(Long id) {
        return store.get(id);
    }

    @Override
    public boolean findByName(String name) {
        List<Member> result = findAll();

        for (Member member : result) {
            if (member.getName().equals(name))
                return true;
        }
        return false;
    }
}
