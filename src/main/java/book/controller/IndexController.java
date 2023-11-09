package book.controller;

import book.pojo.Book;
import book.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @GetMapping("/")
    public String index(HttpSession session){
        List<Book> bookList = indexService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";
    }
}
