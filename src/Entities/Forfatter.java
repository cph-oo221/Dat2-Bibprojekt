package Entities;

public class Forfatter
{
    private int idforfatter;

    private String forfatter;

    public Forfatter(int idforfatter, String forfatter)
    {
        this.idforfatter = idforfatter;
        this.forfatter = forfatter;
    }

    // CONSTRUCTOR WITHOUT IDFORFATTER
    public Forfatter(String forfatter)
    {
        this.forfatter = forfatter;
    }

    public int getIdforfatter()
    {
        return idforfatter;
    }

    public void setIdforfatter(int idforfatter)
    {
        this.idforfatter = idforfatter;
    }

    public String getForfatter()
    {
        return forfatter;
    }

    public void setForfatter(String forfatter)
    {
        this.forfatter = forfatter;
    }

    @Override
    public String toString()
    {
        return "Forfatter: " +
                "idforfatter: " + idforfatter +
                ", forfatter: " + forfatter;
    }
}
