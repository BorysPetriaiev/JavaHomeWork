package com.pb.petriaievB.hw5;

public class Reader {
    private String fullname;
    private int ticket;
    private String faculty;
    private String dateofbirth;
    private String phonemumber;

    public Reader (String fullname, int ticket, String faculty, String dateofbirth, String phonemumber) {
        this.fullname = fullname;
        this.ticket = ticket;
        this.faculty = faculty;
        this.dateofbirth = dateofbirth;
        this.phonemumber = phonemumber;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setTicket(int ticket) {
        this.ticket = ticket;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    public void setPhonemumber(String phonemumber) {
        this.phonemumber = phonemumber;
    }
    public String getFullname() {
        return fullname;
    }
    public int getTicket() {
        return ticket;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getDateofbirth() {
        return dateofbirth;
    }
    public String getPhonemumber() {
        return phonemumber;
    }
    public void takeBook() {
        System.out.println(getFullname() + "взял" + Book.getBookCount() + "книги.");
    }
    public void takeBook(String... titles) {
        System.out.print(getFullname() + "взял книги: ");
        for (String title : titles ) {
            if (title != titles[titles.length-1]) {
                System.out.print(title + ", ");
            } else {
                System.out.println(title + ".");
            }
        }

    }
    public void takeBook(Book... books) {
        System.out.print(getFullname() + " взял книги: ");
        for (Book book : books) {
            if (book != books[books.length-1]) {
                System.out.print(book.getBook_name() + " (" + book.getAuthor() + ", " + book.getYear() + "), ");
            } else {
                System.out.println(book.getBook_name() + " (" + book.getAuthor() + ", " + book.getYear() + ").");
            }
        }
    }
    public void returnBook() {
        System.out.println(getFullname() + " вернул " + Book.getBookCount() + " книги.");
    }
    public void returnBook(String... titles) {
        System.out.print(getFullname() + " вернул книги: ");
        for (String title : titles) {
            if (title != titles[titles.length-1]) {
                System.out.print(title + ", ");
            } else {
                System.out.println(title + ".");
            }
        }
    }
    public void returnBook(Book... books) {
        System.out.print(getFullname() + " вернул книги: ");
        for (Book book : books) {
            if (book != books[books.length-1]) {
                System.out.print(book.getBook_name() + " (" + book.getAuthor() + ", " + book.getYear() + "), ");
            } else {
                System.out.println(book.getBook_name() + " (" + book.getAuthor() + ", " + book.getYear() + ").");
            }
        }
    }
    String getReaderInfo() {
        return "[ФИО: " + fullname + "\nНомер билета: " + ticket + "\nФакультет: "
                + faculty + "\nДата рождения: " + dateofbirth + "\nМобильный: " + phonemumber + "]";
    }
}
