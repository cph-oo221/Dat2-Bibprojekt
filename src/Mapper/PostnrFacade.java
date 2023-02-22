package Mapper;

import Entities.Postnr;

import java.util.List;

public class PostnrFacade
{
    // ZIP CODE
    public static List<Postnr> hentPostnr()
    {
        PostnrMapper postnrMapper = new PostnrMapper();

        return postnrMapper.getAllZipCodes();
    }

    public static Postnr hentPostnrByID(int postnrID)
    {
        PostnrMapper postnrMapper = new PostnrMapper();

        return postnrMapper.getZipCodeByID(postnrID);
    }

    public static void registrerPostnr(int postnr, String bynavn)
    {
        PostnrMapper postnrMapper = new PostnrMapper();

        postnrMapper.registerZipCode(postnr, bynavn);
    }
}
