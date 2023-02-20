package Mapper;

import Database.ConnectionConfiguration;
import Entities.Bog;
import Entities.Forfatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BogMapper
{
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
        catch (Exception e)
        {
            e.printStackTrace();
        }

        for (Bog bog : bogList)
        {
            System.out.println(bog.toString());
        }

        return bogList;
    }

    public Bog getBogByID(int bøgerID)
    {
        return null;
    }


    public List<Forfatter> getForfatters()
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
        catch (Exception e)
        {
            e.printStackTrace();
        }

        for (Forfatter forfatter : forfatterList)
        {
            System.out.println(forfatter.toString());
        }

        return forfatterList;
    }

    public Forfatter getForfattersByID(int ForfatterID)
    {


        return null;
    }


    // TODO make method for udlån
}
