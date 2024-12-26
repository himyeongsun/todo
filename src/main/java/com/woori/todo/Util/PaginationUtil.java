package com.woori.todo.Util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//연관성이 없는 클래스
//클래스가 독립적인 프로그램
@Component
public class PaginationUtil {
    /*-------------------------------
    함수명 : Map<String, Integer> Pagination(Page<?> page)
    인수 : 페이지정보
    결과 : 처음, 이전, 현재, 페이지수, 다음, 마지막 정보
    내용 : 페이지정보를 이용해서 HTML에 필요한 페이지정보 변수를 만들어서 전달
     */
    public static Map<String, Integer>  Pagination(Page<?> page) {
        //데이터베이스 0,1,2,3... 화면 1,2,3,4....
        int currentPage = page.getNumber()+1; //현재 위치한 페이지 번호
        int totalPages = page.getTotalPages(); //전체 페이지 번호
        int blockLimit = 5; //HTML출력할 페이지 번호의 갯수

        Map<String, Integer> pageInfo = new HashMap<>(); //저장할 변수

        //(1),2,3,4,5
        //(6),7,8,9,10
        int startPage = Math.max(1, currentPage-blockLimit/2);
        //1,2,3,4,(5)
        //6,7,8,9,(10)
        int endPage = Math.min(totalPages, currentPage+blockLimit-1);
        //이전페이지 번호(현재페이저-1)
        int prevPage = Math.max(1, currentPage-1);
        //다음페이지 번호(현재페이지+1)
        int nextPage = Math.min(totalPages, currentPage+1);
        int lastPage = totalPages; //마지막 페이지 번호

        //map에 변수 저장
        //.put("변수명", 값)
        pageInfo.put("startPage", startPage);
        pageInfo.put("endPage", endPage);
        pageInfo.put("prevPage", prevPage);
        pageInfo.put("nextPage", nextPage);
        pageInfo.put("lastPage", lastPage);
        pageInfo.put("currentPage", currentPage);

        return pageInfo;
    }
}
