/**
 * Details of your pair
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "The jammy dodgers";  // optional
        details[1] = "Taylor";
        details[2] = "Lewis";
        details[3] = "18027909";
        details[4] = "Piotr";
        details[5] = "Lesniak";
        details[6] = "18050477";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
