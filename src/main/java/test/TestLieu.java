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
    /*public static void main (String args[]){


        Vente v = new Vente();
        v.setId(2);
        v.setNom("Galop'rix");


        Lieu l = new Lieu();
        l.setId(1);
        l.setVille("Villente.");


        v.setLieu(l);


        System.out.println("Vente : " + v.getId() + " " + v.getNom() + " "
                + v.getLieu().getId() + " " + v.getLieu().getVille());
    }*/
     public static void main (String args[]){
        // instantiation d'une race
        Lieu r = new Lieu();
        r.setId(4);
        r.setVille("Pur-Sang");

        // instanciation de 2 chevaux c1 et c2
        // ajout des chevaux c1 et c2 à l'arraylist des chevaux grâce
        // à la relation OneToMany
        Vente c1 = new Vente();
        c1.setId(1);
        c1.setNom("Eclipse");
        r.addVente(c1);

        Vente c2 = new Vente();
        c2.setId(2);
        c2.setNom("Comète");
        r.addVente(c2);

        //Affichage des informations de la race
        System.out.println("La Categorie de Vente est " + r.getId() + " " + r.getVille() + " et contient " + r.getLesVentes().size() + " ventes" );
        System.out.println("Liste des ventes de Categorie " + r.getId() + " : ");

		// Affichage des informations sur chevaux liées à la race
        for (Vente c : r.getLesVentes()){
            System.out.println("Vente numéro : " + c.getId() + " " + c.getNom());
        }
    }
}
