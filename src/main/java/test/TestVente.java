/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Lot;
import model.Vente;

/**
 *
 * @author sio2
 */
public class TestVente {
    /*public static void main (String args[]){


       Lot v = newLot();
        v.setId(2);
        v.setNom("Galop'rix");


        Vente c = new Vente();
        c.setCode(1);
        c.setLibelle("Pur-sang.");


        v.setVente(c);


        System.out.println("Vente : " + v.getId() + " " + v.getNom() + " "
                + v.getVente().getCode() + " " + v.getVente().getLibelle());
        
        
        
    }*/
    
    public static void main (String args[]){
        // instantiation d'une race
        Vente r = new Vente();
        r.setId(4);
        r.setNom("Pur-Sang");

        // instanciation de 2 chevaux c1 et c2
        // ajout des chevaux c1 et c2 à l'arraylist des chevaux grâce
        // à la relation OneToMany
        Lot c1 = new Lot();
        c1.setId(1);
        c1.setPrixDepart("3000€");
        r.addLot(c1);

        Lot c2 = new Lot();
        c2.setId(2);
        c2.setPrixDepart("50000€");
        r.addLot(c2);

        //Affichage des informations de la race
        System.out.println("La Categorie deLot est " + r.getId() + " " + r.getNom() + " et contient " + r.getLesLots().size() + " ventes" );
        System.out.println("Liste des ventes de Categorie " + r.getId() + " : ");

		// Affichage des informations sur chevaux liées à la race
        for (Lot l : r.getLesLots()){
            System.out.println("Vente numéro : " + l.getId() + " " + l.getPrixDepart());
        }
    }
    
}