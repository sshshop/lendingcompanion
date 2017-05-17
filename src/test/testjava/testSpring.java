import com.lj.bookcomment.dao.BookcommentDao;
import com.lj.category.service.CategoryService;
import com.lyj.service.UserService;
import com.upublic.vo.Bookcomment;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rabit on 2017/5/6.
 */
public class testSpring {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationcontext.xml" );
        UserService userService= (UserService) ac.getBean("UserService");
//        userService.test();
    }
    @Test
    public void  testCategoryFindAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationcontext.xml" );
        CategoryService categoryService= (CategoryService) ac.getBean("categoryService");
        System.out.println(categoryService.findCategoryAll().get(2).getCname());
        assertEquals(true,categoryService.findCategoryAll().size()>0);
    }
@Test
    public void testfindComment(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationcontext.xml" );
        BookcommentDao bookcommentDao= (BookcommentDao) ac.getBean("bookCommentDao");
        //Mybatis注解开发+联表查询
        List<Bookcomment> list=bookcommentDao.findCommentByBId(5);
        System.out.println(list.get(1).getInf()+list.get(1).getBctime()+"-----"+list.get(1).getUsername()+"-----");
    System.out.println(list.size());
    }
}
