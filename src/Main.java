import Mapper.BogMapper;
import Mapper.BrugerMapper;

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
        System.out.println(brugerMapper.getPostnrByID(2880));*/

        System.out.println("Get book by id: ");
        System.out.println(bogMapper.getBookByID(1));


        System.out.println("Get author by id: ");
        System.out.println(bogMapper.getAuthorsByID(1));

        System.out.println("Get all udlån");
        bogMapper.getAllUdlån();

        System.out.println();
        System.out.println("Get udlån by id");
        System.out.println(bogMapper.getUdlånByID(2));
    }

}