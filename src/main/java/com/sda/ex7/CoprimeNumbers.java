package com.sda.ex7;

public class CoprimeNumbers {

    public static void main(String[] args) {
        drawCoprimeNumbersTable(9);
    }

    public static void drawCoprimeNumbersTable(int n) {
        char table[][] = new char[n+1][n+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(i==0){
                    table[i][j]=(char)(j+48);
                } else if(j==0) {
                    table[i][j]=(char)(i+48);
                } else if(table[i][j]==(char)0){
                    boolean coprime = areCoprimeNumbers(i, j);
                    char c = coprime? '+': '.';
                    table[i][j] = c;
                    table[j][i] = c;
                }
            }
        }

        for(int i=0; i<=n; i++) {
            for (int j = 0; j <=n; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static boolean areCoprimeNumbers(int a, int b) {
        int max = a > b ? a : b;

        for (int i = 2; i <= max; i++) {
            if(a%i==0 && b%i==0)
                return false;
        }
        return true;
    }
}
