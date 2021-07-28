package sample;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Note {
    private Map notes = new HashMap();
    public Note(List l){
        Iterator it = l.listIterator();
        while(it.hasNext()){notes.put(it.next(),0.0);}
    }
    public void ajouterNote(int id_c, double tot){
        notes.put(id_c,tot);
        System.out.println("Note ajoutee!");
    }
    public void setNote(double note,int ke) throws IOException {
        if(!notes.containsKey(ke)) throw new IOException("Identifiant inexistant!");
        else notes.put(ke,note);
    }
    public void afficheNotes(){
        Iterator it = notes.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            System.out.println("Identifiant : "+me.getKey() + " & " + " Note: "+me.getValue());}
    }
    public void supprimerNotes(int ke)throws IOException{
        if(!notes.containsKey(ke)) throw new IOException("Identifiant inexistant!");
        else notes.remove(ke);
    }
}
