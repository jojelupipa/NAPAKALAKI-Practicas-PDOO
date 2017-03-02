/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Robles Urquiza
 */
public class BadConsequence {
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        
        this.death = false;
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, boolean death){
        
        this.text = text;
        this.death = death;
        this.levels = 100;
        this.nVisibleTreasures = 100;
        this.nHiddenTreasures = 100;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
   
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,ArrayList<TreasureKind> tHidden){
    
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = new ArrayList();
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = new ArrayList();
        this.specificHiddenTreasures = tHidden;
        this.death = false;
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();
        
    }
    /*   INNECESARIOS, se puede poner un array vacío en su lugar // BORRAR
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,int zero){
    
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = new ArrayList();
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = new ArrayList(); 
        this.death = false;
        this.nVisibleTreasures = specificVisibleTreasures.size();
        zero = 0;
        this.nHiddenTreasures = zero;
    }
    
    public BadConsequence(String text, int levels, int zero, ArrayList<TreasureKind> tHidden){
    
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
        this.specificHiddenTreasures = tHidden;
        this.death = false;
        zero = 0;
        this.nVisibleTreasures = zero;
        this.nHiddenTreasures = tHidden.size();
        
    }
    */
    
    
    public void setText(String text){
       this.text = text;
    }
    
    public void setLevels(int levels){
       this.levels = levels;
    }
    
    public void setnVisibleTreasures(int nVisibleTreasures){
       this.nVisibleTreasures = nVisibleTreasures;
    }
    
    public void setnHiddenTreasures(int nHiddenTreasures){
       this.nHiddenTreasures = nHiddenTreasures;
    }
    
    public void setDeath(boolean death){
       this.death = death;
    }
    
    public void setVisibleTreasures(ArrayList<TreasureKind> specificVisibleTreasures){
       this.specificVisibleTreasures = specificVisibleTreasures;
    }
    
    public void setHiddenTreasures(ArrayList<TreasureKind> specificHiddenTreasures){
       this.specificHiddenTreasures = specificHiddenTreasures;
    }

    public String getText(){
       return this.text;
    }
    
    public int getLevels(){
        return this.levels;
    }
    
    public int getnVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return this.death;
    }
    
    public ArrayList<TreasureKind> getsVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getsHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    
    
    
    public String toString(){
        if(death){
            return "\"" + text +"\". Pierdes todos tus niveles y todos tus objetos.";
        }
        else if(nVisibleTreasures.size() > 0){            
            String mensaje;
            mensaje = "\"" + text +"\". Pierdes "; // Hay que terminarlo
            + specificVisibleTreasures +
            
            mensaje += " visibles y" +specificVisibleTreasures +" ocultos.";
        }
        else{
            return "\"" + text +"\". Pierdes " + Integer.toString(levels) + " niveles, "+ Integer.toString(nVisibleTreasures) + " tesoros visibles y " + Integer.toString(nHiddenTreasures) + " tesoros ocultos.";
        }
    }
    
    

}

