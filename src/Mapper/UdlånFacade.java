package Mapper;

import Entities.Udlån;

import java.util.List;

public class UdlånFacade
{
    // UDLÅN
    public static List<Udlån> hentUdlån()
    {
        UdlaanMapper udlaanMapper = new UdlaanMapper();

        return udlaanMapper.getAllBookLoans();
    }

    public static Udlån hentUdlånByID(int udlånID)
    {
        UdlaanMapper udlaanMapper = new UdlaanMapper();

        return udlaanMapper.getBookLoansByID(udlånID);
    }
}
