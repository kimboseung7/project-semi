package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.BoardService;
import com.example.demo.dto.BoardDTO;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService service;

	@GetMapping("/main")
	public void main() {

	}
	@GetMapping("/add")
	public void register() {
		
	}
	// 등록처리
	@PostMapping("/add")
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		int no = service.register(dto);
		redirectAttributes.addFlashAttribute("msg",no);
		return "redirect:/board/main";
		
	}
	
}