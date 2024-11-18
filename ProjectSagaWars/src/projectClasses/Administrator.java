/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectClasses;
import auxClasses.Node;
import auxClasses.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    private Fighter activeFighterL;
    private Fighter activeFighterR;
    private Map<String, ImageIcon> fighterIcons = new HashMap<>();

    public Administrator(Processor processor) {
        preloadImages();
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
        this.activeFighterL = null;
        this.activeFighterR = null;
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

    public Fighter getActiveFighterL() {
        return activeFighterL;
    }

    public void setActiveFighterL(Fighter activeFighterL) {
        this.activeFighterL = activeFighterL;
    }

    public Fighter getActiveFighterR() {
        return activeFighterR;
    }

    public void setActiveFighterR(Fighter activeFighterR) {
        this.activeFighterR = activeFighterR;
    }
    
    public void createFighters() {
        int count = this.fighterCounter;
        Fighter fighterL = new Fighter(this.processor.getDuration(),count, sagaL, charactersL[(int) (Math.random() * 10)]);
        System.out.println("Created: " + fighterL.getName() + " with ID: " + fighterL.getId());
        Node nodeL = new Node(fighterL);
        Fighter fighterR = new Fighter(this.processor.getDuration(),(count + 1), sagaR, charactersR[(int) (Math.random() * 10)]);
        System.out.println("Created: " + fighterR.getName() + " with ID: " + fighterR.getId());
        Node nodeR = new Node(fighterR);
        switch (fighterL.getQuality()) {
            case 3 -> this.queueHighLeft.inqueue(nodeL);
            case 2 -> this.queueMidLeft.inqueue(nodeL);
            default -> this.queueLowLeft.inqueue(nodeL);
        }
        switch (fighterR.getQuality()) {
            case 3 -> this.queueHighRight.inqueue(nodeR);
            case 2 -> this.queueMidRight.inqueue(nodeR);
            default -> this.queueLowRight.inqueue(nodeR);
        }
        this.fighterCounter += 2;
    }
    
    public void initFighters() {
        for (int i = 0; i < 10; i++) {
            this.createFighters();
        }
    }
    
    public String adminFight() {
        
        System.out.println("\n");
        System.out.println("AL" + queueAuxLeft.getSize());
        System.out.println("LL" + queueLowLeft.getSize());
        System.out.println("ML" + queueMidLeft.getSize());
        System.out.println("HL" + queueHighLeft.getSize());
        System.out.println("AR" + queueAuxRight.getSize());
        System.out.println("LR" + queueLowRight.getSize());
        System.out.println("MR" + queueMidRight.getSize());
        System.out.println("HR" + queueHighRight.getSize());
        
        if (Math.random() * 100 <= probReinforce && !queueAuxLeft.isEmpty() && !queueAuxRight.isEmpty()){
            System.out.println("Assigned at aux 1");
            activeFighterL = queueAuxLeft.getFirst().getValue();
            queueAuxLeft.dequeue();
            activeFighterR = queueAuxRight.getFirst().getValue();
            queueAuxRight.dequeue();
        } else if (!queueHighLeft.isEmpty() && !queueHighRight.isEmpty()){
            System.out.println("Assigned at high");
            activeFighterL = queueHighLeft.getFirst().getValue();
            queueHighLeft.dequeue();
            activeFighterR = queueHighRight.getFirst().getValue();
            queueHighRight.dequeue();
        } else if (!queueMidLeft.isEmpty() && !queueMidRight.isEmpty()){
            System.out.println("Assigned at mid");
            activeFighterL = queueMidLeft.getFirst().getValue();
            queueMidLeft.dequeue();
            activeFighterR = queueMidRight.getFirst().getValue();
            queueMidRight.dequeue();
        } else if (!queueLowLeft.isEmpty() && !queueLowRight.isEmpty()){
            System.out.println("Assigned at low");
            activeFighterL = queueLowLeft.getFirst().getValue();
            queueLowLeft.dequeue();
            activeFighterR = queueLowRight.getFirst().getValue();
            queueLowRight.dequeue();
        } else if(!queueAuxLeft.isEmpty() && !queueAuxRight.isEmpty()){
            System.out.println("Assigned at aux 2");
            activeFighterL = queueAuxLeft.getFirst().getValue();
            queueAuxLeft.dequeue();
            activeFighterR = queueAuxRight.getFirst().getValue();
            queueAuxRight.dequeue();
        } else {
            this.initFighters();
            this.adminFight();
            return "skip";
        }
        
   
        if(activeFighterL != null && activeFighterR != null){
            System.out.println("\nAbout to fight: " + activeFighterL.getName() + " Vs. " + activeFighterR.getName());
            String result = this.processor.determinate(activeFighterL, activeFighterR);
            if (result.equals("Battle Tied")) {
                Node nodeL = new Node(activeFighterL);
                queueHighLeft.inqueue(nodeL);
                Node nodeR = new Node(activeFighterR);
                queueHighRight.inqueue(nodeR);
                return "tie";
            } else if (result.equals("Battle Skipped")){
                Node nodeL = new Node(activeFighterL);
                queueAuxLeft.inqueue(nodeL);
                Node nodeR = new Node(activeFighterR);
                queueAuxRight.inqueue(nodeR);
                return "skip";
            } else {
                activeFighterL = null;
                activeFighterR = null;
                return "victory";
            }
        }
        System.out.println("Didn't fight cause lack of fighters");
        System.out.println("#####################################\nCRITICAL ERROR\n#####################################");
        return "skip";
    }
    
    public Fighter checkQueues(Queue queue){
        Node node = queue.getFirst();
            for (int i = 0; i < queue.getSize(); i++) {
                Fighter fighter = node.getValue();
                if (fighter != null) {
//                    System.out.println(fighter.getId() + " " + fighter.getWaitCounter());
                    fighter.setWaitCounter(fighter.getWaitCounter() + 1);
                    if (fighter.getWaitCounter() >= fighter.getWaitLimit()) {
//                        System.out.println("Evolving");
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
        if (upAuxL != null) {
            upAuxL.evolve();
            queueAuxLeft.dequeue();
            queueLowLeft.inqueue(new Node(upAuxL));
        }
        Fighter upLowL = checkQueues(queueLowLeft);
        if (upLowL != null) {
            upLowL.evolve();
            queueLowLeft.dequeue();
            queueMidLeft.inqueue(new Node(upLowL));
        }
        Fighter upMidL = checkQueues(queueMidLeft);
        if (upMidL != null) {
            upMidL.evolve();
            queueMidLeft.dequeue();
            queueHighLeft.inqueue(new Node (upMidL));
        }
        Fighter upHighL = checkQueues(queueHighLeft);
        if (upMidL != null) {
            upHighL.evolve();
        }
       
        Fighter upAuxR = checkQueues(queueAuxRight);
        if (upAuxR != null) {
            upAuxR.evolve();
            queueAuxRight.dequeue();
            queueLowRight.inqueue(new Node(upAuxR));
        }
        Fighter upLowR = checkQueues(queueLowRight);
        if (upLowR != null) {
            upLowR.evolve();
            queueLowRight.dequeue();
            queueMidRight.inqueue(new Node(upLowR));
        }
        Fighter upMidR = checkQueues(queueMidRight);
        if (upMidR != null) {
            upMidR.evolve();
            queueMidRight.dequeue();
            queueHighRight.inqueue(new Node (upMidR));
        }
        Fighter upHighR = checkQueues(queueHighRight);
        if (upHighR != null) {
            upHighR.evolve();
        }
    }
    
    public ArrayList getQueueInfo(Queue queue){
        ArrayList<String> data = new ArrayList<String>();
        Node node = queue.getFirst();
        for (int i = 0; i < queue.getSize(); i++) {
            data.add(Integer.toString(node.getValue().getId()));
            data.add(node.getValue().getName());
            node = node.getNext();
        }
        return data;
    }
    
    public String formatQueueData(Queue queue) {
    ArrayList<String> data = getQueueInfo(queue);
    StringBuilder formattedData = new StringBuilder();
    for (int i = 0; i < data.size(); i += 2) { // Assuming alternating id and name
        formattedData.append("ID: ").append(data.get(i))
                     .append(", Name: ").append(data.get(i + 1))
                     .append("\n");
    }
    return formattedData.toString();
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
    
    private void preloadImages() {
    fighterIcons.put("Darth Vader", new ImageIcon(getClass().getResource("/projectInterface/fighters/darth vader.jpg")));
    fighterIcons.put("Ben Kenobi", new ImageIcon(getClass().getResource("/projectInterface/fighters/ben kenobi.jpg")));
    fighterIcons.put("Han Solo", new ImageIcon(getClass().getResource("/projectInterface/fighters/han solo.jpg")));
    fighterIcons.put("Chewbaca", new ImageIcon(getClass().getResource("/projectInterface/fighters/chewbaca.jpg")));
    fighterIcons.put("Princess Leia", new ImageIcon(getClass().getResource("/projectInterface/fighters/princess leia.jpg")));
    fighterIcons.put("Master Yoda", new ImageIcon(getClass().getResource("/projectInterface/fighters/master yoda.jpg")));
    fighterIcons.put("R2-D2", new ImageIcon(getClass().getResource("/projectInterface/fighters/r2-d2.jpg")));
    fighterIcons.put("C3PO", new ImageIcon(getClass().getResource("/projectInterface/fighters/c3po.jpg")));
    fighterIcons.put("Luke Skywalker", new ImageIcon(getClass().getResource("/projectInterface/fighters/Luke skywalker.jpg")));
    fighterIcons.put("Emperor Palpatine", new ImageIcon(getClass().getResource("/projectInterface/fighters/emperor palpatine.jpg")));
    fighterIcons.put("Ambassador Spock", new ImageIcon(getClass().getResource("/projectInterface/fighters/ambassador spock.jpg")));
    fighterIcons.put("Admiral Picard", new ImageIcon(getClass().getResource("/projectInterface/fighters/admiral picard.jpg")));
    fighterIcons.put("Officer Worf", new ImageIcon(getClass().getResource("/projectInterface/fighters/officer worf.jpg")));
    fighterIcons.put("Captain Kirk", new ImageIcon(getClass().getResource("/projectInterface/fighters/captain kirk.jpg")));
    fighterIcons.put("Lieutenant Data", new ImageIcon(getClass().getResource("/projectInterface/fighters/lieutenant data.jpg")));
    fighterIcons.put("Vice Admiral Janeway", new ImageIcon(getClass().getResource("/projectInterface/fighters/vice admiral janeway.jpg")));
    fighterIcons.put("Dr. McCoy", new ImageIcon(getClass().getResource("/projectInterface/fighters/dr. mccoy.jpg")));
    fighterIcons.put("Commander Sisko", new ImageIcon(getClass().getResource("/projectInterface/fighters/commander sisko.jpg")));
    fighterIcons.put("Fleet Captain Pike", new ImageIcon(getClass().getResource("/projectInterface/fighters/fleet captain pike.jpg")));
    fighterIcons.put("Chief Engineer La Forge", new ImageIcon(getClass().getResource("/projectInterface/fighters/chief engineer la forge.jpg")));
}
    
     public ImageIcon getFighterIcon(String fighterName) {
        return fighterIcons.get(fighterName);
    }

    public void setIconForLabel(JLabel label, String fighterName) {
        ImageIcon icon = fighterIcons.get(fighterName);
        if (icon != null) {
            label.setIcon(icon);
        } else {
            label.setIcon(null); // Handle missing images gracefully
        }
    }
}
