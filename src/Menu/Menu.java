package Menu;

import Entities.*;
import Language.DanskDialog;
import Language.Dialog;
import Language.EngelskDialog;
import Mapper.*;

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

                int bookID = 0;
                System.out.println(dialog.insertID());
                bookID = scanner.nextInt();

                System.out.println(BogFacade.hentBogByID(bookID));

                continueMenu();
                break;

            case 3:
                // DELETE BOOK BY ID
                clearScreen();
                printAllBooks();
                System.out.println();

                int bookDeleteID = 0;
                System.out.println(dialog.insertID());
                bookDeleteID = scanner.nextInt();

                System.out.println(BogFacade.sletBog(bookDeleteID));

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
                // GET ALL USERS
                clearScreen();
                printAllUsers();
                continueMenu();

                break;

            case 6:
                // GET USER BY ID
                clearScreen();
                printAllUsers();
                System.out.println();

                int userID = 0;
                System.out.println(dialog.insertID());
                userID = scanner.nextInt();
                System.out.println(BrugerFacade.hentBrugerByID(userID));

                continueMenu();
                break;

            case 7:
                // DELETE USER BY ID
                clearScreen();
                printAllUsers();
                System.out.println();

                int userDeleteID = 0;
                System.out.println(dialog.insertID());
                userDeleteID = scanner.nextInt();

                System.out.println(BrugerFacade.seltBruger(userDeleteID));

                continueMenu();

                break;

            case 8:
                // REGISTER USER
                clearScreen();
                System.out.print(dialog.insertName());
                String name = scanner.next();
                System.out.println();
                System.out.print(dialog.insertAdresse());
                String adresse = scanner.next();

                System.out.println();

                // TODO - dont work mabye fix later
                /*System.out.println(dialog.zipcodeList());
                printAllZipcodes();*/

                System.out.println();

                System.out.print(dialog.insertZipcode());
                int zipcode = scanner.nextInt();

                System.out.println(BrugerFacade.registrerBruger(new Bruger(name, adresse, zipcode)));

                continueMenu();
                break;

            case 9:
                // GET ALL AUTHORS
                clearScreen();
                printAllAuthors();
                continueMenu();

                break;

            case 10:
                // GET AUTHOR BY ID
                clearScreen();
                printAllAuthors();
                System.out.println();

                int authorID = 0;
                System.out.println(dialog.insertID());
                authorID = scanner.nextInt();
                System.out.println(ForfatterFacade.hentForfatterByID(authorID));

                continueMenu();
                break;

            case 11: // TODO not done
                // DELETE AUTHOR BY ID
                clearScreen();
                printAllAuthors();
                System.out.println();

                int authorDeleteID = 0;
                System.out.println(dialog.insertID());
                authorDeleteID = scanner.nextInt();

                // TODO - dont work rn has to make a method in ForfatterFacade and ForfatterMapper
                // TODO ^^ that deletes an author.

                // System.out.println(ForfatterFacade.sletForfatter(authorDeleteID));

                continueMenu();

                break;

            case 12:
                // REGISTER AUTHOR
                clearScreen();
                System.out.print(dialog.insertName());
                String authorName = scanner.next();
                System.out.println();

                System.out.println(ForfatterFacade.registrerForfatter(new Forfatter(authorName)));

                break;

            case 13:
                // GET ALL ZIPCODES
                clearScreen();
                printAllZipcodes();
                continueMenu();

                break;

            case 14:
                // GET ZIPCODE BY ID
                clearScreen();
                printAllZipcodes();
                System.out.println();

                int zipcodeID = 0;
                System.out.print(dialog.insertID());
                zipcodeID = scanner.nextInt();
                System.out.println(PostnrFacade.hentPostnrByID(zipcodeID));

                continueMenu();
                break;

            case 15:
                // DELETE ZIPCODE BY ID
                clearScreen();
                printAllZipcodes();
                System.out.println();

                int zipcodeDeleteID = 0;
                System.out.print(dialog.insertID());
                zipcodeDeleteID = scanner.nextInt();

                System.out.println(PostnrFacade.deletePostnr(zipcodeDeleteID));

                continueMenu();

                break;

            case 16:
                // REGISTER ZIPCODE
                clearScreen();
                System.out.print(dialog.insertZipcode());
                int newZipcode = scanner.nextInt();
                System.out.println();

                System.out.print(dialog.insertCity());
                String city = scanner.next();
                System.out.println();

                System.out.println(PostnrFacade.registrerPostnr(new Postnr(newZipcode, city)));

                continueMenu();
                break;

            case 17:
                // GET ALL LOANS
                clearScreen();
                printAllLoans();
                continueMenu();

                break;

            case 18:
                // GET LOAN BY ID
                clearScreen();
                printAllLoans();
                System.out.println();

                int loanID = 0;
                System.out.print(dialog.insertID());
                loanID = scanner.nextInt();
                System.out.println(UdlånFacade.hentUdlånByID(loanID));

                continueMenu();
                break;

            case 19:
                // DELETE LOAN BY ID
                clearScreen();
                printAllLoans();
                System.out.println();

                int loanDeleteID = 0;
                System.out.print(dialog.insertID());
                loanDeleteID = scanner.nextInt();

                System.out.println(UdlånFacade.seltUdlån(loanDeleteID));

                continueMenu();

                break;

            case 20:
                // REGISTER LOAN
                clearScreen();
                System.out.println(dialog.booksList());
                printAllBooks();

                System.out.println();
                System.out.println(dialog.usersList());
                printAllUsers();

                System.out.println();
                System.out.print(dialog.insertBookId());
                int booksID2 = scanner.nextInt();
                System.out.println();
                System.out.print(dialog.insertUserID());
                int userID2 = scanner.nextInt();


                System.out.println(UdlånFacade.registrerUdlån(new Udlån(booksID2, userID2)));

                continueMenu();
                break;


            case 21:
                exit();
                break;

            default:
                System.out.println(dialog.invalidChoice());
                clearScreen();
                printMenu();
                break;

        }

    }










    
    private void printAllLoans()
    {
        List<Udlån> udlånList = UdlånFacade.hentUdlån();
        for (Udlån udlån : udlånList)
        {
            System.out.println(udlån);
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

    private void printAllZipcodes()
    {
        List<Postnr> postnrList = PostnrFacade.hentPostnr();
        for (Postnr postnr : postnrList)
        {
            System.out.println(postnr);
        }
    }
}
