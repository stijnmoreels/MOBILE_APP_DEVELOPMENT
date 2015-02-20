package be.howest.nmct.stopafstand;

import java.util.Scanner;

import be.howest.nmct.stopafstand.Voertuig;
import be.howest.nmct.stopafstand.StopAfstandInfo;

/**
 * Created by Stijn on 12/02/2015.
 */
public class TestStopafstand {
    public static void main(String[] args) {
        /*System.out.println("demo oef 1");

        Voertuig voertuig = new Voertuig(Voertuig.MerkVoertuig.Audi, 2012);
        System.out.println(voertuig);

        System.out.println("Geef snelheid op (in km/h):");
        Scanner scanner = new Scanner(System.in);
        int snelheid = scanner.nextInt();*/

        StopAfstandInfo afstand1 = new StopAfstandInfo(89, (float)1.4, StopAfstandInfo.Wegtype.WEGDEK_NAT);
        System.out.println(afstand1.getStopafstand());


        StopAfstandInfo inputStopAfstand = new StopAfstandInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geef snelheid op in (km/h):");
        int snelheid = scanner.nextInt();
        inputStopAfstand.setSnelheid(snelheid);

        System.out.println("Geef reactietijd op (in sec, bv: 1.2)");
        float reactietijd = scanner.nextFloat();
        inputStopAfstand.setReactietijd(reactietijd);

        System.out.println("Welk wegtype selecteer je: NAT of DROOG");
        StopAfstandInfo.Wegtype wegtype = scanner.next().equals("NAT") ?
                StopAfstandInfo.Wegtype.WEGDEK_NAT : StopAfstandInfo.Wegtype.WEGDEK_DROOG;
        inputStopAfstand.setWegtype(wegtype);

        System.out.println("De stopafstand is: " + inputStopAfstand.getStopafstand());
    }
}
