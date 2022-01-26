import java.util.*;
import java.util.ArrayList;
/**
 * Each room has a name,  a protection rating, and a capacity which represents 
 * the maximum number of people(passes) who can be on the room at any one time. Each 
 * room must maintain a list of all people (passes)currently on the room. These lists 
 * are updated whenever passes enter or leave a room,so that it is always possible 
 * to say how many people (passes) are on the room and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Room {
    private int roomNumber;// Used to store the value of 'roomNumber'
    private String name;// Used to store the value of 'name'
    private int dangerRating;// Used to store the value of 'dangerRating'
    private int capacity;// Used to store the value of 'capacity'
    private int roomMinHours;// Used to store the value of 'roomMinHours'
    private boolean isInRoom;// Used to store the value of 'isInRoom'
    private int numberOfPeople;// Used to store the value of 'numberOfPeople'

    public ArrayList<Pass> passes = new ArrayList<>(); /* resizable array(automatic) holds instances of a pass so that everytime this class is called,
                                                          each room will have a different instance of the array, storing different passes dependant on where the passes have been moved to*/

    
    public Room() {
        // Empty Room constructor
    }

    public Room(int roomNumber, String name, int dangerRating, int capacity, int roomMinHours) {
        this.roomNumber = roomNumber;// Initialises the 'roomNumber' variable with the 'roomNumber' parameter which is passed as a parameter, but not yet an actual value
        this.name = name;// Initialises the 'name' variable with the 'name' parameter which is passed as a parameter, but not yet an actual value
        this.dangerRating = dangerRating;// Initialises the 'dangerRating' variable with the 'dangerRating' parameter which is passed as a parameter, but not yet an actual value
        this.capacity = capacity;// Initialises the 'capacity' variable with the 'capacity' parameter which is passed as a parameter, but not yet an actual value
        this.roomMinHours = roomMinHours;// Initialises the 'roomMinHours' variable with the 'roomMinHours' parameter which is passed as a parameter, but not yet an actual value
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    } //Sets the value of roomNumber

    public void setName(String name) {
        this.name = name;
    } //Sets the value of name

    public void setDangerRating(int dangerRating) {
        this.dangerRating = dangerRating;
    } //Sets the value of dangerRating

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    } //Sets the value of capacity

    public void setRoomMinHours(int roomMinHours) {
        this.roomMinHours = roomMinHours;
    } //Sets the value of roomMinHours

    public int getRoomNumber() {
        return this.roomNumber;
    } //returns the value of roomNumber

    public String getName() {
        return this.name;
    } //returns the value of name

    public int getDangerRating() {
        return this.dangerRating;
    } //returns the value of dangerRating

    public int getCapacity() {
        return this.capacity;
    } //returns the value of capacity

    public int getRoomMinHours() {
        return this.roomMinHours;
    } //returns the value of roomMinHours

    public void enter(Pass pass) {
        passes.add(pass);
    }  // adds pass to the passes array (dependant on what room is specified within the door class)

    public void leave(Pass pass) {
        passes.remove(pass);
    } //removes pass from the passes array (dependant on what room is specified within the door class)


    public int roomsCurrentCapacityLeft(){
        int numberOfSpacesLeft;
        numberOfPeople = passes.size();
        if(numberOfPeople < capacity){
            numberOfSpacesLeft = capacity - numberOfPeople;
        }
        else {
            numberOfSpacesLeft = 0;
        }
        return numberOfSpacesLeft;
    } // Method calculates number of available spaces left within the room then returns number of spaces left

    public String allPassesInRoom() {
        String passesInRoom = null;
        for (int i = 0; i < passes.size(); i++) {
            //System.out.println(i);
            if (i == 0 && (passes.size() > 1)) {
                passesInRoom = passes.get(i).getPassID() + ", ";
            }
            else if (passes.size() == 1){
                passesInRoom = "" + passes.get(i).getPassID();
            }
            if (i == 1) {
                passesInRoom += passes.get(i).getPassID();
            }
            if (i >= 2){
                passesInRoom += ", " + passes.get(i).getPassID();
            }
        }
        return passesInRoom;
    } // Method formats passes so that they're neatly displayed with a comma separating each pass within the array

    public String findDetails(Pass pass) {
        for (int i = 0; i < passes.size(); i++) {
            if (passes.get(i) == pass) {
                return pass.toString();
            }
        }
        return "";
    } // Searches through each index of the passes array so that if the parameter passed is equal to the index, it will return a string representation of the details of the given pass

    public int findID(Pass pass) {
        int pass_ID = 0;
        for (Pass value : passes) {
            if (value == pass) {
                pass_ID = pass.getPassID();
                return pass_ID;
            }
        }
        return 0;
    } // Searches through each index of passes just like previous method so that if the parameter passed is equal to an index within the passes array, will return the passes ID

    public boolean isInRoom(Pass pass) {
        for (Pass value : passes) {
            if (value == pass) {
                return true;
            }
        }
        return false;
    } // Method which finds out whether pass is in the given room or not.

    public String toString(){
        return "Room Name: " + name + "\nDanger Rating: " + dangerRating + "\nCapacity: " + capacity +
                "\nRoom minimum hours: " + roomMinHours + "\nPasses in Room: " + allPassesInRoom();
    } // returns the string representation of all the  information relevant to a given room.
}

