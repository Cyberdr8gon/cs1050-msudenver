import java.util.Scanner;

public class Setup
{
    public static void main(String[] args)
    {
        Inventory store1 = new Inventory();
        store1.addFirstDimensionalObject("Laptop");
        store1.addFirstDimensionalObject("Desktop");
        store1.listFirstDimensionalObjects();
        store1.addSecondDimensionalObject("Laptop", "RAM");
        store1.listSecondDimensionObjects("Laptop");
    }
}
