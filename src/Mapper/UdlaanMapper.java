package Mapper;

import Database.ConnectionConfiguration;
import Entities.Udlån;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UdlaanMapper
{
    protected List<Udlån> getAllBookLoans()
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

        return udlånList;
    }


    protected Udlån getBookLoansByID(int udlånID)
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


    protected Udlån registerUdlån(Udlån udlån)
    {
        PreparedStatement statement;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("insert into bibliotek.udlån (idbøger, idlåner) values (?, ?)");

            statement.setInt(1, udlån.getIdBøger());
            statement.setInt(2, udlån.getIdLåner());

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return udlån;
    }

    public Udlån sletUdlån(int udlånID)
    {
        PreparedStatement statementDelete;
        PreparedStatement statementSelect;

        Udlån udlån = null;
        try
        {
            Connection connection = ConnectionConfiguration.getConnection();

            statementDelete = connection.prepareStatement("delete from bibliotek.udlån where idudlån = ?");

            statementSelect = connection.prepareStatement("select * from bibliotek.udlån where idudlån = ?");

            statementSelect.setInt(1, udlånID);

            ResultSet result = statementSelect.executeQuery();

            while (result.next())
            {
                int idudlån = result.getInt("idudlån");
                int idbøger = result.getInt("idbøger");
                int idlåner = result.getInt("idlåner");

                udlån = new Udlån(idudlån, idbøger, idlåner);
            }

            statementDelete.setInt(1, udlånID);
            statementDelete.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return udlån;
    }
}
