import com.lj.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Rabit on 2017/5/6.
 */
public class testSpring {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationcontext.xml" );
        UserService userService= (UserService) ac.getBean("UserService");
        userService.test();
    }
}
