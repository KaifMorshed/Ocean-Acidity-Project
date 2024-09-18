/**
<h1>Ocean Acidification!</h1> 
The Ocean program implements an application that reads
 from file and calculates the average and percentage
difference of Ocean statistics.
This is my own work.

@author  Kaif Morshed
@version 1.0
@since   2021-04-27 
*/

//Import java utility and io to read data from file
import java.util.*;
import java.io.*;


class Main { //start main class
  public static void main(String[] args) { //start main method

    try { //test to see if file exists and data can be read
      File myFile = new File("acidity.txt"); //declare file that will be read from
      Scanner myFileReader = new Scanner(myFile); //scanner to read data from file

      System.out.println("\nFile name: " + myFile.getName() + " is open"); //Check to make sure correct file is open 
      System.out.println("File size in bytes " + myFile.length()); //Check size of File

      if (myFileReader.hasNext() == true) { //If there is data to read from file
        System.out.println("There is data to read\n");
        //Confirm there is data to read
      } 
      
      else { //If there is no Data to read and file is empty
        System.out.println("Error: \nFile is empty");
        //Confirm there is no data to read
      }

      while (myFileReader.hasNextLine()) { //While there is still another line to read in my file
        String ln = myFileReader.nextLine(); //Data from 1 line
        String[] line = ln.split(","); //Splits the data by the commas as separate elements
        
        if(line.length == 4){ //If there is the correct amount of data
          //Data is saved into separate variables as Strings
          String year = line [0];
          double co2 = Double.parseDouble(line[1]);
          double ph = Double.parseDouble(line[2]);
          double aCo2 = Double.parseDouble(line[3]);

          //Create an Object of Class AcidityRecord that holds the data and stores it into an ArrayList
          AcidityRecord currentRecord = new AcidityRecord(year, co2, ph, aCo2);

          //For Test Case 5:
          // if (AcidityRecord.getCount() == 1){
          //   System.out.println(currentRecord + "\n");
          // }
          
        }
      } // end while

    System.out.println(AcidityRecord.getCount() + " files have been read from acidity.txt\n"); //Prints how many lines have been read from the file

    //Print Out all The data from the File
    System.out.printf("%-13s|  %-10s|  %-10s|  %-15s", "Date", "Ocean CO2", "Ocean PH", "Atmos CO2"); //Formatting for the Data table Titles
    System.out.println("\n----------------------------------------------------");

    //Enhanced For loop to print each Aciditiy Record
    for (AcidityRecord record : AcidityRecord.getAcidRecord()){
      System.out.println(record);
    }

    System.out.println("\n----------------------------------------------------");

    //Print the Staistics about Aciditiy Records
    System.out.println();
    //Ocean CO2 Stats
    System.out.println("***************************");
    System.out.println("*     OCEAN CO2 STATS     *");
    System.out.println("***************************");

    System.out.println("First Ten Average: " + AcidityRecord.getFirstAverageCo2());
    System.out.println("First Ten Average: " + AcidityRecord.getLastAverageCo2());
    
    System.out.println();
    //Ocean Ph Stats
    System.out.println("***************************");
    System.out.println("*      OCEAN PH STATS     *");
    System.out.println("***************************");

    System.out.println("First Ten Average: " + AcidityRecord.getFirstAveragePh());
    System.out.println("First Ten Average: " + AcidityRecord.getLastAveragePh());

    System.out.println();
    //Atmosphere CO2 Stats
    System.out.println("***************************");
    System.out.println("*   ATMOSPHERE CO2 STATS  *");
    System.out.println("***************************");

    System.out.println("First Ten Average: " + AcidityRecord.getFirstAverageAco2());
    System.out.println("First Ten Average: " + AcidityRecord.getLastAverageAco2());

    //After everything is done, close the file
    myFileReader.close();
    System.out.println("\nFile acidity.txt has been completed\nacidity.txt is now closed.");
        
    } // end try
    catch (FileNotFoundException e) { //If the specified file was not found or does not exist
      System.out.println("\nERROR:");
      System.out.println("file acidity.txt does not exist.");
    } //end Catch
  } //End main
} //End Class