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

    public List<Postnr> getAllZipCodes()
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



    public Postnr getZipCodeByID(int postnrID)
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

    public Postnr deleteZipCode(int postnrID)
    {
        PreparedStatement statementDelete;
        PreparedStatement statementSelect;
        Postnr postnr = null;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statementDelete = connection.prepareStatement("delete from bibliotek.postnr where idpostnr = ?");
            statementSelect = connection.prepareStatement("select * from bibliotek.postnr where idpostnr = ?");

            statementSelect.setInt(1, postnrID);
            ResultSet result = statementSelect.executeQuery();

            while (result.next())
            {
                postnrID = result.getInt("idpostnr");
                String bynavn = result.getString("bynavn");
                postnr = new Postnr(postnrID, bynavn);
            }

            System.out.println("Postnr slettet: " + postnr.toString());

            statementDelete.setInt(1, postnrID);
            statementDelete.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return postnr;
    }


    public List<Udlån> getAllBookLoans()
    {
        PreparedStatement statement;
        List<Udlån> udlånList = new ArrayList<>();
        Udlån udlån = null;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotek.udlån");

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                int idudlån = result.getInt("idudlån");
                int idbøger = result.getInt("idbøger");
                int idlåner = result.getInt("idlåner");

                udlån = new Udlån(idudlån, idbøger, idlåner);

                udlånList.add(udlån);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        for (Udlån udlån1 : udlånList)
        {
            System.out.println(udlån1.toString());
        }

        return udlånList;
    }


    public Udlån getBookLoansByID(int udlånID)
    {
        PreparedStatement statement;
        Udlån udlån = null;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("select * from bibliotek.udlån where idudlån = ?");

            statement.setInt(1, udlånID);

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                udlånID = result.getInt("idudlån");
                int idbøger = result.getInt("idbøger");
                int idlåner = result.getInt("idlåner");

                udlån = new Udlån(udlånID, idbøger, idlåner);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return udlån;
    }


    // todo - delete book loan


}
