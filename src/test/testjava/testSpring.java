import com.jidy.recentsearch.service.RecentSearchService;
import com.lj.subcription.dao.SubscriptionDao;
import com.upublic.vo.Book;
import com.upublic.vo.Subscription;
import com.upublic.vo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rabit on 2017/5/6.
 */
public class testSpring {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    RecentSearchService recentSearchService= (RecentSearchService) ac.getBean("recentSearchService");
    SubscriptionDao subscriptionDao= (SubscriptionDao) ac.getBean("subscriptionDao");

    @Test
    public void test(){
        recentSearchService.insertSearchKeyword(1,"dsfg");
    }

    @Test
    public void testSubBook(){
        User user=new User();
        user.setUid(1);
       List<Subscription> list= subscriptionDao.findSubBooks(user);
        System.out.println(list.get(3).getList().get(0).getBname()+list.get(3).getList().get(0).getCategory().getCname());
    }

    @Test
    public void testInsertSub(){
        User user=new User();
        user.setUid(1);
       Subscription subscription=new Subscription();
        System.out.println(subscriptionDao.addSubscrition(user,subscription));
    }
}
