import java.util.Arrays;

public class Tabel {
    private int[] esimene = new int[14];
    private int[] teine = new int[14];
    private int[] jospel = new int[6];
    private String[] valikud = {"Ühed", "Kahed", "Kolmed", "Neljad", "Viied", "Kuued", "Paar", "Kolmik", "Nelik", "Kaks+Kaks", "Maja", "Väike rida", "Suur rida",
            "Summa", "Ühe jospel", "Kahe jospel","Kolme jospel", "Nelja jospel", "Viie jospel", "Kuue jospel"};

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

    public Tabel(){
        for (int i = 0; i < 6; i++){
            esimene[i] = -(i+1)*3;
            teine[i] = -(i+1)*3;
        }
        for (int i = 6; i < 9; i++){
            esimene[i] = -(i-4)*6;
            teine[i] = -(i-4)*6;
        }
        esimene[9] = -(2*6+2*5);
        teine[9] = -(2*6+2*5);
        esimene[10] = -(3*6+2*5);
        teine[10] = -(3*6+2*5);
        esimene[11] = -(1+2+3+4+5);
        teine[11] = -(1+2+3+4+5);
        esimene[12] = -(2+3+4+5+6);
        teine[12] = -(2+3+4+5+6);
        esimene[13] = -5*6;
        teine[13] = -5*6;
        for (int i = 0; i<6;i++){
            jospel[i] = -50;
        }
    }

    public void setEsimene(int i, int tulemus){
        esimene[i] = tulemus;
    }

    public void setTeine(int i, int tulemus){
        teine[i] = tulemus;
    }

    public void väljasta(){
        System.out.format("%22d%6d",1,2);
        System.out.println(" ");
        for (int i = 0; i < 14; i++) {
            System.out.format("%-2s%-12s%6d%6d", i+1  + "\t",valikud[i], esimene[i], teine[i]);
            System.out.println("");
            if (i == 5){
                System.out.println("");
            }
        }
        System.out.println("");
        for (int i = 0; i < 6; i++){
            System.out.format("%-2s%-12s%12d", i+14 + "\t",valikud[i+14],jospel[i]);
            System.out.println("");
        }
        System.out.println("");
    }
}
