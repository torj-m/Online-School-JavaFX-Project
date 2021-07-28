package sample;

import java.io.IOException;
import java.util.*;
public class Examen {

    private ArrayList<Question> quest = new ArrayList();

    public void ajouterQuest(Question qst){
        quest.add(qst);
    }


    public ArrayList<Question> getQuest() {
        return quest;
    }

    public void setQuest(ArrayList<Question> a) {
        this.quest = a;
    }

    public void afficher(){
        for (Question q :quest) {
            q.afficherQuest(); }    }




   /* public void lireReponseQuestion() throws NumberFormatException, IOException {
        boolean bonneReponse = quest.get(numeroQuestionEnCours).lireReponseAuClavier();
        if (bonneReponse) {
            total++;
        }
    }*/
   // public double geTotal(){return this.total;}

}
