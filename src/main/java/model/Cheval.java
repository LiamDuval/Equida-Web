package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cheval {

    private int id;
    private String nom;
    private LocalDate dateNaissance;  
    
    private Race race;
    private Robe robe;
    private Cheval pere;
    private Cheval mere;
    ArrayList<ChevalCourse> LesChevauxCourses ;
    


    public ArrayList<ChevalCourse> getLesChevauxCourses() {
        return LesChevauxCourses;
    }

    public void setLesChevauxCourses(ArrayList<ChevalCourse> LesChevauxCourses) {
        this.LesChevauxCourses = LesChevauxCourses;
    }
    


    public Cheval() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }

    public Robe getRobe() {
        return robe;
    }

    public void setRobe(Robe robe) {
        this.robe = robe;
    }
    
    
    
    
@Override
public String toString() {
        return id + " " + nom;
    }


 public Cheval getPere() {
        return pere;
    }

    public void setPere(Cheval pere) {
        this.pere = pere;
    }

    public Cheval getMere() {
        return mere;
    }

    public void setMere(Cheval mere) {
        this.mere = mere;
    }


    public void addChevalCourse(ChevalCourse unChevalCourse){
    if (LesChevauxCourses ==null ){
        LesChevauxCourses= new ArrayList<ChevalCourse>();
    }
    LesChevauxCourses.add(unChevalCourse);
    
    }

}
