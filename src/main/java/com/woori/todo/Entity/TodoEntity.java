package com.woori.todo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor @ToString @Builder
@Table(name="todo")
@SequenceGenerator(
        name="todo_seq",
        sequenceName = "todo_sql",
        initialValue = 1,
        allocationSize = 1
)
public class TodoEntity extends BaseEntity  {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    private Integer id;  //일련번호
    @Column(name="a", length=50)
    private String a; //제목
    @Column(name="b", length=100)
    private String b; //해야할 일
    @Column(name="c")
    private LocalDateTime c; //날짜
    @Column(name="d", length=20)
    private String d; //중요도
    @Column(name="e", length=20)
    private String e; //상태
}
/*JPA 주요 어노테이션
@Entity : 해당클래스가 Entity 클래스임을 나타냅니다.
@Table : 엔티티와 맵핑할 테이블 이름
@Id : 기본키 설정(중복되는 값이 있는 필드는 사용불가)
@GeneratedValue : 자동 생성 전략, 값을 자동으로 생성
@Column : 엔티티의 변수와 맵핑할 테이블의 필드명
@Transient : 변수를 테이블의 필드와 맵핑하지 않고 변수로만 사용

#현재테이블To상대테이블
#Join 작업(부모와 자식 테이블 모두에 지정)
@OneToMany : 하나의 레코드(현재)에 여러관련 레코드(상대)가 존재 *(부모테이블)
           예) 컴퓨터상품         컴퓨터 이미지 3개
@ManyToOne : 여러레코드(현재)가 하나의 레코드(상대) 연관 *(자식테이블)
           예) 컴퓨터 이미지3개    컴퓨터상품
@OneToOne : 하나의 레코드(현재)에 하나의 레코드(상대) 연관
           예) 회원              회원사진
@ManyToMany :여러레코드(현재)가 여러레코드(상대) 연관

#Join 작업시 2개의 테이블을 관계 맺기
@JoinColumn : 외래 키를 맵핑 사용, 관계된 데이터가 존재하면 임의삭제를 방지

#join 작업의 속성(부모 테이블에 선언해서 사용)
CascadeType.ALL : 부모 테이블에 변화가 생기면 자동으로 자식테이블에도 적용(PERSIST,MERGE,REMOVE)
CascadeType.PERSIST : 부모테이블에 저장이 발생하면 자식테이블도 같이 저장
CascadeType.MERGE : 부모테이블과 자식테이블을 결합해서 사용
CascadeType.REMOVE : 부모테이블에서 삭제가 발생하면 자식테이블도 같이 삭제 *(부모테이블)

#fetch 속성
FetchType.LAZY : 지연 로딩, 부모테이블 사용시 자식테이블 사용하지 않는다.(자식테이블 필요할 때 호출)
FetchType.EAGER : 즉시 로딩, 부모테이블 사용하면 자식테이블 바로 사용 *

 */
