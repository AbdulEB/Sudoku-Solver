package com.company;

/* Author: Abdul El Badaoui
* Student Number: 5745716
* Description: This class passes in the board from the main class and run the backTrack method, t solve the board.
*
* */
public class SolveIt {

    Board board;
    //consturctor that passes the board
    public SolveIt(Board sudokuBoard){

        this.board =sudokuBoard;//sets the board

    }
    //back track method, that solves the sudoku board in first major row order
    public boolean backTrack(Board board){
        int openRowLocation, openColumnLocation;// open space row and column indices

        OpenElement currentSpace = findOpenElements(board);// instance of open space

        if (currentSpace.getIfOpenSpace()==false){// if the space is not open
            return true;
        }
        else {// if space is open
            openRowLocation= currentSpace.getRowIndex();//set open row index
            openColumnLocation= currentSpace.getColumnIndex(); // set open column index

        }
        //check the candidate
        for (int num = 1; num <= 9; num++){
            //if candidate is acceptable it continues (method checks valid of the number candidate in the given coordinates)
            if (checkViableCandidates(board, openRowLocation, openColumnLocation, num))  {
                //set the board tile with the value candidate
                board.setBoardValue(openRowLocation,openColumnLocation, num);
                //recursive call to the backtrack method
                if (backTrack(board))
                    return true;
                // reset the position to 0
                board.setBoardValue(openRowLocation,openColumnLocation, 0);
            }
        }

        //returns false if no valid candidate is acceptable
        return false;


    }
    //finds open elements
    public OpenElement findOpenElements( Board board){

        for (int row_index = 0; row_index < board.getBoardRowLength(); row_index++){
            for (int column_index = 0; column_index < board.getBoardColumnLength(row_index); column_index++){
                if (board.getBoardValue(row_index, column_index) == 0){
                    return new OpenElement(true, row_index, column_index);
                }
            }
        }
        return new OpenElement(false);

    }
    //checks if the candidate is acceptable at location
    public boolean checkViableCandidates(Board board, int rowLocation, int columnLocation, int candidate){

        //checks row if candidate already exists
        for (int column_index =0; column_index<board.getBoardColumnLength(rowLocation); column_index++){
            if (board.getBoardValue(rowLocation, column_index)==candidate){
                return false;
            }
        }
        //checks column if candidate already exists
        for (int row_index =0; row_index<board.getBoardRowLength(); row_index++){
            if (board.getBoardValue(row_index, columnLocation)==candidate){
                return false;
            }
        }

        //check quadrant if candidate already exists
        for (int row_index = (rowLocation/3)*3; row_index< (rowLocation/3)*3+3; row_index++){
            for (int column_index = (columnLocation/3)*3; column_index< (columnLocation/3)*3+3; column_index++){
                if (board.getBoardValue(row_index, column_index)==candidate){
                    return false;
                }
            }
        }



        return true;
    }




}
