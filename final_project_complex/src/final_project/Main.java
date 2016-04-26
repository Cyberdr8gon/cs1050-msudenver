package final_project;

public class Main
{

    static DataIO inventoryIO;
    static UserIO stdIO;

    public static double currentTill;
    public static String[][] globalInventory;
    public static int numberOfItems;
    public static int adminPin;

    public static int sentinalValue;
    public static int userInput;

	public static void main(String[] args)
    {
        // Initialize IO classes
        inventoryIO = new DataIO();
        stdIO = new UserIO();
        
        // Load Variables
        initalDataLoad();

        // Main Interface Loop
        sentinalValue = -1;
        while(sentinalValue != 0)
        {
            printActiveInventory();
            userInput = stdIO.userMainSalesPrompt(numberOfItems, adminPin);
            if(userInput == adminPin)
            {
                sentinalValue = adminConsole();
            }
        }
        
        saveAllData();
	}

    static void initalDataLoad()
    {
        if(inventoryIO.isInitialized())
        {
            adminPin = inventoryIO.pullAdminPin();
            currentTill = inventoryIO.pullTill();
            numberOfItems = inventoryIO.pullHeaderItemCount();
            String[][] localInventory = new String[numberOfItems][3];

            for(int i = 0; i < numberOfItems; i++)
            {
                localInventory[i][0] = inventoryIO.pullNamesOfItemsFromHeader(i);
            }

            for(int i = 0; i < numberOfItems; i++)
            {
                localInventory[i][1] = inventoryIO.pullNumberInStockOfItem(i, localInventory[i][0]);
                localInventory[i][2] = inventoryIO.pullActiveStatusOfItem(i, localInventory[i][0]);
            }

            globalInventory = localInventory.clone();

        }
        else
        {
            promptSetup();
        }
    }

    static void saveAllData()
    {
        //TODO
        System.out.printf("This saves the data before exit");
    }

    static void promptSetup()
    {
        //TODO Write setup to initialize all variables
        System.out.println("Error #00 - Data uninitialized. Please compile and run Setup.java");
    }


    static void printActiveInventory();
    {
        //TODO
        System.out.println("This prints the inventory data for a user");
        
    }
    
    static int adminConsole()
    {
        //TODO
        System.out.println("This is the Admin Console");
        return 1;
    }


}
