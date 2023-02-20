package Utilities;

import java.util.Scanner;

public class Input
{
    public static String getString(String s)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(s + " : ");


        return scanner.nextLine();
    }

    public static int getInt(String s)
    {
        int res = 0;


        while (true)
        {
            try
            {
                res = Integer.parseInt(getString(s));
                return res;
            }
            catch (Exception e)
            {
                System.out.println("Husk ikke tal ord");
            }
        }
    }
}
