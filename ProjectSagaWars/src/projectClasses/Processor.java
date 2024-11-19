/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectClasses;
import auxClasses.LinkedList;

/**
 *
 * @author juanmendezl
 */
public class Processor {
    private String statusMain;
    private String statusAux;
    private int duration;
    private int probFight;
    private int probTie;
    private int probSkip;
    private LinkedList winnersL;
    private LinkedList winnersR;

    public Processor(int duration) {
        this.statusMain = "Deciding";
        this.statusAux = "Empty";
        this.duration = duration;
        this.probFight = 40;
        this.probTie = 27;
        this.probSkip = 33;
        this.winnersL = new LinkedList();
        this.winnersR = new LinkedList();
    }

    public String getStatusMain() {
        return statusMain;
    }

    public void setStatusMain(String statusMain) {
        this.statusMain = statusMain;
    }

    public String getStatusAux() {
        return statusAux;
    }

    public void setStatusAux(String statusAux) {
        this.statusAux = statusAux;
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

    public LinkedList getWinnersL() {
        return winnersL;
    }

    public void setWinnersL(LinkedList winners) {
        this.winnersL = winners;
    }
    
    public LinkedList getWinnersR() {
        return winnersR;
    }

    public void setWinnersR(LinkedList winners) {
        this.winnersR = winners;
    }
    
    public String determinate(Fighter fighterL, Fighter fighterR){
        statusMain = "Deciding";
        String result = null;
        double rand = Math.random() * 100;
        if (rand >= this.probFight + this.probTie) {
            result = this.skip(fighterL, fighterR);
        } else if (rand <= this.probFight) {
            result = this.fight(fighterL, fighterR);
        } else {
            result = this.tie(fighterL, fighterR);
        }
        return result; 
    }
    
    public String fight(Fighter fighterL, Fighter fighterR){
        statusMain = "Battling";
//        System.out.println("Currently fighting: " + fighterL.getName() + " Vs " + fighterR.getName());
        int qualityDiff = fighterL.getQuality() - fighterR.getQuality();
        int chance = (int) (Math.random() * 100);
        if (qualityDiff == 2) {
            if (chance <= 90){
                this.winnersL.addLast(fighterL);
//                System.out.println("Battle won by: " + fighterL.getName() + " " + fighterL.getId());
                statusAux = "Victory Left";
                return "left";
            } else {
                this.winnersR.addLast(fighterR);
//                System.out.println("Battle won by: " + fighterR.getName() + " " + fighterR.getId());
                statusAux = "Victory Right";
                return "right";}
            
        } else if (qualityDiff == 1) {
             if (chance <= 70){
                this.winnersL.addLast(fighterL);
//                System.out.println("Battle won by: " + fighterL.getName() + " " + fighterL.getId());
                statusAux = "Victory Left";
                return "left";
            } else {
                this.winnersR.addLast(fighterR);
//                System.out.println("Battle won by: " + fighterR.getName() + " " + fighterR.getId());
                statusAux = "Victory Right";
                return "right";}
             
        } else if (qualityDiff == -1) {
             if (chance <= 30){
                this.winnersL.addLast(fighterL);
//                System.out.println("Battle won by: " + fighterL.getName() + " " + fighterL.getId());
                statusAux = "Victory Left";
                return "left";
            } else {
                this.winnersR.addLast(fighterR);
//                System.out.println("Battle won by: " + fighterR.getName() + " " + fighterR.getId());
                statusAux = "Victory Right";
                return "right";}
             
        } else if (qualityDiff == -2) {
             if (chance <= 10){
                this.winnersL.addLast(fighterL);
//                System.out.println("Battle won by: " + fighterL.getName() + " " + fighterL.getId());
                statusAux = "Victory Left";
                return "left";
            } else {
                this.winnersR.addLast(fighterR);
//                System.out.println("Battle won by: " + fighterR.getName() + " " + fighterR.getId());
                statusAux = "Victory Right";
                return "right";}
             
        } else {
             if (chance <= 50){
                this.winnersL.addLast(fighterL);
//                System.out.println("Battle won by: " + fighterL.getName() + " " + fighterL.getId());
                statusAux = "Victory Left";
                return "left";
            } else {
                this.winnersR.addLast(fighterR);
//                System.out.println("Battle won by: " + fighterR.getName() + " " + fighterR.getId());
                statusAux = "Victory Right";
                return "right";}
        }
    }
    
    public String skip(Fighter fighterL,Fighter fighterR){
        statusMain = "Battling";
        statusAux = "Battle Skipped";
//        System.out.println("Battle Skipped");
        return statusAux;
    }
    
    public String tie(Fighter fighterL,Fighter fighterR){
        statusMain = "Battling";
        statusAux = "Battle Tied";
//        System.out.println("Battle Tied");
        return statusAux;
    }
}
