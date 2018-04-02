public class Tabel {
    private int[] esimene = new int[14];
    private int[] teine = new int[14];
    private int[] jospel = new int[6];

    public int ülemineSumma(int[] veerg){
        int summa = 0;
        for (int i = 0; i < 6; i++) {
            summa += veerg[i];
        }
        if (summa <= 63){
            summa -= 50;
        }
        return summa;
    }
}
