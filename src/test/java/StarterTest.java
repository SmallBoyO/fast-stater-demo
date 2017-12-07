import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhanghe.demo.Application;
import com.zhanghe.demo.mapper.UserMapper;
import com.zhanghe.demo.service.UserService;
import com.zhanghe.demo.vo.UserListVO;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StarterTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test(){
		userService.test();
		userService.test();
	}
	
}
