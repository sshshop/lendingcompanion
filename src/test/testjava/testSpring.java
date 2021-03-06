import com.hyy.adminUser.service.AdminUserService;
import com.jidy.utils.HashCode;
import com.lj.bookcomment.dao.BookcommentDao;
import com.lj.bookcomment.service.BookCommentService;
import com.lj.booktemp.service.BooktemService;
import com.lj.borrowbook.service.BorrowbookService;
import com.lj.category.service.CategoryService;

import com.lj.msg.dao.MsgDao;
import com.lj.news.dao.NewsDao;
import com.lj.news.service.NewsService;
import com.lj.subcription.dao.SubscriptionDao;
import com.lyj.user.dao.UserDao;
import com.lyj.user.service.UserService;
import com.upublic.dao.SearchDao;
import com.upublic.utils.sqlFactory;
import com.upublic.vo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rabit on 2017/5/6.
 */
public class testSpring {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
    UserService userService = (UserService) ac.getBean("userService");
    CategoryService categoryService = (CategoryService) ac.getBean("categoryService");
    UserDao userDao = (UserDao) ac.getBean("userDao");
    BookCommentService bookCommentService = (BookCommentService) ac.getBean("bookCommentService");
    BorrowbookService borrowbookService = (BorrowbookService) ac.getBean("borrowbookService");
    NewsService newsService = (NewsService) ac.getBean("newsService");
    NewsDao newsDao = (NewsDao) ac.getBean("newsDao");
    SearchDao searchDao = (SearchDao) ac.getBean("searchDao");
    AdminUserService adminUserService = (AdminUserService) ac.getBean("adminUserService");
    MsgDao msgDao = (MsgDao) ac.getBean("msgDao");
    SubscriptionDao subscriptionDao = (SubscriptionDao) ac.getBean("subscriptionDao");
    BooktemService booktemService = (BooktemService) ac.getBean("booktemService");

    @Test
    public void test() {
        List<Search> list = searchDao.findSearchByUid(8);
        System.out.println(list.size());
    }

    @Test
    public void testCategoryFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
        CategoryService categoryService = (CategoryService) ac.getBean("categoryService");
        System.out.println(categoryService.findCategoryAll().get(2).getCname());
        assertEquals(true, categoryService.findCategoryAll().size() > 0);
    }

    @Test
    public void testfindComment() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
        BookcommentDao bookcommentDao = (BookcommentDao) ac.getBean("bookCommentDao");
        //Mybatis注解开发+联表查询
        List<Bookcomment> list = bookcommentDao.findCommentByBId(5);
        System.out.println(list.get(1).getInf() + list.get(1).getBctime() + "-----" + list.get(1).getUsername() + "-----");
        System.out.println(list.size());
    }

    @Test
    public void testFindBookByCid() {
        List<Book> list = categoryService.findBookByCid(1);
        System.out.println(list.size());
    }

    @Test
    public void testUser() {
        User u = new User();
        u.setUid(1);
        User user = (User) userDao.findUserByUid(u);
        System.out.println("省份表：" + user.getProvince().getPname() + "城市：" + user.getCity().getCname());
    }

    @Test
    public void testFindCommentByUid() {
        User user = new User();
        user.setUid(2);
        List<Bookcomment> list = bookCommentService.findCommentByUId(user);
        System.out.println(list.size());
        System.out.println(list.get(0).getList().get(0).getBname() + "----" + list.get(0).getInf());
    }

    @Test
    public void testFindBorrBookByUid() {
        User user = new User();
        user.setUid(1);
        List<Borrowbook> list = borrowbookService.findBorrowedBookByUid(user);
        System.out.println(list.size());
        System.out.println(list.get(0).getList().get(0).getBname());
        System.out.println(list.get(1).getList().get(0).getBname());
    }

    @Test
    public void testNewsByUid() {
        User user = new User();
        user.setUid(1);
        List<News> list = newsService.findNewsByUid(user);
        System.out.println(list.size() + "---" + list.get(0).getTime());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNcontent());
        }
    }

    @Test
    public void testDelet() {
        subscriptionDao.deleteSub(2, 1);
    }

    @Test
    public void testBooktem() {
        Booktem booktem = new Booktem();
        booktem.setMoney(10.0);
        System.out.println(new sqlFactory().adminupdateBook(booktem));
    }

    @Test
    public void testREX() {
        String temp = "'ll我要吃 11acb d饭？!#*";
        temp=temp.replace(" ","");
        String re = "[\u4e00-\u9fa5a-zA-Z0-9]+";
        Pattern reg = Pattern.compile(re,Pattern.CASE_INSENSITIVE);
        Matcher m=reg.matcher(temp);
     while (m.find()){
         System.out.println(m.group());
     }
        temp = m.replaceAll("c");
        System.out.println(temp);
    }

}
