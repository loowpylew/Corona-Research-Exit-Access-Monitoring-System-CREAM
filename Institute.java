import java.util.*;

/**
 *
 * @author A.A.Marczyk 
 * @version 09/11/20
 **/
public class Institute implements CREAM {
    private ArrayList<Pass> allPasses = new ArrayList<Pass>();
    private ArrayList<Room> allRooms = new ArrayList<Room>();
    private ArrayList<Door> allDoors = new ArrayList<Door>();
    /**
     * constructor
     */
    public Institute() {
        loadPasses();
        loadRooms();
        setUpDoors();
        enter();
    }

    /**
     * Returns all of the details of all rooms including the passes
     * currently in each room, or "No passes"
     *
     * @return all of the details of all rooms including location
     * of all passes currently in each room, or "No passes"
     */
    public String toString() {
        String detailsOfAllRooms = "";
        for (int i = 0; i < allRooms.size(); i++) {
            detailsOfAllRooms += "\n" + allRooms.get(i).toString() + "\n";
        }
        return "All details of all rooms: " + "\n" + detailsOfAllRooms;
    }

    /**
     * Returns a String representation of all the passes in all rooms
     *
     * @return a String representation of all passes in all rooms, room code
     * and name should be included at the start of the list
     **/
    public String getAllPassesInAllRooms() {
        int i = 0;
        String allPassesInAllRooms = "";
        for (Room temp : allRooms) {
            allPassesInAllRooms += allRooms.get(i).getName() + "\n" + allRooms.get(i).allPassesInRoom() + "\n";
            i++;
        }

        return "Passes in all rooms: " + "\n" + allPassesInAllRooms;

    }


    /**
     * Returns the name of the room which contains the specified pass or null
     *
     * @param ps - the specified pass
     * @return the number of the Room which contains the pass, or -1
     **/
    public int findPass(int ps) {
        int i = 0;
        for (Pass temp : allPasses) {
            if (allPasses.get(i).getPassID() == ps) {
                for (int j = 0; j < allRooms.size(); j++) {
                    if (allRooms.get(j).isInRoom(temp)) {
                        return allRooms.get(j).getRoomNumber();
                    }
                }
            }
            i++;
        }
        return -1;
    }

    /**
     * Given the name of a room, returns the room code
     * or null if room does not exist
     *
     * @param //name of room
     * @return number of room, or -1 if the room does not exist
     */
    public int getRoomNo(String nm) {
        for (int i = 0; i < allRooms.size(); i++) {
            if (allRooms.get(i).getName().equals(nm)) {
                return allRooms.get(i).getRoomNumber();
            }
        }
        return -1;
    }

    /**
     * Returns a String representation of all the passes in specified room
     *
     * @return a String representation of all passes in specified room, or
     * "No such room"
     * @roomCode the room code
     **/
      public String getAllPassesInRoom(int rmNo) {
        String allPassesInRoom = "";
        for (int i = 0; i < allRooms.size(); i++) {
            if (allRooms.get(i).getRoomNumber() == rmNo) {
                    allPassesInRoom = allRooms.get(i).allPassesInRoom();
                }
            i++;
        }
        return "All passes in room: " + allPassesInRoom;

    }

    /**
     * Returns a String with all of the details of a Pass
     *
     * @param //passNo is the pass number
     * @return all details of the Pass, or "No such Pass"
     */
    public String showPass(int pNo) {
        String passDetails = "";
        for (int i = 0; i < allPasses.size(); i++) {
            if (allPasses.get(i).getPassID() == pNo) {
                return allPasses.get(i).toString();
            }
        }
        return "No such Pass";
    }

    /**
     * Returns true if a Pass is allowed to move using the door, false otherwise
     * A move can be made if:
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     *
     * @param psId   is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return true if the pass is allowed in the move, false otherwise
     **/
    public boolean canMove(int psId, int doorNo) {
        for (int i = 0; i < allPasses.size(); i++) {
            if (allPasses.get(i).getPassID() == psId) {
                for (int j = 0; j < allDoors.size(); j++) {
                    if(allDoors.get(j).getDoorNumber() == doorNo) {
                        return allDoors.get(j).canMove(allPasses.get(i));
                    }
                }
            }
        }

        return false;

    }

    /**
     * Returns the result of a pass requesting to move by Door.
     * A move will be successful if:
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has sufficient hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * If the move can be made, the pass information is removed from the source
     * room, added to the destination room and a suitable message returned.
     * If move cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     *
     * @param psId   is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return a String giving the result of the request
     **/
    public String move(int psId, int doorNo) {
        for (Pass temp : allPasses) {
            if (temp.getPassID() == psId) {
                for (Door allDoor : allDoors) {
                    if (allDoor.getDoorNumber() == doorNo) {
                        return allDoor.move(temp);
                    }
                }
            }
        }
        return "Not moved";
    }
    /**
     * Resets all passes:  moves to 0, available hours left to allowable hours
     */
    public void resetAllPasses() {

        for(Pass temp: allPasses) {
            temp.resetHoursAndMoves();
            for(int i = 0; i < allRooms.size(); i++) {
                allRooms.get(i).leave(temp);
            }
        }
        enter();

    }
    // These methods are for Task 7 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following 

    /**
     * Resets one passes: moves to 0, available hours left to allowable hours
     *
     * @param id of the pass
     */
    public void resetPass(int id) {
        for (int i = 0; i < allPasses.size(); i++) {
            if (allPasses.get(i).getPassID() == id) {
                allPasses.get(i).resetHoursAndMoves();
                for (Room temp : allRooms) {
                    if (temp.findID(allPasses.get(i)) == id) {
                        allPasses.get(i).deductHours(temp.getRoomMinHours());
                    }
                }
            }
        }
    }


    /**
     * Moves a pass directly back to the Outside without affecting data
     * and not using existing doors
     */
    public void moveOutside(int id) {
        for (Pass temp : allPasses) {
            if (temp.getPassID() == id) {
                for (int i = 0; i < allRooms.size(); i++) {
                    if (allRooms.get(i).findID(temp) == id) {
                        allRooms.get(i).leave(temp);
                    }
                    if (allRooms.get(i).getName().equals("Outside")) {
                        allRooms.get(i).enter(temp);
                    }
                }
            }
        }
    }


    /**
     * In an emergency, evacuates all passes directly back to the Outside without
     * affecting information and not using existing doors
     */
    public void evacuateAll() {
        for (Pass temp : allPasses) {
            for (int i = 0; i < allRooms.size(); i++) {
                allRooms.get(i).leave(temp);
                if (allRooms.get(i).getName().equals("Outside")) {
                    allRooms.get(i).enter(temp);
                }
            }
        }
    }


    //***************private methods**************
    private void loadRooms() {
        Room outSide = new Room(100, "Outside", 0, 1000, 0);
        allRooms.add(outSide);
        Room staffRoom = new Room(101, "Staff Room", 1, 100, 1);
        allRooms.add(staffRoom);
        Room lab1 = new Room(102, "Lab1", 3, 10, 3);
        allRooms.add(lab1);
        Room virusLab = new Room(103, "Virus Lab", 5, 2, 4);
        allRooms.add(virusLab);
        Room decontamination = new Room(104, "Decontamination", 0, 1, 0);
        allRooms.add(decontamination);

    }

    private void setUpDoors() {
        Door door0 = new Door(0, allRooms.get(0), allRooms.get(1));
        allDoors.add(door0);
        Door door1 = new Door(1, allRooms.get(1), allRooms.get(0));
        allDoors.add(door1);
        Door door2 = new Door(2, allRooms.get(1), allRooms.get(2));
        allDoors.add(door2);
        Door door3 = new Door(3, allRooms.get(2), allRooms.get(1));
        allDoors.add(door3);
        Door door4 = new Door(4, allRooms.get(3), allRooms.get(1));
        allDoors.add(door4);
        Door door5 = new Door(5, allRooms.get(1), allRooms.get(4));
        allDoors.add(door5);
        Door door6 = new Door(6, allRooms.get(4), allRooms.get(1));
        allDoors.add(door6);
        Door door7 = new Door(7, allRooms.get(2), allRooms.get(3));
        allDoors.add(door7);
        Door door8 = new Door(8, allRooms.get(1), allRooms.get(3));
        allDoors.add(door8);
    }

    private void loadPasses() {
        Pass pass = new Pass(1000, "Ali", 5, 10);
        allPasses.add(pass);
        Pass pass1 = new Pass(1001, "Bert", 3, 20);
        allPasses.add(pass1);
        Pass pass2 = new Pass(1002, "Ceri", 10, 20);
        allPasses.add(pass2);
        Pass pass3 = new Pass(1003, "Dani", 2, 12);
        allPasses.add(pass3);
        Pass pass4 = new Pass(1004, "Eli", 3, 3);
        allPasses.add(pass4);
        Pass pass5 = new Pass(1005, "Fred", 1, 5);
        allPasses.add(pass5);
        Pass pass6 = new Pass(1006, "Gani", 10, 6);
        allPasses.add(pass6);
        Pass pass7 = new Pass(1007, "Hui", 7, 20);
        allPasses.add(pass7);
        Pass pass8 = new Pass(1008, "Imran", 6, 24);
        allPasses.add(pass8);
    }

    // You may find these methods useful to simplify your code above

    /**
     * Returns the pass with the pass id specified by the parameter
     *
     * @return the pass with the specified name
     **/
    public Pass getPass(int id) {
        int i = 0;
        for (Pass temp : allPasses) {
            if (temp.getPassID() == id) {
                return allPasses.get(i);
            }
            i++;
        }
        return null;
    }


    /**
     * Returns the room with the name specified by the parameter
     *
     * @param roomNo is the number of the required room
     * @return the room with the specified name
     **/
    private Room getRoom(int roomNo) {
        int i = 0;
        for (Room temp : allRooms) {
            if (temp.getRoomNumber() == roomNo) {
                return allRooms.get(i);

            }
            i++;
        }

        return null;
    }

    /**
     * Returns the room with the name specified by the parameter
     *
     * @return the room with the specified name
     **/
    private Door getDoor(int dr) {
        for (int i = 0; i < allDoors.size(); i++) {
            if (allDoors.get(i).getDoorNumber() == dr) {
                return allDoors.get(i);
            }
            i++;
        }
        return null;
    }

    public void enter() {
        for (Pass temp : allPasses) {
            for (int i = 0; i < allRooms.size(); i++) {
                if (allRooms.get(i).getName().equals("Outside")) {
                    allRooms.get(i).enter(temp);
                }
            }
        }
    }

}