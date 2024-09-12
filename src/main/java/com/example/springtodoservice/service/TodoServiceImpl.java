package com.example.springtodoservice.service;

import com.example.springtodoservice.dto.TodoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    @Override
    public void register(TodoDTO todoDTO) {

    }
}
