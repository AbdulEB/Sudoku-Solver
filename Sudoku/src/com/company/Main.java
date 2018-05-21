package com.company;

/* Author: Abdul El Badaoui
* Student Number: 5745716
* Description: The main class run the entire program. It sets the board size, and run the program in a for loop until
*  user wishes to end. It asks the user to input the file name and it passes it to the board class to initialize the
*  board and then checks if the board is valid or not. If the board is valid it will continue and pass the board to
*  the solve it class, and if not, it will ask the user whether he wishes to continue or not.
* */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static final int BOARD_SIZE = 9;// sets te board size length

    public static void main(String[] args) throws FileNotFoundException {
        // infinite loop until user breaks from the program
        for ( ; ; ){
            int userFileSelection = 0;
            Scanner userInput = new Scanner(System.in);
            //while loop to input a valid integer for an existing file path name or insert your own
            while (userFileSelection>4 || userFileSelection<1 ){
                System.out.println("Please enter an integer value from 1 to 3 to select a file or 4 for a specified file path");
                //check if an integer was input
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a perferred number!");
                    userInput.next();
                }
                userFileSelection = userInput.nextInt();
            }
            String filePath = "";
            // set the path based on the number that was inputted
            if (userFileSelection == 1){
                filePath = "valid.txt";
            }
            else if (userFileSelection == 2){
                filePath = "invalid.txt";
            }
            else if (userFileSelection == 3){
                filePath = "unsolvable.txt";
            }
            else if (userFileSelection == 4){
                System.out.println("Please enter file path");
                filePath = userInput.next();
            }
            //declares a new instance of the board
            Board sudokuBoard = new Board((new int[BOARD_SIZE][BOARD_SIZE]), filePath);
            System.out.println("Selected board (Empty): ");
            //print the initial instance of the board
            sudokuBoard.printBoard();
            //check the validity of the board
            boolean isValid = sudokuBoard.isValid();
            if (isValid==true){
                System.out.println("Yes! The Board is valid");
                //solvae the board if valid
                SolveIt solveSudoku = new SolveIt(sudokuBoard);
                //if board is solvable
                if (solveSudoku.backTrack(sudokuBoard)){
                    System.out.println("The Solution:");
                    System.out.println();
                    sudokuBoard.printBoard();
                }
                else{//if the board has no solution
                    System.out.println();
                    System.out.println("The board has no solution");
                }

            }
            else{//if board is invalid
                System.out.println("No! The board is invaid");
            }
            System.out.println();
            //if the user wishes to continue
            System.out.println("Do you wish to continue, please press 'Y' or 'y' ");
            String userContinueAnswer = userInput.next();
            if (userContinueAnswer.equals("Y")|| userContinueAnswer.equals("y")){

            }
            else{
                break;
            }

        }

    }
}
