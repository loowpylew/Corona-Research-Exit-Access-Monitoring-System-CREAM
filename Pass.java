
/**
 * A Pass has an id number, name, a protection rating and number of hours.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pass {
    private int passID; // Used to store the value of a pass_ID
    private String staffName; // Used to store the value of owner of the pass
    private int protectionRating; // Used to store the value of the protection rating of the staff member
    private int allowableWorkingHours; // Used to store the allowable working hours a staff member has left
    private int numberOfHoursLeftToWork; // Used to store and which is left unaffected to refer back to, to set the allowable working hours back to its default number of hrs.
    private int numberOfMoves; //Used to store and act as a counter given once it reaches a maximum of 5. Prevents a pass from meeting the relevant required condition to move into a room.
    public Pass() {
    }

    public Pass(int passID, String staffName, int protectionRating, int allowableWorkingHours) {
        this.passID = passID;// Initialises the 'PassID' variable with the 'passID' parameter which is passed as a parameter, but not yet an actual value
        this.staffName = staffName;// Initialises the 'staffName' variable with the 'staffName' parameter which is passed as a parameter, but not yet an actual value
        this.protectionRating = protectionRating;// Initialises the 'protectionRating' variable with the 'protectionRating' parameter which is passed as a parameter, but not yet an actual value
        this.allowableWorkingHours = allowableWorkingHours;// Initialises the 'allowableWorkingHours' variable with the 'allowableWorkingHours' parameter which is passed as a parameter, but not yet an actual value
        this.numberOfHoursLeftToWork = allowableWorkingHours; // Initialises the 'numberOfHoursLeftToWork' variable with the 'allowableWorkingHours' parameter which is passed as a parameter, but not yet an actual value
        this.numberOfMoves = 0;// Initialises the 'numberOfMoves' variable with the default value of 0
    }

    ///////////////Start of setters/////////////////

    public void setPassID(int passID) {
        this.passID = passID;
    } //Sets the value of 'PassID'

    public void setStaffName(String passName) {
        this.staffName = passName;
    }//Sets the value of 'StaffName'

    public void setProtectionRating(int protectionRating) {
        this.protectionRating = protectionRating;
    } // Sets the value of 'ProtectionRating'

    public void setAllowableWorkingHours(int allowableWorkingHours) {
        this.allowableWorkingHours = allowableWorkingHours;
    }// Sets the value of 'allowableWorkingHours'

    public void setNumberOfHoursLeftToWork(int allowableWorkingHours) {
        this.numberOfHoursLeftToWork = allowableWorkingHours;
    } //Sets the value of 'numberOfHoursLeftToWork' to allowableWorking hours and will remain unchanged

    public void setNumberOfMoves() {
        this.numberOfMoves = 0;
    } //Sets the value of 'number of moves

    //////////////////End of setters////////////////////

    //////////////////Start of Getters//////////////////
    public int getPassID() {
        return this.passID;
    } // returns the 'Pass_ID'

    public String getStaffName() {
        return this.staffName;
    } // returns the 'staffName'

    public int getProtectionRating() {
        return this.protectionRating;
    } // returns the 'protectionRating'

    public int getAllowableWorkingHours() {
        return this.allowableWorkingHours;
    }// returns the allowableWorking hours

    public int getNumberOfMoves() {
        return this.numberOfMoves;
    }// returns the 'numberOfMoves' made
    //////////////////End of Getters//////////////////


    public void deductHours(int hrs) {
        allowableWorkingHours -= hrs;
        } //Method which deducts a number of hrs away from 'allowableWorkingHours'


    public void incrementMoves() {
        numberOfMoves++;
    }// Method which increments moves by one

    public void resetHoursAndMoves() {
        allowableWorkingHours = numberOfHoursLeftToWork; //Method which resetsHours back to original hrs of a given a pass and rests 'numberOfMoves' back to 0
        numberOfMoves = 0;
    }

    //Method which returns all values relevant to the pass in the form of a string
    public String toString() {
        return "Staff name: " + staffName + "\n Pass ID: "+ passID + "\n Protection Rating: "+ protectionRating + "\n AllowableWorkingHours: " + allowableWorkingHours + "\n Number of moves made: " + numberOfMoves;
    }
}



