package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {
    private String enonce;
    private int etat;
    private ArrayList<String> reponse = new ArrayList();

    Question(String enonce){
        this.enonce = enonce;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public ArrayList<String> getReponse() {
        return reponse;
    }

    public void setReponse(ArrayList<String> reponse) {
        this.reponse = reponse;
    }

    public void ajouterReponse(String rep, boolean bon){
        this.reponse.add(rep);
        if (bon) {
            etat = reponse.size();
        }
    }
    public void afficherQuest(){
        System.out.println( enonce+":");
       for (int i=0; i<reponse.size();i++){
           System.out.println(reponse.get(i));
       }
    }
    public boolean lireReponseAuClavier(){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String r = this.reponse.get(etat);
        return str.equals(r);
    }
    @Override
    public String toString() {
        return "Question [enonce = " +enonce+", indiceBonneReponse = " +etat+ ", reponses=" + reponse + "]";
    }
}
