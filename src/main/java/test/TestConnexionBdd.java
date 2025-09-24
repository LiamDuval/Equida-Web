package test;

import java.sql.Connection;
import java.util.ArrayList;

import database.Connexionbdd;
import database.DaoCheval;
import database.DaoVente;

public class TestConnexionBdd {

    public static void main (String args[]) {

        Connection cnx = Connexionbdd.ouvrirConnexion();
        System.out.println ("nombre de chevaux = " + DaoCheval.getLesChevaux(cnx).size());
        System.out.println ("nombre de chevaux = " + DaoCheval.getLeCheval(cnx, 1));

        System.out.println ("nombre de Vente = " + DaoVente.getLesVentes(cnx).size());
        System.out.println ("La Vente = " + DaoVente.getLaVente(cnx, 1));

            }

}
