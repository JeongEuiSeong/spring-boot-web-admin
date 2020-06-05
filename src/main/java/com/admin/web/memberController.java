package com.admin.web;

import com.admin.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class memberController {

    private final MemberService memberService;

    @GetMapping("/ra/user")
    public String member(Model model)
    {
        model.addAttribute("member",memberService.findAllDesc());
        return "user";
    }


}
