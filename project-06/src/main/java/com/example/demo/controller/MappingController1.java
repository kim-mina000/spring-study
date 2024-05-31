/*
 * package com.example.demo.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * @Controller // 컨트롤러로 지정 + 빈 생성해서 담기 (@Component 어노테이션이 포함되어있음) public class
 * MappingController1 {
 * 
 * // HTML문서 없이 메세지 바디에 데이터를 직접 담는 기능
 * 
 * @ResponseBody
 * 
 * // GET + localhost:8080/board
 * 
 * @RequestMapping(value = "/board", method = RequestMethod.GET) // value는 주소
 * method는 방식 GET -> 조회
 * 
 * @GetMapping("/board") 의미가 위와 같음 // RequestMapping(v1) GetMapptin(v2) 버전의 차이일
 * 뿐 같은 기능을 한다 public String list() { System.out.println("게시물 조회 . . ."); return
 * "ok"; } // 페이지에 응답할때 꼭 html파일로만 보내줘야하는것은 아님 해당 데이터를 html 혹은 json으로 보내줘도됨
 * 
 * // Post + localhost:8080/board
 * 
 * @ResponseBody
 * 
 * @PostMapping("/board") public String save() {
 * System.out.println("게시물 등록 . . ."); return "ok"; }
 * 
 * // Put + localhost:8080/board
 * 
 * @ResponseBody
 * 
 * @PutMapping("/board") public String modify() {
 * System.out.println("게시물 수정 . . ."); return "ok"; }
 * 
 * // Delete + localhost:8080/board // 주소는같아도 방식이 다르기 때문에 같은 주소를 사용할수있다
 * 
 * @ResponseBody
 * 
 * @DeleteMapping("/board") public String remove() {
 * System.out.println("게시물 삭제 . . ."); return "ok"; } }
 */