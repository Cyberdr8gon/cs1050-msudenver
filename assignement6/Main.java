import java.util.Scanner;

class ShapesIO
{
    public static int getInt(String type)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter %s:\n", type);
        while(!input.hasNextInt())
        {
            System.out.printf("Error: Not a number, please try again (no floats)\n");
            input.next();
        }
        int number = input.nextInt();
        return number;
    }

    public void outputArea(String type, double area)
    {
        System.out.printf("The area of this %s is: %f meters\n", type, area);
    }
    
    public int menu(String[] menuOptions)
    {
        System.out.printf("#\tOption\n");
        for(int i = 0; i < menuOptions.length; i++)
        {
            System.out.printf("%d\t%s area\n", i, menuOptions[i]);
        }
        int userInput = getInt("your selection");
        return userInput;
    }
}


class Shapes
{
    public static int initialValue;
    public static ShapesIO stdIO;
    public Shapes()
    {
        System.out.printf("error\n");
    }
    public Shapes(int userInput)
    {
        initialValue = userInput;
        stdIO = new ShapesIO();
        switch(userInput) 
        {
            case 0:
            {
                Shapes triangle = new Shapes(0, stdIO.getInt("triangle side 1 length (in meters)"), stdIO.getInt("triangle side 2 lenght (in meters)"));
                break;
            }
            case 1:
            {
                Shapes square = new Shapes(0, stdIO.getInt("square side length (in meters)"));
                break;
            }
            case 2:
            {
                Shapes rectangle = new Shapes(1, stdIO.getInt("rectangle side 1 length (in meters)"), stdIO.getInt("rectangle side 2 length (in meters)"));
                break;
            }
            case 3:
            {
                Shapes circle = new Shapes(1, stdIO.getInt("circle radius (in meters)"));
                break;
            }
            case 4:
            {
                break;
            }
            
            default:
            {
                System.out.println("Error invalid selection");
            }
        }
    }

    public Shapes(int type, int side1, int side2)
    {
        if(type == 0)
        {
            triangleArea(side1, side2);
        }
        else if (type == 1)
        {
            rectangleArea(side1, side2);
        }        
        
    }

    public Shapes(int type, int side)
    {
        if(type == 0)
        {
            squareArea(side);
        }
        else if (type == 1)
        {
            circleArea(side);
        }
    }

    static void triangleArea(int side1, int side2)
    {
        double area = (double)side1 * (double) side2 * 0.5;
        stdIO.outputArea("Triangle", area);
    }

    static void rectangleArea(int side1, int side2)
    {
        double area = (double)side1 * (double) side2;
        stdIO.outputArea("Rectangle", area);
    }

    static void squareArea(int side)
    {
        double area = (double) side * (double) side;
        stdIO.outputArea("Square", area);
    }
    
    static void circleArea(int radius)
    {
        double area = (double) radius * (double) radius * Math.PI;
        stdIO.outputArea("Circle", area);
    }
}



public class Main
{
    static Shapes interactive;

    public static void main(String[] args)
    {
        do
            interactive = new Shapes(mainMenuInput());
        while(interactive.initialValue != 4);
    }

    static int mainMenuInput()
    {
        ShapesIO stdIO = new ShapesIO();
        String[] menuOptions = {"Triangle", "Square", "Rectangle", "Circle", "Exit"};
        int userInput = stdIO.menu(menuOptions);
        return userInput;
    }
}
