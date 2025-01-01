# EOP-yr1-PMS
Project Repo for Elements of Programming subject. Patient Management System project.

### Disscussed details 

Our project is Patient Management System. 

We already decided the general prototype for our system. 
Our system will be mostly like a database; 
We can INSERT, UPDATE, VIEW and DELETE the data of the patient. 
The patient data will be stored in a table-like structure. 

So there will be
- rows; which will be the number of patient and represent the patient itself.
and
- columns; which will be the details of each patient. 

so it will almost be like this 


      | patientid   |  patientname | ...
    1 |  124        |  Ahmad       | ...
    2 |  135        |  Aisyah      | ...
    3 |  ...

And so forth...
So in our system, the index of the array which is [0]
will represent a patient, each patient will have a different index number 
so practically the index [i] will represent the row.

And column would each be a different Array. 
```java

String[] patientname = {..., ...}; 

int[] patientid = {..., ...}; 
```
and so on...

so the general structure in our program there will be a
main method in which there will be a 
`greetings();` method that will be displayed upon startup of the program. 
There's also :

```java

while(opt != 'q') {
   query(); 
}
```
So this program will continue to run until user input a certain character or word.
in our `query();` method it will ask the user for to choose 4 operation:

- `insert();` which will insert the data into the table

- `update();` which will update the data on the table 

- `view();` which will display the certain/whole data from the table

- `delete();` which will delete a certain data from the table

all of this operation are a method. 

We also considered a `save();` and `read();` operation to save the data from array to a .txt file.
But that's still in experiment, I'll say something if we are to proceed with it.

### Tasks

- Programming

`Insert();` - harits
`view();` - mansaa
`update();` - 
`delete();` - Haddif
`query();`  harits
`save();` - Farees 
`read();` - Farees
`greetings();` - Farees

- Decide column attributes
  - vacant
- Make a flowchart
  - vacant
- Slide presentation
  - vacant
