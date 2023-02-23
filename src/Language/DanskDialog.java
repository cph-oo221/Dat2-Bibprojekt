package Language;

public class DanskDialog extends Dialog
{
    @Override
    public String hello()
    {
        return "Hej";
    }

    @Override
    public String welcome()
    {
        return "Velkommen til bibliotek!";
    }

    @Override
    public String askAge()
    {
        return "Hvor gammel er du?";
    }

    @Override
    public String changeLanguage()
    {
        return "Tryk y for at skifte sprog";
    }

    @Override
    public String chooseLanguage()
    {
        return "Vælg et sprog: ";
    }

    @Override
    public String userChoice()
    {
        return "Valg: ";
    }

    @Override
    public String languageOpsDanish()
    {
        return "Dansk";
    }

    @Override
    public String languageOpsEnglish()
    {
        return "Engelsk";
    }

    @Override
    public String exit()
    {
        return "Afslut";
    }

    @Override
    public String exitMessage()
    {
        return "Programmet afsluttes...";
    }

    @Override
    public void menuOptions()
    {
        System.out.println("1. Hent alle bøger");
        System.out.println("2. Hent bog på ID");
        System.out.println("3. Slet bog på ID");
        System.out.println("4. Opret bog");

        System.out.println("5. Hent alle brugere");
        System.out.println("6. Hent bruger på ID");
        System.out.println("7. Slet bruger på ID");
        System.out.println("8. Opret bruger");

        System.out.println("9. Hent alle forfattere");
        System.out.println("10. Hent forfatter på ID");
        System.out.println("11. Slet forfatter på ID");
        System.out.println("12. Opret forfatter");

        System.out.println("13. Hent alle postnumre");
        System.out.println("14. Hent postnummer på ID");
        System.out.println("15. Slet postnummer på ID");
        System.out.println("16. Opret postnummer");

        System.out.println("17. Hent alle lån");
        System.out.println("18. Hent lån på ID");
        System.out.println("19. Slet lån på ID");
        System.out.println("20. Opret lån");


        System.out.println("21. Afslut");
    }

    @Override
    public String menuContinue()
    {
        return "Tryk enter for at fortsætte";
    }

    @Override
    public String invalidChoice()
    {
        return "Ugyldigt valg";
    }

    @Override
    public String insertID()
    {
        return "Indtast ID: ";
    }

    @Override
    public String insertBookId()
    {
        return "Indtast bog ID: ";
    }

    @Override
    public String insertUserID()
    {
        return "Indtast bruger ID: ";
    }

    @Override
    public String insertTitle()
    {
        return "Indtast titel: ";
    }

    @Override
    public String insertAuthor()
    {
        return "Indtast forfatter Id: ";
    }

    @Override
    public String authorList()
    {
        return "Forfatter liste: ";
    }

    @Override
    public String insertName()
    {
        return "Indtast navn: ";
    }

    @Override
    public String insertAdresse()
    {
        return "Indtast adresse: ";
    }

    @Override
    public String insertZipcode()
    {
        return "Indtast postnummer: ";
    }

    @Override
    public String zipcodeList()
    {
        return "Postnummer liste: ";
    }

    @Override
    public String insertCity()
    {
        return "Indtast by: ";
    }

    @Override
    public String booksList()
    {
        return "Bog liste: ";
    }

    @Override
    public String usersList()
    {
        return "Bruger liste: ";
    }
}
