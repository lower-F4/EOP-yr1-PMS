/*
 * Patient Management System 
 * by Group 5, BICS 1301, Year 1 Sem 1
*/
import java.util.Scanner;
import java.lang.System; 

public class PMSMain {
    public static void main(String[] args) {
        //TODO main:
        /*
        - While loop that include a user input to exit/stay in program.
        - The array which represent the table column.
        - 
        */

        while(true) {
            query(); 
        }

    }

    //TODO greetings():
    /*
    - Make a stands out ASCII art upon program startup.
    */
    public static void greetings() {
        System.out.printf(" _____     _   _         _      _____                                   _   \r\n" + //
                        "|  _  |___| |_|_|___ ___| |_   |     |___ ___ ___ ___ ___ _____ ___ ___| |_ \r\n" + //
                        "|   __| .'|  _| | -_|   |  _|  | | | | .'|   | .'| . | -_|     | -_|   |  _|\r\n" + //
                        "|__|  |__,|_| |_|___|_|_|_|    |_|_|_|__,|_|_|__,|_  |___|_|_|_|___|_|_|_|  \r\n" + //
                        "                                                 |___|                      \r\n" + //
                        "                                                                            \r\n" + //
                        " _____         _                                                            \r\n" + //
                        "|   __|_ _ ___| |_ ___ _____                                                \r\n" + //
                        "|__   | | |_ -|  _| -_|     |                                               \r\n" + //
                        "|_____|_  |___|_| |___|_|_|_|                                               \r\n" + //
                        "      |___|                                                                 \n");
    }

    //TODO query():
    /*
    -  to ask for user the option of each operation methods.
    - redirect user option into a specific method.
    */
    public static void query() {
        
        String input; 
        Scanner query = new Scanner(System.in); 

        System.out.print("PMS>"); 
        input = query.nextLine(); 
        input = input.toLowerCase(); 

        switch (input) {
            case "insert":
                
                break;
            case "update":

                break; 
            case "view": 

                break; 

            case "delete":
        
                break; 
            case "exit":
                System.out.println("Exiting... Thank You for using Patient Management System.")
                System.exit(0); 
            default:
                System.out.println("Please enter a valid command.");
                break;
        }
    }



    //TODO view():
    /*
    - to display the detail of each a certain/ whole patient table.
    */
    public static void view(int[] ptid, String[] ptname, String[] disease, int[] docid){
        Scanner input = new Scanner(System.in);
        System.out.println("Please key-in which patient's information that you wish to view: \n");

        for (int i = 0 ; i<ptid.length ; i++){
            System.out.println( (i+1) + ". " + ptname[i]);
        }
        System.out.println( (ptid.length+1) + ". " + "VIEW ALL PATIENTS");
        int viewname = input.nextInt();

        int loopname = viewname - 1;

        System.out.println("Patient ID    Patient Name    Disease    Doctor ID");
        System.out.println("---------------------------------------------------");
        
        if (viewname > 0 && viewname != (ptid.length+1))
            System.out.printf("%-10f    %-11s    %-7s    %-9f\n", ptid[loopname],ptname[loopname],disease[loopname],docid[loopname]);
        else if (viewname == (ptid.length+1))
            for (int i = 0 ; i < ptid.length ; i++)
                    System.out.printf("%-10f    %-11s    %-7s    %-9f\n", ptid[i],ptname[i],disease[i],docid[i]);
    }

    //TODO INSERT(); 

    //TODO UPDATE(): 

    //TODO DELETE(); 

    //TODO SAVE(); 

    //TODO READ(); 
}
