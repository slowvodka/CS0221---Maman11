import java.util.Scanner;

/**
 * /*
 * program gets a 4 digit number from user
 * according to user it reverse the sign or\and reverse the order of the digits
 *
 */

public class Number
{
    public static void main (String [] args)
    {

        //variable declaration
        final int MAX_NUM = 10000;
        final int MIN_NUM = 999;
        final int REV_SIGN = 1;
        final int REV_NUM = 2;
        final int REV_BOTH = 3;
        int number, reverse;
        Scanner scan = new Scanner (System.in); //define scanner object
        System.out.println("Please enter a 4 digit number:");
        number = scan.nextInt(); //get age from user

        if (Math.abs(number)  < MAX_NUM &&  Math.abs(number) > MIN_NUM )
        //if number is 4 digit number
        {
            int option;
            System.out.println("1. Reverse sign.");
            System.out.println("2. Reverse number.");
            System.out.println("3. Reverse sign and number.");
            System.out.println("Please choose an option:");
            option = scan.nextInt();

            if (option >= REV_SIGN && option <= REV_BOTH )
            {
                if (option == REV_BOTH || option == REV_NUM) // if need to reverse the order
                {
                    reverse = number % 10;
                    number /= 10;
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                    number = reverse;
                }
                if (option == REV_SIGN || option == REV_BOTH) //in need to reverse sign
                    number*=(-1);

                System.out.print("The result is: " + number ); //print result
            }
            else
                System.out.print("Illegal option - you must choose 1, 2 or 3"); // option illegal
        }
        else //if number is not a 4 digit number
            System.out.print("Illegal number - you must enter a 4 digit number"); //illegal number

    } // end of method main
} //end of class HeartRate