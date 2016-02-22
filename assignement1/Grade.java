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
        int number = input.nextInt();
        return number;
    }
}

class Output
{
    public void standardOut(String first, String last, Float average)
    {
        System.out.printf("Name\t\tAverage Score:\n%c. %s \t%.2f\n", first.charAt(0), last, average);
    }
}

class Grade {
    public static void main(String[] args)
    {
        GetInput userInput = new GetInput();
        Output output = new Output();
        String firstName = userInput.getName("First");
        String lastName = userInput.getName("Last");
        int[] scores = new int[3];
        for(int i = 0; i < 3; ++i)
        {
            scores[i] = userInput.getInt("Test Score " + (i + 1));
        }
        float averageScore = (float)(scores[0] + scores[1] + scores[2]) /(float)3;
        output.standardOut(firstName, lastName, averageScore);
    }
}
