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
    
    public void setJospel(int i, int tulemus){
        jospel[i] = tulemus;
    }
    
    public void väljasta(){
        System.out.format("%22d%6d",1,2);
        System.out.println(" ");
        String üks;
        String kaks;
        for (int i = 0; i < 14; i++) {
            if (esimene[i] == 0){
                üks = "X";
            }else{
                üks = Integer.toString(esimene[i]);
            }
            if (teine[i] == 0){
                kaks = "X";
            }else{
                kaks = Integer.toString(teine[i]);
            }
            System.out.format("%-2s%-12s%6s%6s", i+1  + "\t",valikud[i], üks, kaks);
            System.out.println("");
            if (i == 5){
                System.out.println("");
            }
        }
        System.out.println("");
        for (int i = 0; i < 6; i++){
            System.out.format("%-2s%-12s%12s", i+15 + "\t",valikud[i+14],jospel[i]);
            System.out.println("");
        }
        System.out.println("");
    }

    public int valiMeetod(int i, int[] valik){
        switch(i){
            case 0: return Meetodid.ühed(Meetodid.teisenda(valik));
            case 1: return Meetodid.kahed(Meetodid.teisenda(valik));
            case 2: return Meetodid.kolmed(Meetodid.teisenda(valik));
            case 3: return Meetodid.neljad(Meetodid.teisenda(valik));
            case 4: return Meetodid.viied(Meetodid.teisenda(valik));
            case 5: return Meetodid.kuued(Meetodid.teisenda(valik));
            case 6: return Meetodid.paar(Meetodid.teisenda(valik));
            case 7: return Meetodid.kolmik(Meetodid.teisenda(valik));
            case 8: return Meetodid.nelik(Meetodid.teisenda(valik));
            case 9: return Meetodid.kaksPlussKaks(Meetodid.teisenda(valik));
            case 10: return Meetodid.maja(Meetodid.teisenda(valik));
            case 11: return Meetodid.väikeRida(Meetodid.teisenda(valik));
            case 12: return Meetodid.suurRida(Meetodid.teisenda(valik));
            case 13: return Meetodid.summa(Meetodid.teisenda(valik));
            case 14: return Meetodid.jospel(Meetodid.teisenda(valik),1);
            case 15: return Meetodid.jospel(Meetodid.teisenda(valik),2);
            case 16: return Meetodid.jospel(Meetodid.teisenda(valik),3);
            case 17: return Meetodid.jospel(Meetodid.teisenda(valik),4);
            case 18: return Meetodid.jospel(Meetodid.teisenda(valik),5);
            case 19: return Meetodid.jospel(Meetodid.teisenda(valik),6);
            default: return 9998;
        }
    }
}
