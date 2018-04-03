import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sisesta esimese mängija nimi: ");
        Mängija m1 = new Mängija(sc.nextLine());
        System.out.println("Sisesta teise mängija nimi: ");
        Mängija m2 = new Mängija(sc.nextLine());
        Mängija aktiivne = m1;
        Täringud täringud = new Täringud();
        täringud.veeretaKõik();

        while(true){
            if (aktiivne.getVise() == 1){
                int sagedus = 0;

                for (int i = 1; i < 7; i++){
                    if (Collections.frequency(Meetodid.valik(täringud),i) >= 3){
                        break;
                    }else{
                        täringud.veeretaKõik();
                    }
                }
            }
            while(true){
                täringud.väljasta();
                System.out.println("Vali täringud, mida uuesti veeretada: ");
                String sisend = sc.nextLine();
                if (sisend.length() > 1){
                    String[] sõned = sisend.split(" ");
                    int[] valik = new int[sõned.length];
                    for (int i = 0; i < sõned.length; i++) {
                        valik[i] = Integer.parseInt(sõned[i]);
                    }
                    täringud.veeretaValik(valik);
                    aktiivne.lisaVise();
                }else{
                    break;
                }
            }
            System.out.println(m1.getVise() + " " + m2.getVise());
        }
    }
}
