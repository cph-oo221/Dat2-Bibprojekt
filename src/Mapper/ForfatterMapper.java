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

    protected Forfatter registerAnAuthors(Forfatter forfatter)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.forfatter (forfatter) values (?)");

            statement.setString(1, forfatter.getForfatter());

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return forfatter;
    }

    public Forfatter deleteAnAuthors(int forfatterID)
    {
        PreparedStatement statementDelete;
        PreparedStatement statementSelect;
        Forfatter forfatter = null;

        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statementSelect = connection.prepareStatement("SELECT * from bibliotek.forfatter where idforfatter = ?");
            statementDelete = connection.prepareStatement("DELETE from bibliotek.forfatter where idforfatter = ?");

            statementSelect.setInt(1, forfatterID);
            ResultSet resultSet = statementSelect.executeQuery();

            while (resultSet.next())
            {
                forfatterID = resultSet.getInt("idforfatter");
                String forfatterNavn = resultSet.getString("forfatter");

                forfatter = new Forfatter(forfatterID, forfatterNavn);
            }

            statementDelete.setInt(1, forfatterID);
            statementDelete.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return forfatter;
    }
}
