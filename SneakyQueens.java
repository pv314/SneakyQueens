// Heng Hong, COP3503, Spring of 2023, he242542.

import java.util.*;
import java.lang.*;
import java.io.*;

public class SneakyQueens
{
    // Convert string letter to int number
    private static int stringToNumber(String s)
    {
        int col = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                col *= 26;
                col += ((s.charAt(i) - 'A') - 31);
            }
        }
        return col;
    }

    // convert string number to int number
    private static int numToNumber(String s)
    {
        int row = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) <= 57 && s.charAt(i) >= 48)
            {
                row = row * 10 + (s.charAt(i) - '0');
            }
        }
        return row;
    }

    //main function to process the chess board
    public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
    {
        if(boardSize == 1)
            return true;

        // some 1d array store value
        int [] columns = new int[boardSize+1];
        int [] rows = new int[boardSize+1];
        int [] blue = new int[boardSize*2];// diagonal '/'
        int [] red = new int[boardSize*2]; // diagonal '\'

        // loop all the string
        for (String str : coordinateStrings)
        {
            //get int from convert function
            int colIdx = stringToNumber(str);
            int rowIdx = numToNumber(str);

            //check columns
            if (columns[colIdx] == 1)
                return false;

            //check rows
            if (rows[rowIdx] == 1)
                return false;

            //check diagonal '/'
            if(red[colIdx+rowIdx-1] == 1)
                return false;

            //check diagonal '\'
            if(blue[rowIdx-colIdx+(boardSize-1)] == 1)
                return false;

            rows[rowIdx] = 1;
            columns[colIdx] = 1;
            red[colIdx+rowIdx-1] = 1;
            blue[rowIdx-colIdx+(boardSize -1)] = 1; 
        }
        return true;
    }

    public static double difficultyRating() {
        return 4.0;
    }

    public static double hoursSpent() {
        return 6.0;
    }
}
