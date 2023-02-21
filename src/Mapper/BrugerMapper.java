package Mapper;

import Entities.Bruger;
import Database.ConnectionConfiguration;
import Entities.Postnr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrugerMapper
{

    // BRUGER - GET ALL & BY ID

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


    public Bruger getBrugerByID(int brugerID)
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

    public Bruger deleteBruger(int brugerID)
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



    // POSTNR - GET ALL & BY ID:

    public List<Postnr> getAllPostnr()
    {
        PreparedStatement statement;
        List<Postnr> postnrList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotek.postnr");

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                int id = result.getInt("idpostnr");
                String bynavn = result.getString("bynavn");

                Postnr postnr = new Postnr(id, bynavn);

                postnrList.add(postnr);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        for (Postnr postnr : postnrList)
        {
            System.out.println(postnr);
        }


        return postnrList;
    }



    public Postnr getPostnrByID(int postnrID)
    {
        PreparedStatement statement;
        Postnr postnr = null;

        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("select * from bibliotek.postnr where idpostnr = ?");

            statement.setInt(1, postnrID);

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                postnrID = result.getInt("idpostnr");
                String bynavn = result.getString("bynavn");

                postnr = new Postnr(postnrID, bynavn);

            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return postnr;
    }
}
