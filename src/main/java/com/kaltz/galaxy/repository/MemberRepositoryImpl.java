package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.page.SearchDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Member> findAll(SearchDto params) {
        int pageSize = params.getPageSize();
        int pageNumber = params.getPage();

        ArrayList<Member> members = new ArrayList<>(store.values());
        List<Member> pageMembers = members.subList((pageNumber - 1) * pageSize, Math.min(pageNumber * pageSize, members.size()));

        return pageMembers;
    }

    public int getCount() {
        return store.keySet().size();
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

    @Override
    public void clear() {
        store.clear();
    }
}
