package com.pb.petriaievB.hw5;

public class Book {
    private static int bookCount = 0;
    public static int getBookCount() {
        return bookCount;
    }

    private String Book_name;
    private String author;
    private int year;

    public Book( String Book_name, String author, int year) {
        this.Book_name = Book_name;
        this.author = author;
        this.year = year;
        bookCount++;
    }
    public void setBook_name(String Book_name) {
        this.Book_name = Book_name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear( int year) {
        this.year = year;
    }
    public String getBook_name() {
        return Book_name;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public String getBookinfo() {
        return "[название: " + Book_name + ", автор:" + author + ", год выпуска:" + year + "]";
    }
}
