package com.example.springtodoservice.service;

import com.example.springtodoservice.domain.TodoVO;
import com.example.springtodoservice.dto.PageRequestDTO;
import com.example.springtodoservice.dto.PageResponseDTO;
import com.example.springtodoservice.dto.TodoDTO;
import com.example.springtodoservice.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 주입이 필요한 객체의 타입을 final로 고정시키고 @RequiredQrgsConstructor을 이용하여 생성자를 생성하는 방식으로 주입 받는다.
public class TodoServiceImpl implements TodoService{

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;
    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

//    @Override
//    public List<TodoDTO> getAll() {
//        finishedModify(todoMapper.selectAll());
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream().map(vo->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
//        return dtoList;
//    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        return modelMapper.map(todoVO, TodoDTO.class);
    }

    @Override
    public void remove(Long tno) {
        log.info(modelMapper);
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream().map(vo->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
        int total = todoMapper.getCount(pageRequestDTO);
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO
                .<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

//    @Override
//    public void finishedModify(TodoDTO todoDTO) {
//        log.info(modelMapper);
//        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//        todoMapper.finishedUpdate(todoVO);
//    }

    // 1시간마다 실행 (밀리초 기준)
//    @Scheduled(fixedRate = 3600000)
//    public void updateFinishedStatusScheduler() {
//        todoMapper.updateFinishedStatus();
//        System.out.println("Finished 상태가 업데이트되었습니다.");
//    }
}