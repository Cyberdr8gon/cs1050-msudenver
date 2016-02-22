import java.util.Scanner;

class GetInput
{
    public String getName(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter %s Name:\n", type); 
        String name = input.nextLine();
        return name;
    }

    public int getInt(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter %s:\n", type);
        while(!input.hasNextInt())
        {
            System.out.printf("Error: Not a number, please try again\n");
            input.next();
        }
        int number = input.nextInt();
        return number;
    }
}

class Output
{
    public void standardOut(String first, String last, Float average)
    {
        System.out.printf("Name\t\tAverage Score:\n%c. %s \t\t%.2f\n", first.charAt(0), last, average);
    }

    public int menu()
    {
        GetInput userInput = new GetInput();
        System.out.printf("\nWhat do you want to do?\n(enter corresponding number to action)\n1\tEnter New Student Scores\n\n0\tExit\n");
        int input = userInput.getInt("Option");
        return input;
    }
}

class Grades {
    public void addStudent()
    {
        GetInput userInput = new GetInput();
        Output output = new Output();
        String firstName = userInput.getName("First");
        String lastName = userInput.getName("Last");
        int numberOfScores = userInput.getInt("Number of Scores for this Student");
        int[] scores = new int[numberOfScores];
        int totalOfScores = 0;
        for(int i = 0; i < numberOfScores; ++i)
        {
            scores[i] = userInput.getInt("Test Score " + (i + 1));
            totalOfScores += scores[i];
        }
        float averageScore = (float)totalOfScores / (float)numberOfScores;
        output.standardOut(firstName, lastName, averageScore);
    }
}

class Program
{
    public static void main(String[] args)
    {
        Grades student = new Grades();
        Output generalOutput = new Output();
        int userInputData = -1;
        while(userInputData != 0)
        {
            userInputData = generalOutput.menu();
            if(userInputData == 1)
            {
                student.addStudent();
            }
        
        }
    }
}
