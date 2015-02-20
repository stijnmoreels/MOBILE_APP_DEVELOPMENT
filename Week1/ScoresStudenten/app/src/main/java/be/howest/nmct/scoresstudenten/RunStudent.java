package be.howest.nmct.scoresstudenten;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stijn on 12/02/2015.
 */
public class RunStudent {
    public static void main(String[] args) {

        List<Student> studenten = new ArrayList<Student>();

        Student student1 = new Student("stijn.moreels@student.howest.be");
        student1.VoegScoreToe("Programming Skills", 18);
        student1.VoegScoreToe("WEB", 13);
        studenten.add(student1);

        Student student2 = new Student("jef.daels@howest.be");
        student2.VoegScoreToe("Programming Skills", 20);
        student2.VoegScoreToe("WEB", 5);
        studenten.add(student2);

        Student student3 = new Student("stijn.walcarius@howest.be");
        student3.VoegScoreToe("Programming Skills", 19);
        student3.VoegScoreToe("WEB", 14);
        studenten.add(student3);

        log("Gemiddelde score van de module WEB is: " + Student.getGemiddeldeScoreModule(studenten, "WEB"));

        log("De scores van de module Programming Skills zijn:");
        List<Double> scores = Student.getScoresModule(studenten, "Programming Skills");
        for(int i = 0; i < scores.size(); i++)
            log("" + scores.get(i));

        log("Sorteer de studenten volgens hun totale score");
        Student.sorteerStudenten(studenten);
        for(int i = 0; i < studenten.size(); i++)
            log(studenten.get(i).getEmailStudent() + " - Totale score: " + studenten.get(i).getTotaleScoreStudent());

    }

    private static void log(String message) {
        System.out.println(message);
    }
}
