/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Lieu;
import model.Vente;

/**
 *
 * @author sio2
 */
public class TestLieu {
    public static void main (String args[]){


        Vente v = new Vente();
        v.setId(2);
        v.setNom("Galop'rix");


        Lieu l = new Lieu();
        l.setId(1);
        l.setVille("Villente.");


        v.setLieu(l);


        System.out.println("Vente : " + v.getId() + " " + v.getNom() + " "
                + v.getLieu().getId() + " " + v.getLieu().getVille());
    }
}
