package Mapper;

import Entities.Udlån;

import java.util.List;

public class UdlånFacade
{
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

    public static Udlån registrerUdlån(Udlån udlån)
    {
        UdlaanMapper udlaanMapper = new UdlaanMapper();

        return udlaanMapper.registerUdlån(udlån);
    }

    public static Udlån seltUdlån(int udlånID)
    {
        UdlaanMapper udlaanMapper = new UdlaanMapper();

        return udlaanMapper.sletUdlån(udlånID);
    }
}
