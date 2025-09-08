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
public class TestVente {
    public static void main (String args[]){


        Vente v = new Vente();
        v.setId(2);
        v.setNom("Galop'rix");


        CategVente c = new CategVente();
        c.setCode(1);
        c.setLibelle("Pur-sang.");


        v.setCategVente(c);


        System.out.println("Vente : " + v.getId() + " " + v.getNom() + " "
                + v.getCategVente().getCode() + " " + v.getCategVente().getLibelle());
        
        
        
    }
}