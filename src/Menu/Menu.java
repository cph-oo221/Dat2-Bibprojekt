package Menu;

import Language.DanskDialog;
import Language.Dialog;
import Language.EngelskDialog;

import java.util.Scanner;

public class Menu
{
    private Scanner scanner = new Scanner(System.in);
    private Dialog dialog;

    public void run()
    {
        dialog = new EngelskDialog();
        selectLanguage();
    }

    private void selectLanguage()
    {
        System.out.println(dialog.chooseLanguage());
        System.out.println("1. " + dialog.languageDanish());
        System.out.println("2. " + dialog.languageEnglish());
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
                System.exit(0);
                break;
            default:
                System.out.println("Ugyldigt valg");
                break;
        }
    }




    // TODO - I dont know wtf this dogshit is vvv
    private void printMenu()
    {
        System.out.println("1. Hent alle bøger");
        System.out.println("2. Hent alle brugere");
        System.out.println("3. Hent alle forfattere");
        System.out.println("4. Hent alle postnumre");
        System.out.println("5. Hent alle udlån");
        System.out.println("6. Hent alle udlån for en bruger");
        System.out.println("7. Hent alle udlån for en bog");
        System.out.println("8. Hent alle udlån for en forfatter");
        System.out.println("9. Hent alle udlån for et postnummer");
        System.out.println("10. Hent alle udlån for en forfatter og et postnummer");
        System.out.println("11. Hent alle udlån for en forfatter og en bog");
        System.out.println("12. Hent alle udlån for en forfatter og en bruger");
        System.out.println("13. Hent alle udlån for en forfatter og et postnummer");
        System.out.println("14. Hent alle udlån for en bog og en bruger");
        System.out.println("15. Hent alle udlån for en bog og et postnummer");
        System.out.println("16. Hent alle udlån for en bruger og et postnummer");
        System.out.println("17. Hent alle udlån for en forfatter, en bog og en bruger");
        System.out.println("18. Hent alle udlån for en forfatter, en bog og et postnummer");
        System.out.println("19. Hent alle udlån for en forfatter, en bruger og et postnummer");
        System.out.println("20. Hent alle udlån for en bog, en bruger og et postnummer");
        System.out.println("21. Hent alle udlån for en forfatter, en bog, en bruger og et postnummer");
        System.out.println("22. Hent alle udlån for en forfatter, en bog, en bruger og et postnummer");
        System.out.println("23. Hent alle udlån for en forfatter, en bog, en bruger og et postnummer");
    }
}
