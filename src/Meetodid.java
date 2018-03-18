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
        Set<Integer> set = new HashSet<Integer>(valik);
        if (set.size() < valik.size()) {
            Collections.sort(valik);
            Collections.reverse(valik);
            for (int i = 0; i < valik.size(); i++) {
                if (valik.get(i) == valik.get(i + 1)) {
                    if (valik.get(i) == 6) {
                        return "X";
                    } else {
                        return -(12 - valik.get(i) * 2) + "";
                    }
                }
            }
        }
        return "ei saa tabelisse panna ";
    }

    public static String Kolmik(List<Integer> valik) {
        Set<Integer> set = new HashSet<Integer>(valik);
        if (set.size() < valik.size()&&valik.size()>=3) {
            Collections.sort(valik);
            Collections.reverse(valik);
            for (int i = 0; i < valik.size()-2; i++) {
                if (valik.get(i) == valik.get(i + 1) && valik.get(i) == valik.get(i + 2)){
                    if (valik.get(i) == 6) {
                        return "X";
                    } else {
                        return -(18 - valik.get(i) * 3) + "";
                    }
                }
            }
        }
        return "ei saa tabelisse panna ";
    }
    public static String Nelik(List<Integer> valik) {
        Set<Integer> set = new HashSet<Integer>(valik);
        if (set.size() < valik.size()&&valik.size()>=4) {
            Collections.sort(valik);
            Collections.reverse(valik);
            for (int i = 0; i < valik.size()-3; i++) {
                if (valik.get(i) == valik.get(i + 1) && valik.get(i) == valik.get(i + 2)&& valik.get(i) == valik.get(i + 3)){
                    if (valik.get(i) == 6) {
                        return "X";
                    } else {
                        return -(24 - valik.get(i) * 4) + "";
                    }
                }
            }
        }
        return "ei saa tabelisse panna ";
    }
    public static String KaksPlussKaks(List<Integer> valik){
        Set<Integer> set = new HashSet<Integer>(valik);
        if (set.size() < valik.size()&&valik.size()>=4) {
            Collections.sort(valik);
            Collections.reverse(valik);
            for (int i = 0; i < valik.size()-3; i++) {
                if (valik.get(i) == valik.get(i + 1) && valik.get(i+2) == valik.get(i + 3) && valik.get(i)!=valik.get(i+2)){
                    int sum=0;
                    for (int j = i; j <=i+3 ; j++) {
                        sum=sum+valik.get(j);
                    }
                    if (sum == 22) {
                        return "X";
                    } else {
                        return -(22-sum) + "";
                    }
                }
            }
        }
        return "ei saa tabelisse panna ";
    }

    public static String Summa(List<Integer> valik) {
        if (valik.size()>=5){
            Collections.sort(valik);
            Collections.reverse(valik);
            int summa=0;
            for (int i = 0; i <5 ; i++) {
                summa=summa+valik.get(i);
            }
            if(summa==30){
                return "X";
            }else{
                return summa+"";
            }
        }else {
            return "ei saa tabelisse panna ";
        }
    }
}
