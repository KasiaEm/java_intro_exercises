package com.sda.ex8;

import java.util.Scanner;

import static com.sda.ex8.Player.*;

public class ShipsGame {
    private static int size = 3;
    private static char player1HiddenTable[][] = new char[size][size];
    private static char player2HiddenTable[][] = new char[size][size];
    private static char player1VisibleTable[][] = new char[size][size];
    private static char player2VisibleTable[][] = new char[size][size];
    private static int player1Ships = size;
    private static int player2Ships = size;

    public static void main(String[] args) {
        fillTablesInitially();

        System.out.println(PLAYER_1 + " - add ships:");
        addShipsForPlayer(player1HiddenTable);
        hide();
        System.out.println(PLAYER_2 + " - add ships:");
        addShipsForPlayer(player2HiddenTable);
        hide();

        game();
    }

    private static void game() {
        Player currentPlayer = PLAYER_2;

        while(player1Ships>0 && player2Ships>0){
            currentPlayer = (currentPlayer.equals(PLAYER_1)? PLAYER_2: PLAYER_1);
            Scanner scanner = new Scanner(System.in);
            char currentAttackedVisibleTable[][] = (currentPlayer.equals(PLAYER_1)? player2VisibleTable: player1VisibleTable);
            char currentAttackedHiddenTable[][] = (currentPlayer.equals(PLAYER_1)? player2HiddenTable: player1HiddenTable);

            printTable(currentAttackedVisibleTable);

            System.out.println(currentPlayer + " attack.");
            System.out.print("Attack position number: ");
            int number = scanner.nextInt()-1;
            System.out.print("Attack position letter: ");
            int letter = (int) (scanner.next().charAt(0)-65);
            if(currentAttackedHiddenTable[letter][number]=='X') {
                currentAttackedVisibleTable[letter][number] = 'X';
                if(currentPlayer.equals(PLAYER_1))
                    player2Ships--;
                else
                    player1Ships--;
            } else {
                currentAttackedVisibleTable[letter][number] = 'O';
            }
            printTable(currentAttackedVisibleTable);
            System.out.println("_____________________________________");
            System.out.println();
        }
        System.out.println(currentPlayer + " is the winner!");
    }

    private static void addShipsForPlayer(char[][] playerHiddenTable) {
        Scanner scanner = new Scanner(System.in);
        printTable(playerHiddenTable);
        for(int i=0; i<size; i++){
            System.out.println("Add a ship (" + (i+1) + ")");
            System.out.print("Position number: ");
            int number = scanner.nextInt()-1;
            System.out.print("Position letter: ");
            int letter = (int) (scanner.next().charAt(0)-65);

            playerHiddenTable[letter][number] = 'X';
            printTable(playerHiddenTable);
        }
    }

    private static void fillTablesInitially(){
        fillWithDots(player1VisibleTable);
        fillWithDots(player2VisibleTable);
        fillWithDots(player1HiddenTable);
        fillWithDots(player2HiddenTable);
    }

    private static void hide(){
        for(int i=0; i<20; i++){
            System.out.println();
        }
    }

    private static void fillWithDots(char table[][]) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j]='.';
            }
        }
    }

    private static void printTable(char table[][]) {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((char) (65 + i) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
