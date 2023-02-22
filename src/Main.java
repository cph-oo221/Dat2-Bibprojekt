import Entities.Bog;
import Language.DanskDialog;
import Language.Dialog;
import Language.EngelskDialog;
import Mapper.BogFacade;
import Menu.Menu;
import Utilities.Input;



public class Main
{
    public static void main(String[] args)
    {
        /*Dialog dialog;


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

        }*/


        Menu menu = new Menu();
        menu.run();
        
    }
}