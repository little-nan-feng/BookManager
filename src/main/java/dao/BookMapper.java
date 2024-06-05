package dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import pojo.Book;

import java.util.List;

public interface BookMapper {
    @SelectProvider(type = BookDynaSqlProvider.class,method = "queryBook")
    public List<Book> queryBook(Book book);
    @Select("select * from tb_book where isbn=#{isbn}")
    public Book queryBookByIsbn(String isbn);
    @UpdateProvider(type = BookDynaSqlProvider.class,method = "updateBook")
    public int updateBook(Book book);
}
