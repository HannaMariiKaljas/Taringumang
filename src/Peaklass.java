import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.println("Kas soovid [J]ätkata eelmist mängu või [A]lustada uut?");
        Scanner sc = new Scanner(System.in);
        Mängija m1;
        Mängija m2;
        if(sc.nextLine().equals("J")){
            try{
                FileInputStream fin = new FileInputStream("mänguseis.ser");
                ObjectInputStream oin = new ObjectInputStream(fin);
                m1 = (Mängija) oin.readObject();
                m2 = (Mängija) oin.readObject();
            }catch (FileNotFoundException e){
                System.out.println("Eelmist mängu pole salvestatud. Alustame selle asemel uut.");
                System.out.println("Sisesta esimese mängija nimi: ");
                m1 = new Mängija(sc.nextLine());
                System.out.println("Sisesta teise mängija nimi: ");
                m2 = new Mängija(sc.nextLine());
            }
        }else {
            System.out.println("Sisesta esimese mängija nimi: ");
            m1 = new Mängija(sc.nextLine());
            System.out.println("Sisesta teise mängija nimi: ");
            m2 = new Mängija(sc.nextLine());
        }
        Täringud täringud = new Täringud();
        Mängija aktiivne = m1; //alustab mängija 1

        while(true){
            FileOutputStream f = new FileOutputStream(new File("mänguseis.ser"),false);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(aktiivne);
            if (aktiivne.equals(m1)){
                o.writeObject(m2);
            }else{
                o.writeObject(m1);
            }
            täringud.veeretaKõik();
            aktiivne.lisaVise();
            aktiivne.getTabel().väljasta();
            System.out.println("\n" + aktiivne.getNimi() + " kord! Tehtud visete arv: " + aktiivne.getVise() + "\n");
            if (aktiivne.getVise() == 1){ // viskeid hakatakse alles siis lugema, kui täringute seas on kolm ühesugust
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
            while(true){ // täringute uuesti veeretamine
                if (aktiivne.getVise() != 60){
                    täringud.väljasta();
                    System.out.println("Vali täringud, mida uuesti veeretada: ");
                    String sisend = sc.nextLine();
                    if (!sisend.isEmpty()){
                        try{
                            String[] sõned = sisend.split(" ");

                            int[] valik = new int[sõned.length];
                            for (int i = 0; i < sõned.length; i++) {
                                valik[i] = Integer.parseInt(sõned[i]);
                            }
                            täringud.veeretaValik(valik);
                            aktiivne.lisaVise();
                        }catch(NumberFormatException e){
                            System.out.println("Vale sisend." + "\n");
                        }

                    }else{
                        break;
                    }
                }else{
                    break;
                }

            }
            while(true){ // tulemuse tabelisse panemine
                aktiivne.getTabel().väljasta();
                täringud.väljasta();
                System.out.println("Vali milliseid täringuid tahad tabelisse panna.");
                String sisend = sc.nextLine(); // mängija valib täringud indeksite järgi
                if (!sisend.isEmpty()){
                    String[] sõned = sisend.split(" ");
                    int[] valik = new int[sõned.length];
                    try{
                        for (int i = 0; i < sõned.length; i++) {
                            valik[i] = Integer.parseInt(sõned[i]);
                        }
                        System.out.println("Vali kuhu tabelisse täringud paned.");
                        sisend = sc.nextLine();
                        if (!sisend.isEmpty()){
                            String[] pos = sisend.split(" ");
                            try{
                                int rida = Integer.parseInt(pos[0]);
                                int veerg = 0;
                                if (pos.length == 1){
                                    if(rida > 14){
                                        veerg = 3; //veergu 3 ei eksisteeri, kasutuses lihtsalt abimuutujana
                                    }
                                }else{
                                    veerg = Integer.parseInt(pos[1]);
                                }
                                if (veerg == 1){
                                    if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9998) {
                                        System.out.println("Sisesta korrektne reanumber.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) ==9990){
                                        System.out.println("Sa ei valinud ühtegi täringut.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9991){
                                        System.out.println("Ei saa tabelisse panna.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9992){
                                        System.out.println("Valisid liiga palju täringuid.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9993){
                                        System.out.println("Valisid liiga vähe täringuid.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9994){
                                        System.out.println("Valiku seas pole josplit.");
                                    }else{
                                        aktiivne.getTabel().setEsimene(rida-1, aktiivne.getTabel().valiMeetod(rida-1,täringud.getValikuVäärtused(valik)));
                                        if (aktiivne.equals(m1)){ //järgmise mängija kord
                                            if (m2.getVise() != 60){
                                                aktiivne = m2;
                                            }
                                        }else{
                                            if (m1.getVise() != 60){
                                                aktiivne = m1;
                                            }
                                        }
                                        if (m1.getVise() == 60 && m2.getVise() == 60){
                                            break;
                                        }
                                        break;
                                    }
                                }else if (veerg == 2){
                                    if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9998) {
                                        System.out.println("Sisesta korrektne reanumber.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) ==9990){
                                        System.out.println("Sa ei valinud ühtegi täringut.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9991){
                                        System.out.println("Ei saa tabelisse panna.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9992){
                                        System.out.println("Valisid liiga palju täringuid.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9993){
                                        System.out.println("Valisid liiga vähe täringuid.");
                                    }else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik))==9994){
                                        System.out.println("Valiku seas pole josplit.");
                                    }else{
                                        aktiivne.getTabel().setTeine(rida-1,aktiivne.getTabel().valiMeetod(rida-1,täringud.getValikuVäärtused(valik)));
                                        if (aktiivne.equals(m1)){
                                            if (m2.getVise() != 60){
                                                aktiivne = m2;
                                            }
                                        }else{
                                            if (m1.getVise() != 60){
                                                aktiivne = m1;
                                            }
                                        }
                                        if (m1.getVise() == 60 && m2.getVise() == 60){
                                            break;
                                        }
                                        break;
                                    }
                                }else if (veerg == 3) {
                                    if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9998) {
                                        System.out.println("Sisesta korrektne reanumber.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9990) {
                                        System.out.println("Sa ei valinud ühtegi täringut.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9991) {
                                        System.out.println("Ei saa tabelisse panna.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9992) {
                                        System.out.println("Valisid liiga palju täringuid.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9993) {
                                        System.out.println("Valisid liiga vähe täringuid.");
                                    } else if (aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)) == 9994) {
                                        System.out.println("Valiku seas pole josplit.");
                                    } else {
                                        aktiivne.getTabel().setJospel(rida - 15, aktiivne.getTabel().valiMeetod(rida - 1, täringud.getValikuVäärtused(valik)));
                                        if (aktiivne.equals(m1)) {
                                            if (m2.getVise() != 60) {
                                                aktiivne = m2;
                                            }
                                        } else {
                                            if (m1.getVise() != 60) {
                                                aktiivne = m1;
                                            }
                                        }
                                        if (m1.getVise() == 60 && m2.getVise() == 60){
                                            break;
                                        }
                                        break;
                                    }
                                }else{
                                    System.out.println("Sisesta korrektne veerunumber.");
                                }
                            }catch(NumberFormatException e){
                                System.out.println("Vigane sisend.");
                            }
                        }
                    }catch(NumberFormatException b){
                        System.out.println("Vigane sisend.");
                    }
                }else{
                    System.out.println("Sisend ei saa olla tühi.");
                }
            }
            if (m1.getVise() == 60 && m2.getVise() == 60){ //mäng lõpeb kui mõlemal mängijal on 60 viset täis
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
