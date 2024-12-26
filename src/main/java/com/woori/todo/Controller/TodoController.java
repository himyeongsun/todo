package com.woori.todo.Controller;

import com.woori.todo.DTO.TodoDTO;
import com.woori.todo.Service.TodoService;
import com.woori.todo.Util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TodoController {
    //컨트롤러는 서비스에 작업지시
    private final TodoService todoService;

    /*----------------------------
    함수명 : String aForm(Pageable pageable, Model model)
    맵핑 : get(/a)
    인수 : 데이터를 조회할 페이지 번호
    결과 : list페이지
    설명 : 페이지번호를 받아서 해당페이지의 데이터를 조회해서 목록페이지로 전달
    ------------------------------*/
    //페이지번호가 생략되었을 때 기본 1페이지로 설정
    @GetMapping("/a")
    public String listForm(@PageableDefault(page=1)Pageable pageable, Model model) {
        //해당페이지의 내용을 서비스를 통해 데이터베이스로 부터 조회
        Page<TodoDTO> todoDTOS = todoService.a(pageable);

        //사용자 클래스에서 페이지정보를 보내서 HTML에 필요한 페이지정보를 받는다.
        Map<String, Integer> pageInfo = PaginationUtil.Pagination(todoDTOS);

        model.addAttribute("list", todoDTOS);
        //Map은 변수, 값....클래스가 존재하지 않으므로
        model.addAllAttributes(pageInfo);
        return "list";
    }
    /*----------------------------
    함수명 : String bForm()
    맵핑 : get(/b)
    인수 : 없음
    결과 : insert페이지
    설명 : 입력폼 페이지로 이동
    ------------------------------*/
    @GetMapping("/b")
    public String bForm() {
        return "insert";
    }
    /*----------------------------
    함수명 : String bProc(TodoDTO todoDTO)
    맵핑 : post(/b)
    인수 : 입력폼에 데이터
    결과 : 없음
    설명 : 입력폼에서 입력한 데이터를 서비스를 통해 데이터베이스에 저장
    ------------------------------*/
    @PostMapping("/b")
    public String bProc(TodoDTO todoDTO) {
        //서비스를 통해서 저장
        todoService.c(todoDTO);
        return "redirect:/a";
    }
    /*----------------------------
    함수명 : String cForm(Integer id, Model model)
    맵핑 : get(/c)
    인수 : 없음
    결과 : update페이지
    설명 : 해당 id로 서비스에서 데이터를 조회한 결과를 수정폼 페이지로 전달
    ------------------------------*/
    @GetMapping("/c")
    public String cForm(Integer id, Model model) {
        //서비스를 통해서 해당 레코드를 조회
        TodoDTO todoDTO = todoService.b(id);
        model.addAttribute("data", todoDTO);

        return "update";
    }
    /*----------------------------
    함수명 : String cProc(TodoDTO todoDTO)
    맵핑 : post(/c)
    인수 : 수정폼에 데이터
    결과 : 없음
    설명 : 수정폼에서 수정한 데이터를 서비스를 통해 데이터베이스에 저장
    ------------------------------*/
    @PostMapping("/c")
    public String cProc(TodoDTO todoDTO) {
        //서비스를 통해서 수정처리
        todoService.d(todoDTO);

        return "redirect:/a";
    }
    /*----------------------------
    함수명 : String dForm(Integer id)
    맵핑 : get(/d)
    인수 : 기본키 일련번호
    결과 : 없음(목록)
    설명 : 해당 id로 서비스에서 데이터를 조회해서 삭제
    ------------------------------*/
    @GetMapping("/d")
    public String dForm(@RequestParam Integer id) {
        //서비스를 통해 데이터 삭제
        todoService.e(id);

        return "redirect:/a";
    }
}
