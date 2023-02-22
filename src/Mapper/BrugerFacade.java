package Mapper;

import Entities.*;

import java.util.List;

public class BrugerFacade
{
    // BRUGER
    public static List<Bruger> hentBruger()
    {
        BrugerMapper brugerMapper = new BrugerMapper();

        return brugerMapper.getBruger();
    }

    public static Bruger hentBrugerByID(int brugerID)
    {
        BrugerMapper brugerMapper = new BrugerMapper();

        return brugerMapper.getBrugerByID(brugerID);
    }

    public static Bruger seltBruger(int brugerID)
    {
        BrugerMapper brugerMapper = new BrugerMapper();

        return brugerMapper.deleteBruger(brugerID);
    }

    public static void registrerBruger(String navn, String adresse, int postnr)
    {
        BrugerMapper brugerMapper = new BrugerMapper();

        brugerMapper.registerBruger(navn, adresse, postnr);
    }



}
