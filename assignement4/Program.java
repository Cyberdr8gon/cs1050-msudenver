/*
 *  Title:
 *      Palindrome Checker
 *
 *  Author:
 *      Sam Bateman
 *
 *  Description:
 *      Take inputted sentence and test if it is a palindrome.
 *
 *  Licence:
 *      M.I.T. Open License
 *
 */
import java.util.Scanner;

class GetInput
{
    public String getString(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter %s:\n", type); 
        String userInput= input.nextLine();
        return userInput;
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


class Palindrome
{
    public void test()
    {
        GetInput userInput = new GetInput();
        String palindrome = userInput.getString("Sentence to be tested");
        boolean testResult = runTest(palindrome);
        resultPrintLogic(testResult);
    }

    public static void resultPrintLogic(boolean result)
    {
        if(result == true)
        {
            System.out.printf("The sentence inputed is a palindrome.\n");
        }
        else
        {
            System.out.printf("The sentence inputed is not a palindrome. \n");
        }
    }

    public static boolean runTest(String rawData)
    {
        String testableData = cleanData(rawData);
        boolean result = checkPalindrome(testableData);
        return result;
    }

    public static boolean checkPalindrome(String testData)
    {
        boolean testResult = true;
        int testDataLength = testData.length();
        for(int i = 0; i < testDataLength; i++)
        {
            if(testData.charAt(i) != testData.charAt(testDataLength -1 - i))
            {
                testResult = false;
                break;
            }
        }
        return testResult;
    }

    public static String cleanData(String input)
    {
        String workingData = input;
        workingData = workingData.toLowerCase().trim().replaceAll("\\s","");
        //TODO(sam): Check previous line for errors
        return workingData;
    }
}

class Menu
{
    public int mainMenu()
    {
        GetInput menuInput = new GetInput();
        int userMenuInput;
        System.out.printf("\nMain Menu:\nEnter the number corresponding to your choice:\n\n[1]\tTest Palindromes\n\n[0]\tQuit\n");
        userMenuInput = menuInput.getInt("Choice");
        mainMenuLogic(userMenuInput);
        return userMenuInput;
    }
    public static void mainMenuLogic(int userInput)
    {
        switch(userInput)
        {
            case 1:
            {
                Palindrome testingProgram = new Palindrome();
                testingProgram.test();
                break;
            }
            case 0:
            {
                break;
            }
            default:
            {
                System.out.printf("Error, invalid selection.\n");
                break;
            }
        
        }

        //TODO(sam): Write this too!!!!
    }
}

class Program
{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        int userSelection = -1;
        while(userSelection != 0)
        {
            userSelection = menu.mainMenu();
        }
    }
}
