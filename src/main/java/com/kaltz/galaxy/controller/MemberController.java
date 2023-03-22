package com.kaltz.galaxy.controller;

import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.page.Pagination;
import com.kaltz.galaxy.page.PagingResponse;
import com.kaltz.galaxy.page.SearchDto;
import com.kaltz.galaxy.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMember(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/home";
    }

    @GetMapping("/members")
    public String list(SearchDto params,
                       Model model) {
        PagingResponse<Member> result = memberService.findMembers(params);

        List<Member> members = result.getList();
        Pagination pagination = result.getPagination();

//        model.addAttribute("members", members);
//        model.addAttribute("pagination", pagination);
        model.addAttribute("response", result);
        model.addAttribute("params", params);

        return "members/memberList";
    }
}
