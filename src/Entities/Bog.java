package Entities;

public class Bog
{
    private int idbøger;
    private String titel;
    private int forfatter;

    public Bog(int idbøger, String titel, int forfatter)
    {
        this.idbøger = idbøger;
        this.titel = titel;
        this.forfatter = forfatter;
    }


    public int getIdbøger()
    {
        return idbøger;
    }

    public void setIdbøger(int idbøger)
    {
        this.idbøger = idbøger;
    }

    public String getTitel()
    {
        return titel;
    }

    public void setTitel(String titel)
    {
        this.titel = titel;
    }

    public int getForfatter()
    {
        return forfatter;
    }

    public void setForfatter(int forfatter)
    {
        this.forfatter = forfatter;
    }


    @Override
    public String toString()
    {
        return "Bog: " +
                "idbøger: " + idbøger +
                ", titel: " + titel  +
                ", forfatter: " + forfatter;
    }
}
