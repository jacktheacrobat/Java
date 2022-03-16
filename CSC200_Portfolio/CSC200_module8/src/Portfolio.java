import java.util.Scanner;

public class Portfolio {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numStudents = 0;
		int ageAverage = 0;
		int ageSum = 0;
		String userPrompt = "";
		
		System.out.println("How many students are in the class? ");
		numStudents = scan.nextInt();
		
		String studentName[] = new String[numStudents];
		int studentAge[] = new int[numStudents];
		
		for (int i = 0; i < studentName.length; i++) {
			System.out.println("Please enter the name of student " + (i + 1) + ": ");
			studentName[i] = scan.next();
			try {
			System.out.println("Please enter the age of student " + (i + 1) + ": ");
			studentAge[i] = scan.nextByte();
			}
			catch (Exception e) {
				System.out.println("You did not enter a valid response.");
			}
		}
		System.out.println("Thank you for entering all student information.");
		
		while (! userPrompt.equals("exit")) {
			
			System.out.println("");
			System.out.println("Please type \"names\" to view all student names: ");
			System.out.println("Please type \"ages\" to view all student ages: ");
			System.out.println("Please type \"average\" to view average student age: ");
			System.out.println("Please type \"all\" to view all student information: ");
			System.out.println("Please type \"exit\" to quit the program: ");
		
			userPrompt = scan.next();
		
			//Print student names
			if (userPrompt.equals("names")){
				for (int i = 0; i < studentName.length; i++) {
					System.out.println(studentName[i] + " ");
				   }
				}
			
			//Print student ages
			else if (userPrompt.equals("ages")) {
				for (int i = 0; i < studentAge.length; i++) {
					System.out.println(studentAge[i] + " ");
			   }
		    }
			
			//Print average age
			else if (userPrompt.equals("average")) {
				for (int i = 1; i <= studentAge.length; i++) {
					ageSum += studentAge[i - 1];
				}
					ageAverage = (ageSum / studentAge.length);
				System.out.println("Average age:" + ageAverage);
			}
			
			//Print all information
			else if (userPrompt.equals("all")) {
				for (int i = 0; i < studentName.length; i++) {
					System.out.println (studentName[i] + ": " + studentAge[i] + " years old.");
				}
				for (int i = 1; i <= studentAge.length; i++) {
					ageSum += studentAge[i - 1];
				}
					ageAverage = (ageSum / studentAge.length);
				System.out.println("Average age: " + ageAverage + " years old.");
		    }
			
			//Print exit phrase
			else if (userPrompt.equals("exit")) {
				System.out.println("Thanks for using this program.");
			}
			
			
			//Invalid request
			else {
				System.out.println("You did not enter a valid request.");
				
			}
	}
	}	
}
