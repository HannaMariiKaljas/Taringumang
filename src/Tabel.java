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
        }else {
            summa+=50;
        }
        return summa;
    }
    public int alumineSumma(int[] veerg){
        int summa = 0;
        for (int i = 6; i < 14; i++) {
            summa += veerg[i];
        }
        return summa;
    }

    public int josplidSumma( int[] josplid){
        int summa=0;
        for (int i = 0; i < 6; i++) {
            summa+=josplid[i];
        }
        return summa;
    }

    public int üldineSumma (){
        return alumineSumma(esimene)+alumineSumma(teine)+ülemineSumma(esimene)+ülemineSumma(teine)+josplidSumma(jospel);
    }
}