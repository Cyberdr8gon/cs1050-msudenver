import java.util.Scanner;
import java.util.LinkedList;

class GetInput
{
    public static int getInt(String query)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n", query);
        while(!input.hasNextInt())
        {
            System.out.printf("Error: Not a number, please try again\n");
            input.next();
        }
        int number = input.nextInt();
        return number;
    }
}

public class LaptopSale
{
    static LinkedList data;

    public static checkForInitialization()
    {
        if(data == null)
        {
            data = new LinkedList;
            String[] cpu = new String[4];
            cpu[0] = "360\tIntel Core i7-4790K";
            cpu[1] = "250\tIntel Core i5-3670";
            cpu[2] = "110\tIntel Core i3-2350";
            data.push(cpu);
            String[] ram = new String[4];
            ram[0] = "100\t4GB" //TODO
        }
    }
}

public class ComputerStore
{
    public void beginLaptopSale()
    {
        LaptopSale purchase = new LaptopSale;
        System.out.printf("Thank you for choosing to buy a laptop with us!\n");
        purchase.chooseCPU();
        purchase.chooseRAM();
        purchase.chooseGPU();
        purchase.chooseSSD();
        purchase.completePurchase();
    }

    public void beginDesktopSale()
    {
        DesktopSale purchase = new DesktopSale;
        System.out.printf("Thank you for choosing to buy a desktop with us!\n");
        purchase.chooseCPU();
        purchase.chooseRAM();
        purchase.chooseGPU();
        purchase.chooseSSD();
        purchase.chooseHDD();
        purchase.completePurchase();
    }
}

public class Program
{
    boolean programRunning;

    public static void main(String[] args)
    {
        programRunning = true;
        while(programRunning != false)
        {
            menuLogicParser(displayMainMenu());
        }
    }


    public static int displayMainMenu()
    {
        GetInput input = new GetInput;
        System.out.printf("Hello! Welcome to Sam's Computer Shop!\nYour patronage is deeply appreciated!\n\nTo begin, please decide what you would like to do?\n\nPlease Enter the number that corrisponds to your prefered option:\n\n 1\tBuy a Laptop\n2\tBuy a Desktop\n\n\n0\tLeave the Store\n");
        int userInput = input.getInt("Please Enter Your Choice:");
        return userInput;
    }
    
    public static void menuLogicParser(int userInput)
    {
        ComputerStore store1 = new ComputerStore;
        switch(userInput)
        {
            case 1:
            {
                store1.beginLaptopSale();
                break;
            }
            case 2:
            {
                store1.beginDesktopSale();
                break;
            }
            case 0:
            {
                System.out.printf("Thanks for your patronage!\n");
                programRunning = false;
                break;
            }
            default:
            {
                System.out.printf("Error, please enter a valid selection.\n");
                break;
            }
        }
    }
}
