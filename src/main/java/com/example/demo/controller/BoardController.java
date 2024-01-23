package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	//목록화면
		@GetMapping("/list")
		public void list(Model model) {
			List<BoardDTO> list = service.getList();
			model.addAttribute("list", list);
		}
		
	// 등록처리
		@PostMapping("/add")
		public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		    int no = service.register(dto);
		    redirectAttributes.addFlashAttribute("msg", no);
		    return "redirect:/board/list";
		}
		@GetMapping("/modify")
		void modify(@RequestParam(name="no") int no, Model model) {
			BoardDTO dto = service.read(no);
			
			model.addAttribute("dto", dto);
		}
		
		@PostMapping("/modify")
		public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
			//게시물 수정
			service.modify(dto);
			// 리다이렌트 주소에 파라미터 추가 (?no=1)
			redirectAttributes.addAttribute("no", dto.getNo());
			// 상세화면으로 이동
			return "redirect:/board/list";
		}

}