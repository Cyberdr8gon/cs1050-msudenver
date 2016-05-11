/*
 *  Author:
 *      Sam Bateman
 *
 *  Title:
 *      Cell Phone Final and Assignment 7
 *
 *  License:
 *      MIT OPEN LICENSE 2016
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class PhoneIO
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

    public String getString(int specialCase, String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n", type); 
        String userInput= input.nextLine();
        switch(specialCase)
        {
            case 1: userInput = userInput.trim(); break;
            default: break;
        }
        return userInput;
    }

    public int printMenu(String[] mainMenu)
    {
        System.out.println("Main Menu");
        System.out.printf("#\tChoice\n-\t---------\n");
        for(int i = 0; i < mainMenu.length; i++)
        {
            System.out.printf("%d\t%s\n", i + 1, mainMenu[i]);
        }
        System.out.println("Enter 0 to exit");
        int userInput = getInt("Enter number of your choice:");
        while(userInput < 0 || userInput > 3)
        {
            userInput = getInt("Error: Invalid Selection, please try again");
        }
        return userInput;
    }

    public int printMenu(String title, String[] menuItems)
    {
        System.out.printf("%s\n#\tChoice\n-\t------\n", title);
        for(int i = 0; i < menuItems.length; i++)
        {
            System.out.printf("%d\t%s\n", i, menuItems[i]);
        }

        int userInput = getInt("Enter number of your choice:");
        while(userInput < 0 || userInput > menuItems.length)
        {
            userInput = getInt("Error: Invalid Selection, please try again");
        }
        return userInput;
    }
}

class ContactsList
{
    static List<String> dynamicContacts;
    static PhoneIO stdIO;
    static String[] sortChoices;
    String[] mainMenu;

    public ContactsList()
    {
        dynamicContacts = new ArrayList<String>();
        stdIO = new PhoneIO();
        mainMenu = new String[3];
        mainMenu[0] = "Add Contact";
        mainMenu[1] = "Sort Contacts";
        mainMenu[2] = "Print Contacts";
    }
    
    public static void addNumbers()
    {
        int sentinalValue = 1;
        String temp = "";
        StringBuilder appender = new StringBuilder(64);
        while(sentinalValue != 0)
        {
            // 1 for chomp
            appender.append(stdIO.getString(1, "Enter Last Name of person"));
            appender.append(" " + stdIO.getString(1, "Enter First Name of person") + " ");
            appender.append(stdIO.getLong("Enter Number:"));
            appender.append("\t");
            appender.append("Speed Dial Number: ");
            appender.append(dynamicContacts.size() + 1);
            dynamicContacts.add(appender.toString());
            appender.delete(0,64);
            sentinalValue = stdIO.getInt("Do you want to add another?\nIf so, enter 1, if not, enter 0");
        }
    }

    public void addNumbers(int specialCase)
    {
        switch(specialCase)
        {
            case 0: System.out.printf("Welcome to your new phone!\nEnter Your Contacts!\n"); addNumbers(); break;

            default: addNumbers(); break;
        }
    }

    public int mainMenu()
    {
        int userInput = stdIO.printMenu(mainMenu);
        mainMenuLogic(userInput);
        return userInput;
    }

    public static void sortMenu()
    {
        sortChoices = new String[3];
        sortChoices[0] = "Quick Sort";
        sortChoices[1] = "Bubble Sort";
        sortChoices[2] = "Selection Sort";
        sortMenuLogic(stdIO.printMenu("Choose your sort method", sortChoices));
    }

    public static void mainMenuLogic(int userInput)
    {
        switch(userInput)
        {
            case 1: addNumbers(); break;
            case 2: sortMenu(); break;
            case 3: printContactsUnsorted(); break;
            case 0: break;
            default: System.out.println("Error: Invalid Selection. Please Try Again.");
        }
    }

    public static void sortMenuLogic(int userInput)
    {
        switch(userInput)
        {
            case 0: quickSort(); break;
            case 1: bubbleSort(); break;
            case 2: selectionSort(); break;
            default: sortMenuLogic(stdIO.printMenu("Error: Invalid Selection. Please Enter a Valid Choice", sortChoices));
        }
    }

    public void exitMessage()
    {
        System.out.println("Thank you for using SMB Mobile");
    }

    public static void printContactsUnsorted()
    {
        String[] tempArray = dynamicContacts.toArray(new String[dynamicContacts.size()]);
        for(String str : tempArray)
        {
            System.out.println(str);
        }
    }

    public static String[] arrayLowerCase(String[] input)
    {
        for(int i = 0; i < input.length; i++)
        {
            input[i] = input[i].toLowerCase();
        }
        return input;
    }

    public static void quickSort()
    {
        long startTime = System.nanoTime();
        String[] tempArray = dynamicContacts.toArray(new String[dynamicContacts.size()]);
        tempArray = arrayLowerCase(tempArray);
        Arrays.sort(tempArray);
        System.out.println("Sorted Numbers");
        for(String str : tempArray)
        {
            System.out.println(str);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.printf("Sort took %d miliseconds\n", duration);
    }

    public static void bubbleSort()
    {
        long startTime = System.nanoTime();
        String[] tempArray = dynamicContacts.toArray(new String[dynamicContacts.size()]);
        tempArray = arrayLowerCase(tempArray);
        boolean complete = false;
        String temp = "";
        while(complete == false)
        {
            for(int i = 1; i < tempArray.length; i++)
            {
                if(tempArray[i].toLowerCase().compareTo(tempArray[i-1].toLowerCase()) <  0)
                {
                    temp = tempArray[i];
                    tempArray[i] = tempArray[i-1];
                    tempArray[i-1] = temp;
                }
            }
            complete = true;
            for(int i = 1; i < tempArray.length; i++)
            {
                if(tempArray[i].toLowerCase().compareTo(tempArray[i-1].toLowerCase()) <  0)
                {
                    complete = false;
                }
            }
        }
        System.out.println("Sorted Numbers");
        for(String str : tempArray)
        {
            System.out.println(str);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.printf("Sort took %d miliseconds\n", duration);
    }

    public static void selectionSort()
    {
        long startTime = System.nanoTime();
        String[] tempArray = dynamicContacts.toArray(new String[dynamicContacts.size()]);
        tempArray = arrayLowerCase(tempArray);
        int index;
        String lowerAlphabetically;
        for(int i = 0; i < (tempArray.length - 1); i++)
        {
            index = i;
            for(int j = (i + 1); j < tempArray.length; j++)
            {
                if(tempArray[i].toLowerCase().compareTo(tempArray[j].toLowerCase()) >  0)
                {
                    index = j;
                }
            }
            lowerAlphabetically = tempArray[index];
            tempArray[index] = tempArray[i];
            tempArray[i] = lowerAlphabetically;
        }

        System.out.println("Sorted Numbers");
        for(String str : tempArray)
        {
            System.out.println(str);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.printf("Sort took %d miliseconds\n", duration);
    }
}


public class Main
{
    public static void main(String[] args)
    {
        int sentinalValue = -1;
        ContactsList phone = new ContactsList();
        // pass number to state if it is the first initialization of numbers
        phone.addNumbers(0);
        while(sentinalValue != 0)
        {
            sentinalValue = phone.mainMenu();
        }
        phone.exitMessage();
    }
}
