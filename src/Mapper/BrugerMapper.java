package Mapper;

import Entities.Bruger;
import Database.ConnectionConfiguration;
import Entities.Postnr;
import Entities.Udlån;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrugerMapper
{

    // BRUGER - GET ALL & BY ID

    protected List<Bruger> getBruger()
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
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        for (Bruger bruger : brugerList)
        {
            System.out.println(bruger.toString());
        }

        return brugerList;
    }


    protected Bruger getBrugerByID(int brugerID)
    {
        Bruger bruger = null;
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotek.låner where idlåner = ?");

            statement.setInt(1, brugerID);
            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                brugerID = result.getInt("idlåner");
                String navn = result.getString("navn");
                String adresse = result.getString("adresse");
                int postnr = result.getInt("postnr");

                bruger = new Bruger(brugerID, navn, adresse, postnr);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bruger;
    }

    protected Bruger deleteBruger(int brugerID)
    {
        PreparedStatement statementDelete;
        PreparedStatement statementSelect;
        Bruger bruger = null;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statementDelete = connection.prepareStatement("delete from bibliotek.låner where idlåner = ?");
            statementSelect = connection.prepareStatement("select * from bibliotek.låner where idlåner = ?");

            statementSelect.setInt(1, brugerID);
            ResultSet result = statementSelect.executeQuery();
            while (result.next())
            {
                brugerID = result.getInt("idlåner");
                String navn = result.getString("navn");
                String adresse = result.getString("adresse");
                int postnr = result.getInt("postnr");

                bruger = new Bruger(brugerID, navn, adresse, postnr);
            }
            System.out.println("Bruger slettet: " + bruger.toString());

            statementDelete.setInt(1, brugerID);
            statementDelete.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        return bruger;
    }

    protected void registerBruger(String navn, String adresse, int postnr)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.låner (navn, adresse, postnr) VALUES (?, ?, ?)");

            statement.setString(1, navn);
            statement.setString(2, adresse);
            statement.setInt(3, postnr);

            statement.executeUpdate();

            System.out.println("New user has been registed");
            System.out.println("Name: " + navn + " Adresse: " + adresse + " Zip code: " + postnr);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
