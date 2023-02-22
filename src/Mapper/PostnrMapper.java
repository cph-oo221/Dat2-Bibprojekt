package Mapper;

import Database.ConnectionConfiguration;
import Entities.Postnr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostnrMapper
{
    protected List<Postnr> getAllZipCodes()
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

        return postnrList;
    }


    protected Postnr getZipCodeByID(int postnrID)
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

    protected Postnr deleteZipCode(int postnrID)
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

    protected Postnr registerZipCode(Postnr postnr)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.postnr (idpostnr, bynavn) VALUES (?, ?)");

            statement.setInt(1, postnr.getPostnr());
            statement.setString(2, postnr.getBynavn());
            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return postnr;
    }
}
