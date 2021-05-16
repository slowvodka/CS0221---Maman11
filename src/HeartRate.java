import java.util.Scanner;

/**
 *
 *         This program calculates your target heart rate while exercising.
 *         input - age
 *         output - range of healthy heart bit
 *
 */
public class HeartRate
{
    public static void main (String [] args)
    {

        final int CONST = 220;
        final int MAX_PERCENT = 85 , MIN_PERCENT = 65;

        //defining variables
        int age,minHeartBit, maxHeartBit;

        Scanner scan = new Scanner (System.in); //define scanner object
        System.out.println("This program calculates your target heart rate while exercising.\nEnter your age: ");
        age = scan.nextInt(); //get age from user
        minHeartBit = (CONST - age) * MIN_PERCENT / 100; //calculate minimal heart bit
        maxHeartBit = (CONST - age) * MAX_PERCENT / 100; ////calculate maximal heart bit
        System.out.print("Your estimated target heart rate zone is " + minHeartBit + " - " + maxHeartBit + " beats per minute.");

    } // end of method main
} //end of class HeartRate


