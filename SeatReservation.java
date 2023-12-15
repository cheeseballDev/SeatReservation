package javaActivities;

import java.util.*;

public class SeatReservation {
    
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] bus = new String[11][4];
        boolean flag = true;
        int selectedRow, selectedCol;
        String selectedNum;
        String[] changeRowColumn;
        
        System.out.println("Bus Seat Reservation:");
        System.out.print("       ");
        for (int column = 0; column < bus[0].length; column++){
            System.out.print(" Col " + (column +1));
        }
        for(int row = 0; row < bus.length; row++) {
            if(row != 0) {
                System.out.printf("Row %2d |", (row));
            }
            for(int column = 0; column < bus[row].length; column++) {
                if (row != 0) {
                    bus[row][column] = "*";
                    System.out.printf("%5.5s", bus[row][column]);  
                }
            }
            System.out.println("\t");
        }
        while(flag){
            System.out.print("Enter row and column number to reserve separated by space (Enter a negative number to exit): ");
            selectedNum = userInput.nextLine();
            changeRowColumn = selectedNum.split(" ");
            selectedRow = Integer.parseInt(changeRowColumn[0]);
            if (changeRowColumn.length == 2) {
                selectedCol = Integer.parseInt(changeRowColumn[1]);
                if ((selectedRow >= 1 && selectedRow <= 10) && (selectedCol >= 1 && selectedCol <= 4)){
                    if(bus[selectedRow][selectedCol-1].equals("*")) {
                        bus[selectedRow][selectedCol-1] = "X";
                        System.out.print("       ");
                        for (int column = 0; column < bus[0].length; column++){
                            System.out.print(" Col " + (column + 1));
                        }
                        for(int row = 0; row < bus.length; row++) {
                            if(row != 0) {
                                System.out.printf("Row %2d |", (row));
                            }
                            for(int column = 0; column < bus[row].length; column++) {
                                if (row != 0) {
                                    System.out.printf("%5.5s", bus[row][column]);  
                                }
                            }
                            System.out.println("\t");
                        }
                    } else if(selectedRow < 0 || selectedCol < 0) {
                        System.out.println("Program exit!");
                        flag = false;
                    } else {
                        System.out.println("Seat already reserved! Try again.");
                        continue;
                    }
                } else {
                    System.out.println("Invalid choice! Please try again.");
                }
            } else if(selectedRow < 0) {
                System.out.println("Program exit!");
                flag = false;
            }  else {
                System.out.println("Please enter two valid separated by space numbers.");
                continue;
            }
        }
    }
}
