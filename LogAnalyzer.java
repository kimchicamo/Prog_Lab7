
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
 /*
  * Q1, 
  * 10 14 18 
  * 
  * Q4,
  * It is used often bcz it is used in fields,constructors 
  * and also the first 2 methods
  * 
  * Q5 
  * int[] counts; it has o be after the type and not before
  * boolean[] occupied;
  * occupied = new boolean[5000];
  * 
  * Q7 20 string objects are created by the following declaration
  * 
  * Q9 It dose not work <= bcz we have hours from 0 to 23 and when we put the sign
  * <= it makes it to go to 24 from 0 and theres no space so there is an error
  * count 0 to 24 its 25.
  * 
  * 
  * 
  * public void printGreater(double marks, double mean) { 
for(index = 0; index <= marks.length; index++) {
if(marks[index] > mean) {
System.out.println(marks[index]);
} 
} 
}  * 
  * 
  * 
  * 
  * 
    */
  

public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    //Q3 private Person[] people; 
    //Q4
    private boolean[] vacant;
    //Q5
    private  boolean[] occupied;
    int[] counts;
    //Q6
    double[] readings;
    String[] urls;
    //Q7 
    String[] labels;
    //Q8
    double[] prices;
    //TicketMachine[] machines;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    //Q12
    public LogAnalyzer(String logfilename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        //Q12
        reader = new LogfileReader(logfilename);
        //Q5
        occupied = new boolean[5000];
        //Q6
        readings = new double[60];
        urls = new String[90];
        //machines = new TicketMachine[5];
        //Q7 
        labels = new String[20];
        //Q8
        prices = new double[50];
    }


    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        //for(int hour = 0; hour < hourCounts.length; hour++) {
            //System.out.println(hour + ": " + hourCounts[hour]);
        //}
        //Q10
        int hour= 0;
        while ( hour < hourCounts.length)
        {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
        //Q11
        double[] marks = {2.3,3.3,5.8,1.0,0.8};
        printGreater(marks,2.0);
    }
    
    //Q11
    public void printGreater(double[] marks, double mean) { 
       for(int index = 0; index < marks.length; index++) {
         if(marks[index] > mean) {
           System.out.println(marks[index]);
         } 
       } 
    }
}

