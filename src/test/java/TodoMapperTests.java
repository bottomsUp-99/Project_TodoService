import com.example.springtodoservice.domain.TodoVO;
import com.example.springtodoservice.dto.PageRequestDTO;
import com.example.springtodoservice.dto.PageResponseDTO;
import com.example.springtodoservice.dto.TodoDTO;
import com.example.springtodoservice.mapper.TodoMapper;
import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
//@ExtendWith(SpringExtension.class)**를 통해 Spring의 애플리케이션 컨텍스트를 로딩하고,
//@Autowired로 필요한 의존성을 주입받아 테스트하는 구조
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {
    @Autowired(required = false)
    //@Autowired는 Spring이 해당 빈(Bean)을 자동으로 주입하도록 합니다.
    //그러나 required = false 옵션을 추가하면, 해당 빈이 필수적이지 않다는 의미가 됩니다.
    //즉, 스프링이 해당 의존성을 주입할 수 없는 경우에도 예외를 발생시키지 않고, 빈이 존재하지 않으면 그냥 넘어갑니다.
    //만약 주입할 빈이 없으면 해당 필드나 메서드는 null로 남게 됩니다.
    private TodoMapper todoMapper;

    @Test
    public void testGetTime(){
        log.info("현재 시간은 {}", todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("spring test")
                .dueDate(LocalDate.of(2024,9,12))
                .writer("LJH")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(System.out::println);
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info(todoVO);
    }

    @Test
    public void testDelete(){
        todoMapper.delete(3L);
    }

    @Test
    public void testUpdate(){
        TodoVO todoVO = TodoVO.builder()
                .title("update test")
                .dueDate(LocalDate.of(2024,9,20))
                .writer("LJH")
                .finished(true)
                .build();
        todoMapper.update(todoVO);
    }

    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(log::info);
    }

    @Test
    public void testSelectSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String []{"t","w"})
                .keyword("스프링")
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(log::info);
    }
}
