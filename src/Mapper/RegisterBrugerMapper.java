package Mapper;

import Database.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterBrugerMapper
{
    public void registerBruger(String navn, String adresse, int postnr)
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
    public void registerZipCode(int postnr, String bynavn)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.postnr (idpostnr, bynavn) VALUES (?, ?)");

            statement.setInt(1, postnr);
            statement.setString(2, bynavn);
            statement.executeUpdate();

            System.out.println("A new Zip code has been registed");
            System.out.println("Zip code: " + postnr + " City: " + bynavn);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
