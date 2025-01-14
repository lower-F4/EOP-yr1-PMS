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

        String[] passData = new String[ptid.length]; 
           
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
            passData = query(ptid, ptname, disease, docid); 

            //create a new array?
            for (int i = 0; i < passData.length; i++) {
                /*debug*/System.out.println(passData[i]);
                if(passData[i] == null) {
                    //triggered by view()
                    /*debug*/System.out.println("Break");
                    break; 
                }
                String[] row = passData[i].split("\t");
                if (row.length == 4) {
                    //debug
                    if(ptid[i] == 0) {
                        break; 
                    }
                    System.out.println("Updated Data with size: " + ptid.length);
                    System.out.println("PTID: " + row[0]);
                    System.out.println("PTNAME:"+ row[1]);
                    System.out.println("DISEASE:"+ row[2]);
                    System.out.println("DOCID:"+ row[3]);
                    //debug
                    ptid[i] = Integer.parseInt(row[0]); //out of bound
                    ptname[i] = row[1];
                    disease[i] = row[2];
                    docid[i] = Integer.parseInt(row[3]);
                }
            }
        }

    }

    //greetings
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

    //query
    public static String[] query(int[] ptid, String[] ptname, String[] disease, int[] docid) {
        
        int input; 
        String[] passData = new String[ptid.length]; 
        Scanner query = new Scanner(System.in); 


        
        System.out.println("Patient Management System:\n1. Insert\n2. Update\n3. View\n4. Delete\n5. Save\n6. Read\n7. Exit");
        System.out.print("What do you wish to do: ");
        input = query.nextInt();

        switch (input) {
            case 1: passData = insert(ptid, ptname, disease, docid);
                
                break;
            case 2: //update();
                update(ptid, ptname, disease, docid);
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
                    passData = read(ptid, ptname, disease, docid);
                } catch (IOException e) {
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
        return passData; 
    }



    //view():
    /*
    - to display the detail of each a certain/ whole patient table.
    */
    public static void view(int[] ptid, String[] ptname, String[] disease, int[] docid){
        Scanner input = new Scanner(System.in);
        System.out.println("Please key-in which patient's information that you wish to view: \n");

        for (int i = 0 ; i<ptid.length ; i++){
            //Farees added
            if(ptid[i] == 0) {
                break;
            }
            System.out.println( (i+1) + ". " + ptname[i]);
        }
        System.out.println( (ptid.length+1) + ". " + "VIEW ALL PATIENTS");
        
        int viewname = input.nextInt();

        System.out.println("Patient ID    Patient Name    Disease                Doctor ID");
        System.out.println("--------------------------------------------------------------");
        
        if (viewname > 0 && viewname != (ptid.length+1)){
            int loopname = viewname - 1;
            System.out.printf("%-10d    %-12s    %-20s    %-9d\n", ptid[loopname],ptname[loopname],disease[loopname],docid[loopname]);
        } else if (viewname == (ptid.length+1)){
            for (int i = 0 ; i < ptid.length ; i++) {
                    if(ptid[i] == 0) {
                        break;
                    }
                    System.out.printf("%-10d    %-12s    %-20s    %-9d\n", ptid[i],ptname[i],disease[i],docid[i]);
            }
        }
    }

    //TODO INSERT(); Harits' 

    public static String[] insert(int[] ptid, String[] ptname, String[] disease, int[] docid) {
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

        for (int i = 0; i < ptid.length; i++)
        {
            newPtIdArray[i] = ptid[i];
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
        //Farees added
        if(ptname[i] == null) {
            break;
        }
        insertedPatientList += String.format("%-10d    %-13s    %-8s    %-9d\n", ptid[i], ptname[i], disease[i], docid[i]);
    }

    System.out.println("New patient details added successfully.");
    System.out.println( insertedPatientList); // Return the updated patient list
    //TODO index out of bound after printing

    //return to query()
    //String[] passData = new String[ptid.length];
    String[] passData = new String[ptid.length];
    for (int i = 0; i < ptid.length; i++) {
        passData[i] = String.join("\t",
                String.valueOf(ptid[i]),
                ptname[i],
                disease[i],
                String.valueOf(docid[i]));
        }
        //index out of bound
    return passData;
}




    //TODO UPDATE();
    public static void update(int[] ptid, String[] ptname, String[] disease, int[] docid) {
        Scanner input = new Scanner(System.in);
    
        // Display all patients' IDs and names
        System.out.println("Select the patient you want to update:");
        for (int i = 0; i < ptid.length; i++) {
            System.out.println(ptid[i] + " - " + ptname[i]);
        }
    
        // Prompt the user to enter the patient ID
        System.out.print("Enter the Patient ID: ");
        int id = input.nextInt();
    
        // Find the index of the patient ID
        int index = -1;
        for (int i = 0; i < ptid.length; i++) {
            if (ptid[i] == id) {
                index = i;
                break;
            }
        }
    
        // If the patient ID is not found
        if (index == -1) {
            System.out.println("Patient ID not found. Returning to the main menu.");
            return;
        }
    
        // Display current information of the patient
        System.out.println("Current information of Patient ID " + id + ":");
        System.out.println("1. Patient Name: " + ptname[index]);
        System.out.println("2. Disease: " + disease[index]);
        System.out.println("3. Doctor ID: " + docid[index]);
        System.out.println();
        
        // Prompt the user to select which field to update
        System.out.println("What do you want to update?");
        System.out.println("1. Patient Name");
        System.out.println("2. Disease");
        System.out.println("3. Doctor ID");
        System.out.print("Enter your choice (1-3): ");
        int choice = input.nextInt();
        System.out.println();
        // Update the selected field
        input.nextLine(); // Consume the newline character
        switch (choice) {
            case 1:
                System.out.print("Enter the new Patient Name: ");
                ptname[index] = input.nextLine();
                break;
            case 2:
                System.out.print("Enter the new Disease: ");
                disease[index] = input.nextLine();
                break;
            case 3:
                System.out.print("Enter the new Doctor ID: ");
                docid[index] = input.nextInt();
                break;
            default:
                System.out.println("Invalid choice. No updates were made.");
                return;
        }
    
        // Display the updated information
        System.out.println();
        System.out.println("Updated information of Patient ID " + id + ":");
        System.out.printf("Patient Name: %s\n", ptname[index]);
        System.out.printf("Disease: %s\n", disease[index]);
        System.out.printf("Doctor ID: %d\n", docid[index]);
        System.out.println();
    
        System.out.println("Update successful! Returning to the main menu.\n");
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


    public static String[] read(int[] ptid, String[] ptname, String[] disease, int[] docid) throws IOException {


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
        //pass back to query()
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

    //choose what patient you want to delete
    
public static void delete(int[] ptid, String[] ptname, String[] disease, int[] docid) {
    Scanner input = new Scanner(System.in);

    // Display current patients
    System.out.println("Current Patients:");
    for (int i = 0; i < ptid.length; i++) {
        if(ptid[i] == 0) {
            break;
        }
        if (ptid[i] != -1) { // Only show non-deleted entries
            System.out.printf("%d. %s (ID: %d)\n", i + 1, ptname[i], ptid[i]);
        }
    }

    // Ask the user to select a patient to delete
    System.out.print("Enter the index of the patient to delete (1-" + ptid.length + "): ");
    int index = input.nextInt() - 1; // Convert to 0-based index

    // Validate input
    if (index < 0 || index >= ptid.length || ptid[index] == -1) {
        System.out.println("Invalid index. No changes made.");
        return;
    }

    // Mark the patient as deleted
    ptid[index] = -1; // Use -1 to indicate the ID is deleted
    ptname[index] = null;
    disease[index] = null;
    docid[index] = -1;

    System.out.println("Patient deleted successfully. Updated list:");
    for (int i = 0; i < ptid.length; i++) {
        if(ptid[i] == 0) {
            break;
        }
        if (ptid[i] != -1) { // Skip deleted entries
            System.out.printf("%d. %s (ID: %d)\n", i + 1, ptname[i], ptid[i]);
            }
}   
}
