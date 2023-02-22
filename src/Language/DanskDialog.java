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
        return "Velkommen!";
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
    public String languageDanish()
    {
        return "Dansk";
    }

    @Override
    public String languageEnglish()
    {
        return "Engelsk";
    }

    @Override
    public String exit()
    {
        return "Afslut";
    }
}
