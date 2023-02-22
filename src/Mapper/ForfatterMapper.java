package Mapper;

import Database.ConnectionConfiguration;
import Entities.Forfatter;
import Entities.Udlån;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForfatterMapper
{
    protected List<Forfatter> getAllAuthors()
    {
        PreparedStatement statement;
        List<Forfatter> forfatterList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotek.forfatter");

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                int idforfatter = result.getInt("idforfatter");
                String forfatters = result.getString("forfatter");

                Forfatter forfatter = new Forfatter(idforfatter, forfatters);
                forfatterList.add(forfatter);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        for (Forfatter forfatter : forfatterList)
        {
            System.out.println(forfatter.toString());
        }

        return forfatterList;
    }

    protected Forfatter getAuthorsByID(int forfatterID)
    {
        PreparedStatement statement;
        Forfatter forfatter = null;

        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("SELECT * from bibliotek.forfatter where idforfatter = ?");

            statement.setInt(1, forfatterID);

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                forfatterID = result.getInt("idforfatter");
                String forfatterNavn = result.getString("forfatter");

                forfatter = new Forfatter(forfatterID, forfatterNavn);
            }


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return forfatter;
    }


    protected void registerAnAuthors(String forfatter)
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
