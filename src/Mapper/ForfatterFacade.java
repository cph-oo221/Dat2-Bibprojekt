package Mapper;

import Entities.Forfatter;

import java.util.List;

public class ForfatterFacade
{
    public static List<Forfatter> hentForfatter()
    {
        ForfatterMapper forfatterMapper = new ForfatterMapper();

        return forfatterMapper.getAllAuthors();
    }

    public static Forfatter hentForfatterByID(int forfatterID)
    {
        ForfatterMapper forfatterMapper = new ForfatterMapper();

        return forfatterMapper.getAuthorsByID(forfatterID);
    }

    public static Forfatter registrerForfatter(Forfatter forfatter)
    {
        ForfatterMapper forfatterMapper = new ForfatterMapper();

        return forfatterMapper.registerAnAuthors(forfatter);
    }
}
