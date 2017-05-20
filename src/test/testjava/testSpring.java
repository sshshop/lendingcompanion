import com.jidy.recentsearch.service.RecentSearchService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rabit on 2017/5/6.
 */
public class testSpring {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    RecentSearchService recentSearchService= (RecentSearchService) ac.getBean("recentSearchService");

    @Test
    public void test(){
        recentSearchService.insertSearchKeyword(1,"dsfg");
    }
}
