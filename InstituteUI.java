import java.util.*;
/**
 * Write a description of class InstituteIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstituteUI
{
    
    private Scanner reader = new Scanner(System.in);
    private CREAM corona = new Institute();
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllRooms();}
            else if (choice == 2){listAllPassesbyRoom();}
            else if (choice == 3){listOneRoom();}
            else if (choice == 4){findAPass();}
            else if (choice == 5){showAPass();}
            else if (choice == 6){tryMove();}
            else if (choice == 7){moveNow();}
            else if (choice == 8){resetAllPasses();}
            else if (choice == 9){resetPass();} // Task 7
            else if (choice == 10){moveOutside();} // Task 7
            else if (choice == 11){evacuateAll();} // Task 7
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all Institute information");
       System.out.println("2. List all passes in each room");
       System.out.println("3. List all passes in one room");
       System.out.println("4. Find the current room of a pass");
       System.out.println("5. Show details of a pass");
       System.out.println("6. Say if pass can move through a door");
       System.out.println("7. Move a pass through door");
       System.out.println("8. ResetAllPasses");
       System.out.println("9. ResetPass"); // Task 7
       System.out.println("10. MoveOutside");// Task 7
        System.out.println("11. Evacuate staff"); // Task 7


       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllRooms()
    {
        System.out.println(corona.toString());
    }
    
    // provide the code here  
    private void listAllPassesbyRoom()
    {
        System.out.println(corona.getAllPassesInAllRooms());

    }
   
    // provide the code here
    private void listOneRoom()
    {
        System.out.println("Enter room number: ");
        int input = reader.nextInt();
        System.out.println(corona.getAllPassesInRoom(input));

    }
        

    
    // provide the code here
    private void findAPass()
    {
        System.out.println("Please enter a Pass_ID: ");
        int input = reader.nextInt();
        System.out.println("Pass is in room " + corona.findPass(input));
    }
    
    private void showAPass()
    {
        System.out.println("Please enter a Pass_ID: ");
        int ps = reader.nextInt();
        System.out.println(corona.showPass(ps));
    }
    
    // This one has been done for you 
    private void tryMove()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter door number");
        int door = reader.nextInt();
        System.out.println(corona.canMove(trav,door));
    }
    
    // This one has been done for you 
    private void moveNow()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter door number");
        int door = reader.nextInt();
        System.out.println(corona.move(trav,door));
    }
    
    // This one has been done for you
    private void resetAllPasses()
    {
        corona.resetAllPasses();
    }

    // Extra methods that are not required for the demo (Task 7)
    private void resetPass(){
        System.out.println("Please insert Pass_id: ");
        int input = reader.nextInt();
        corona.resetPass(input);
        System.out.println("Allowable working hours and moves set back to default");
    }

    private void moveOutside(){
        System.out.println("Please insert Pass_id: ");
        int input = reader.nextInt();
        corona.moveOutside(input);
        System.out.println("Pass has been moved outside");
    }

    private void evacuateAll(){
        corona.evacuateAll();
        System.out.println("All passes have been evacuated to Outside");
    }


    public static void main(String[] args)
    {
        InstituteUI xx = new InstituteUI();
        xx.runUI();
    }
}
