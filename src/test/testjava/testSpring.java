import com.jidy.utils.HashCode;
import com.jidy.utils.SearchRegex;
import com.lj.bookcomment.dao.BookcommentDao;
import com.lj.bookcomment.service.BookCommentService;
import com.lj.borrowbook.service.BorrowbookService;
import com.lj.category.service.CategoryService;

import com.lj.news.dao.NewsDao;
import com.lj.news.service.NewsService;
import com.lyj.user.dao.UserDao;
import com.lyj.user.service.UserService;
import com.upublic.dao.SearchDao;
import com.upublic.vo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rabit on 2017/5/6.
 */
public class testSpring {
    @Test
    public void splitTest(){
        SearchRegex searchRegex=new SearchRegex();
        System.out.println(searchRegex.splitRed("路遥很牛逼"));
    }
}
