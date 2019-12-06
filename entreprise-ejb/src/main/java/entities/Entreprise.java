/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Claire
 */
public class Entreprise {
    private String codeClient;
    private ArrayList<String> compteRendus;

    public Entreprise(String codeClient) {
        this.codeClient = codeClient;
    }
    
    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public ArrayList<String> getCompteRendus() {
        return compteRendus;
    }

    public void setCompteRendus(ArrayList<String> compteRendus) {
        this.compteRendus = compteRendus;
    }

    @Override
    public String toString() {
        return "enteprise{" + "codeClient=" + codeClient + ", compteRendus=" + compteRendus + '}';
    }
    
    
    
    
}
