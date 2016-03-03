/*
 * Name: 
 *      Shape Area Averager 0.9
 *
 * Description: 
 *      A program that gives the areas of 
 *      squares, circles, rectangles and triangles
 *
 * Author:
 *      Samuel Bateman
 *
 * License:
 *      MIT Open License
 *
 */
import java.util.Scanner;

class GetInput
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
}

class Shapes
{
    public static void circleArea()
    {
        GetInput stdIn = new GetInput();
        double radius = (double)stdIn.getInt("Radius of circle");
        double area = Math.PI * (double)radius * (double)radius;
        System.out.printf("Area of Circle with radius %10.3f: %10.3f\n", radius, area);
    }

    public static void rectangleArea()
    {
        GetInput stdIn = new GetInput();
        double sideOne = (double)stdIn.getInt("Side one Length");
        double sideTwo = (double)stdIn.getInt("Side two Length");
        double area = sideOne * sideTwo;
        System.out.printf("Area of Rectangle with sides length %10.3f and %10.3f: %10.3f\n", sideOne, sideTwo, area);
    }

    public static void squareArea()
    {
        GetInput stdIn = new GetInput();
        double side = (double)stdIn.getInt("Side Length");
        double area = (double)side * side;
        System.out.printf("Area of Square with side length %10.3f: %10.3f\n", side, area);
    }

    public static void triangleArea()
    {
        GetInput stdIn = new GetInput();
        double sideOne = (double)stdIn.getInt("Side one Length");
        double sideTwo = (double)stdIn.getInt("Side two Length");
        double area = (float)(sideOne * sideTwo) / 2.0;       
        System.out.printf("Area of Triangle with sides length %10.3f and %10.3f: %10.3f\n", sideOne, sideTwo, area);
    }
    
    
}


class Program
{
    public static void main(String args[])
    {
        int userMenuSelection = -1;
        do
        {
            userMenuSelection = mainMenu();
            userInputLogic(userMenuSelection);    
        }
        while(userMenuSelection != 0);

    }

    public static int mainMenu()
    {
        GetInput menuInput = new GetInput();
        System.out.printf("1\tCircle area\n2\tRectangle area\n3\tSquare Area\n4\tTriangle Area\n\n0\tquit\n");
        int userInput = menuInput.getInt("A Selection");
        return userInput;
    }

    public static void userInputLogic(int userMenuSelection)
    {
        Shapes areaCalc = new Shapes();
        switch(userMenuSelection)
        {
            case 1: 
            {
                areaCalc.circleArea();
                break;
            }
            case 2:
            {
                areaCalc.rectangleArea();
                break;
            }
            case 3:
            {
                areaCalc.squareArea();
                break;
            }
            case 4:
            {
                areaCalc.triangleArea();
                break;
            }
            case 0:
            {
                break;
            }
            default:
            {
                System.out.printf("Invalid selection, Please try again.\n");
                break;
            }       
        }
    }
}
