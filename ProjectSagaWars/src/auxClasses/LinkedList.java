/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxClasses;

import projectClasses.Fighter;

/**
 *
 * @author vadau
 * @param <T>
 */
public class LinkedList<T> {
    
    private Node head;
    private Node tail;
    
    public LinkedList(){
    
        this.head = null;
        this.tail = null;
    }
    
    public LinkedList(Node n){
        this.head = n;
        this.tail = n;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    
    }
    
    public int size(){
        int i = 0;
                
        if (isEmpty()){
            return 0;
        }
        
        Node aux = this.head;
            while(aux != null){
               aux = aux.getNext();
               i++;   
            }
        return i;
        
    }
    
    public void addFirst(Fighter value){
        Node n = new Node(value);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            n.setNext(this.head);
            this.head = n;
        }      
    }
    
    public void addLast(Fighter value){
        Node n = new Node(value);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(n);
            this.tail = n; 
        }
    }
    
    public void insert(Fighter value, int i){
        if (isEmpty() || i == 0) {
            this.addFirst(value);
        } else if (i >= (size() - 1)){
            this.addLast(value);
        }else if(i < 0) {
            this.insert(value, size() + i);
        } else {
            Node n = new Node(value);
            Node aux = this.head;
            int counter = 0;
            while(counter < i - 1){
                aux = aux.getNext();
                counter++;
            }
            n.setNext(aux.getNext());
            aux.setNext(n);
        }
    }
    
    public Fighter deleteFirst(){
        if (isEmpty()){
            return null;
        }
        Node temp = this.head;
        this.head = this.head.getNext();
        temp.setNext(null);
        return temp.getValue();
    }
    
    public Fighter deleteLast(){
        if (isEmpty()){
            return null;
        }
        Node aux = this.head;
        while(aux.getNext().getNext() != null){
            aux = aux.getNext();
        }
        Node temp = aux.getNext();
        aux.setNext(null);
        this.tail = aux;
        temp.setNext(null);
        return temp.getValue();
    }
    
    public Fighter delete(int i){
        if (isEmpty()){
            return null;
        } else if(i == 0){
            return deleteFirst();
        } else if(i == (size() - 1)){
            return deleteLast();
        } else if(i < 0){
            return this.delete(size() + i);
        } else if(i > size()){
            System.out.println("Error. Índice inválido.");
            return null;
        } else{
            Node aux = this.head;
            int counter = 0;
            while(counter < i - 1){
                aux = aux.getNext();
                counter++;
            }
            Node temp = aux.getNext();
            aux.setNext(temp.getNext());
            temp.setNext(null);
            return temp.getValue();
        }
    }
    
    public void print(){
        if (isEmpty()){
            System.out.println("Lista Vacía.");
        }else{
            Node aux = this.head;
            int i = 0;
            while(aux != null){
                System.out.print(aux.getValue() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            }
        }
    }
    
    public int search(T value){
        if (isEmpty()){
            return -1;
        } else {
            Node aux = this.head;
            int counter = 0;
            while(aux != null){
                if(value.equals(aux.getValue())){
                    return counter;
                }
                counter++;
                aux = aux.getNext();                      
            }
        return -1;
        }    
    }
    
//    public void sort(){
//        Node current = this.head;
//        Node  next = null;
//        T temp;
//        
//        if (isEmpty()) {
//        }
//        
//        while(current != null){
//            next = current.getNext();
//            while(next != null){                
////                if (current.getValue() > next.getValue()){
//                if (Node.comparator(current, next) > 0){
//                    temp = current.getValue();
//                    current.setValue(next.getValue());
//                    next.setValue(temp);
//                }
//                next = next.getNext();
//            }
//            current = current.getNext();
//        }
//        
//    }
    
//    public void sortReverse(){
//        Node<T> current = this.head;
//        Node <T> next = null;
//        
//        T temp;
//        
//        if (isEmpty()) {
//        }
//        
//        while(current != null){
//            next = current.getNext();
//            while(next != null){                
//                if (Node.comparator(current, next) < 0){
//                    temp = current.getValue();
//                    current.setValue(next.getValue());
//                    next.setValue(temp);
//                }
//                next = next.getNext();
//            }
//            current = current.getNext();
//        }
//        
//    }
    
    public Fighter getLast(){
        if(isEmpty()){
            return null;
        }
        return this.tail.getValue();
    }
    
    public Fighter getFirst(){
        if(isEmpty()){
            return null;
        }
        return this.head.getValue();
    }
    
    public Fighter get(int i){
        if(isEmpty()){
            return null;
        } else if(i > size()){
            System.out.println("Error. Índice inválido.");
            return null;
        } else if(i < 0){
            return this.get(size() + i);
        } else {
            Node n = this.head;
            for(int counter = 0; counter < i; counter++){
                n = n.getNext();
            }
            return n.getValue();   
        }
    }

    public void set(Fighter value, int i){
        if (isEmpty()){
            Node n = new Node(value);
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else if (i > size()){
            System.out.println("Error. Índice inválido.");
        } else if (i < 0) {
            this.set(value, size() + i);
        } else {
            Node aux = this.head;
            for (int counter = 0; counter < i; counter ++){
                aux = aux.getNext();
            }
            aux.setValue(value);
        }
        
    }
    
//    public boolean isSorted(){
//        if (isEmpty()){
//            return true;
//        } else {
//            boolean asc = true;
//            boolean des = true;
//            Node<T> current = this.head;
//            Node<T> aux = current.getNext();
//            while(aux != null){
//                if (Node.comparator(current, aux) > 0){
//                    asc = false;
//                } else if(Node.comparator(current, aux) < 0) {
//                    des = false;
//                } if (des == false && asc == false) {
//                    return false;
//                }
//                current = aux;
//                aux = aux.getNext();    
//            }  
//            return true; 
//        }
//    }
    
    public int count(Fighter value){
        if (isEmpty()){
            return 0;
        } else {
            Node aux = this.head;
            int counter = 0;
            while(aux != null){
                if(value.equals(aux.getValue())){
                    counter++;
                }
                aux = aux.getNext();
            }
            return counter;
        }
    }
    
//    private void insertAsc(T value){
//        Node<T> n = new Node(value);
//        Node<T> aux = this.head;
//        if (Node.comparator(n, head) < 0){
//            this.addFirst(value);
//        } else {
//            while(Node.comparator(n, aux) > 0 && aux.getNext() != null){
//                aux = aux.getNext();
//            }
//            if (aux.getNext() == null){
//                this.addLast(value);
//            } else{
//                n.setNext(aux.getNext());
//                aux.setNext(n);
//            }
//        }
//    }
//    
//    private void insertDes(T value){
//        Node<T> n = new Node(value);
//        Node<T> aux = this.head;
//        if (Node.comparator(n, head) > 0){
//            this.addFirst(value);
//        } else {
//            while(Node.comparator(n, aux) < 0 && aux.getNext() != null){
//                aux = aux.getNext();
//            }
//            if (aux.getNext() == null){
//                this.addLast(value);
//            } else{
//                n.setNext(aux.getNext());
//                aux.setNext(n);
//            }
//        }
//    }
//    
//    public void insertSort(T value){
//        if (!isSorted()){
//            System.out.println("La lista no se encuentra ordenada.");
//        } else {
//            if(isEmpty()){
//                this.addFirst(value);
//            } else {
//                boolean asc = false;
//                boolean des = false;
//                Node<T> current = this.head;
//                Node<T> aux = current.getNext();
//                while(aux != null){
//                    if(Node.comparator(current, aux) <= 0) {
//                        asc = true;
//                    } else if (Node.comparator(current, aux) > 0){
//                        des = true;
//                    } if (des == true || asc == true){
//                        break;
//                    }
//                } if (asc == true) {
//                    this.insertAsc(value);
//                } else {
//                    this.insertDes(value);
//                }
//                
//            }
//        }
//    
//    }
}

