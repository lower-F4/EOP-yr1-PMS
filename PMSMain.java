/*
 * Patient Management System 
 * by Group 5, BICS 1301, Year 1 Sem 1
*/
import java.util.Scanner;
import java.lang.System; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class PMSMain {
    public static void main(String[] args) {
        //TODO main:
        /*
        - While loop that include a user input to exit/stay in program.
        - The array which represent the table column.
        - 
        */
        int[] ptid = new int[100];  
        String[] ptname = new String[100]; 
        String[] disease = new String[100];  
        int[] docid = new int[100];
           
        /*-------------------------TEST DATA--------------------------------------
        int[] ptid = {
            100, 101, 102,
            103, 104, 105
        }; 
        String[] ptname = {
            "Saiful", "Ahmad", "Hanif",
            "Syamsol", "Badrul", "Qistina"
        }; 
        String[] disease = {
            "Diabetes", "High blood pressure", "Heart attack",
            "Heart broken", "Broken leg", "Accident"
        }; 
        int[] docid = {
            1000, 1001, 1002, 
            1003, 1004, 1005
        }; 
        *///-------------------------TEST DATA--------------------------------------
        
        greetings();
        while(true) {
            query(ptid, ptname, disease, docid); 
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
    public static void query(int[] ptid, String[] ptname, String[] disease, int[] docid) {
        
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
            case "save":
                save(ptid, ptname, disease, docid); 
                break;
            case "read":
                try {
                    read(ptid, ptname, disease, docid);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                break;
            case "exit":
                System.out.println("Exiting... Thank You for using Patient Management System.");
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



    public static void save(int[] ptid, String[] ptname, String[] disease, int[] docid) {
        
        try {
            BufferedWriter savedata = new BufferedWriter(new FileWriter("Data.txt"));

            for(int i = 0;i < ptid.length; i++) {
                savedata.write(ptid[i] + "\t");
                savedata.write(ptname[i] + "\t"); 
                savedata.write(disease[i] + "\t"); 
                savedata.write(docid[i] + "\t"); 
                savedata.write("\n");
            }
            savedata.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }


    public static void read(int[] ptid, String[] ptname, String[] disease, int[] docid) throws IOException {


        //Read is void method, it will write it to the master variable.
        try {
            BufferedReader readdata = new BufferedReader(new FileReader("Data.txt"));
            
            String line; 
            int index = 0; 
            while ((line = readdata.readLine()) != null) {
                String[] row = line.split("\t");
                if (row.length == 4) { // Ensure each row has 4 elements
                    ptid[index] = Integer.parseInt(row[0]);
                    //System.out.println("ptid["+index+"]: "+ptid[index]); 
                    ptname[index] = row[1];
                    //System.out.println("ptname["+index+"]: "+ptname[index]);
                    disease[index] = row[2];
                    //System.out.println("disease["+index+"]: "+disease[index]);
                    docid[index] = Integer.parseInt(row[3]);
                    //System.out.println("docid["+index+"]: "+docid[index]);
                }
            index++; 
            }
            System.out.println("Read Operation Successful."); 

            readdata.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        //TODO:how do I pass it back to main?
    }
}
