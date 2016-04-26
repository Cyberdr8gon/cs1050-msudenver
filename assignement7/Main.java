import java.util.Scanner;

class PhoneNumberIO
{
    public static int getInt(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n", type);
        while(!input.hasNextInt())
        {
            System.out.printf("Error: Not a number, please try again (no floats)\n");
            input.next();
        }
        int number = input.nextInt();
        return number;
    }

    public static long getLong(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n", type);
        while(!input.hasNextLong())
        {
            System.out.printf("Error: Not a number, please try again (no floats)\n");
            input.next();
        }
        long number = input.nextLong();
        return number;
    }

    public String getString(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n", type); 
        String userInput= input.nextLine();
        return userInput;
    }
}

class PhoneNumber
{
    public static PhoneNumberIO stdio; 

    public static String firstName;
    public static String lastName;
    public static long areaCode;
    public static long phoneNumberMiddle;
    public static long phoneNumberLast;

    public void initializeClass()
    {
        PhoneNumberIO stdio = new PhoneNumberIO();
        firstName = stdio.getString("What is their first name?");
        lastName = stdio.getString("What is their last name?");
        setPhoneNumberFromString();
    }

    static void setPhoneNumberFromString()
    {
        long unparsedNumber = stdio.getLong("What is their phone number? (no spaces, dashes or parantheses)");
        while(unparsedNumber > 9999999999l)
        {
            unparsedNumber = stdio.getLong("Error: Invalid Number. Please enter a valid phone number");
        }
        areaCode = unparsedNumber / 10000000;
        phoneNumberMiddle = (unparsedNumber % 10000000) / 10000;
        phoneNumberLast = (unparsedNumber % 10000000) % 10000;
    }

    public void printContact()
    {
        System.out.printf("Name:\t%s, %s\nNumber:\t(%d) %d-%d\n", lastName, firstName, areaCode, phoneNumberMiddle, phoneNumberLast);
    }
}

public class Main
{
    static PhoneNumber[] speedDialArray;
    static int sentinalValue;
    static PhoneNumberIO stdio;

    public static void main(String[] args)
    {
        stdio = new PhoneNumberIO();
        do
        {
            if(speedDialArray == null)
            {
                setSpeedDialSize();
                fillSpeedDialArray();
            }
            displaySpeedDial();
            sentinalValue = exitMenu();
        }
        while(sentinalValue == 0);
    }

    static void setSpeedDialSize()
    {
        int temp = stdio.getInt("How many phone numbers do you want in speed diali?");
        speedDialArray = new PhoneNumber[temp];
        for(int i = 0; i < speedDialArray.length; i++)
        {
           speedDialArray[i] = new PhoneNumber(); 
        }
    }

    static void fillSpeedDialArray()
    {
        for(int i = 0; i < speedDialArray.length; i++)
        {

            speedDialArray[i].initializeClass();
        }
    }

    static void displaySpeedDial()
    {
        for(int i = 0; i < speedDialArray.length; i++)
        {
            speedDialArray[i].printContact();
        }
    }

    static int exitMenu()
    {
        int userInput = stdio.getInt("Do you want to view your contacts or exit? (enter 0 for contacts and 1 for exit)");
        return userInput;
    }
}
