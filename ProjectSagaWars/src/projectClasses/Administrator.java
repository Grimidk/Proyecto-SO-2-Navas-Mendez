/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectClasses;
import auxClasses.Node;
import auxClasses.Queue;

/**
 *
 * @author juanmendezl
 */
public class Administrator{
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
    private int probReinforce;

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
        this.probReinforce = 80;
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

    public int getProbReinforce() {
        return probReinforce;
    }

    public void setProbReinforce(int probReinforce) {
        this.probReinforce = probReinforce;
    }
    
    public void createFighters() {
        int count = this.fighterCounter;
        Fighter fighterL = new Fighter(this.processor.getDuration(),count, sagaL, charactersL[(int) (Math.random() * 10)]);
        System.out.println("Created: " + fighterL.getName() + " with ID: " + fighterL.getId());
        Node nodeL = new Node(fighterL);
        Fighter fighterR = new Fighter(this.processor.getDuration(),(count + 1), sagaR, charactersR[(int) (Math.random() * 10)]);
        System.out.println("Created: " + fighterR.getName() + " with ID: " + fighterR.getId());
        Node nodeR = new Node(fighterR);
        if (fighterL.getQuality() == 3) {
            this.queueHighLeft.inqueue(nodeL);
        } else if (fighterL.getQuality() == 2){
            this.queueMidLeft.inqueue(nodeL);
        } else {
            this.queueLowLeft.inqueue(nodeL);
        }
        if (fighterR.getQuality() == 3) {
            this.queueHighRight.inqueue(nodeR);
        } else if (fighterL.getQuality() == 2){
            this.queueMidRight.inqueue(nodeR);
        } else {
            this.queueLowRight.inqueue(nodeR);
        }
        this.fighterCounter += 2;
    }
    
    public void initFighters() {
        for (int i = 0; i < 10; i++) {
            this.createFighters();
        }
    }
    
    public String adminFight() {
        Fighter fighterL = null;
        Fighter fighterR = null;
        
        System.out.println("AL" + queueAuxLeft.getSize());
        System.out.println("LL" + queueLowLeft.getSize());
        System.out.println("ML" + queueMidLeft.getSize());
        System.out.println("HL" + queueHighLeft.getSize());
        System.out.println("AR" + queueAuxRight.getSize());
        System.out.println("LR" + queueLowRight.getSize());
        System.out.println("MR" + queueMidRight.getSize());
        System.out.println("HR" + queueHighRight.getSize());
        
        if (Math.random() * 100 <= probReinforce && !queueAuxLeft.isEmpty() && !queueAuxRight.isEmpty()){
            fighterL = queueAuxLeft.getFirst().getValue();
            queueAuxLeft.dequeue();
            fighterR = queueAuxRight.getFirst().getValue();
            queueAuxRight.dequeue();
        } else if (!queueHighLeft.isEmpty() && !queueHighRight.isEmpty()){
            fighterL = queueHighLeft.getFirst().getValue();
            queueHighLeft.dequeue();
            fighterR = queueHighRight.getFirst().getValue();
            queueHighRight.dequeue();
        } else if (!queueMidLeft.isEmpty() && !queueMidRight.isEmpty()){
            fighterL = queueMidLeft.getFirst().getValue();
            queueMidLeft.dequeue();
            fighterR = queueMidRight.getFirst().getValue();
            queueMidRight.dequeue();
        } else if (!queueLowLeft.isEmpty() && !queueLowRight.isEmpty()){
            fighterL = queueLowLeft.getFirst().getValue();
            queueLowLeft.dequeue();
            fighterR = queueLowRight.getFirst().getValue();
            queueLowRight.dequeue();
        } else if(!queueAuxLeft.isEmpty() && !queueAuxRight.isEmpty()){
            fighterL = queueAuxLeft.getFirst().getValue();
            queueAuxLeft.dequeue();
            fighterR = queueAuxRight.getFirst().getValue();
            queueAuxRight.dequeue();
        } else {
            this.initFighters();
            this.adminFight();
        }
        
        System.out.println("About to fight: " + fighterL.getName() + " Vs. " + fighterR.getName());
        while(fighterL != null && fighterR != null){
            String result = this.processor.determinate(fighterL, fighterR);
            if (result.equals("tie")) {
                Node nodeL = new Node(fighterL);
                queueHighLeft.inqueue(nodeL);
                Node nodeR = new Node(fighterR);
                queueHighRight.inqueue(nodeR);
                return "tie";
            } else if (result.equals("skip")){
                Node nodeL = new Node(fighterL);
                queueAuxLeft.inqueue(nodeL);
                Node nodeR = new Node(fighterR);
                queueAuxRight.inqueue(nodeR);
                return "skip";
            } else {
                fighterL = null;
                fighterR = null;
                return "victory";
            }
        }
        return "skip";
    }
    
    public Fighter checkQueues(Queue queue){
        Node node = queue.getFirst();
            for (int i = 0; i < queue.getSize(); i++) {
                Fighter fighter = node.getValue();
                if (fighter != null) {
                    fighter.setWaitCounter(fighter.getWaitCounter() + 1);
                    if (fighter.getWaitCounter() >= fighter.getWaitLimit()) {
                        return fighter;
                    } else {
                        node = node.getNext();
                    }  
                }
            }
        return null;
    }
    
    public void adminQueues() {
        Fighter upAuxL = checkQueues(queueAuxLeft);
        if (upAuxL != null) {upAuxL.evolve();}
        Fighter upLowL = checkQueues(queueLowLeft);
        if (upLowL != null) {upLowL.evolve();}
        queueAuxLeft.dequeue();
        queueLowLeft.inqueue(new Node(upAuxL));
        Fighter upMidL = checkQueues(queueMidLeft);
        if (upMidL != null) {upMidL.evolve();}
        queueLowLeft.dequeue();
        queueMidLeft.inqueue(new Node(upLowL));
        Fighter upHighL = checkQueues(queueHighLeft);
        if (upMidL != null) {upHighL.evolve();}
        queueMidLeft.dequeue();
        queueHighLeft.inqueue(new Node (upMidL));
        
        Fighter upAuxR = checkQueues(queueAuxRight);
        if (upAuxR != null) {upAuxR.evolve();}
        Fighter upLowR = checkQueues(queueLowRight);
        if (upLowR != null) {upLowR.evolve();}
        queueAuxRight.dequeue();
        queueLowRight.inqueue(new Node(upAuxR));
        Fighter upMidR = checkQueues(queueMidRight);
        if (upMidR != null) {upMidR.evolve();}
        queueLowRight.dequeue();
        queueMidRight.inqueue(new Node(upLowR));
        Fighter upHighR = checkQueues(queueHighRight);
        if (upHighR != null) {upHighR.evolve();}
        queueMidRight.dequeue();
        queueHighRight.inqueue(new Node (upMidR));
    }
    
    public void adminRun(){
        adminFight();
        if (cycleCounter%cycles == 0) {
            if (Math.random() * 100 <= probCreate) {
                createFighters();
            }
        }
        adminQueues();
        
        System.out.println("\n");
        System.out.println("Cycles: " + cycleCounter);
        System.out.println("Total Figthers: " + fighterCounter);
        System.out.println("Winners Left: " + processor.getWinnersL().size());
        System.out.println("Winners Right: " + processor.getWinnersR().size());
        cycleCounter += 1;
    }
}
