package service.impl;

import dao.BookMapper;
import dao.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Book;
import pojo.User;
import pojo.Record;

import java.time.LocalDate;
import java.util.List;

public class BookServiceImpl {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RecordMapper recordMapper;
    public List<Book> queryBook(Book book){
        return bookMapper.queryBook(book);
    }
    public Book queryBookByIsbn(String isbn){
        return bookMapper.queryBookByIsbn(isbn);
    }
    public Boolean borrowBook(Book book, User user){
        book.setStorage(book.getStorage()-1);
        int num=bookMapper.updateBook(book);
        Record record=new Record();
        record.setName(book.getName());
        record.setIsbn(book.getIsbn());
        record.setBorrower(user.getName());
        record.setBorrowTime(LocalDate.now());
        if(user.getIdentity().equalsIgnoreCase("学生"))
            record.setDeadline(LocalDate.now().plusDays(30L));
        else if(user.getIdentity()=="教师")
            record.setDeadline(LocalDate.now().plusDays(60L));
        record.setStatus("借阅中");
        num= recordMapper.addRecord(record);
        if (num>0)
            return true;
        else
            return false;
    }
}
