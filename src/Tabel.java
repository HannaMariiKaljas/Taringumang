import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tabel {
    List<Valikud> v = new ArrayList<>();

    private int[] ühed = new int[2];
    private int[] kahed = new int[2];
    private int[] kolmed = new int[2];
    private int[] neljad = new int[2];
    private int[] viied = new int[2];
    private int[] kuued = new int[2];
    private int[] paar = new int[2];
    private int[] kolmik = new int[2];
    private int[] nelik = new int[2];
    private int[] maja = new int[2];
    private int[] summa = new int[2];
    private int[] väikeRida = new int[2];
    private int[] suurRida = new int[2];
    private int[] KaksKaks = new int[2];
    private int[] jospel = new int[6];

    public int arvutaSumma(){
        int s;
        s = IntStream.of(ühed).sum() + IntStream.of(kahed).sum() + IntStream.of(kolmed).sum() + IntStream.of(neljad).sum() + IntStream.of(viied).sum() +
                IntStream.of(kuued).sum();
        if (s < 0){
            s -= 50;
        }
        s += IntStream.of(paar).sum() + IntStream.of(kolmik).sum() + IntStream.of(nelik).sum() + IntStream.of(maja).sum() +
                IntStream.of(summa).sum() + IntStream.of(väikeRida).sum() + IntStream.of(suurRida).sum() + IntStream.of(KaksKaks).sum() + IntStream.of(jospel).sum();
    }


}
