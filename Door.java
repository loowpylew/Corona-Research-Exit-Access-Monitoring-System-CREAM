
/**
 * A door provides a one-way connection between two rooms. It
 * has a Door number and information about both the "from" and
 * the "to" room
 * @param doorNumber - door Number for each room
 * @param Room from - current room the pass is in
 * @param Room to - the room the pass wants to move to
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door
{
    //Private fields
    private int doorNumber; // Used to store the value of door number
    private Room from, to; // Used to store the value of the 'from' room and the 'to' room

    public Door(int doorNumber, Room from, Room to){
        this.from = from; // Initialises the 'from' variable with the 'from' parameter which is passed as a parameter, but not yet an actual value
        this.to = to; // Initialises the 'to' variable with the 'to' parameter which is passed as a parameter, but not yet an actual value
        this.doorNumber = doorNumber; // Initialises the 'doorNumber' variable with the 'to' parameter which is passed as a parameter, but not yet an actual value

    }

    public void setDoorNumber(int doorNumber){
        this.doorNumber = doorNumber;
    } //Sets the value of doorNumber

    public void setFrom(Room from) {
        this.from = from;
    }// Sets the value of the 'from' room
    public void setTo(Room to){
        this.to = to;
    }// Sets the value of the 'to' room


    public int getDoorNumber(){ return this.doorNumber;}// returns the value of the doorNumber
    public Room getFrom(){
        return this.from;
    }// returns the value of the 'from' room
    public Room getTo(){
        return this.to;
    }// returns the value of the 'to' room

    //Method which uses the value of a pass as a parameter to see if the pass meets the varying conditions to enter a room. Returns true if the conditions are met, otherwise returns false
    public boolean canMove(Pass pass) {
        if ((pass.getAllowableWorkingHours() >= to.getRoomMinHours()) &&
                (pass.getProtectionRating() >= to.getDangerRating()) &&
                (to.roomsCurrentCapacityLeft() > 0) &&
                (from.isInRoom(pass) && pass.getNumberOfMoves() < 5 && pass.getPassID() == from.findID(pass)) && (doorNumber == 0 || doorNumber == 1 || doorNumber == 2 || doorNumber == 3 ||
                doorNumber == 4 || doorNumber == 5 || doorNumber == 6 || doorNumber == 7 || doorNumber == 8)){
            return true;
        }
        return false;
    }

    //Method which calls the 'can move method to determine whether the pass meets all the conditions, then if so, will enter the new room, leave the current room, deduct relevant hrs and increment moves.
    //Method will then return a string stating the pass has entered a given room else, will return a string stating the pass did not meet the conditions.
    public String move(Pass pass){
        if(canMove(pass)){
            to.enter(pass);
            from.leave(pass);
            pass.deductHours(to.getRoomMinHours());
            pass.incrementMoves();
            return pass.getStaffName() + " has entered room " + to.getRoomNumber();
        }
        else {
            return pass.getStaffName() + " does not meet one of the conditions to enter ";
        }
    }

    // Method returns a string of all details about a the door number that has been specified, the to.room and from.room and the names of these rooms.
    public String toString(){
        return "Door number: " + doorNumber + "\nRoom from number: " + from.getRoomNumber() + "\nRoom to number: " + to.getRoomNumber() + "\nRoom from name: " + from.getName() + "\nRoom to name: " + to.getName();
    }
}
