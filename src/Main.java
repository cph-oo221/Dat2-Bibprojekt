import Language.DanskDialog;
import Language.Dialog;
import Language.EngelskDialog;
import Utilities.Input;

public class Main
{
    public static void main(String[] args)
    {
        /*System.out.println("Bøgerne er: ");
        List<Bog> bogList = BogFacade.hentBøger();
        for (Bog bog : bogList)
        {
            System.out.println(bog.toString());
        }

        System.out.println();
        System.out.println("Bruger er:  ");
        BrugerFacade.hentBruger();

        System.out.println();

        System.out.println("Forfattere er: ");
        ForfatterFacade.hentForfatter();

        System.out.println();

        System.out.println("Zip code er: ");
        PostnrFacade.hentPostnr();

        System.out.println();

        System.out.println("Udlaan er: ");
        List<Udlån> udlånList = UdlånFacade.hentUdlån();
        for (Udlån udlån1 : udlånList)
        {
        System.out.println(udlån1.toString());
        }*/


        Dialog dialog;

        dialog = new DanskDialog();
        System.out.println(dialog.hello());
        System.out.println(dialog.welcome());
        System.out.println(Input.getInt(dialog.askAge()));

        dialog = new EngelskDialog();
        System.out.println(dialog.hello());
        System.out.println(dialog.welcome());


        dialog = new DanskDialog();

        while (true)
        {
            System.out.println(Input.getInt(dialog.askAge()));
            if (Input.getString(dialog.changeLanguage()).equalsIgnoreCase("y"))
            {
                if(dialog instanceof DanskDialog)
                {
                    dialog = new EngelskDialog();
                }
                else
                {
                    dialog = new DanskDialog();
                }
            }

        }


    }
}