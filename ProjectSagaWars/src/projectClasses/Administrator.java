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
    private int probCreate;
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
        this.probCreate = 80;
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

    public int getProbCreate() {
        return probCreate;
    }

    public void setProbCreate(int probCreate) {
        this.probCreate = probCreate;
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
    
    public void createFighter() {
        
    }
    
    public void adminFight(Fighter fighterL,Fighter fighterR) {
        String result = this.processor.determinate(fighterL, fighterR);
    }
}
