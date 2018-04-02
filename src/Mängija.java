public class Mängija {
    private String nimi;
    private Tabel tulemused = new Tabel();
    private int summa;

    public Mängija(String nimi) {
        this.nimi = nimi;
    }

    public void setSumma(int summa){
        this.summa = summa;
    }

    public String getNimi(){
        return nimi;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
