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
        brugerMapper.getBruger();
        System.out.println();
        System.out.println();
        System.out.println();
        BogMapper bogMapper = new BogMapper();
        bogMapper.getBogs();
        System.out.println();
        bogMapper.getForfatters();
    }

}