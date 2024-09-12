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
//@ExtendWith(SpringExtension.class)**를 통해 Spring의 애플리케이션 컨텍스트를 로딩하고,
//@Autowired로 필요한 의존성을 주입받아 테스트하는 구조
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {
    @Autowired(required = false)
    //@Autowired는 Spring이 해당 빈(Bean)을 자동으로 주입하도록 합니다.
    //그러나 required = false 옵션을 추가하면, 해당 빈이 필수적이지 않다는 의미가 됩니다.
    //즉, 스프링이 해당 의존성을 주입할 수 없는 경우에도 예외를 발생시키지 않고, 빈이 존재하지 않으면 그냥 넘어갑니다.
    //만약 주입할 빈이 없으면 해당 필드나 메서드는 null로 남게 됩니다.
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
