package com.shop.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired MemberRepository repository;
	


	@GetMapping(value="/members/new")
	public ModelAndView members1(
	  @ModelAttribute("memberForm") DakkuMember member, ModelAndView mav) {
	  mav.setViewName("members/createMemberForm");
	  mav.addObject("msg","sample content"); Iterable<DakkuMember> list =
	  repository.findAll(); mav.addObject("datalist",list); return mav; }
	 

	
	 @PostMapping(value="/members/new")
	  
	  @Transactional(readOnly=false)
	 public String members(@Valid @ModelAttribute("memberForm") 
	 DakkuMember member,Errors errors) { 
		 if(errors.hasErrors()) { 
			 return "members/createMemberForm"; }
	  LocalDateTime now = LocalDateTime.now(); 
	  member.setTimestamp(now);
	  repository.saveAndFlush(member); 
	  return "redirect:/"; 
	  }
	 

}
