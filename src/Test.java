import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> proov= new ArrayList<>();
        proov.add(1);
        proov.add(6);
        proov.add(6);
        proov.add(2);
        proov.add(2);
        proov.add(3);
        Meetodid m1=new Meetodid(proov);
        System.out.println(m1.Kolmik(proov));
    }
}
