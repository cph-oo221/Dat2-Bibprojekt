package Mapper;

import Entities.Bog;

import java.util.List;

public class BøgerFacade
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

    public static void registrerBog(String titel, int forfatter)
    {
        BogMapper bogMapper = new BogMapper();

        bogMapper.registerBook(titel, forfatter);
    }
}
