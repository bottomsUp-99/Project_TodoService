package com.example.springtodoservice.service;

import com.example.springtodoservice.dto.PageRequestDTO;
import com.example.springtodoservice.dto.PageResponseDTO;
import com.example.springtodoservice.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
//    List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
//    void finishedModify(TodoDTO todoDTO);
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
