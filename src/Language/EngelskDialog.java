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
}
