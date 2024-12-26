package com.woori.todo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder @ToString
//Builder 변수들을 DTO 만드는 작업
//ToString DTO를 변수로 출력
public class TodoDTO {
    private Integer id;  //일련번호
    private String a; //제목
    private String b; //해야할 일
    private LocalDateTime c; //날짜
    private String d; //중요도
    private String e; //상태
    private LocalDateTime regdate;
    private LocalDateTime moddate;
}
