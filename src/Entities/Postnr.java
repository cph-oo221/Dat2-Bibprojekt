package Entities;

public class Postnr
{
    private int postnr;

    private String bynavn;

    public Postnr(int postnr, String bynavn)
    {
        this.postnr = postnr;
        this.bynavn = bynavn;
    }

    public int getPostnr()
    {
        return postnr;
    }

    public void setPostnr(int postnr)
    {
        this.postnr = postnr;
    }

    public String getBynavn()
    {
        return bynavn;
    }

    public void setBynavn(String bynavn)
    {
        this.bynavn = bynavn;
    }

    @Override
    public String toString()
    {
        return "Postnr: " +
                "postnr: " + postnr +
                ", bynavn: " + bynavn;
    }
}
