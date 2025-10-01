/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Course {
    private int id;
    private String nom;
    private String ville;
    
    ArrayList<ChevalCourse> LesChevauxCourses ;
    
    
    public Course() {
    }

    public ArrayList<ChevalCourse> getLesChevauxCouses() {
        return LesChevauxCourses;
    }

    public void setLesChevauxCourses(ArrayList<ChevalCourse> LesChevauxCouses) {
        this.LesChevauxCourses = LesChevauxCourses;
    }
    
    public void addChevalCourses(ChevalCourse unChevalCourse){
    if (LesChevauxCourses ==null ){
        LesChevauxCourses= new ArrayList<ChevalCourse>();
    }
    LesChevauxCourses.add(unChevalCourse);
    
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
}
