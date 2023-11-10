package book.service.impl;

import book.mapper.BookMapper;
import book.pojo.Book;
import book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Book getBookById(Integer bookId) {
        Book book = bookMapper.getBookById(bookId);
        return book;
    }
}
