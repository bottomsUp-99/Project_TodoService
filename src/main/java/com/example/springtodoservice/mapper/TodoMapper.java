package com.example.springtodoservice.mapper;

import com.example.springtodoservice.domain.TodoVO;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);
}
