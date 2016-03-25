/*
 * Savable Inventory Class
 * 
 * Description:
 *      Allows a setup program to create a new store and then be ported into many different POS front ends
 * 
 * Author:
 *      Samuel Bateman
 *
 * MIT OPEN LICENSE
 *
 */

import java.util.LinkedList;

public class Inventory implements java.io.Serializable
{
    static LinkedList firstDimensionList;
    
    // Utilites

    public static void checkForInitialization()
    {
        if(firstDimensionList == null)
        {
            firstDimensionList = new LinkedList();
        }
    }

    public static int numberOfFirstDimensionalElements()
    {
        checkForInitialization();
        return firstDimensionList.size();
    }

    public static int numberOfElements(LinkedList query)
    {
        //TODO

    }

    // Searching Functions
    
    public static LinkedList firstDimensionSearch(String query)
    {
        checkForInitialization();
        LinkedList temp;
        LinkedList actual;
        for(int i = 0; i < numberOfFirstDimensionalElements(); i++)
        {
            temp = (LinkedList)(firstDimensionList.get(i));
            if(temp.getFirst() == query)
            {
                actual = temp;
                return actual;
            }
        }
        return null;
    }

    // Adding Functions

    public static void addFirstDimensionalObject(String object)
    {
        checkForInitialization();
        LinkedList firstDimensionalObject = new LinkedList();
        firstDimensionalObject.push(object);
        firstDimensionList.push(firstDimensionalObject);
    }
    
    public static void addSecondDimensionalObject(String firstDimensionalObject, String Descriptor)
    {
        checkForInitialization();
        LinkedList temp = firstDimensionSearch(firstDimensionalObject);
        LinkedList secondDimensionalObject = new LinkedList();
        secondDimensionalObject.push(Descriptor);
        temp.push(secondDimensionalObject);
    }

    // Listing Functions

    public static void listFirstDimensionalObjects()
    {
        checkForInitialization();
        LinkedList temp;
        for(int i = 0; i < numberOfFirstDimensionalElements(); i++)
        {
            temp = (LinkedList)(firstDimensionList.get(i));
            System.out.printf("%s\n", temp.getFirst());
        }
    }
    public static void listSecondDimensionObjects(String firstDimensionalObject)
    {
        LinkedList temp = firstDimensionSearch(firstDimensionalObject);
        for(int i = 0; i < numberOfSecondDimensionalElements(temp))
    }
}


