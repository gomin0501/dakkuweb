package com.shop.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("userId")
public class LoginController {

    private final MemberRepository repository;

    public LoginController(MemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/members/login")
    public String loginForm() {
        return "members/login";
    }

    @PostMapping("/members/login")
    public String login(@RequestParam(name="userId") String userId,
                        @RequestParam(name="password") String password,
                        Model model,
                        HttpSession session) {
        DakkuMember member = repository.findByuserId(userId);
        if (member != null && member.getPassword().equals(password)) {
            session.setAttribute("userId", userId);
            return "redirect:/";
        } else {
            model.addAttribute("error", true);
            return "members/login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
    	//세션의 사용자 정보 삭제
    	status.setComplete();
    	
    	return "redirect:/";
    }
}
