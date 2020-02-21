/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dohuu;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This test case allows users to create town and its information
 *
 * @author Khang Do 2020
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        //Prompt user to enter how many town they want to create
        boolean continueInput = true;
        int num = 0;
        do {
            //Catch error when user doesn't input an Integer
            try {
                System.out.print("How many town do you want to create? ");
                num = validateNumber(input.nextInt());
                input.nextLine();

                continueInput = false;
            } catch (InputMismatchException ex1) {
                System.out.println("Error: the value must be an Integer");
                input.next();
                System.out.print("Please input the number of town again: ");
            } catch (IllegalArgumentException ex2) {
                System.out.println("Error: the value must be positive");
                System.out.print("Please input the number of town again: ");
            }
        } while (continueInput);
        continueInput = true;
        //Create an Array for all the towns and assign as default constructors
        FantasyTown[] allTown = new FantasyTown[num];
        for (int i = 0; i < num; i++) {
            allTown[i] = new FantasyTown();
        }

        //Condition for the loop in the main method.
        continueInput = true;
        String temp;
        int countLoop = 0;
        //Loop for creating a town, repeat when user want to create a new town
        for (int i = 0; continueInput; i++) {
            System.out.print("Please input the name of the town: ");
            do {
                try {
                    allTown[i].setName(input.nextLine());

                    continueInput = false;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: value cannot be the null object "
                            + "or the empty String");
                    System.out.println("Please input the name of town again: ");
                }
            } while (continueInput);

            continueInput = true;
            System.out.print("Please input the capacity of the town: ");
            do {
                try {
                    allTown[i].setCapacity(input.nextInt());

                    continueInput = false;
                } catch (IllegalArgumentException exp1) {
                    System.out.println("Error: the value is at least 1");
                    System.out.print("Please input the capacity again: ");
                } catch (InputMismatchException exp2) {
                    System.out.println("Error: the value must be an Integer");
                    input.next();
                    System.out.print("Please input the capacity again: ");
                }
            } while (continueInput);

            input.nextLine();
            continueInput = true;
            boolean occupantInput = true;
            System.out.println("Please add the current occupants: ");
            System.out.println("You can input 0 to mention "
                    + "\"No additional occupants\".");
            do {
                try {
                    int count = 1;
                    temp = null;
                    do {
                        if (count < allTown[i].getCapacity()) {
                            temp = input.nextLine();
                            count++;
                        }
                        if (!"0".equals(temp)) {
                            //occupantInput = false;}
                            //else if (count < town1.getCapacity()) {
                            allTown[i].addOccupant(temp);
                        } else {
                            occupantInput = false;
                        }
                        if (count == allTown[i].getCapacity()) {
                            occupantInput = false;
                        }

                    } while (occupantInput);
                    continueInput = false;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: the value cannot be "
                            + "a null object or an empty String");
                }
            } while (continueInput);

            continueInput = true;

            System.out.print("Please input the x & y "
                    + "coordinates for your town:  ");
            double x = 0;
            double y = 0;
            do {
                try {
                    allTown[i].setCoordinates(x, y);

                    continueInput = false;
                } catch (IllegalArgumentException exp1) {
                    System.out.println("Error: the value is "
                            + "in range of 0 and 100");
                    System.out.print("Please input again: ");
                } catch (InputMismatchException exp2) {
                    System.out.println("Error: the value must be an Double");
                    System.out.print("Please input again: ");                                       
                }
            } while (continueInput);

            //input.nextLine();
            continueInput = true;
            System.out.println("Do you want to input "
                    + "your town's description? (Yes/No)");
            temp = input.next().trim().toLowerCase();
            
            while (!"yes".equals(temp) && !"no".equals(temp)) {
                System.out.println("Please input Yes or No.");
                temp = input.next().trim().toLowerCase();
            }
            if ("yes".equals(temp)) {
                input.nextLine();
                System.out.println("Please input your town's description: ");
                do {
                    try {
                        allTown[i].setDescription(input.nextLine());

                        continueInput = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: value cannot be "
                                + "the null object or the empty String");
                    }
                } while (continueInput);
            }
            continueInput = true;

            //Print the information of the town entered
            System.out.println(allTown[i].toString());

            //Stopping when it reaches the limited town user want to create
            countLoop++;
            if (countLoop < num) {

                //Ask user to add information for the next town in the array.
                System.out.println("Do you want to enter another "
                        + "town's information? (Yes/No)");
                temp = input.next().trim().toLowerCase();
                //Makes sure user input correctly
                while (!"yes".equals(temp) && !"no".equals(temp)) {
                    System.out.println("Please input Yes or No.");
                    temp = input.next().trim().toLowerCase();
                }
                if ("no".equals(temp)) {
                    continueInput = false;
                }
                input.nextLine();
            } else {
                continueInput = false;
            }
        }
        //Get the index of the current town
        int currentIndex = countLoop - 1;
        //Inform the user where they are and ask them how far 
        //they are willing to walk
        System.out.println("You are at the town "
                + allTown[currentIndex].getName());
        continueInput = true;
        while (continueInput) {
            System.out.print("How many kilometres are you willing to walk? ");
            double distance = 0;
            do {
                try {
                    distance = validateDistance(input.nextDouble());

                    continueInput = false;
                } catch (IllegalArgumentException ex1) {
                    System.out.println("Error: value should be positive");
                    System.out.print("Please input the distance again: ");
                } catch (InputMismatchException ex2) {
                    System.out.println("Error: the value is invalid");
                    System.out.print("Please input the distance again: ");
                    input.next();
                }
            } while (continueInput);
            continueInput = true;
            //Calculate the distance and show the list of towns
            System.out.println("The list of town where you can walk: ");
            int countTown = 0;
            double tempDist;
            //Calculate the distance and printout the list of town
            for (int i = 0; i < num; i++) {
                tempDist = allTown[i].
                        calculateDistanceTo(allTown[currentIndex]);
                //Only print if its distance is lower than the chosen distance
                //and it below the number of town user created.
                if ((i != currentIndex) && (tempDist <= distance)) {
                    System.out.println((countTown + 1)
                            + ". " + allTown[i].getName());
                    countTown++;
                }
            }

            if (countTown == 0) {
                System.out.println("You're too lazy, try to walk further.");
                break;
            }

            //User choose a number of town to walk to
            while (continueInput) {

                int choice = 0;
                do {
                    //Catch error when user doesn't input an Integer
                    try {
                        System.out.print("What town do you want to walk to, "
                                + "please pick a number "
                                + "(e.g. 1. A town, type 1)? ");
                        choice = validateNumber(input.nextInt());
                        input.nextLine();

                        continueInput = false;
                    } catch (InputMismatchException ex1) {
                        System.out.println("Error: the value must be "
                                + "an Integer");
                        input.next();
                        System.out.print("Please input your choice again: ");
                    } catch (IllegalArgumentException ex2) {
                        System.out.println("Error: the value must be positive");
                        System.out.print("Please input your choice again: ");
                    }
                } while (continueInput);
                continueInput = true;
                //Get back the index of the chosen town.
                countTown = 0;

                //temp Index for the chosen town before user moves in
                int tempIndex = currentIndex;
                for (int i = 0; i < num; i++) {
                    tempDist = allTown[i].
                            calculateDistanceTo(allTown[currentIndex]);
                    if ((i != currentIndex) && (tempDist <= distance)) {
                        countTown++;
                        //Get the tempIndex for chosen town
                        if (countTown == choice) {
                            tempIndex = i;
                        }
                    }

                }
                //If the choice is less than the total town and 
                //the chosen town is not full.
                if ((choice <= countTown) && (!allTown[tempIndex].isFull())) {
                    currentIndex = tempIndex;
                    System.out.println("You are now at the town "
                            + allTown[currentIndex].getName());
                    break;

                } else if ((choice <= countTown)
                        && (allTown[tempIndex].isFull())) {
                    System.out.println("Sorry, your town chosen is full, "
                            + "please choose another one.");
                    countTown = 0; //Reset the count for number of Town
                    //Run the test distance again
                    for (int i = 0; i < num; i++) {
                        tempDist = allTown[i].
                                calculateDistanceTo(allTown[tempIndex]);
                        if ((i != currentIndex) && (tempDist <= distance)
                                && (i != tempIndex)) {
                            System.out.println((countTown + 1) + ". "
                                    + allTown[i].getName());
                            countTown++;
                        }

                    }
                    if (countTown == 0) {
                        System.out.println("Sorry, there is no more town.");
                        continueInput = false; //Terminates the program.
                        break;

                    }
                }

            }
        }
    }

    /**
     *
     * @param distance how far do you want to walk
     * @return distance of walking of user
     * @throws IllegalArgumentException if the distance is negative
     */
    public static double validateDistance(double distance)
            throws IllegalArgumentException {
        if (distance < 0) {
            throw new IllegalArgumentException("Error: value "
                    + "should be positive");
        }
        return distance;
    }

    public static int validateNumber(int num)
            throws IllegalArgumentException {
        if (num <= 0) {
            throw new IllegalArgumentException("Error: value "
                    + "should be positive");
        }
        return num;
    }

}
