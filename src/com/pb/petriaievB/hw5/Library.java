package com.pb.petriaievB.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("Хоббит", "Дж. Р.Р. Толикэн", 1932);
        books[1] = new Book("Оно", "Стивен Кинг", 1986);
        books[2] = new Book("Кристина", "Стивен Кинг", 1983);
        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Петряев Б. Д.", 20022, "Экономический ",
                "09/12/99", "+380931112233");
        readers[1] = new Reader("Петряева Н.В.", 20023, "Медицинский",
                "20/04/84", "+380831112233");
        readers[2] = new Reader("Петряева Д. В.", 19875, "Экономический",
                "30/01/76", "+3806831112233");
        // vivod vsex autorov
        System.out.println("Книги: ");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookinfo());
        }
        System.out.println("\nЧитатели: ");
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].getReaderInfo());
        }
        System.out.println();
        readers[0].takeBook();
        readers[0].takeBook("Хоббит", "Оно", "Кристина");
        readers[0].takeBook(books[0], books[1], books[2]);
        System.out.println();
        readers[0].returnBook();
        readers[0].returnBook("Хоббит", "Оно", "Кристина");
        readers[2].returnBook(books[0], books[1], books[2]);
    }
}
