import java.io.*;
import java.util.*;

public class Tester_11 
{
	private static int count = 0;
	private static enum tests {TEST_1, TEST_2};
	private static LinkedList<AbstractMap.SimpleEntry<String, String>>  testsList;

	public static void main(String[] args) 
	{
		System.out.println("This is just a basic tester for your code. You must run more tests!\r\n");
		System.out.println("------------ BEGIN TEST Q1 ------------");
		runTest(tests.TEST_1);
		System.out.println("------------ End TEST Q1 ------------\n\n");

		System.out.println("------------ BEGIN TEST Q2 ------------");
		runTest(tests.TEST_2);
		System.out.println("------------ End TEST Q2 ------------");
	}

	private static void runTest(tests numOfTest) 
	{
		createTest(numOfTest);
		count = 0;
		for (int i = 0; i < testsList.size(); i++)
			test(testsList.get(i).getKey(),testsList.get(i).getValue(), numOfTest);
	}

	private static void createTest(tests numOfTest) 
	{
		testsList = new LinkedList<AbstractMap.SimpleEntry<String, String>>();

		if(numOfTest == tests.TEST_1)
		{
			testsList.add(new AbstractMap.SimpleEntry<>("24", 
					"Your estimated target heart rate zone is 127 - 166 beats per minute."));
			
			testsList.add(new AbstractMap.SimpleEntry<>("10", 
					"Your estimated target heart rate zone is 136 - 178 beats per minute."));
			
			testsList.add(new AbstractMap.SimpleEntry<>("42", 
					"Your estimated target heart rate zone is 115 - 151 beats per minute."));
			
			testsList.add(new AbstractMap.SimpleEntry<>("120", 
					"Your estimated target heart rate zone is 65 - 85 beats per minute."));



			// Add more for test 1 here
		}
		else if(numOfTest == tests.TEST_2)
		{
			testsList.add(new AbstractMap.SimpleEntry<>("1234 1", "-1234"));

			testsList.add(new AbstractMap.SimpleEntry<>("1234 2", "4321"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("-1234 2", "-4321"));

			testsList.add(new AbstractMap.SimpleEntry<>("1234 3", "-4321"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("-1234 3", "4321"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("1234 6", "Illegal option - you must choose 1, 2 or 3"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("1234 0", "Illegal option - you must choose 1, 2 or 3"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("1234 -1", "Illegal option - you must choose 1, 2 or 3"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("999 1", "Illegal number - you must enter a 4 digit number"));

			testsList.add(new AbstractMap.SimpleEntry<>("10000 1", "Illegal number - you must enter a 4 digit number"));

			// Add more test 2 here
		}
		else
			System.out.println("Error in createTest number " + numOfTest);
	}

	private static void test(String input, String output, tests numOfTest) 
	{
		count++;

		InputStream stdin = System.in;
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream old = System.out;
		System.setOut(new PrintStream(b));
		try 
		{
			System.setIn(new ByteArrayInputStream(input.getBytes()));
			if (numOfTest == tests.TEST_1)
				HeartRate.main(new String[] {});
			else if(numOfTest == tests.TEST_2)
				Number.main(new String[] {});
			else
				System.out.println("Error in test number " + numOfTest);
			
		} catch (Exception e) 
		{
			System.out.println("Error!!!");
		}
		finally 
		{
			System.setIn(stdin);
			System.out.flush();
			System.setOut(old);
		}

		String outputStudent = b.toString();
		if (outputStudent.contains(output))
		{
			System.out.printf("%s %30s\n","Test #" + count, "\t\tPassed");
		}
		else
		{
			System.out.printf("\n%s %30s","Test #" + count, "\t\tFAILED!!!!\n");
			System.out.println("Input is:\r\n" + input);
			String[] lines = outputStudent.split("\n");
			System.out.println("Student's result is:\r\n" + lines[lines.length - 1]);
			System.out.println("Result should be:\r\n" + output);
		}
	}
}