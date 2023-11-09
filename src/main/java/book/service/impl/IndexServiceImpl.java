package book.service.impl;

import book.mapper.IndexMapper;
import book.pojo.Book;
import book.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;
    @Override
    public List<Book> getBookList() {
        List<Book> list = indexMapper.getAllBook();
        return list;
    }
}
