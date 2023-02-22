package Mapper;

import Entities.Bruger;
import Database.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrugerMapper
{

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

    protected Bruger registerBruger(Bruger bruger)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.låner (navn, adresse, postnr) VALUES (?, ?, ?)");

            statement.setString(1, bruger.getNavn());
            statement.setString(2, bruger.getAdresse());
            statement.setInt(3, bruger.getPostnr());

            statement.executeUpdate();


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bruger;
    }

    protected Bruger opretBruger(Bruger bruger)
    {
        try {
            Connection connection = ConnectionConfiguration.getConnection();

            String sql = "INSERT INTO bibliotek.låner (navn, adresse, postnr) VALUES (?,?,?)";

            // PreparedStatement statement = connection.prepareStatement("INSERT  INTO manBib.Bruger (navn, adresse, postnr)" + "VALUES (?,?,?)");
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, bruger.getNavn());
            statement.setString(2, bruger.getAdresse());
            statement.setInt(3, bruger.getPostnr());


            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            resultSet.next();


            bruger.setIdlåner(resultSet.getInt(1));



        } catch (Exception e) {

            e.printStackTrace();

        }
        return bruger;
    }
}
