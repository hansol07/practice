package kh.promising.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.promising.dto.BoardDTO;
import kh.promising.dto.PageMaker;
import kh.promising.dto.PageVO;
import kh.promising.repository.BoardRepository;
import kh.promising.service.BoardService;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/board")
@Log
public class BoardController {

	@Autowired
	private BoardService service;
	@Autowired
	private BoardRepository repo;
	@GetMapping("/register")
	public void register(@ModelAttribute("dto")BoardDTO dto) {
		
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("dto")BoardDTO dto,RedirectAttributes rttr) {
		System.out.println(dto.getTitle());
		service.save(dto);
		rttr.addFlashAttribute("msg","suc");
		return "redirect:/board/list";
		
	}
	@GetMapping("/list")
	public void list(PageVO pvo,Model model) {
		Pageable page= pvo.makePageable(0, "bno");
		Page<BoardDTO> result = repo.findAll(repo.makePredicate(pvo.getType(), pvo.getKeyword()),page);
		model.addAttribute("result",new PageMaker(result));


	}
		
	@PostMapping("/delete/{bno}")
	public String delete(@PathVariable("bno") Long bno) {
		System.out.println(bno);
		service.deleteById(bno);
		return "redirect:/board/list";
	}
	@GetMapping("/detail/{bno}")
	public String detail(@PathVariable("bno") Long bno,Model model) {
		System.out.println(bno);
	
		 BoardDTO dto=service.findById(bno).get();
		 System.out.println(dto);
		 model.addAttribute("dto",dto);
		return "board/detail";
	}
	@GetMapping("/modify/{bno}")
	public String modify(@PathVariable("bno") Long bno,Model model) {
		 BoardDTO dto=service.findById(bno).get();
		 model.addAttribute("dto",dto);
		return "board/modify";
	}
	@PostMapping("/modify/{bno}")
	public String modifyProc(@PathVariable("bno") Long bno,@ModelAttribute("dto")BoardDTO dto,Model model) {
		service.save(dto);
		return "redirect:/board/detail/{bno}";
	}
}
	
