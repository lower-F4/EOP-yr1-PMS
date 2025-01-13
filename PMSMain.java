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

        //-------------------------TEST DATA--------------------------------------
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
        //-------------------------TEST DATA--------------------------------------
        
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
        
          int input;
        Scanner query = new Scanner(System.in); 

        System.out.print("PMS>"); 
        
       

        System.out.println("Patient Management System:\n1. Insert\n2. Update\n3. View\n4. Delete\n5. Save\n6. Read\n7. Exit");
        System.out.print("What do you wish to do: ");
        input = query.nextInt();

        String[] passData = new String[100];
        
        switch (input) {
            case 1: passData = insert(ptid, ptname, disease, docid);
                
                break;
            case 2: update();

                break; 
            case 3: 
                view(ptid, ptname, disease, docid);
                break; 

            case 4: delete(ptid, ptname, disease, docid);
        
                break; 
            case 5:
                save(ptid, ptname, disease, docid); 
                break;
            case 6:
                try {
                    read();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                break;
            case 7:
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

        System.out.println("Patient ID    Patient Name    Disease    Doctor ID");
        System.out.println("---------------------------------------------------");
        
        if (viewname > 0 && viewname != (ptid.length+1))
            int loopname = viewname - 1;
            System.out.printf("%-10d    %-13s    %-8s    %-9d\n", ptid[loopname],ptname[loopname],disease[loopname],docid[loopname]);
        else if (viewname == (ptid.length+1))
            for (int i = 0 ; i < ptid.length ; i++)
                    System.out.printf("%-10d    %-13s    %-8s    %-9d\n", ptid[i],ptname[i],disease[i],docid[i]);
    }

    //TODO INSERT(); Harits' 

    public static String insert(int[] ptid, String[] ptname, String[] disease, int[] docid) {
        Scanner input = new Scanner(System.in);
    
        // Prompt for new patient details
        System.out.println("Enter new patient ID: ");
        int newPtId = input.nextInt();
    
        input.nextLine(); // Consume newline character
        System.out.println("Enter new patient name: ");
        String newPtName = input.nextLine();
    
        System.out.println("Enter disease: ");
        String newDisease = input.nextLine();
    
        System.out.println("Enter doctor ID: ");
        int newDocId = input.nextInt();
    
        //Add new details/data into the arrays

        int[] newPtIdArray = new int[ptid.length + 1];
        String[] newPtNameArray = new String[ptname.length + 1];
        String[] newDiseaseArray = new String[disease.length + 1];
        int[] newDocIdArray = new int[docid.length + 1];

        //to copy old data into the new array

        for (int i = 0; ptid.length; i++)
        {
            newptIdArray[i] = ptid[i];
            newPtNameArray[i] = ptname[i] ;
            newDiseaseArray[i] = disease[i];
            newDocIdArray[i] = docid[i];
        }
        
        // Add new data to the last position of the arrays
    newPtIdArray[ptid.length] = newPtId;
    newPtNameArray[ptname.length] = newPtName;
    newDiseaseArray[disease.length] = newDisease;
    newDocIdArray[docid.length] = newDocId;

    // Assign the new arrays back to the existing variables
    ptid = newPtIdArray;
    ptname = newPtNameArray;
    disease = newDiseaseArray;
    docid = newDocIdArray;

    // Construct the updated patient list using string concatenation
    String insertedPatientList = "Updated Patient List:\n";
    insertedPatientList += "Patient ID    Patient Name    Disease    Doctor ID\n";
    insertedPatientList += "---------------------------------------------------\n";
    for (int i = 0; i < ptid.length; i++) {
        insertedPatientList += String.format("%-10d    %-13s    %-8s    %-9d\n", ptid[i], ptname[i], disease[i], docid[i]);
    }

    System.out.println("New patient details added successfully.");
    System.out.println( insertedPatientList); // Return the updated patient list

        String[] passData = new String[ptid.length];
        for (int i = 0; i < ptid.length; i++) {
            passData[i] = String.join("\t",
                    String.valueOf(ptid[i]),
                    ptname[i],
                    disease[i],
                    String.valueOf(docid[i]));
        }
        return passData;
}




    //TODO UPDATE(): 

    //TODO DELETE(); 

    //TODO SAVE(); 

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

    //TODO READ(); 

    public static void read() throws IOException {

        //Using bufferedReader
        try {
            BufferedReader readdata = new BufferedReader(new FileReader("Data.txt"));
            //TODO while loop reading data, categorize each into array.
            String st = readdata.readLine();

            System.out.println(st); 

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 

        //using scanner


    }

    //choose what patient you want to delete
    
public static void delete(int[] ptid, String[] ptname, String[] disease, int[] docid) {
    Scanner input = new Scanner(System.in);
    
    // Display current patients
    System.out.println("Current Patients:");
    for (int i = 0; i < ptid.length; i++) {
        System.out.printf("%d. %s (ID: %d)\n", i + 1, ptname[i], ptid[i]);
    }
    
    // Ask the user to select a patient to delete
    System.out.print("Enter the index of the patient to delete (1-" + ptid.length + "): ");
    int index = input.nextInt() - 1; // Convert to 0-based index
    
    // Validate input
    if (index < 0 || index >= ptid.length) {
        System.out.println("Invalid index. No changes made.");
        return;
    }
    
    // Create new arrays with one less element
    int[] newPtid = new int[ptid.length - 1];
    String[] newPtname = new String[ptname.length - 1];
    String[] newDisease = new String[disease.length - 1];
    int[] newDocid = new int[docid.length - 1];
    
    // Copy all elements except the one to be deleted
    for (int i = 0, j = 0; i < ptid.length; i++) {
        if (i != index) { // Skip the deleted patient
            newPtid[j] = ptid[i];
            newPtname[j] = ptname[i];
            newDisease[j] = disease[i];
            newDocid[j] = docid[i];
            j++;
        }
    }
    
    // Update the original arrays
    ptid = newPtid;
    ptname = newPtname;
    disease = newDisease;
    docid = newDocid;
    
    System.out.println("Patient record deleted successfully.");
}
    
    
}
