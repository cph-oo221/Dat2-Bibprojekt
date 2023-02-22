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
        return "Welcome!";
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
    public String languageDanish()
    {
        return "Danish";
    }

    @Override
    public String languageEnglish()
    {
        return "English";
    }

    @Override
    public String exit()
    {
        return "Exit";
    }
}
