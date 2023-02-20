package Mapper;

import Entities.Bruger;
import Database.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BrugerMapper
{
    public List<Bruger> getBruger()
    {
        PreparedStatement statement;
        List<Bruger> brugerList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotek.låner");

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

        return brugerList;
    }


    public Bruger getBrugerByID(int brugerID)
    {
        return null;
    }


    // TODO make method for postnr
}
