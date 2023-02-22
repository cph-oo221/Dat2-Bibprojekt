package Mapper;

import Database.ConnectionConfiguration;
import Entities.Bog;
import Entities.Forfatter;
import Entities.Udlån;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BogMapper
{
    // BOG - GET ALL, BY ID & delete book.
    protected List<Bog> getBooks()
    {
        PreparedStatement statement;
        List<Bog> bogList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statement = connection.prepareStatement("select * from bibliotek.bøger");

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                int idbøger = result.getInt("idbøger");
                String titel = result.getString("titel");
                int forfatter = result.getInt("forfatter");

                Bog bog = new Bog(idbøger, titel, forfatter);
                bogList.add(bog);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        return bogList;
    }

    protected Bog getBookByID(int bøgerID)
    {
        PreparedStatement statement;
        Bog bog = null;

        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("SELECT * from bibliotek.bøger where idbøger = ?");

            statement.setInt(1, bøgerID);

            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                bøgerID = result.getInt("idbøger");
                String titel = result.getString("titel");
                int forfatter = result.getInt("forfatter");

                bog = new Bog(bøgerID, titel, forfatter);
            }


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bog;
    }

    protected Bog deleteBook(int bøgerID)
    {
        PreparedStatement statementDelete;

        PreparedStatement statementBook;

        Bog bog = null;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statementDelete = connection.prepareStatement("delete from bibliotek.bøger where idbøger = ?");

            statementBook = connection.prepareStatement("select * from bibliotek.bøger where idbøger = ?");

            statementBook.setInt(1, bøgerID);


            ResultSet result = statementBook.executeQuery();

            while (result.next())
            {
                bøgerID = result.getInt("idbøger");
                String titel = result.getString("titel");
                int forfatter = result.getInt("forfatter");

                bog = new Bog(bøgerID, titel, forfatter);
            }

            System.out.println("The book has been deleted");
            System.out.println("Book: " + bog.toString());

            statementDelete.setInt(1, bøgerID);
            statementDelete.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bog;
    }

    protected Bog registerBook(Bog bog)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.bøger (titel, forfatter) VALUES (?, ?)");

            statement.setString(1, bog.getTitel());
            statement.setInt(2, bog.getForfatter());

            statement.executeUpdate();


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

        return bog;
    }

}
