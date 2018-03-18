import java.util.*;

public class Meetodid {
    List<Integer> valik;

    public Meetodid(List<Integer> valik) {
        this.valik = valik;
    }
    public static String ühed(List<Integer> valik) {
        if (valik.contains(1)) {
            int sagedus = Collections.frequency(valik, 1);
            if (sagedus == 3) {
                return "X";
            } else {
                return (-(1 * 3)) + (sagedus * 1) + "";
            }
        } else {
            return "ei saa tabelisse panna ";
        }
    }
    public static String kahed(List<Integer> valik) {
            if (valik.contains(2)) {
                int sagedus = Collections.frequency(valik, 2);
                if (sagedus == 3) {
                    return "X";
                } else {
                    return (-(2 * 3)) + (sagedus * 2) + "";
                }
            } else {
                return "ei saa tabelisse panna ";
            }
        }
    public static String kolmed(List<Integer> valik) {
        if (valik.contains(3)) {
            int sagedus = Collections.frequency(valik, 3);
            if (sagedus == 3) {
                return "X";
            } else {
                return (-(3 * 3)) + (sagedus * 3) + "";
            }
        } else {
            return "ei saa tabelisse panna ";
        }
    }
    public static String neljad(List<Integer> valik) {
        if (valik.contains(4)) {
            int sagedus = Collections.frequency(valik, 4);
            if (sagedus == 3) {
                return "X";
            } else {
                return (-(4 * 3)) + (sagedus * 4) + "";
            }
        } else {
            return "ei saa tabelisse panna ";
        }
    }
    public static String viied(List<Integer> valik) {
        if (valik.contains(5)) {
            int sagedus = Collections.frequency(valik, 5);
            if (sagedus == 3) {
                return "X";
            } else {
                return (-(5 * 3)) + (sagedus * 5) + "";
            }
        } else {
            return "ei saa tabelisse panna ";
        }
    }
    public static String kuued(List<Integer> valik) {
        if (valik.contains(6)) {
            int sagedus = Collections.frequency(valik, 6);
            if (sagedus == 3) {
                return "X";
            } else {
                return (-(6 * 3)) + (sagedus * 6) + "";
            }

        } else {
            return "ei saa tabelisse panna ";
        }
    }
    public static String Paar(List<Integer> valik) {
        if(valik.size()!=2){
            if(valik.size()>2){
                return "valisid liiga palju täringuid";
            }return "valisid liiga vähe täringuid";
        }
        if (valik.get(0) == valik.get(1)) {
            if (valik.get(0) == 6) {
                return "X";
            } else {
                return -(12 - valik.get(0) * 2) + "";
            }
        }
        return "ei saa tabelisse panna ";
    }

    public static String Kolmik(List<Integer> valik) {
        if (valik.size() != 3) {
            if (valik.size() > 3) {
                return "valisid liiga palju täringuid";
            }
            return "valisid liiga vähe täringuid";
        }
        if (valik.get(0) == valik.get(1) && valik.get(1) == valik.get(2)) {
            if (valik.get(0) == 6) {
                    return "X";
                } else {
                    return -(18 - valik.get(0) * 3) + "";
            }
        }
        return "ei saa tabelisse panna ";
    }
    public static String Nelik(List<Integer> valik) {
        if (valik.size() != 4) {
            if (valik.size() > 4) {
                return "valisid liiga palju täringuid";
            }
            return "valisid liiga vähe täringuid";
        }
        if (valik.get(0) == valik.get(1) && valik.get(1) == valik.get(2)&& valik.get(2)== valik.get(3)){
            if (valik.get(0) == 6) {
                return "X";
            } else {
                return -(18 - valik.get(0) * 3) + "";
            }
        }
        return "ei saa tabelisse panna ";
    }
    public static String KaksPlussKaks(List<Integer> valik){
        if (valik.size() != 4) {
            if (valik.size() > 4) {
                return "valisid liiga palju täringuid";
            }
            return "valisid liiga vähe täringuid";
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
                    return "X";
                } else {
                    return -(22 - valik.get(0) * 3) + "";
                }
            }
        }
        return "ei saa tabelisse panna ";
    }

    public static String Maja(List<Integer> valik){
        if (valik.size() != 5) {
            if (valik.size() > 5) {
                return "valisid liiga palju täringuid";
            }
            return "valisid liiga vähe täringuid";
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
                    return "X";
                } else {
                    return -(28 - valik.get(0) * 3) + "";
                }
            }
        }
        return "ei saa tabelisse panna ";
    }
    public static String VäikeRida(List<Integer> valik){
        if (valik.size() != 5) {
            if (valik.size() > 5) {
                return "valisid liiga palju täringuid";
            }
            return "valisid liiga vähe täringuid";
        }
        Set<Integer> set = new HashSet<Integer>(valik);
        if (set.size() == valik.size()&&valik.get(0)==1){
            return "X";
        }
        return "ei saa tabelisse panna";
    }
    public static String SuurRida(List<Integer> valik){
        if (valik.size() != 5) {
            if (valik.size() > 5) {
                return "valisid liiga palju täringuid";
            }
            return "valisid liiga vähe täringuid";
        }
        Set<Integer> set = new HashSet<Integer>(valik);
        if (set.size() == valik.size()&&valik.get(0)==2){
            return "X";
        }
        return "ei saa tabelisse panna";
    }
    public static String Summa(List<Integer> valik) {
        if (valik.size() > 5) {
            return "valisid liiga palju täringuid";
        }
        Collections.sort(valik);
        Collections.reverse(valik);
        int summa=0;
        for (int i = 0; i <valik.size() ; i++) {
            summa=summa+valik.get(i);
        }
        if(summa==30){
            return "X";
        }else{
            return summa+"";
        }
    }
}
