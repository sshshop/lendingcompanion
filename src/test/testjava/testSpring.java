import com.lj.category.service.CategoryService;
import com.lj.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

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
    @Test
    public void  testCategoryFindAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationcontext.xml" );
        CategoryService categoryService= (CategoryService) ac.getBean("categoryService");
        System.out.println(categoryService.findCategoryAll().get(2).getCname());
        assertEquals(true,categoryService.findCategoryAll().size()>0);
    }
}
