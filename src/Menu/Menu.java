package Menu;

import Entities.Bog;
import Entities.Bruger;
import Entities.Forfatter;
import Language.DanskDialog;
import Language.Dialog;
import Language.EngelskDialog;
import Mapper.BogFacade;
import Mapper.BrugerFacade;
import Mapper.ForfatterFacade;

import java.util.List;
import java.util.Scanner;

public class Menu
{
    private Scanner scanner = new Scanner(System.in);
    private Dialog dialog;

    public void run()
    {
        dialog = new EngelskDialog();
        selectLanguage();
        printMenu();


    }

    private void selectLanguage()
    {
        System.out.println(dialog.chooseLanguage());
        System.out.println("1. " + dialog.languageOpsDanish());
        System.out.println("2. " + dialog.languageOpsEnglish());
        System.out.println("3. " + dialog.exit());
        System.out.print(dialog.userChoice());

        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                dialog = new DanskDialog();
                break;
            case 2:
                dialog = new EngelskDialog();
                break;
            case 3:
                exit();
                break;

            default:
                System.out.println("Ugyldigt valg");
                break;
        }
    }



    private void printMenu()
    {
        System.out.println(dialog.welcome());
        dialog.menuOptions();
        System.out.print(dialog.userChoice());
        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                // GET ALL BOOKS
                clearScreen();
                printAllBooks();

                continueMenu();
                break;

            case 2:
                // GET BOOK BY ID
                clearScreen();
                printAllBooks();
                System.out.println();

                int id = 0;
                System.out.println(dialog.insertID());
                id = scanner.nextInt();

                System.out.println(BogFacade.hentBogByID(id));

                continueMenu();
                break;

            case 3:
                // DELETE BOOK BY ID
                clearScreen();
                printAllBooks();
                System.out.println();

                int id2 = 0;
                System.out.println(dialog.insertID());
                id2 = scanner.nextInt();

                System.out.println(BogFacade.sletBog(id2));

                continueMenu();
                break;

            case 4:
                // REGISTER BOOK
                clearScreen();

                System.out.print(dialog.insertTitle());
                String title = scanner.next();

                System.out.println();

                System.out.println(dialog.authorList());
                printAllAuthors();

                System.out.println();

                System.out.println(dialog.insertAuthor());
                int forfatter = scanner.nextInt();

                System.out.println(BogFacade.registrerBog(new Bog(title, forfatter)));

                continueMenu();
                break;

            case 5:
                // TODO - Get all books by year
                break;
            case 6:
                // TODO - Get all books by publisher
                break;
            case 7:
                // TODO - Get all books by language
                break;
            case 8:
                // TODO - Get all books by ISBN
                break;
            case 9:
                break;

            default:
                System.out.println(dialog.invalidChoice());
                clearScreen();
                printMenu();
                break;

        }

    }


    private void continueMenu()
    {
        System.out.println();
        System.out.println();

        System.out.println(dialog.menuContinue());
        scanner.nextLine();
        scanner.nextLine();
        clearScreen();
        printMenu();
    }


    private void clearScreen()
    {
        for (int i = 0; i < 40; i++)
        {
            System.out.println("");
        }
    }

    private void exit()
    {
        System.out.println(dialog.exitMessage());
        System.exit(0);
    }

    private void printAllBooks()
    {
        List<Bog> bogList = BogFacade.hentBøger();
        for (Bog bog : bogList)
        {
            System.out.println(bog);
        }
    }

    private void printAllAuthors()
    {
        List<Forfatter> forfatterList = ForfatterFacade.hentForfatter();
        for (Forfatter forfatter : forfatterList)
        {
            System.out.println(forfatter);
        }
    }

    private void printAllUsers()
    {
        List<Bruger> brugerList = BrugerFacade.hentBruger();
        for (Bruger bruger : brugerList)
        {
            System.out.println(bruger);
        }
    }
}
