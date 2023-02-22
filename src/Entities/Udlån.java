package Entities;

public class Udlån
{
    private int idUdlån;
    private int idBøger;
    private int idLåner;


    public Udlån(int idUdlån, int idBøger, int idLåner)
    {
        this.idUdlån = idUdlån;
        this.idBøger = idBøger;
        this.idLåner = idLåner;
    }

    public Udlån(int idBøger, int idLåner)
    {
        this.idBøger = idBøger;
        this.idLåner = idLåner;
    }


    public int getIdUdlån()
    {
        return idUdlån;
    }

    public void setIdUdlån(int idUdlån)
    {
        this.idUdlån = idUdlån;
    }

    public int getIdBøger()
    {
        return idBøger;
    }

    public void setIdBøger(int idBøger)
    {
        this.idBøger = idBøger;
    }

    public int getIdLåner()
    {
        return idLåner;
    }

    public void setIdLåner(int idLåner)
    {
        this.idLåner = idLåner;
    }

    @Override
    public String toString()
    {
        return "Udlån: " +
                "idUdlån: " + idUdlån +
                ", idBøger: " + idBøger +
                ", idLåner: " + idLåner;
    }
}
