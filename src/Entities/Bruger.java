package Entities;

public class Bruger
{
    private int idlåner;
    private String navn;
    private String adresse;
    private int postnr;

    public Bruger(int idlåner, String navn, String adresse, int postnr)
    {
        this.idlåner = idlåner;
        this.navn = navn;
        this.adresse = adresse;
        this.postnr = postnr;
    }


    // CONSTRUCTOR WITHOUT IDLÅNER
    /*public Bruger(String navn, String adresse, int postnr)
    {
        this.navn = navn;
        this.adresse = adresse;
        this.postnr = postnr;
    }*/

    public int getIdlåner()
    {
        return idlåner;
    }

    public void setIdlåner(int idlåner)
    {
        this.idlåner = idlåner;
    }

    public String getNavn()
    {
        return navn;
    }

    public void setNavn(String navn)
    {
        this.navn = navn;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public int getPostnr()
    {
        return postnr;
    }

    public void setPostnr(int postnr)
    {
        this.postnr = postnr;
    }

    @Override
    public String toString()
    {
        return "Bruger: " +
                "idlåner: " + idlåner +
                ", navn: " + navn  +
                ", adresse: " + adresse +
                ", postnr: " + postnr;
    }
}
