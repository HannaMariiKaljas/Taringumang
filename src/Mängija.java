public class Mängija {
    private String nimi;
    private Tabel tulemused = new Tabel();
    private int summa;
    private int viskeid = 0;

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
        viskeid++;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
