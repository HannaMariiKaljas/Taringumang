import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> proov= new ArrayList<>();
        Meetodid m1=new Meetodid(proov);
        System.out.println(m1.ühed(proov));

        String test = "15";
        String[] test2 = test.split(" ");

        System.out.println(test2[1]);
    }
}
