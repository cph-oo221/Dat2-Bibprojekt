import Mapper.BogMapper;
import Mapper.BrugerMapper;
import Mapper.RegisterBogMapper;
import Mapper.RegisterBrugerMapper;

public class Main
{
    public static void main(String[] args)
    {
        /*System.out.println(getString("Hvad er dit navn?"));

        System.out.println(getInt("Angiv venligst din skostørrelse?"));

        System.out.println(getInt("Angiv venligst din højde?"));*/

        /*while (true)
        {
            switch (getString("angiv dit ønske ?"))
            {
                case "lån bog":
                    System.out.println("du ønsker at låne en bog");
                    break;
                case "stop":
                    break;
            }
            if(getString("q for quit").equalsIgnoreCase("q"))
                break;
        }*/

        BrugerMapper brugerMapper = new BrugerMapper();
        BogMapper bogMapper = new BogMapper();
        RegisterBogMapper registerBogMapper = new RegisterBogMapper();
        RegisterBrugerMapper registerBrugerMapper = new RegisterBrugerMapper();


        /*System.out.println("få alle bruger");
        brugerMapper.getBruger();
        System.out.println("");
        System.out.println("Få alle bøger: ");
        bogMapper.getBogs();
        System.out.println(" ");
        System.out.println("Få alle forfatter: ");
        bogMapper.getAllAuthors();
        System.out.println(" ");
        System.out.println("Få bruger på id'et");
        System.out.println(brugerMapper.getBrugerByID(1));
        System.out.println(" ");
        System.out.println("Alle post nummer: ");
        brugerMapper.getAllPostnr();
        System.out.println(" ");
        System.out.println("Få post nummer på id");
        System.out.println(brugerMapper.getPostnrByID(2880));

        System.out.println("Get book by id: ");
        System.out.println(bogMapper.getBookByID(1));


        System.out.println("Get author by id: ");
        System.out.println(bogMapper.getAuthorsByID(1));

        System.out.println("Get all udlån");
        bogMapper.getAllUdlån();

        System.out.println();
        System.out.println("Get udlån by id");
        System.out.println(bogMapper.getUdlånByID(2));


        System.out.println("register a book");
        registerBogMapper.registerBook("Harry Potter and the Goblet of Fire", 1);

        System.out.println("register An Author");
        registerBogMapper.registerAnAuthors("Helle Helle");

        System.out.println("Register a zip code");
        registerBrugerMapper.registerZipCode(2000, "Frederiksberg");

        registerBrugerMapper.registerBruger("Annelise", "Finsensvej 12", 2000);*/

        // bogMapper.deleteBook(5);

        // brugerMapper.deleteBruger(7);

        // registerBrugerMapper.registerZipCode(2900, "Hellerup");


        // brugerMapper.deleteZipCode(2900);

    }

}