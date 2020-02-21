/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dohuu;
import java.util.Scanner;
/**
 * Model a fiction town in a game setting.
 *
 * @author Khang Do 2020
 */
public class FantasyTown {

    //the default name is "A Town without a Name"
    private String name = "A Town without a Name";
    //the default description is "A mysterious place 
    //the capacity of a town must be at least 1
    private int capacity = 1;
    //you’ve never been to before"
    private String description = "A mysterious place "
            + "you’ve never been to before";
    private String[] occupants = new String[capacity];

    private double[] coordinates = new double[2];

    /**
     * Create a constructor with default value for data members, the default
     * name is "A Town without a Name", the default description is “A mysterious
     * place you’ve never been to before”, the default occupants is "The Mayor",
     */
    //Create a constructor with a default value for data members    
    public FantasyTown() {

        setName(name);
        setCapacity(capacity);
        //setCoordinates(coordinates[0], coordinates[1]);

        //the default occupant called "The Mayor"
        //occupants = new String[capacity];
        occupants[0] = "The Mayor";

    }

    /**
     * Creates constructor for a given name, capacity and coordinates
     *
     * @param name is the name of the town
     * @param capacity of the town
     * @param x coordinate, location of the town
     * @param y coordinate, location of the town
     * @throws IllegalArgumentException if input form name, capacity and
     * coordinates are inappropriate
     */
    public FantasyTown(String name, int capacity, double x, double y)
            throws IllegalArgumentException {
        setName(name);
        setCoordinates(x, y);

        setCapacity(capacity);
        occupants[0] = "The Mayor";
        getNumberOfOccupant();
    }

    /**
     * Gets the name of the town
     *
     * @return the name of the town
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a name for the town
     *
     * @param name of the town
     * @throws IllegalArgumentException if name is a null or "" String
     */
    public void setName(String name) throws IllegalArgumentException {
        if ((name == null) || (name.trim().isEmpty())) {
            throw new IllegalArgumentException("Error: value cannot be "
                    + "the null object or the empty String");
        } else {
            this.name = name;
        }
    }

    /**
     * Gets the town's description
     *
     * @return the description of the town
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the town
     *
     * @param description of the town
     * @throws IllegalArgumentException if description is a null or "" String
     */
    public void setDescription(String description)
            throws IllegalArgumentException {
        if ((description == null) || ("".equals(description))) {
            throw new IllegalArgumentException("Error: value cannot be "
                    + "the null object or the empty String");
        } else {
            this.description = description;
        }
    }

    /**
     * Creates a new description for a town
     *
     * @param description
     */
    public void addToDescription(String description)
            throws IllegalArgumentException {
        if ((description == null) || ("".equals(description))) {
            throw new IllegalArgumentException("Error: value cannot be "
                    + "the null object or the empty String");
        } else {
            this.description = description;
        }
    }

    /**
     * Gets occupants for the town
     *
     * @return the occupants of the town
     */
    public String[] getOccupants() {
        return occupants;
    }

    /**
     * Picks a random occupant in the occupants list in a town
     *
     * @return a random occupant member.
     */
    public String getRandomOccupant() {
        int randNumber = (int) (Math.random() * getNumberOfOccupant());
        return occupants[randNumber];
    }

    /**
     * Calculates the number of occupant in a town
     *
     * @return number of occupant in a town
     */
    public int getNumberOfOccupant() {
        int count = 0;
        for (String occupant : occupants) {
            if ((occupant != null) && (!"".equals(occupant))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks whether the occupant name is in the town or not.
     *
     * @param name of a occupant who needs to check
     * @return true if the occupant is in the town, and false if not.
     */
    public boolean hasOccupant(String name) {
        boolean temp = false;
        for (String occupant : occupants) {
            if (occupant.equals(name)) {
                temp = true;
            }
        }
        return temp;
    }

    /**
     * Adds a new occupant to a town.
     *
     * @param name of the occupant who needs to add
     * @throws IllegalArgumentException if name is a null of "" String
     */
    public void addOccupant(String name) throws IllegalArgumentException {
        if ((name == null) || (name.trim().isEmpty())) {
            throw new IllegalArgumentException("Error: value cannot be"
                    + "the null object or the empty String");
        } else {
            if (getNumberOfOccupant() < capacity) {
                occupants[getNumberOfOccupant()] = name;
            }
        }
    }

    /**
     * Gets the capacity of the town
     *
     * @return the capacity of the town
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the town
     *
     * @param capacity the capacity to set
     * @throws IllegalArgumentException if the capacity is lower than 1.
     */
    public void setCapacity(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Error: the value can not"
                    + "below 1");
        } else {
            this.capacity = capacity;
        }
        occupants = new String[capacity];
        occupants[0] = "The Mayor";
    }

    /**
     * Increase the capacity for a town for a certain amount.
     *
     * @param amount of increasing capacity
     * @throws IllegalArgumentException if the amount is less than 1
     */
    public void increaseCapacity(int amount) throws IllegalArgumentException {
        if (amount < 1) {
            throw new IllegalArgumentException("Error: the value is "
                    + "at least 1");
        } else {
            setCapacity(capacity + amount);
        }

    }

    /**
     * Checks whether a town is full or not.
     *
     * @return true is the town is full, false if it's not.
     */
    public boolean isFull() {
        boolean temp = false;
        if (getNumberOfOccupant() == capacity) {
            temp = true;
        }
        return temp;
    }

    /**
     * Gets the coordinates of the town location
     *
     * @return the coordinates of the town
     */
    public double[] getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the coordinates x and y for a location of the town
     *
     * @param x how far along the horizontal axis
     * @param y how far along the vertical axis
     * @throws IllegalArgumentException if \the coordinate is not in the range
     * of 0 and 100
     */
    public void setCoordinates(double x, double y) {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Please input the x: ");
        x = input.nextDouble();
        System.out.print("Please input the y: ");
        y = input.nextDouble();
        if ((x < 0) || (x > 100) || (y < 0) || (y > 100)) {
            throw new IllegalArgumentException("Error: the value should be "
                    + "in the range of 0 and 100");
        } else {
            coordinates[0] = x;
            coordinates[1] = y;
        }
    }

    /**
     * Calculates the distance between the current town and nearbyTown
     *
     * @param nearbyTown a FantasyTown object
     * @return the distance between current town and nearbyTown
     */
    public double calculateDistanceTo(FantasyTown nearbyTown) {
        double[] nearbyCoordinates = nearbyTown.getCoordinates();

        return Math.sqrt(Math.pow(coordinates[0] - nearbyCoordinates[0], 2)
                + Math.pow(coordinates[1] - nearbyCoordinates[1], 2));

    }

    /**
     * Creates the String output for FantasyTown program
     *
     * @return a String for a town information of name, location, capacity and
     * number of current occupants
     */
    @Override
    public String toString() {
        String temp;
        getNumberOfOccupant();
        temp = String.format("\n%s is located at (%2.2f, %2.2f) and",
                name, coordinates[0], coordinates[1]);
        temp += String.format(" is occupied by %d out of a possible %d people.",
                getNumberOfOccupant(), capacity);
        temp += String.format("\n%s is %s", name, description);
        return temp;
    }
}
