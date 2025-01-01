/*
 * Patient Management System 
 * by Group 5, BICS 1301, Year 1 Sem 1
*/
import java.util.Scanner;

public class PMSMain {
    public static void main(String[] args) {
        //TODO main:
        /*
        - While loop that include a user input to exit/stay in program.
        - The array which represent the table column.
        - 
        */              
    }

    //TODO greetings():
    /*
    - Make a stands out ASCII art upon program startup.
    */

    //TODO query():
    /*
    -  to ask for user the option of each operation methods.
    */


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
