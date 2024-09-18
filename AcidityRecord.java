//Import utility and io to read from file and modify read elements
import java.util.*;
import java.io.*;

public class AcidityRecord{ //Start Class

  private static ArrayList<AcidityRecord> acidRecord = new ArrayList<AcidityRecord>(); //Create ArrayList to store each AcidityRecord Object

  //Instance Variables for data from file
  private String year;
  private double co2;
  private double ph;
  private double aCo2;

  //Immutable count variable to keep track of number of records
  private static int count;

  //Constructor to create each record 
  public AcidityRecord(String year, double co2, double ph, double aCo2){
    //assign values to the instance variables
    this.year = year;
    this.co2 = co2;
    this.ph = ph;
    this.aCo2 = aCo2;

    //Add the object to the ArrayList acidRecord
    acidRecord.add(this);

    //add 1 to count for each new object
    count++;
  } //end constructor

  //Accessor Methods
  //Get Year
  public String getYear(){
    return this.year;
  }

  //Get Ocean CO2
  public double getCo2(){
    return this.co2;
  }

  //Get Ocean Ph
  public double getPh(){
    return this.ph;
  }

  //Get Atmospheric CO2
  public double getAco2(){
    return this.aCo2;
  }

  //Get Count
  public static int getCount(){
    return count;
  }

  //Get the ArrayList containing each record
  public static ArrayList<AcidityRecord> getAcidRecord(){
    return acidRecord;
  }

  //Mutators arent needed as all the data is already given and should not be changed

  
  //Helper methods
  //Acidity Record Stats and Averages
  //Get first 10 average of Ocean CO2
  public static double getFirstAverageCo2(){
    double t = 0; //initialize total
    for (int i = 0; i<10; i++){ //while i is less than 10, i will increase by 1
      t += acidRecord.get(i).getCo2(); //add the ocean CO2 from the first 10
    }

    t = t/10; //find average
    return t; //return average
  }

  //Get last 10 average of Ocean CO2
  public static double getLastAverageCo2(){
    double t = 0; //initialize total
    for (int i = acidRecord.size() - 1; i> acidRecord.size() - 11; i-- ){//while i is greater than acidRecords size - 11, i will decrease by 1
      t += acidRecord.get(i).getCo2; //add the ocean CO2 from the last 10
    }

    t = t/10; //find average
    return t; //return average
  }

  //Get first 10 average of Ocean Ph
  public static double getFirstAveragePh(){
    double t  = 0;
    for (int i = 0; i<10; i++){
      t += acidRecord.get(i).getPh();
    }

    t = t/10;
    return t;
  }

  //Get last 10 average of Ocean Ph
  public static double getLastAveragePh(){
    double t = 0;
    for (int i = acidRecord.size() - 1; i> acidRecord.size() - 11; i-- ){
      t += acidRecord.get(i).getPh();
    }

    t = t/10;
    return t;
  }

  //Get first 10 average of Atmospheric CO2
  public static double getFirstAverageAco2(){
    double t  = 0;
    for (int i = 0; i<10; i++){
      t += acidRecord.get(i).getAco2();
    }

    t = t/10;
    return t;
  }

  //Get last 10 average of Atmospheric CO2
  public static double getLastAverageAco2(){
    double t = 0;
    for (int i = acidRecord.size() - 1; i> acidRecord.size() - 11; i-- ){
      t += acidRecord.get(i).getAco2();
    }

    t = t/10;
    return t;
  }

  //toString Method
  //Returns data from each object formatted and spaced correctly with the correct number of decimal places
  public String toString(){
    return String.format("%-13s|  %-10.1f|  %-10.4f|  %-15.2f", this.year, this.co2, this.ph, this.aCo2);
  }
  
} //end class