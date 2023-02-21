package Mapper;

import Database.ConnectionConfiguration;
import Entities.Bog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterBogMapper
{
    public void registerBook(String titel, int forfatter)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.bøger (titel, forfatter) VALUES (?, ?)");

            statement.setString(1, titel);
            statement.setInt(2, forfatter);

            statement.executeUpdate();

            System.out.println("Bog er nu registreret");

            System.out.println("Titel: " + titel + " Forfatter: " + forfatter);



            // cant use executeQuery() with insert statement
            /*ResultSet result = statement.executeQuery();

            while (result.next())
            {
                int idbøger = result.getInt("idbøger");
                titel = result.getString("titel");
                forfatter = result.getInt("forfatter");

                bog = new Bog(idbøger, titel, forfatter);
            }*/

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public void registerAnAuthors(String forfatter)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.forfatter (forfatter) values (?)");

            statement.setString(1, forfatter);

            statement.executeUpdate();

            System.out.println("The author has been register");
            System.out.println("Forfatter: " + forfatter);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
