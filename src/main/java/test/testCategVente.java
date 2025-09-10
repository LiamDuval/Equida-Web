/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.CategVente;
import model.Vente;

/**
 *
 * @author sio2
 */
public class testCategVente {
    public static void main (String args[]){
        // instantiation d'une race
        CategVente r = new CategVente();
        r.setCode(4);
        r.setLibelle("Pur-Sang");

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
        System.out.println("La Categorie de Vente est " + r.getCode() + " " + r.getLibelle() + " et contient " + r.getLesVentes().size() + " ventes" );
        System.out.println("Liste des ventes de Categorie " + r.getCode() + " : ");

		// Affichage des informations sur chevaux liées à la race
        for (Vente c : r.getLesVentes()){
            System.out.println("Vente numéro : " + c.getId() + " " + c.getNom());
        }
    }
    
}
