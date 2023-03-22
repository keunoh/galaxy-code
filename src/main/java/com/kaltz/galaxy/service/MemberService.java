package com.kaltz.galaxy.service;

import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.page.Pagination;
import com.kaltz.galaxy.page.PagingResponse;
import com.kaltz.galaxy.page.SearchDto;
import com.kaltz.galaxy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        if (memberRepository.findByName(member.getName()))
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    public PagingResponse<Member> findMembers(SearchDto params) {

        int count = memberRepository.getCount();
        log.debug("hashmap count : {}", count);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        System.out.println("pagination = " + pagination);

        List<Member> list = memberRepository.findAll(params);
        log.debug("paging list : {}", list);

        return new PagingResponse<>(list, pagination);
    }


}
