package final_project;

public class DataIO
{

    public boolean isInitialized()
    {
        //TODO
        System.out.println("This checks if the ../data directory has been initialized");
        return true;
    }

    public int pullAdminPin()
    {
        //TODO
        System.out.println("This pulls the admin pin from ../data/header.txt");
        return 1234;
    }

    public double pullTill()
    {
        //TODO
        System.out.println("This pulls the double value till from ../data/header.txt");
        return 100d;
    }

    public int pullHeaderItemCount()
    {
        //TODO
        System.out.println("This pulls the total number of items from ../data/header.txt");
        return 2;
    }

    public String pullNamesOfItemsFromHeader(int index)
    {
        //TODO
        System.out.println("This pulls the String names of each item dependent on index from ../data/header.txt.");
        return ("asf" + index);
    }

    public String pullNumberInStockOfItem(int indexOfItem, String nameOfItem)
    {
        //TODO
        System.out.println("This pulls the String number of each item from ../data/ITEM_NAME.txt");
        return Integer.toString(indexOfItem + 5);
    }

    public String pullActiveStatusOfItem(int indexOfItem, String nameOfItem)
    {
        //TODO
        System.out.println("This pulls the String status of each item from ../data/ITEM_NAME.txt");
        return "1";
    }
}
