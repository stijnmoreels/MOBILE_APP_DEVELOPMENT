package be.howest.nmct.scoresstudenten;

/**
 * Created by Stijn on 12/02/2015.
 */
public class ModulePunt {
    private String moduleNaam;
    private int aantalStudiePunten = 6;
    private double score;

    public String getModuleNaam() {
        return moduleNaam;
    }

    public void setModuleNaam(String moduleNaam) {
        this.moduleNaam = moduleNaam;
    }

    public int getAantalStudiePunten() {
        return aantalStudiePunten;
    }

    public void setAantalStudiePunten(int aantalStudiePunten) {
        this.aantalStudiePunten = aantalStudiePunten;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ModulePunt() {

    }

    public ModulePunt(String moduleNaam, double score) {
        this.moduleNaam = moduleNaam;
        this.score = score;
    }

    public ModulePunt(String moduleNaam, double score, int aantalStudiePunten) {
        this.moduleNaam = moduleNaam;
        this.score = score;
        this.aantalStudiePunten = aantalStudiePunten;
    }

    @Override
    public String toString() {
        return "ModulePunt{" +
                "moduleNaam='" + moduleNaam + '\'' +
                ", aantalStudiePunten=" + aantalStudiePunten +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModulePunt that = (ModulePunt) o;

        if (!moduleNaam.equals(that.moduleNaam)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return moduleNaam.hashCode();
    }
}
