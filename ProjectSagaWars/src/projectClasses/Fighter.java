/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectClasses;

/**
 *
 * @author juanmendezl
 */
public class Fighter {
    private int id;
    private String saga;
    private String name;
    private int waitCounter;
    private boolean healthStat;
    private boolean attackStat;
    private boolean speedStat;
    private boolean skillStat;
    private int qualityCounter;
    private int quality;

    public Fighter(int id, String saga, String name) {
        this.id = id;
        this.saga = saga;
        this.name = name;
        this.waitCounter = 0;
        this.healthStat = (Math.random() * 100) >= 70;
        this.attackStat = (Math.random() * 100) >= 50;
        this.speedStat = (Math.random() * 100) >= 40;
        this.skillStat = (Math.random() * 100) >= 60;
        this.makeQuality();
    }
    
    public final void makeQuality(){
        if(this.healthStat) {this.qualityCounter += 1;}
        if(this.attackStat) {this.qualityCounter += 1;}
        if(this.speedStat) {this.qualityCounter += 1;}
        if(this.skillStat) {this.qualityCounter += 1;}

        if(this.qualityCounter >= 4) {this.quality = 3;}
        else if(this.qualityCounter >= 2) {this.quality = 2;}
        else {this.quality = 1;}
    }
    
    public final void evolve(){
        if(!this.healthStat) {
            this.healthStat = true;
            this.makeQuality();
        } else if(!this.attackStat) {
            this.attackStat = true;
            this.makeQuality();
        } else if(!this.speedStat) {
            this.speedStat = true;
            this.makeQuality();
        } else if(!this.skillStat) {
            this.skillStat = true;
            this.makeQuality();
        } else {
            this.makeQuality();
        }
    }
    
    public int getQuality() {
        return quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaitCounter() {
        return waitCounter;
    }

    public void setWaitCounter(int waitCounter) {
        this.waitCounter = waitCounter;
    }

    public boolean isHealthStat() {
        return healthStat;
    }

    public void setHealthStat(boolean healthStat) {
        this.healthStat = healthStat;
    }

    public boolean isAttackStat() {
        return attackStat;
    }

    public void setAttackStat(boolean attackStat) {
        this.attackStat = attackStat;
    }

    public boolean isSpeedStat() {
        return speedStat;
    }

    public void setSpeedStat(boolean speedStat) {
        this.speedStat = speedStat;
    }

    public boolean isSkillStat() {
        return skillStat;
    }

    public void setSkillStat(boolean skillStat) {
        this.skillStat = skillStat;
    }
    
    
}
