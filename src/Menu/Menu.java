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
        printMainMenu();

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

        clearScreen();
    }



    private void printMainMenu()
    {
        System.out.println(dialog.welcome());
        dialog.menuOptions();
        System.out.print(dialog.userChoice());
        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                // GET ALL BOOKS
                // bookMenu();
                getAllBooks();

                break;

            case 2:
                // GET BOOK BY ID
                getBookByID();
                break;

            case 3:
                // DELETE BOOK BY ID
                deleteBookByID();

                break;

            case 4:
                // REGISTER BOOK
                registerBook();

                break;

            case 5:
                // GET ALL USERS
                getAllUsers();

                break;

            case 6:
                // GET USER BY ID
                getUserByID();
                break;

            case 7:
                // DELETE USER BY ID
                deleteUser();

                break;

            case 8:
                // REGISTER USER
                registerUser();
                break;

            case 9:
                // GET ALL AUTHORS
                getAllAuthors();
                break;

            case 10:
                // GET AUTHOR BY ID
                getAuthorByID();
                break;

            case 11:
                // DELETE AUTHOR BY ID
                deleteAuthor();

                break;

            case 12:
                // REGISTER AUTHOR
                registerAuthor();

                break;

            case 13:
                // GET ALL ZIPCODES
                getAllZipCodes();

                break;

            case 14:
                // GET ZIPCODE BY ID
                getZipCodeByID();

                break;

            case 15:
                // DELETE ZIPCODE BY ID
                deleteZipCodeByID();

                break;

            case 16:
                // REGISTER ZIPCODE
                registerZipCode();

                break;

            case 17:
                // GET ALL LOANS
                getAllLoans();

                break;

            case 18:
                // GET LOAN BY ID
                getLoanByID();

                break;

            case 19:
                // DELETE LOAN BY ID
                deleteLoan();

                break;

            case 20:
                // REGISTER LOAN
                registerLoan();

                break;


            case 21:
                exit();
                break;

            default:
                System.out.println(dialog.invalidChoice());
                clearScreen();
                printMainMenu();
                break;
        }
    }


    /*private void bookMenu()
    {
        dialog.menuOptionsBook();
        System.out.print(dialog.userChoice());
        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                // GET ALL BOOKS
                getAllBooks();

                break;

            case 2:
                // GET BOOK BY ID
                getBookByID();
                break;

            case 3:
                // DELETE BOOK BY ID
                deleteBookByID();

                break;

            case 4:
                // REGISTER BOOK
                registerBook();

                break;

            case 5:
                // back to main menu

                break;

            case 6:
                // EXIT
                exit();
                break;

            default:
                System.out.println(dialog.invalidChoice());
                clearScreen();
                bookMenu();
                break;
        }
    }*/




    private void registerLoan()
    {
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
    }

    private void deleteLoan()
    {
        clearScreen();
        printAllLoans();
        System.out.println();

        int loanDeleteID = 0;
        System.out.print(dialog.insertID());
        loanDeleteID = scanner.nextInt();

        System.out.println(UdlånFacade.seltUdlån(loanDeleteID));

        continueMenu();
    }

    private void getLoanByID()
    {
        clearScreen();
        printAllLoans();
        System.out.println();

        int loanID = 0;
        System.out.print(dialog.insertID());
        loanID = scanner.nextInt();
        System.out.println(UdlånFacade.hentUdlånByID(loanID));

        continueMenu();
    }

    private void getAllLoans()
    {
        clearScreen();
        printAllLoans();
        continueMenu();
    }

    private void registerZipCode()
    {
        clearScreen();
        System.out.print(dialog.insertZipcode());
        int newZipcode = scanner.nextInt();
        System.out.println();

        System.out.print(dialog.insertCity());
        String city = scanner.next();
        System.out.println();

        System.out.println(PostnrFacade.registrerPostnr(new Postnr(newZipcode, city)));

        continueMenu();
    }

    private void deleteZipCodeByID()
    {
        clearScreen();
        printAllZipcodes();
        System.out.println();

        int zipcodeDeleteID = 0;
        System.out.print(dialog.insertID());
        zipcodeDeleteID = scanner.nextInt();

        System.out.println(PostnrFacade.deletePostnr(zipcodeDeleteID));

        continueMenu();
    }

    // GET ALL BOOKS
    private void getAllBooks()
    {
        clearScreen();
        printAllBooks();
        continueMenu();
    }

    // GET BOOK BY ID
    private void getBookByID()
    {
        clearScreen();
        printAllBooks();
        System.out.println();

        int bookID = 0;
        System.out.println(dialog.insertID());
        bookID = scanner.nextInt();

        System.out.println(BogFacade.hentBogByID(bookID));

        continueMenu();
    }
    private void deleteBookByID()
    {
        clearScreen();
        printAllBooks();
        System.out.println();

        int bookDeleteID = 0;
        System.out.println(dialog.insertID());
        bookDeleteID = scanner.nextInt();

        System.out.println(BogFacade.sletBog(bookDeleteID));

        continueMenu();
    }

    private void registerBook()
    {
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
    }


    private void getAllUsers()
    {
        // GET ALL USERS
        clearScreen();
        printAllUsers();
        continueMenu();
    }

    private void getUserByID()
    {
        clearScreen();
        printAllUsers();
        System.out.println();

        int userID = 0;
        System.out.println(dialog.insertID());
        userID = scanner.nextInt();
        System.out.println(BrugerFacade.hentBrugerByID(userID));

        continueMenu();
    }

    private void deleteUser()
    {
        // DELETE USER BY ID
        clearScreen();
        printAllUsers();
        System.out.println();

        int userDeleteID = 0;
        System.out.println(dialog.insertID());
        userDeleteID = scanner.nextInt();

        System.out.println(BrugerFacade.seltBruger(userDeleteID));

        continueMenu();
    }

    private void registerUser()
    {
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
    }


    private void getAllAuthors()
    {
        // GET ALL AUTHORS
        clearScreen();
        printAllAuthors();
        continueMenu();
    }

    private void getAuthorByID()
    {
        clearScreen();
        printAllAuthors();
        System.out.println();

        int authorID = 0;
        System.out.println(dialog.insertID());
        authorID = scanner.nextInt();
        System.out.println(ForfatterFacade.hentForfatterByID(authorID));

        continueMenu();
    }

    private void deleteAuthor()
    {
        clearScreen();
        printAllAuthors();
        System.out.println();

        int authorDeleteID = 0;
        System.out.print(dialog.insertID());
        authorDeleteID = scanner.nextInt();

        System.out.println(ForfatterFacade.deleteForfatter(authorDeleteID));

        continueMenu();
    }

    private void registerAuthor()
    {
        clearScreen();
        System.out.print(dialog.insertName());
        String authorName = scanner.next();
        System.out.println();

        System.out.println(ForfatterFacade.registrerForfatter(new Forfatter(authorName)));
    }


    private void getAllZipCodes()
    {
        // GET ALL ZIPCODES
        clearScreen();
        printAllZipcodes();
        continueMenu();
    }

    private void getZipCodeByID()
    {
        clearScreen();
        printAllZipcodes();
        System.out.println();

        int zipcodeID = 0;
        System.out.print(dialog.insertID());
        zipcodeID = scanner.nextInt();
        System.out.println(PostnrFacade.hentPostnrByID(zipcodeID));

        continueMenu();
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
        printMainMenu();
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
