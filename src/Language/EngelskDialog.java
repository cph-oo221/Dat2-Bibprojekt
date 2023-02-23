package Language;

public class EngelskDialog extends Dialog
{
    @Override
    public String hello()
    {
        return "Hello";
    }

    @Override
    public String welcome()
    {
        return "Welcome to the library!";
    }

    @Override
    public String askAge()
    {
        return "How old are you?";
    }

    @Override
    public String changeLanguage()
    {
        return "Press y to change language";
    }

    @Override
    public String chooseLanguage()
    {
        return "Choose a language: ";
    }

    @Override
    public String userChoice()
    {
        return "Choice: ";
    }

    @Override
    public String languageOpsDanish()
    {
        return "Danish";
    }

    @Override
    public String languageOpsEnglish()
    {
        return "English";
    }

    @Override
    public String exit()
    {
        return "Exit";
    }

    @Override
    public String exitMessage()
    {
        return "The program is shutting down...";
    }

    @Override
    public void menuOptions()
    {
        System.out.println("1. Get all books");
        System.out.println("2. Get book by ID");
        System.out.println("3. Delete book by ID");
        System.out.println("4. Register book");

        System.out.println("5. Get all Users");
        System.out.println("6. Get User by ID");
        System.out.println("7. Delete User by ID");
        System.out.println("8. Register User");

        System.out.println("9. Get all Authors");
        System.out.println("10. Get Author by ID");
        System.out.println("11. Delete Author by ID");
        System.out.println("12. Register Author");

        System.out.println("13. Get all Zipcodes");
        System.out.println("14. Get Zipcode by ID");
        System.out.println("15. Delete Zipcode by ID");
        System.out.println("16. Register Zipcode");

        System.out.println("17. Get all Loans");
        System.out.println("18. Get Loan by ID");
        System.out.println("19. Delete Loan by ID");
        System.out.println("20. Register Loan");

        System.out.println("21. Exit");
    }

    @Override
    public String menuContinue()
    {
        return "Press enter to continue";
    }

    @Override
    public String invalidChoice()
    {
        return "Invalid choice";
    }

    @Override
    public String insertID()
    {
        return "Insert ID: ";
    }

    @Override
    public String insertBookId()
    {
        return "Insert book ID: ";
    }

    @Override
    public String insertUserID()
    {
        return "Insert user ID: ";
    }

    @Override
    public String insertTitle()
    {
        return "Insert title: ";
    }

    @Override
    public String insertAuthor()
    {
        return "Insert author ID: ";
    }

    @Override
    public String authorList()
    {
        return "Author list: ";
    }

    @Override
    public String insertName()
    {
        return "Insert name: ";
    }

    @Override
    public String insertAdresse()
    {
        return "Insert address: ";
    }

    @Override
    public String insertZipcode()
    {
        return "Insert zipcode: ";
    }

    @Override
    public String zipcodeList()
    {
        return "Zipcode list: ";
    }

    @Override
    public String insertCity()
    {
        return "Insert city: ";
    }

    @Override
    public String booksList()
    {
        return "Book list: ";
    }

    @Override
    public String usersList()
    {
        return "User list: ";
    }
}
