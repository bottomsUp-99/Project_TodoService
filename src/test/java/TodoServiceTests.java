import com.example.springtodoservice.domain.TodoVO;
import com.example.springtodoservice.dto.TodoDTO;
import com.example.springtodoservice.service.TodoService;
import com.example.springtodoservice.service.TodoServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {
    @Autowired(required = false)
    private TodoService todoService;

    @Test
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("registerTest")
                .dueDate(LocalDate.of(2024,9,12))
                .writer("NYH")
                .build();
        todoService.register(todoDTO);
        log.info(todoDTO);
    }
}
