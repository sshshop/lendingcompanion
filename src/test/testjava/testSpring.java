import com.hyy.adminUser.service.AdminUserService;
import com.jidy.searchbook.dao.BookDao;
import com.jidy.utils.SearchRegex;
import com.lj.bookcomment.dao.BookcommentDao;
import com.lj.bookcomment.service.BookCommentService;
import com.lj.borrowbook.dao.BorrowbookDao;
import com.lj.borrowbook.service.BorrowbookService;
import com.lj.category.service.CategoryService;

import com.lj.news.dao.NewsDao;
import com.lj.news.service.NewsService;
import com.lyj.user.dao.UserDao;
import com.lyj.user.service.UserService;
import com.upublic.dao.SearchDao;
import com.upublic.vo.*;
import com.upublic.vo.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.*;
import java.util.List;

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
    BookDao bookDao = (BookDao) ac.getBean("bookDao");
    BorrowbookDao borrowbookDao = (BorrowbookDao) ac.getBean("borrowbookDao");

    @Test
    public void test() {
        List<Search> list = searchDao.findSearchByUid(8);
        System.out.println(list.size());
    }

    public void splitTest() {
        SearchRegex searchRegex = new SearchRegex();
        System.out.println(searchRegex.splitRed("路遥很牛逼"));
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
    public void testre() {
        adminUserService.deleteUser(42);
    }

    @Test
    public void testlikeUserByname() {
        String name = "lj";
        List<User> list = userDao.findUserByRe(name.trim());
        System.out.println(list.size());
    }

    @Test
    public void testLikeUserName() {
        String bname = "a";
        List<Book> list = bookDao.findBookByRe(bname);
        System.out.println(list.size());
    }

    @Test
    public void testfindborrBybid() {
        Book book = new Book();
        book.setBid(2);
        List<Borrowbook> list = borrowbookDao.findBorrowedByBid(book);
        System.out.println(list.size());
        System.out.println(list.get(0).getUserList().get(0).getUsername());
    }

    @Test
    public void testfindborrByUid() {
        User user = new User();
        user.setUid(1);
        List<Borrowbook> list = borrowbookDao.findBorroewByUid(user);

        System.out.println(list.get(0).getList().get(0).getBname());
        System.out.println(list.size());
    }

    @Test
    public void testBorrowed() {
        List<Borrowbook> borrowbookList = borrowbookService.findBorrowedBookMSG("lj", "");
        System.out.println(borrowbookList.size());
        System.out.println(borrowbookList.get(2).getUserList().get(0).getUsername());
        System.out.println(borrowbookList.get(0).getList().get(0).getBname());
    }
}
