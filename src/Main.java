import Entities.Bruger;
import database.ConnectionConfiguration;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*System.out.println(getString("Hvad er dit navn?"));

        System.out.println(getInt("Angiv venligst din skostørrelse?"));

        System.out.println(getInt("Angiv venligst din højde?"));*/

        /*while (true)
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
        }*/

        PreparedStatement statement;
        List<Bruger> brugerList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotektonsdag.låner");

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                int id = result.getInt("idlåner");
                String navn = result.getString("navn");
                String adresse = result.getString("adresse");
                int postnr = result.getInt("postnr");

                Bruger bruger = new Bruger(id, navn, adresse, postnr);

                brugerList.add(bruger);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        for (Bruger bruger : brugerList)
        {
            System.out.println(bruger.toString());
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