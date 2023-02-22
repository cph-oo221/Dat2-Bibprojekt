package Mapper;

import Entities.*;

import java.sql.SQLException;
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

    public static Bruger registrerBruger(Bruger bruger)
    {
        BrugerMapper brugerMapper = new BrugerMapper();

        return brugerMapper.registerBruger(bruger);
    }


    public static Bruger opdaterBruger(Bruger bruger)
    {
        BrugerMapper brugerMapper = new BrugerMapper();

        return brugerMapper.opretBruger(bruger);
    }



}
