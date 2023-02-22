package Mapper;

import Entities.Bog;

import java.util.List;

public class BogFacade
{
    // BØGER
    public static List<Bog> hentBøger()
    {
        BogMapper bogMapper = new BogMapper();

        return bogMapper.getBooks();
    }

    public static Bog hentBogByID(int bogID)
    {
        BogMapper bogMapper = new BogMapper();

        return bogMapper.getBookByID(bogID);
    }

    public static Bog sletBog(int bogID)
    {
        BogMapper bogMapper = new BogMapper();

        return bogMapper.deleteBook(bogID);
    }

    public static Bog registrerBog(Bog bog)
    {
        BogMapper bogMapper = new BogMapper();

        return bogMapper.registerBook(bog);
    }
}
