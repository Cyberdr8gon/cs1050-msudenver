/*
 * Name:
 *      Computer Store POS
 * Description:
 *      Allow customers to select options of a Desktop or a Laptop and produce a 
 *      list of the items and a order total. Also provide a invoice file on machine.
 *
 * Author:
 *      Samuel Bateman
 *
 * Copyright:
 *      MIT OPEN LICENSE
 *
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

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
class DesktopSale
{
    static LinkedList data;
    static double orderTotal;
    static String[] shoppingCart;
    static int itemsInCart;

    public static void checkForInitialization()
    {
        if(data == null)
        {
            data = new LinkedList();
            String[] cpu = new String[4];
            cpu[0] = "360\tIntel Core i7-4790K";
            cpu[1] = "250\tIntel Core i5-3670";
            cpu[2] = "110\tIntel Core i3-2350";
            cpu[3] = "50\tIntel Atom i3";
            data.push(cpu);
            String[] ram = new String[4];
            ram[0] = "100\t4GB RAM";
            ram[1] = "190\t8GB RAM";
            ram[2] = "270\t16GB RAM";
            ram[3] = "500\t32GB RAM";
            data.push(ram);
            String[] gpu = new String[4];
            gpu[0] = "0\tNo Graphics Card";
            gpu[1] = "200\tNvidia 960 2GB";
            gpu[2] = "300\tNvidia 970 3GB";
            gpu[3] = "500\tNvidia 980 4GB";
            data.push(gpu);
            String[] ssd = new String[4];
            ssd[0] = "120\t120GB SSD";
            ssd[1] = "180\t256GB SSD";
            ssd[2] = "290\t512GB SSD";
            ssd[3] = "500\t1TB SSD";
            data.push(ssd);

            orderTotal = 0;
            shoppingCart = new String[4];
        }
    }

    public static void printFormattedArray(String title, String[] target)
    {
        System.out.printf("%s\nitem #\tprice \titem\n------\t------\t------------------\n",title);
        for(int i=0; i < target.length; i++)
        {
            System.out.printf("%d\t%s\n", i, target[i]);
        } 
    }

    public static void addItemToTotalAndCart(String item)
    {
        orderTotal += Long.parseLong(item.substring(0, item.indexOf("\t")));
        shoppingCart[itemsInCart] = item;
        itemsInCart++;
    }

    public static int itemMenuSelector()
    {
        System.out.printf("Enter Item Number of Choice");
        int userInput = -1;
        GetInput stdIn = new GetInput();
        userInput = stdIn.getInt("");
        while(userInput >= 4 || userInput < 0)
        {
            userInput = stdIn.getInt("Not a valid option");
        }
        return userInput;
    }

    public static void chooseCPU()
    {
        checkForInitialization();
        String[] cpu = (String [])(data.get(3));
        printFormattedArray("CPU options", cpu);
        addItemToTotalAndCart(cpu[itemMenuSelector()]);
    }

    public static void chooseRAM()
    {
        String[] ram = (String [])(data.get(2));
        printFormattedArray("RAM Options", ram);
        addItemToTotalAndCart(ram[itemMenuSelector()]);
    }

    public static void chooseGPU()
    {
        String[] gpu = (String [])(data.get(1));
        printFormattedArray("GPU Options", gpu);
        addItemToTotalAndCart(gpu[itemMenuSelector()]);
    }

    public static void chooseSSD()
    {
        String[] ssd = (String [])(data.get(0));
        printFormattedArray("SSD Options", ssd);
        addItemToTotalAndCart(ssd[itemMenuSelector()]);
    }

    public static void completePurchase() throws IOException
    {
        printFormattedArray("Final Shopping Cart", shoppingCart);
        orderTotal += 300;
        System.out.printf("x\t300\tCase\n\nGrand Total:\t $%.2f\n", orderTotal);
        String fileOutputName = Long.toString(System.currentTimeMillis());
        PrintWriter out = new PrintWriter(new FileWriter(".\\invoice"+fileOutputName+".txt"));
        out.printf("%s\nitem #\tprice \titem\n------\t------\t------------------\n",fileOutputName);
        for(int i=0; i < shoppingCart.length; i++)
        {
            out.printf("%d\t%s\n", i, shoppingCart[i]);
        }
        out.println("Grand Total:\t"+orderTotal);
        out.close();
    }

}

class LaptopSale
{
    static LinkedList data;
    static double orderTotal;
    static String[] shoppingCart;
    static int itemsInCart;

    public static void checkForInitialization()
    {
        if(data == null)
        {
            data = new LinkedList();
            String[] cpu = new String[4];
            cpu[0] = "360\tIntel Core i7-4790K";
            cpu[1] = "250\tIntel Core i5-3670";
            cpu[2] = "110\tIntel Core i3-2350";
            cpu[3] = "50\tIntel Atom i3";
            data.push(cpu);
            String[] ram = new String[4];
            ram[0] = "100\t4GB RAM";
            ram[1] = "190\t8GB RAM";
            ram[2] = "270\t16GB RAM";
            ram[3] = "500\t32GB RAM";
            data.push(ram);
            String[] gpu = new String[4];
            gpu[0] = "0\tNo Graphics Card";
            gpu[1] = "200\tNvidia 960M 2GB";
            gpu[2] = "300\tNvidia 970M 3GB";
            gpu[3] = "500\tNvidia 980M 4GB";
            data.push(gpu);
            String[] ssd = new String[4];
            ssd[0] = "120\t120GB SSD";
            ssd[1] = "180\t256GB SSD";
            ssd[2] = "290\t512GB SSD";
            ssd[3] = "500\t1TB SSD";
            data.push(ssd);

            orderTotal = 0;
            shoppingCart = new String[4];
        }
    }

    public static void printFormattedArray(String title, String[] target)
    {
        System.out.printf("%s\nitem #\tprice \titem\n------\t------\t------------------\n",title);
        for(int i=0; i < target.length; i++)
        {
            System.out.printf("%d\t%s\n", i, target[i]);
        } 
    }

    public static void addItemToTotalAndCart(String item)
    {
        orderTotal += Long.parseLong(item.substring(0, item.indexOf("\t")));
        shoppingCart[itemsInCart] = item;
        itemsInCart++;
    }

    public static int itemMenuSelector()
    {
        System.out.printf("Enter Item Number of Choice");
        int userInput = -1;
        GetInput stdIn = new GetInput();
        userInput = stdIn.getInt("");
        while(userInput >= 4 || userInput < 0)
        {
            userInput = stdIn.getInt("Not a valid option");
        }
        return userInput;
    }

    public static void chooseCPU()
    {
        checkForInitialization();
        String[] cpu = (String [])(data.get(3));
        printFormattedArray("CPU options", cpu);
        addItemToTotalAndCart(cpu[itemMenuSelector()]);
    }

    public static void chooseRAM()
    {
        String[] ram = (String [])(data.get(2));
        printFormattedArray("RAM Options", ram);
        addItemToTotalAndCart(ram[itemMenuSelector()]);
    }

    public static void chooseGPU()
    {
        String[] gpu = (String [])(data.get(1));
        printFormattedArray("GPU Options", gpu);
        addItemToTotalAndCart(gpu[itemMenuSelector()]);
    }

    public static void chooseSSD()
    {
        String[] ssd = (String [])(data.get(0));
        printFormattedArray("SSD Options", ssd);
        addItemToTotalAndCart(ssd[itemMenuSelector()]);
    }

    public static void completePurchase() throws IOException
    {
        printFormattedArray("Final Shopping Cart", shoppingCart);
        orderTotal += 300;
        System.out.printf("x\t300\tLaptop Shell\n\nGrand Total:\t $%.2f\n", orderTotal);
        String fileOutputName = Long.toString(System.currentTimeMillis());
        PrintWriter out = new PrintWriter(new FileWriter(".\\invoice"+fileOutputName+".txt"));
        out.printf("%s\nitem #\tprice \titem\n------\t------\t------------------\n",fileOutputName);
        for(int i=0; i < shoppingCart.length; i++)
        {
            out.printf("%d\t%s\n", i, shoppingCart[i]);
        }
        out.println("Grand Total:\t"+orderTotal);
        out.close();
    }

}

class ComputerStore
{
    public void beginLaptopSale() throws IOException
    {
        LaptopSale purchase = new LaptopSale();
        System.out.printf("Thank you for choosing to buy a laptop with us!\n");
        purchase.chooseCPU();
        purchase.chooseRAM();
        purchase.chooseGPU();
        purchase.chooseSSD();
        purchase.completePurchase();
    }

    public void beginDesktopSale() throws IOException
    {
        DesktopSale purchase = new DesktopSale();
        System.out.printf("Thank you for choosing to buy a desktop with us!\n");
        purchase.chooseCPU();
        purchase.chooseRAM();
        purchase.chooseGPU();
        purchase.chooseSSD();
        purchase.completePurchase();
    }
}

public class Program
{
    static boolean programRunning;

    public static void main(String[] args) throws IOException
    {
        programRunning = true;
        System.out.printf("Hello! Welcome to Sam's Computer Shop!\n");
        while(programRunning != false)
        {
            menuLogicParser(displayMainMenu());
        }
    }


    public static int displayMainMenu()
    {
        GetInput input = new GetInput();
        System.out.printf("Your patronage is deeply appreciated!\n\nTo begin, please decide what you would like to do?\n\nPlease Enter the number that corrisponds to your prefered option:\n\n1\tBuy a Laptop\n2\tBuy a Desktop\n\n\n0\tLeave the Store\n");
        int userInput = input.getInt("Please Enter Your Choice:");
        return userInput;
    }
    
    public static void menuLogicParser(int userInput) throws IOException
    {
        ComputerStore store1 = new ComputerStore();
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
