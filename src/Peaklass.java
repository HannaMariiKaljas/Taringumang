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

        System.out.println(aktiivne.getNimi() + " kord");

        while(true){
            täringud.veeretaKõik();
            if (aktiivne.getVise() == 1){
                while(true){
                    boolean kontroll = false;
                    for (int i = 1; i < 7; i++){
                        if (Collections.frequency(Meetodid.teisenda(täringud.getTäringud()),i) >= 3){
                            kontroll = true;
                            break;
                        }
                    }
                    if (kontroll){
                        break;
                    }
                    täringud.veeretaKõik();
                }
            }
            while(true){
                täringud.väljasta();
                aktiivne.lisaVise();
                System.out.println("Vali täringud, mida uuesti veeretada: ");
                String sisend = sc.nextLine();
                if (!sisend.isEmpty()){
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
            while(true){
                aktiivne.getTabel().väljasta();
                täringud.väljasta();
                System.out.println("Vali milliseid täringuid tahad tabelisse panna.");
                String sisend = sc.nextLine();
                if (!sisend.isEmpty()){
                    String[] sõned = sisend.split(" ");
                    int[] valik = new int[sõned.length];
                    for (int i = 0; i < sõned.length; i++) {
                        valik[i] = Integer.parseInt(sõned[i]);
                    }
                    System.out.println("Vali kuhu tabelisse täringud paned.");
                    sisend = sc.nextLine();
                    if (!sisend.isEmpty()){
                        String[] pos = sisend.split(" ");
                        int rida = Integer.parseInt(pos[0]);
                        System.out.println(rida);
                        int veerg = Integer.parseInt(pos[1]);
                        System.out.println(aktiivne.getTabel().valiMeetod(rida-1,täringud.getValikuVäärtused(valik)));
                        if (veerg == 1){
                            if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9998) {
                                System.out.println("Sisesta korrektne reanumber.");
                            } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) ==9990){
                                System.out.println("Sa ei valinud ühtegi täringut");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9991){
                                System.out.println("ei saa tabelisse panna");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9992){
                                System.out.println("valisid liiga palju täringuid");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9993){
                                System.out.println("valisid liiga vähe täringuid");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9994){
                                System.out.println("valiku seas pole josplit");
                            }else{
                                aktiivne.getTabel().setEsimene(rida-1, aktiivne.getTabel().valiMeetod(rida-1,täringud.getValikuVäärtused(valik)));
                                aktiivne.getTabel().väljasta();
                                if (aktiivne.equals(m1)){
                                    if (m2.getVise() != 60){
                                        aktiivne = m2;
                                    }
                                }else{
                                    if (m1.getVise() != 60){
                                        aktiivne = m1;
                                    }
                                }
                                System.out.println("Tehtud visete arv: " + aktiivne.getVise()+"\n"+aktiivne.getNimi() + " kord");
                                break;
                            }
                        }else if (veerg == 2){
                            if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9998) {
                                System.out.println("Sisesta korrektne reanumber.");
                            } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) ==9990){
                                System.out.println("Sa ei valinud ühtegi täringut");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9991){
                                System.out.println("ei saa tabelisse panna");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9992){
                                System.out.println("valisid liiga palju täringuid");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9993){
                                System.out.println("valisid liiga vähe täringuid");
                            }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9994){
                                System.out.println("valiku seas pole josplit");
                            }else{
                                aktiivne.getTabel().setTeine(rida-1,aktiivne.getTabel().valiMeetod(rida-1,täringud.getValikuVäärtused(valik)));
                                aktiivne.getTabel().väljasta();
                                if (aktiivne.equals(m1)){
                                    if (m2.getVise() != 60){
                                        aktiivne = m2;
                                    }
                                }else{
                                    if (m1.getVise() != 60){
                                        aktiivne = m1;
                                    }
                                }
                                System.out.println("Tehtud visete arv: " + aktiivne.getVise()+"\n"+aktiivne.getNimi() + " kord");
                                break;
                            }
                        }else{
                            System.out.println("Sisesta korrektne veerunumber.");
                        }
                    }
                }else{
                    System.out.println("Sisend ei saa olla tühi.");
                }
            }
            if (m1.getVise() == 60 && m2.getVise() == 60){
                System.out.println(m1.getNimi() + " sai " + m1.getTabel().üldineSumma() + " ja " + m2.getNimi() + " sai " + m2.getTabel().üldineSumma() + " punkti.");
                if (m1.getTabel().üldineSumma() > m2.getTabel().üldineSumma()){
                    System.out.println(m1.getNimi() + " võitis!");
                }else if (m1.getTabel().üldineSumma() < m2.getTabel().üldineSumma()){
                    System.out.println(m2.getNimi() + " võitis!");
                }else{
                    System.out.println("Viik!");
                }
                break;
            }
        }
    }
}
