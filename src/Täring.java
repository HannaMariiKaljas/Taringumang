import java.util.List;
import java.util.Random;

public class Täring {
    private Random rand;
    private boolean valitud; //võib ju kasutada nii täringute valimiseks kui ka täringute hoidmiseks ja uuesti veeretamiseks
    private int tulemus;


    public Täring() {
        this.rand = new Random();
        this.valitud = false;
        this.tulemus = veereta();
    }

    public int veereta(){
        if (valitud == false){
            tulemus = rand.nextInt(6) + 1;
        }
        return tulemus;
    }

    public boolean getValitud() {
        return valitud;
    }

    public int getTulemus() {
        return tulemus;
    }

    public void lülitaValitud() {
        valitud = !valitud;
    }
}
