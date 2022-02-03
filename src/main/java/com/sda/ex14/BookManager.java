package com.sda.ex14;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static java.time.temporal.ChronoUnit.DAYS;

public class BookManager {
    private static Book books[];

    public static void main(String[] args) {
        prepareData();

    }

    private static void prepareData() {
        books = new Book[]{
                new Book("Title1", "Author1", LocalDate.of(2020, Month.JANUARY, 1), LocalDate.of(1995, Month.MARCH, 2)),
                new Book("Title2", "Author2", LocalDate.of(2019, Month.DECEMBER, 3), LocalDate.of(2008, Month.MAY, 30)),
                new Book("Title3", "Author3", LocalDate.of(2019, Month.NOVEMBER, 15), LocalDate.of(2019, Month.NOVEMBER, 1)),
        };
    }

    public static double checkPenalty(Book[] borrowed){
        Double penalty = 0d;
        Double smallestPenalty = 0d;
        for (Book book : borrowed) {
            Double tempPenalty = 0d;
            long days = DAYS.between(book.getBorrowed(), LocalDate.now()) - 16;
            int counter = 0;
            while (days > 0) {
                if (counter < 28) {
                    tempPenalty += 0.5;
                    days -= 7;
                    counter += 7;
                } else if (counter < 56) {
                    tempPenalty += 0.7;
                    days -= 7;
                    counter += 7;
                } else {
                    tempPenalty += 0.2;
                    days--;
                    counter++;
                }
            }
            if (tempPenalty > 0d) {
                if (DAYS.between(book.getPublished(), book.getBorrowed()) < 30) {
                    tempPenalty *= 1.1;
                }
                if (smallestPenalty == 0d || tempPenalty < smallestPenalty) {
                    smallestPenalty = tempPenalty;
                }
            }
            penalty += tempPenalty;
        }
        if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            penalty -= smallestPenalty;
        }
        return penalty;
    }
}
