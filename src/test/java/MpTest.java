import book.pojo.Book;
import book.pojo.User;
import book.service.IndexService;
import book.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定当前测试类在Spring的测试环境中执行，此时就可以通过注入的方式，直接获取IOC容器中的Bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring.xml")
public class MpTest {
    @Autowired
    private IndexService indexService;

    @Autowired
    private UserService userService;

    @Test
    public void testCon(){
        List<Book> bookList = indexService.getBookList();
        for (Book book : bookList){
            System.out.println(book);
        }
    }

    @Test
    public void testLogin(){
        User user = userService.login("root", "root");
        System.out.println(user);
    }
}
