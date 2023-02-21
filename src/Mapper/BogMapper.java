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
    // BOG - GET ALL & BY ID.
    public List<Bog> getBogs()
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

        for (Bog bog : bogList)
        {
            System.out.println(bog.toString());
        }

        return bogList;
    }

    public Bog getBookByID(int bøgerID)
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

    // AUTHORS - GET ALL & BY ID
    public List<Forfatter> getAllAuthors()
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

    public Forfatter getAuthorsByID(int forfatterID)
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


    // UDLÅN - GET ALL & BY ID
    public List<Udlån> getAllUdlån()
    {
        PreparedStatement statement;
        List<Udlån> udlånList = new ArrayList<>();

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


                Udlån udlån = new Udlån(idudlån,idbøger,idlåner);

                udlånList.add(udlån);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        for (Udlån udlån : udlånList)
        {
            System.out.println(udlån.toString());
        }

        return udlånList;
    }


    public Udlån getUdlånByID(int udlånID)
    {
        PreparedStatement statement;
        Udlån udlån = null;

        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("SELECT * from bibliotek.udlån where idudlån = ?");

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

}
