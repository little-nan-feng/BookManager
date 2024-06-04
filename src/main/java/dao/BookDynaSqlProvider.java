package dao;

import org.apache.ibatis.jdbc.SQL;
import pojo.Book;

public class BookDynaSqlProvider {
    public String queryBook(final Book book){
        return new SQL(){
            {
                SELECT("*");
                FROM("tb_book");
                if(book.getName()!=null&&!book.getName().equals(""))
                    WHERE("name=#{name}");
                if(book.getAuthor()!=null&&!book.getAuthor().equals(""))
                    WHERE("author=#{author}");
                if(book.getIsbn()!=null&&!book.getIsbn().equals(""))
                    WHERE("isbn=#{isbn}");
                if(book.getPress()!=null&&!book.getPress().equals(""))
                    WHERE("press=#{press}");
            }
        }.toString();
    }

    public String updateBook(final Book book){
        return new SQL(){
            {
                UPDATE("tb_book");
                if(book.getName()!=null&&!book.getName().equals(""))
                    SET("name=#{name}");
                if(book.getAuthor()!=null&&!book.getAuthor().equals(""))
                    SET("author=#{author}");
                if(book.getPress()!=null&&!book.getPress().equals(""))
                    SET("press=#{press}");
                if(book.getPublishTime()!=null&&!book.getPublishTime().equals(""))
                    SET("publishTime=#{publishTime}");
                if(book.getPrice()!=null&&!String.valueOf(book.getPrice()).equals(""))
                    SET("price=#{price}");
                if(book.getStorage()!=null&&!String.valueOf(book.getStorage()).equals(""))
                    SET("storage=#{storage}");
                WHERE("isbn=#{storage}");
            }
        }.toString();
    }
}
