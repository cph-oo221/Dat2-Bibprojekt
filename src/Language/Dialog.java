package Language;

public abstract class Dialog
{
    public abstract String hello();

    public abstract String welcome();

    public abstract String askAge();

    public abstract String changeLanguage();

    public abstract String chooseLanguage();
    
    public abstract String userChoice();
    
    public abstract String languageOpsDanish();
    public abstract String languageOpsEnglish();
    public abstract String exit();
    public abstract String exitMessage();

    public abstract void menuOptions();

    public abstract void menuOptionsBook();
    public abstract void menuOptionsUser();
    public abstract void menuOptionsLoan();
    public abstract void menuOptionsAuthor();
    public abstract void menuOptionsZipcode();


    public abstract String menuContinue();

    public abstract String invalidChoice();
    public abstract String insertID();

    public abstract String insertBookId();
    public abstract String insertUserID();

    public abstract String insertTitle();
    public abstract String insertAuthor();

    public abstract String authorList();

    public abstract String insertName();

    public abstract String insertAdresse();

    public abstract String insertZipcode();

    public abstract String zipcodeList();

    public abstract String insertCity();

    public abstract String booksList();

    public abstract String usersList();
}
