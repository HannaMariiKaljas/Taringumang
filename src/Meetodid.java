import java.util.*;

public class Meetodid {
    //public List<Integer> valik;

    /*public Meetodid(List<Integer> valik) {
        this.valik = valik;
    }*/

    /*public Meetodid(Täring[] täringud){
        valik = new ArrayList<>();
        for (Täring t : täringud) {
            if (t.getValitud() == true) {
                valik.add(t.getTulemus());
            }
        }
    }*/

    //Parem on vist kui selle klassi kasutamiseks ei pea isendit looma

    public static List<Integer> valik(Täringud t){ // teisendab array Täring[] List<Integer>-ks
        List<Integer> valik = new ArrayList<>();
        int[] täringud = t.getTäringud();
        for (int i = 0; i < 7; i++){
            valik.add(täringud[i]);
        }
        return valik;
    }
    public static int ühed(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.contains(1)) {
                    int sagedus = Collections.frequency(valik, 1);
                    if (sagedus == 3) {
                        return 0;
                    } else {
                        return (-3) + sagedus;
                    }
                } else {
                    throw new Exception( "ei saa tabelisse panna ");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999; // 9999 on siis mingi error
    }

    public static int kahed(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.contains(2)) {
                    int sagedus = Collections.frequency(valik, 2);
                    if (sagedus == 3) {
                        return 0;
                    } else {
                        return (-(2*3)) + (sagedus*2);
                    }
                } else {
                    throw new Exception( "ei saa tabelisse panna ");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int kolmed(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.contains(3)) {
                    int sagedus = Collections.frequency(valik, 3);
                    if (sagedus == 3) {
                        return 0;
                    } else {
                        return (-(3*3)) + (sagedus*3);
                    }
                } else {
                    throw new Exception( "ei saa tabelisse panna ");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int neljad(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.contains(4)) {
                    int sagedus = Collections.frequency(valik, 4);
                    if (sagedus == 3) {
                        return 0;
                    } else {
                        return (-(4*3)) + (sagedus*4);
                    }
                } else {
                    throw new Exception( "ei saa tabelisse panna ");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int viied(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.contains(5)) {
                    int sagedus = Collections.frequency(valik, 5);
                    if (sagedus == 3) {
                        return 0;
                    } else {
                        return (-(5*3)) + (sagedus*5);
                    }
                } else {
                    throw new Exception( "ei saa tabelisse panna ");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int kuued(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.contains(6)) {
                    int sagedus = Collections.frequency(valik, 6);
                    if (sagedus == 3) {
                        return 0;
                    } else {
                        return (-(6*3)) + (sagedus*6);
                    }
                } else {
                    throw new Exception( "ei saa tabelisse panna ");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int Paar(List<Integer> valik) {
        while(true){
            try {
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if(valik.size()!=2){
                    if(valik.size()>2){
                        throw new Exception("valisid liiga palju täringuid");
                    }throw new Exception("valisid liiga vähe täringuid");
                }
                if (valik.get(0) == valik.get(1)) {
                    if (valik.get(0) == 6) {
                        return 0;
                    } else {
                        return -(12 - valik.get(0) * 2);
                    }
                }
                throw new Exception("ei saa tabelisse panna ");
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }

    public static int Kolmik(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.size() != 3) {
                    if (valik.size() > 3) {
                        throw new Exception("valisid liiga palju täringuid");
                    }
                    throw new Exception("valisid liiga vähe täringuid");
                }
                if (valik.get(0) == valik.get(1) && valik.get(1) == valik.get(2)) {
                    if (valik.get(0) == 6) {
                        return 0;
                    } else {
                        return -(18 - valik.get(0) * 3);
                    }
                }
                throw new Exception("ei saa tabelisse panna ");
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int Nelik(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                throw new Exception("Sa ei valinud ühtegi täringut");
            }
                if (valik.size() != 4) {
                    if (valik.size() > 4) {
                        throw new Exception("valisid liiga palju täringuid");
                    }
                   throw new Exception("valisid liiga vähe täringuid");
                }
                if (valik.get(0) == valik.get(1) && valik.get(1) == valik.get(2)&& valik.get(2)== valik.get(3)){
                    if (valik.get(0) == 6) {
                        return 0;
                    } else {
                        return -(24 - valik.get(0) * 3);
                    }
                }
                throw new Exception("ei saa tabelisse panna");

            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int KaksPlussKaks(List<Integer> valik){
        while(true){
            try{
                if(valik.size()==0){
                throw new Exception("Sa ei valinud ühtegi täringut");
            }
                if (valik.size() != 4) {
                    if (valik.size() > 4) {
                        throw new Exception("valisid liiga palju täringuid");
                    }
                    throw new Exception("valisid liiga vähe täringuid");
                }
                Set<Integer> set = new HashSet<Integer>(valik);
                if (set.size() < valik.size()) {
                    Collections.sort(valik);
                    Collections.reverse(valik);
                    if(valik.get(0)==valik.get(1)&&valik.get(2)==valik.get(3)){
                        int sum=0;
                        for (int i = 0; i <valik.size() ; i++) {
                            sum=sum+valik.get(i);
                        }
                        if (sum==22) {
                            return 0;
                        } else {
                            return -(22 - sum);
                        }
                    }
                }
                throw new Exception( "ei saa tabelisse panna ");
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int Maja(List<Integer> valik){
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.size() != 5) {
                    if (valik.size() > 5) {
                        throw new Exception("valisid liiga palju täringuid");
                    }
                    throw new Exception("valisid liiga vähe täringuid");
                }
                Set<Integer> set = new HashSet<Integer>(valik);
                if (set.size() < valik.size()) {
                    Collections.sort(valik);
                    Collections.reverse(valik);
                    if(valik.get(0)==valik.get(1)&&valik.get(1)==valik.get(2)&&valik.get(3)==valik.get(4)
                            ||valik.get(0)==valik.get(1)&&valik.get(2)==valik.get(3)&&valik.get(3)==valik.get(4)){
                        int sum=0;
                        for (int i = 0; i <valik.size() ; i++) {
                            sum=sum+valik.get(i);
                        }
                        if (sum==28) {
                            return 0;
                        } else {
                            return -(28 - sum);
                        }
                    }
                }
                throw new Exception("ei saa tabelisse panna ");
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return  9999;// 9999 on siis mingi error
    }
    public static int VäikeRida(List<Integer> valik){
        while(true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.size() != 5) {
                    if (valik.size() > 5) {
                        throw new Exception("valisid liiga palju täringuid");
                    }
                    throw new Exception("valisid liiga vähe täringuid");
                }
                Set<Integer> set = new HashSet<Integer>(valik);
                if (set.size() == valik.size()&&valik.get(0)==1){
                    return 0;
                }
                throw new Exception("ei saa tabelisse panna");
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
    public static int SuurRida(List<Integer> valik){
        while(true){
            try {
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.size() != 5) {
                    if (valik.size() > 5) {
                        throw new Exception("valisid liiga palju täringuid");
                    }
                    throw new Exception("valisid liiga vähe täringuid");
                }
                Set<Integer> set = new HashSet<Integer>(valik);
                if (set.size() == valik.size()&&valik.get(0)==2){
                    return 0;
                }
                throw new Exception("ei saa tabelisse panna");

            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }

    public static int Summa(List<Integer> valik) {
        while(true){
            try{
                if(valik.size()==0){
                throw new Exception("Sa ei valinud ühtegi täringut");
            }
                if (valik.size() > 5) {
                    throw new Exception("valisid liiga palju täringuid");
                }
                Collections.sort(valik);
                Collections.reverse(valik);
                int summa=0;
                for (int i = 0; i <valik.size() ; i++) {
                    summa=summa+valik.get(i);
                }
                if(summa==30){
                    return 0;
                }else{
                    return summa;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999; // 9999 on siis mingi error
    }
    public static int Jospel(List<Integer> valik, int jospel) {
        while (true){
            try{
                if(valik.size()==0){
                    throw new Exception("Sa ei valinud ühtegi täringut");
                }
                if (valik.size() < 5) {
                    throw new Exception("valisid liiga vähe täringuid");
                }
                List<Integer> ilmakordusteta = new ArrayList<>(new HashSet<>(valik));
                Collections.sort(valik);
                int väärtus = 0;
                int indeks = 0;
                if (ilmakordusteta.size() <= 3) {
                    väärtus=Collections.frequency(valik,4);
                    if (väärtus >= 5) {
                        if (väärtus == 5) {
                            return 0;
                        } else if (väärtus == 6) {
                            return 10;
                        }
                        return 20;
                    }
                }
                throw new Exception("valitud täringut seas pole josplit");
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }return 9999;// 9999 on siis mingi error
    }
}
