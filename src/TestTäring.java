public class TestTäring {
    public static void main(String[] args) {
        Täring[] täringud = new Täring[6];
        for (int i = 0; i < 6; i++){
            Täring t = new Täring();
            t.lülitaValitud();
            täringud[i] = t;
            System.out.println(täringud[i].getTulemus());
        }

        täringud[0].lülitaValitud();
        täringud[1].lülitaValitud();
        System.out.println(Meetodid.neljad(Meetodid.valik(täringud)));
    }

}
