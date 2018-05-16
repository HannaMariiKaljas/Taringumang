import java.io.Serializable;

public class Mängija implements Serializable{
    private String nimi;
    private Tabel tulemused = new Tabel();
    private int summa;
    private int vise = 0;

    public Mängija(String nimi) {
        this.nimi = nimi;
    }

    public void setSumma(int summa){
        this.summa = summa;
    }

    public String getNimi(){
        return nimi;
    }

    public void lisaVise(){
        vise++;
    }

    public Tabel getTabel(){
        return tulemused;
    }
    public int getVise(){
        return vise;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
