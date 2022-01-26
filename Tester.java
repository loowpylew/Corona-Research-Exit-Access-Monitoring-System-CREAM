import java.util.*;
/**
 * Write a description of class OTester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    private void doTest()
    {
        // write your tests here
        //CREAM site1 = new Institute();
        //Scanner enter = new Scanner(System.in);

        //System.out.println("*********All Rooms**************");
        //System.out.println(site1.toString());
        //enter.nextLine();
        // write your tests here

        // Creating new instances of the class to tests if various methods work according to the desired functionality.


        // To see if passes can be entered into the instance staffRoom.
        // to see staffRooms current capacity.
        // To return all passes within the staffroom.
        // To detect whether a given pass is within the room.

        Institute institute = new Institute(); // creates instance of institute class.

        System.out.println(institute.toString());  // This will show me the initial states of all Rooms in respects to Room name, Danger rating, Capacity, Room min-hours, Passes currently in the Room.

        //Here I can check the initial state of the passes that I move before details about the pass are changed due to moving into rooms.
        System.out.println(institute.getPass(1000));
        System.out.println("\n" + institute.getPass(1001));
        System.out.println("\n" + institute.getPass(1005));


        // Here I move pass '1000'/'1005' twice and pass '1001' once. Through this; if successful, if i then print out all passesInAllRooms, I can see what rooms the passes are in.
        institute.move(1000, 0);
        institute.move(1000, 2);
        institute.move(1001,0);
        institute.move(1005, 0);
        institute.move(1005, 8);

        //Here, I view all passes in all Rooms which confirms to me that I have managed to move passes from one room to another.
        System.out.println(institute.getAllPassesInAllRooms());

        /*This will show passes current state and signifies the changes made to their original states given they have moved between rooms,
        affecting number of moves made to numberofhrs they can work */
        System.out.println(institute.getPass(1000));
        System.out.println("\n" + institute.getPass(1001));
        System.out.println("\n" + institute.getPass(1005));

        //Here, I test to see if passes can move through doors

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("\nDoor 0");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 0));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 0));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 0));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 0));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 0));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 0));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 0));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 0));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 0));

        //From Room 101 - Staff Room, I can get passes to enter through doors 2, 8, 5, or 1 via the staffRoom, but not 0, 3, 4, or 6
        System.out.println("Door 1");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 1));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 1));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 1));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 1));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 1));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 1));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 1));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 1));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 1));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 0));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 0));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 0));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 0));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 0));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 0));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 0));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 0));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 0));

        System.out.println("Door 2");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 2));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1001, 2));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1002, 2));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1003, 2));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1004, 2));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1005, 2));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1006, 2));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1007, 2));
        System.out.println("Can Pass 1009 move: " + institute.canMove(1008, 2));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 0));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 0));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 0));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 0));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 0));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 0));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 0));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 0));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 0));

        System.out.println("Door 3");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 3));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 3));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 3));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 3));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 3));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 3));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 3));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 3));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 3));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 0));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 0));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 0));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 0));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 0));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 0));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 0));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 0));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 0));


        System.out.println("Door 4");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 4));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 4));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 4));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 4));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 4));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 4));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 4));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 4));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 4));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 0));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 0));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 0));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 0));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 0));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 0));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 0));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 0));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 0));


        System.out.println("Door 5");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 5));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 5));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 5));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 5));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 5));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 5));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 5));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 5));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 5));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println(institute.canMove(1000, 0));
        System.out.println(institute.canMove(1001, 0));
        System.out.println( institute.canMove(1002, 0));
        System.out.println(institute.canMove(1003, 0));
        System.out.println( institute.canMove(1004, 0));
        System.out.println(institute.canMove(1005, 0));
        System.out.println(institute.canMove(1006, 0));
        System.out.println(institute.canMove(1007, 0));
        System.out.println(institute.canMove(1008, 0));

        System.out.println("Door 6");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 6));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 6));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 6));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 6));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 6));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 6));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 6));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 6));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 6));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println(institute.canMove(1000, 0));
        System.out.println(institute.canMove(1001, 0));
        System.out.println( institute.canMove(1002, 0));
        System.out.println(institute.canMove(1003, 0));
        System.out.println( institute.canMove(1004, 0));
        System.out.println(institute.canMove(1005, 0));
        System.out.println(institute.canMove(1006, 0));
        System.out.println(institute.canMove(1007, 0));
        System.out.println(institute.canMove(1008, 0));

        System.out.println("Door 7");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 7));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 7));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 7));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 7));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 7));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 7));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 7));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 7));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 7));

        institute.resetAllPasses(); // Reset all passes to test whether initial passes that meet the requirements can enter 'to' rooms from room 101 - Staff Room

        //Initial move of all passes is to enter Room 101 - Staff Room via door 0
        System.out.println("Door 0");
        System.out.println(institute.canMove(1000, 0));
        System.out.println(institute.canMove(1001, 0));
        System.out.println( institute.canMove(1002, 0));
        System.out.println(institute.canMove(1003, 0));
        System.out.println( institute.canMove(1004, 0));
        System.out.println(institute.canMove(1005, 0));
        System.out.println(institute.canMove(1006, 0));
        System.out.println(institute.canMove(1007, 0));
        System.out.println(institute.canMove(1008, 0));

        System.out.println("Door 8");
        System.out.println("Can Pass 1000 move: " + institute.canMove(1000, 8));
        System.out.println("Can Pass 1001 move: " + institute.canMove(1001, 8));
        System.out.println("Can Pass 1002 move: " + institute.canMove(1002, 8));
        System.out.println("Can Pass 1003 move: " + institute.canMove(1003, 8));
        System.out.println("Can Pass 1004 move: " + institute.canMove(1004, 8));
        System.out.println("Can Pass 1005 move: " + institute.canMove(1005, 8));
        System.out.println("Can Pass 1006 move: " + institute.canMove(1006, 8));
        System.out.println("Can Pass 1007 move: " + institute.canMove(1007, 8));
        System.out.println("Can Pass 1008 move: " + institute.canMove(1008, 8));

        /* If all display the correct output in respects to trying to enter a 'to' room and a 'from' room resulting in either 'true' or 'false' as an output.
         I am safe to say it will work for all other rooms when a particular pass is within rooms: 100 - Outside, 102 - Lab1, 103 - Virus lab, 104 - Decontamination.
         */

        institute.resetAllPasses();

        // First, I will move pass 1000 into 101 - Staff Room.
        institute.move(1000, 0);
        // I will then display the pass to see how moving it into the room affects the details of the pass such as number of moves and hrs left.
        institute.showPass(1000);
        // I will then move again into 102 - Lab1.
        institute.move(1000, 2);
        // Then repeat the same to see how moving it into the room affects the details of the pass such as number of moves and hrs left.

        /* I will then reset the pass, but also check to see if the current number min hours of the room the pass is in is taken away from the pass by default.
           So it may have travelled through multiple rooms so resetting the pass will up the potential times it can enter rooms, but will still take into account
           the current room min-hours. It cant leave the room with full hours.
         */
        institute.resetPass(1000);

        //Below, this will evacuate all passes back to outside without affecting any the moves nor the hrs-left.
        institute.evacuateAll();





    }


    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
