public class Mängija {
    private String nimi;
    private Tabel tulemused = new Tabel();
    private int summa;
    private int vise = 1;

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

    public int getVise(){
        return vise;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
