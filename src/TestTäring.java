public class TestTäring {
    public static void main(String[] args) {
        Tabel tabel = new Tabel();
        Täringud t = new Täringud();
        t.veeretaKõik();
        tabel.väljasta();
        t.väljasta();
        int[] valik = {1,2,3};
        t.veeretaValik(valik);
        t.väljasta();
    }

}
