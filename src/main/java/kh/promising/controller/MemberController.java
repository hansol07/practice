package kh.promising.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.promising.dto.MemberDTO;
import kh.promising.dto.MemberRole;
import kh.promising.repository.MemberRepository;
import lombok.extern.java.Log;
@Log
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private PasswordEncoder pwEncoder;
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/signup")
	public void signup() {
		}
	@Transactional
	@PostMapping("/signup")
	public String join(MemberDTO dto) {
		MemberRole role = new MemberRole();
		role.setRoleName("BASIC");
		dto.setRoles(Arrays.asList(role));
		dto.setPassword(pwEncoder.encode(dto.getPassword()));
		log.info("member"+dto);
		log.info("pw :"+ dto.getPassword());
		memberRepository.save(dto);
		return "redirect:/";
	}
}
