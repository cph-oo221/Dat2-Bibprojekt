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

    public static Postnr registrerPostnr(Postnr postnr)
    {
        PostnrMapper postnrMapper = new PostnrMapper();

        return postnrMapper.registerZipCode(postnr);
    }

    public static Postnr deletePostnr(int postnrID)
    {
        PostnrMapper postnrMapper = new PostnrMapper();

        return postnrMapper.deleteZipCode(postnrID);
    }
}
