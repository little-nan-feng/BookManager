package contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Book;
import pojo.User;
import service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/query")
    public String queryBook(Book book, HttpServletRequest request){
        List<Book>books = bookService.queryBook(book);
        request.setAttribute("books",books);
        return "queryBook";
    }
    @ResponseBody
    @RequestMapping("/queryBookByIsbn")
   public  Book queryBookByIsbn(String isbn){
    return bookService.queryBookByIsbn(isbn);
    }
    @ResponseBody
    @RequestMapping("/borrow")
    public Boolean borrowBook(Book book, HttpSession session){
        User user = (User)session.getAttribute("USER_SESSION");
        return  bookService.borrowBook(book,user);
    }
}
