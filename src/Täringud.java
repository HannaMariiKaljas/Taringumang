import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Täringud {
    private Random rand;
    private int[] täringud = new int[7];


    public Täringud() {
        this.rand = new Random();
    }

    public void veeretaKõik(){
        for (int i = 0; i < 7; i++) {
            täringud[i] = rand.nextInt(6) + 1;
        }
    }

    public void veeretaValik(int[] valik){
        for (int i = 0; i < valik.length; i++){
            täringud[valik[i]-1] = rand.nextInt(6) + 1;
        }
    }

    public int[] getTäringud() {
        return täringud;
    }

    public void väljasta(){
        System.out.format("%-7s%2d%2d%2d%2d%2d%2d%2d","Täring\t",1,2,3,4,5,6,7);
        System.out.println("");
        System.out.format("%-7s%2d%2d%2d%2d%2d%2d%2d","Tulemus\t", täringud[0],täringud[1],täringud[2],täringud[3],täringud[4],täringud[5],täringud[6]);
        System.out.println("\n");
    }
}
