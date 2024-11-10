/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxClasses;

/**
 *
 * @author vadau
 */
public class Queue {
    
    private Node head;
    private Node tail;
    private int size;
    
    public Queue(){
    
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void empty(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    
    }
    
    public void inqueue(Node n){
        if (isEmpty()){
            this.head = n;
            this.tail = n;
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
        size++;
    }
    
    public void dequeue(){
        if (isEmpty()){
        } else if (size == 1) {
            this.empty();
        } else {     
            this.head = this.head.getNext();
            size--;
        }
    }  
    
    public Node getFirst(){
        return head;
    }
    
    public int getSize(){
        return size;
    }
    
}
