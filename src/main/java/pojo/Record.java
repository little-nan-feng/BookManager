package pojo;

import java.time.LocalDate;

public class Record {

    private String name;
    private String isbn;
    private String borrower;
    private LocalDate borrowTime;
    private LocalDate deadline;
    private LocalDate returnTime;
    private String status;
    private Book book;

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrower='" + borrower + '\'' +
                ", borrowTime=" + borrowTime +
                ", deadline=" + deadline +
                ", returnTime=" + returnTime +
                ", status='" + status + '\'' +
                ", book=" + book +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDate returnTime) {
        this.returnTime = returnTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
