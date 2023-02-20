import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*System.out.println(getString("Hvad er dit navn?"));

        System.out.println(getInt("Angiv venligst din skostørrelse?"));

        System.out.println(getInt("Angiv venligst din højde?"));*/

        while (true)
        {
            switch (getString("angiv dit ønske ?"))
            {
                case "lån bog":
                    System.out.println("du ønsker at låne en bog");
                    break;
                case "stop":
                    break;
            }
            if(getString("q for quit").equalsIgnoreCase("q"))
                break;
        }

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