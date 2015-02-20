package be.howest.nmct.scoresstudenten;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Stijn on 12/02/2015.
 */
public class Student implements Comparable {
    private String emailStudent;
    private Map<String, ModulePunt> scoresStudent = new HashMap<String, ModulePunt>();

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public Student() {

    }

    public Student(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public void VoegScoreToe(String moduleNaam, double score) {
        ModulePunt punt = new ModulePunt(moduleNaam, score);
        if(!scoresStudent.containsKey(moduleNaam))
            this.scoresStudent.put(moduleNaam , punt);
    }

    public float getTotaleScoreStudent() {
        double studiepunten = getStudiepunten();
        float percentage = 0;
        for(ModulePunt value : scoresStudent.values()) {
            double product = value.getScore() * (value.getAantalStudiePunten() / studiepunten);
            percentage += product;
        }
        return percentage;
    }

    private double getStudiepunten() {
        double studiepunten = 0;
        for(ModulePunt value : scoresStudent.values())
            studiepunten += value.getAantalStudiePunten();
        return studiepunten;
    }

    @Override
    public String toString() {
        return "Student{" +
                "emailStudent='" + emailStudent + '\'' +
                ", scoresStudent=" + scoresStudent +
                '}';
    }

    @Override
    public int compareTo(Object another) {
        float student1 = this.getTotaleScoreStudent();
        float student2 = ((Student) another).getTotaleScoreStudent();

        if(student1 == student2)
            return 0;
        else if(student1 > student2)
            return -1;
        else
            return 1;
    }

    public static List<Double> getScoresModule(List<Student> studenten, String moduleNaam) {
        List<Double> scores = new ArrayList<Double>();
        for(Student stud : studenten)
            if (stud.scoresStudent.containsKey(moduleNaam))
                scores.add(stud.scoresStudent.get(moduleNaam).getScore());
        return scores;
    }

    public static double getGemiddeldeScoreModule(List<Student> studenten, String moduleNaam) {
        List<Double> scores = getScoresModule(studenten, moduleNaam);
        double totaal = someerAlleScores(scores);
        return totaal / scores.size();
    }

    private static double someerAlleScores(List<Double> scores) {
        double score = 0;
        for(int i = 0; i < scores.size(); i++)
            score += scores.get(i);
        return score;
    }

    public static void sorteerStudenten(List<Student> studenten) {
        Collections.sort(studenten);
    }
}
