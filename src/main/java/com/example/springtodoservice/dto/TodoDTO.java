package com.example.springtodoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//서버 사이드 데이터 검증 : 스프링 MVC에서는 파라미터 검증 작업은 컨트롤러에서 진행한다.
//@Vaild와 BindingResult 객체를 이용하여 처리한다.
//hibernate-validate 라이브러리가 필요하다.
public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;

    @NotEmpty
    private String writer;

    private boolean finished;
}
