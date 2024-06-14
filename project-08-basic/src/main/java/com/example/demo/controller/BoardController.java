package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService service;

    // 메인화면
    @GetMapping("/main")
    public void main() {
    }

    // 목록화면
    @GetMapping("/list")
    public void list(@RequestParam(defaultValue ="0", name = "page") int page, Model model) {
    	// /board/list?page=0 기본값 defaultValue, "page"는 파라미터 이름
        Page<BoardDTO> list = service.getList(page);
        model.addAttribute("list", list);
        
        System.out.println("전체 페이지 수: " + list.getTotalPages());
        System.out.println("전체 게시물 수: "+list.getTotalElements());
        System.out.println("현재 페이지 번호: "+(list.getNumber()+1));
        System.out.println("페이지에 표시할 게시물 수: "+list.getNumberOfElements());
    }

    // 등록화면
    @GetMapping("/register")
    public void register() {
    }

    // 등록처리
    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
        int no = service.register(dto); 
        redirectAttributes.addFlashAttribute("msg", no);
        return "redirect:/board/list";
    }

    // 상세화면
    @GetMapping("/read")
    public void read(@RequestParam(name = "no") int no, 
    		@RequestParam(defaultValue ="0", name = "page") int page ,Model model) {
        BoardDTO dto = service.read(no);
        model.addAttribute("dto", dto);
        model.addAttribute("page", page); // 화면에 페이지 번호를 전달해서 modify 페이지에 갔다가 다시 나오더라도
        // 다시 그 페이지를 유지할수 있게끔 해주는 역할
    }

    // 수정화면
    @GetMapping("/modify")
    public void modify(@RequestParam(name = "no") int no, Model model) {
        BoardDTO dto = service.read(no);
        model.addAttribute("dto", dto);
    }

    // 수정처리
    @PostMapping("/modify")
    public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
        service.modify(dto);
        redirectAttributes.addAttribute("no", dto.getNo());
        return "redirect:/board/read";
    }

    // 삭제처리
    @PostMapping("/remove")
    public String removePost(int no) {
        service.remove(no);
        return "redirect:/board/list";
    }

}
