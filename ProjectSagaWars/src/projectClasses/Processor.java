/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectClasses;
import projectClasses.Fighter;

/**
 *
 * @author juanmendezl
 */
public class Processor {
    private int duration;
    private int probFight;
    private int probTie;
    private int probSkip;
//    private LinkedList winners;

    public Processor(int duration) {
        this.duration = duration;
        this.probFight = 40;
        this.probTie = 27;
        this.probSkip = 33;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getProbFight() {
        return probFight;
    }

    public void setProbFight(int probFight) {
        this.probFight = probFight;
    }

    public int getProbTie() {
        return probTie;
    }

    public void setProbTie(int probTie) {
        this.probTie = probTie;
    }

    public int getProbSkip() {
        return probSkip;
    }

    public void setProbSkip(int probSkip) {
        this.probSkip = probSkip;
    }
    
    public final void determinate(Fighter fighter1, Fighter fighter2){
        double rand = Math.random() * 100;
        if (rand >= this.probFight + this.probTie) {
            this.skip(fighter1, fighter2);
        } else if (rand <= this.probFight) {
            this.fight(fighter1, fighter2);
        } else {
            this.tie(fighter1, fighter2);
        }
    }
    
    public final void fight(Fighter fighter1,Fighter fighter2){
        
    }
    
    public final void skip(Fighter fighter1,Fighter fighter2){
        
    }
    
    public final void tie(Fighter fighter1,Fighter fighter2){
        
    }
}
