import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(getString("Hvad er dit navn?"));

        System.out.println(getInt("Angiv venligst din skostørrelse?"));

        System.out.println(getInt("Angiv venligst din højde?"));
    }

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