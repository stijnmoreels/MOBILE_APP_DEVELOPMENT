package be.howest.nmct.stopafstandandroid;

/**
 * Created by Stijn on 12/02/2015.
 */
public class StopAfstandInfo {
    public static enum Wegtype {
        WEGDEK_DROOG, WEGDEK_NAT
    }
    private int snelheid;
    private float reactietijd;
    private float stopafstand;
    private Wegtype wegtype;

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        this.snelheid = snelheid;
    }

    public float getReactietijd() {
        return reactietijd;
    }

    public void setReactietijd(float reactietijd) {
        this.reactietijd = reactietijd;
    }

    public float getStopafstand() {
        float remvertraging = wegtype == Wegtype.WEGDEK_DROOG ? 8 : 5;
        float snelheid = this.snelheid / (float)3.6;
        stopafstand = snelheid * reactietijd + (snelheid * snelheid) / (2 * remvertraging);
        return stopafstand;
    }

    public void setStopafstand(float stopafstand) {
        this.stopafstand = stopafstand;
    }

    public Wegtype getWegtype() {
        return wegtype;
    }

    public void setWegtype(Wegtype wegtype) {
        this.wegtype = wegtype;
    }

    public StopAfstandInfo(int snelheid, float reactietijd, Wegtype wegtype) {
        this.snelheid = snelheid;
        this.reactietijd = reactietijd;
        this.wegtype = wegtype;
    }

    public StopAfstandInfo() {

    }
}
