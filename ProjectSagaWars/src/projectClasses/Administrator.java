/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectClasses;
import projectClasses.Processor;
import projectClasses.Fighter;
import auxClasses.Queue;

/**
 *
 * @author juanmendezl
 */
public class Administrator {
    private Processor processor;
    private int cycles;
    private int cycleCounter;
    private int probCreate;
    private int fighterCounter;
    private String sagaR;
    private String sagaL;
    private String[] charactersR;
    private String[] charactersL;
    private Queue queueHighRight;
    private Queue queueMidRight;
    private Queue queueLowRight;
    private Queue queueAuxRight;
    private Queue queueHighLeft;
    private Queue queueMidLeft;
    private Queue queueLowLeft;
    private Queue queueAuxLeft;

    public Administrator(Processor processor) {
        this.processor = processor;
        this.cycles = 2;
        this.cycleCounter = 0;
        this.probCreate = 80;
        this.fighterCounter = 0;
        this.sagaR = "Star Wars";
        this.sagaL = "Star Trek";
        this.charactersR = new String[] {"Darth Vader", "Ben Kenobi", "Han Solo", "Chewbaca", "Princess Leia", "Master Yoda", "R2-D2", "C3PO", "Luke Skywalker", "Emperor Palpatine"};
        this.charactersL = new String[] {"Ambassador Spock", "Admiral Picard", "Officer Worf", "Captain Kirk", "Lieutenant Data", "Vice Admiral Janeway", "Dr. McCoy", "Commander Sisko", "Fleet Captain Pike", "Chief Engineer La Forge"};
        this.queueHighRight = new Queue();
        this.queueMidRight = new Queue();
        this.queueLowRight = new Queue();
        this.queueAuxRight = new Queue();
        this.queueHighLeft = new Queue();
        this.queueMidLeft = new Queue();
        this.queueLowLeft = new Queue();
        this.queueAuxLeft = new Queue();
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int getCycleCounter() {
        return cycleCounter;
    }

    public void setCycleCounter(int cycleCounter) {
        this.cycleCounter = cycleCounter;
    }

    public int getProbCreate() {
        return probCreate;
    }

    public void setProbCreate(int probCreate) {
        this.probCreate = probCreate;
    }

    public int getFighterCounter() {
        return fighterCounter;
    }

    public void setFighterCounter(int fighterCounter) {
        this.fighterCounter = fighterCounter;
    }

    public String getSagaR() {
        return sagaR;
    }

    public void setSagaR(String sagaR) {
        this.sagaR = sagaR;
    }

    public String getSagaL() {
        return sagaL;
    }

    public void setSagaL(String sagaL) {
        this.sagaL = sagaL;
    }

    public String[] getCharactersR() {
        return charactersR;
    }

    public void setCharactersR(String[] charactersR) {
        this.charactersR = charactersR;
    }

    public String[] getCharactersL() {
        return charactersL;
    }

    public void setCharactersL(String[] charactersL) {
        this.charactersL = charactersL;
    }
    

    public Queue getQueueHighRight() {
        return queueHighRight;
    }

    public void setQueueHighRight(Queue queueHighRight) {
        this.queueHighRight = queueHighRight;
    }

    public Queue getQueueMidRight() {
        return queueMidRight;
    }

    public void setQueueMidRight(Queue queueMidRight) {
        this.queueMidRight = queueMidRight;
    }

    public Queue getQueueLowRight() {
        return queueLowRight;
    }

    public void setQueueLowRight(Queue queueLowRight) {
        this.queueLowRight = queueLowRight;
    }

    public Queue getQueueAuxRight() {
        return queueAuxRight;
    }

    public void setQueueAuxRight(Queue queueAuxRight) {
        this.queueAuxRight = queueAuxRight;
    }

    public Queue getQueueHighLeft() {
        return queueHighLeft;
    }

    public void setQueueHighLeft(Queue queueHighLeft) {
        this.queueHighLeft = queueHighLeft;
    }

    public Queue getQueueMidLeft() {
        return queueMidLeft;
    }

    public void setQueueMidLeft(Queue queueMidLeft) {
        this.queueMidLeft = queueMidLeft;
    }

    public Queue getQueueLowLeft() {
        return queueLowLeft;
    }

    public void setQueueLowLeft(Queue queueLowLeft) {
        this.queueLowLeft = queueLowLeft;
    }

    public Queue getQueueAuxLeft() {
        return queueAuxLeft;
    }

    public void setQueueAuxLeft(Queue queueAuxLeft) {
        this.queueAuxLeft = queueAuxLeft;
    }
    
    
    public Fighter[] createFighters() {
        int count = this.fighterCounter;
        Fighter fighterL = new Fighter(count, sagaL,charactersL[(int) (Math.random() * 10)]);
        Fighter fighterR = new Fighter(count + 1, sagaR,charactersL[(int) (Math.random() * 10)]);
        return new Fighter[] {fighterL, fighterR};
    }
    
    public void initRun() {
        for (int i = 0; i < 10; i++) {
            this.createFighters();
        }
    }
    
    public void runCycle(){
        
    }
    
    public void adminFight(Fighter fighterL,Fighter fighterR) {
        String result = this.processor.determinate(fighterL, fighterR);
    }
}
