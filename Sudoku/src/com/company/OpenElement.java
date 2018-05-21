package com.company;

/* Author: Abdul El Badaoui
* Student Number: 5745716
* Description: This class has to constructors, if the board has an open space it sets a constructor with a boolean
* value of true, a row index value, and column index value which will be passed down from the solve it class, and be
* stored in the methods to call upon in the SolveIt class. If false, it just stores a false boolean value in a method
* to call upon in the SolveIt class.
* */


public class OpenElement {

    int openRowIndex, openColumnIndex;
    boolean isOpen;
    //constructor if the space is open
    public OpenElement(boolean isOpenSpace, int rowIndex, int columnIndex){
        this.openRowIndex = rowIndex; //set the row
        this.openColumnIndex =columnIndex; //set the column
        this.isOpen =isOpenSpace;//set the boolean value

    }
    //constructor if space is false
    public OpenElement(boolean isOpenSpace){
        this.isOpen =isOpenSpace;

    }
    //return the bollean value
    public boolean getIfOpenSpace(){
        return isOpen;

    }
    //returns the row index
    public int getRowIndex(){
        return openRowIndex;
    }
    //returns the column index
    public int getColumnIndex(){
        return openColumnIndex;
    }
}
