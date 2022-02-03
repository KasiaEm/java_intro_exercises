package com.sda.ex14;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private LocalDate borrowed;
    private LocalDate published;

    public Book(String title, String author, LocalDate borrowed, LocalDate published) {
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(LocalDate borrowed) {
        this.borrowed = borrowed;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" + title + '\'' +
                ", author='" + author + '\'' +
                ", borrowed=" + borrowed +
                ", published=" + published +
                '}';
    }
}
