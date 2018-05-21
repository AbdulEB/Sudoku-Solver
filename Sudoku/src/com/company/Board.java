package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Author: Abdul El Badaoui
* Student Number: 5745716
* Description: This class initialize the board with the file path location passed in. It also has methods to be called
* upon that tells if the board is valid on not and print method to print the state of the board. In addition, you
* can get a tile value or set a tile value in return methods that are implemented here.*
* */
public class Board {

    int [][] board;// board


    //a constructor that passes board and file path location
    public Board(int [][] sudokuBoard, String sudokuFile) throws FileNotFoundException {

        initialBoard(sudokuBoard, sudokuFile);// initialize the board, based on the file.
        this.board = sudokuBoard; //sets board to the board passed in

    }

    public int[][] initialBoard(int [][] startBoard, String fileLocation) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new FileInputStream(new File(fileLocation)));// fileInput to read in
        while(fileInput.hasNext()){// while loop to initialize the board
            for (int row_index = 0 ; row_index<startBoard.length; row_index++){
                for (int column_index = 0 ; column_index<startBoard[0].length; column_index++){
                    startBoard[row_index][column_index] = fileInput.nextInt();
                }
            }
        }
        return startBoard;
    }

    public void printBoard(){//call the method to print the board
        System.out.println();
        for (int row_index = 0 ; row_index<board.length; row_index++){
            for (int column_index = 0 ; column_index<board[0].length; column_index++){
                System.out.print(board[row_index][column_index] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isValid(){// call method to check if the board is valid (returns true or false)
        boolean result = true;
        //tile value to represent the tile of the board row and column index location, using it to save space, quadrantRow
        // and quadrantColumn is needed for the quadrant checking loop and I use it save space and make the loop look nice
        int tileValue, quadrantRow, quadrantColumn;
        int[] valueCounter = new int[board.length];
        //check for any values greater than 9 or less than 0 or any multiple occurrences of values per row
        for (int row_index = 0 ; row_index<board.length; row_index++){
            //an int array of length 9 all initialized to 0. will increase in count and if one index is greater then 1
            //it will reutrn the result as invalid
            for (int value_count =0; value_count<9; value_count++){
                valueCounter[value_count] = 0;
            }
            for (int column_index = 0 ; column_index<board[0].length; column_index++){
                tileValue = board[row_index][column_index];
                //checks if any input value was above 9 or below 0
                if (tileValue>9 || tileValue<0 ){
                    result =false;
                }
                // increases the valueCounter array index value by 1, if the value of the tile is not 0.
                else if(tileValue !=0){
                    valueCounter[tileValue-1]++;
                    //checks the index of the count if it is greater then 1, if it is the board is not valid.
                    if (valueCounter[tileValue-1]>1){
                        result =false;
                    }
                }
            }

        }

        //check for any values greater than 9 or less than 0 or any multiple occurrences of values per column
        for (int column_index = 0 ; column_index<board[0].length; column_index++){
            //an int array of length 9 all initialized to 0. will increase in count and if one index is greater then 1
            //it will reutrn the result as invalid
            for (int value_count =0; value_count<9; value_count++){
                valueCounter[value_count] = 0;
            }
            for (int row_index = 0 ; row_index<board.length; row_index++){
                tileValue = board[row_index][column_index];
                //checks if any input value was above 9 or below 0
                if (tileValue>9 || tileValue<0 ){
                    result =false;
                }
                // increases the valueCounter array index value by 1, if the value of the tile is not 0.
                else if(tileValue !=0){
                    valueCounter[tileValue-1]++;
                    //checks the index of the count if it is greater then 1, if it is the board is not valid.
                    if (valueCounter[tileValue-1]>1){
                        result =false;
                    }
                }
            }
        }


        //check for any values greater than 9 or less than 0 or any multiple occurrences of values per quadrant
        for(int quadrant = 0; quadrant < board.length; quadrant++){
            quadrantRow =quadrant/3;// quadrant row of the  sudoku board
            quadrantColumn =quadrant%3;// quadrant column of the sudoku board
            //an int array of length 9 all initialized to 0. will increase in count and if one index is greater then 1
            //it will reutrn the result as invalid
            for (int value_count =0; value_count<9; value_count++){
                valueCounter[value_count] = 0;
            }
            // times the quadrant row and column by 3 and ran it to plus 3 to have the specific quadrant checked in
            // the row division and column modulus location.
            for(int row_index = quadrantRow*3; row_index <quadrantRow*3 + 3; row_index++){
                for(int column_index = quadrantColumn*3; column_index <quadrantColumn*3 + 3; column_index++){
                    tileValue = board[row_index][column_index];
                    //checks if any input value was above 9 or below 0
                    if (tileValue>9 || tileValue<0 ){
                        result =false;
                    }
                    // increases the valueCounter array index value by 1, if the value of the tile is not 0.
                    else if(tileValue !=0){
                        valueCounter[tileValue-1]++;
                        //checks the index of the counter if it is greater then 1, if it is the board is not valid.
                        if (valueCounter[tileValue-1]>1){
                            result =false;
                        }
                    }
                }
            }
        }
        return result;
    }
    //returns the board tile value
    public int getBoardValue( int row, int column){
        return board[row][column];
    }
    // set the tile value on the board
    public void setBoardValue( int row, int column, int value){
        board[row][column] = value;
    }
    //get the board length of a row
    public int getBoardRowLength(){
        return board.length;
    }
    //get the board length of the column
    public int getBoardColumnLength(int row){
        return board[row].length;
    }

}
