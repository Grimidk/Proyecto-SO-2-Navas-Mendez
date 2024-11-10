package auxClasses;

/**
 *
 * @author vadau
 * @param <T>
 */
public class Node<T>{
    
    private Node next;
    private Node previous;
    private T value;
    
    public Node(T value){
        this.value = value;
        this.next = null;
        this.previous = null;
                
    }
    
    // Next
    
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    // Previous
    
    public Node getPrev(){
        return previous;
    }
    
    public void setPrev(Node previous){
        this.previous = previous;
    }
    
    
    // Value
    
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static int comparator(Node firstNode, Node secondNode){
        String firstClass = firstNode.getValue().getClass().getSimpleName();
        String secondClass = firstNode.getValue().getClass().getSimpleName();
        if (!firstClass.equals(secondClass)){
            throw new Error("Nodos son distintos tipos de data.");
        }
        switch(firstClass) {
            case "Integer":
                Integer firstDataInteger = (Integer)firstNode.getValue();
                Integer secondDataInteger = (Integer)secondNode.getValue();
                if (firstDataInteger > secondDataInteger){
                    return 1;
                }else if (secondDataInteger > firstDataInteger){
                    return -1;
                }else{
                    return 0;
                }
                
            case "Double":
                Double firstDataDouble = (Double)firstNode.getValue();
                Double secondDataDouble = (Double)secondNode.getValue();
                if (firstDataDouble > secondDataDouble){
                    return 1;
                }else if (secondDataDouble > firstDataDouble){
                    return -1;
                }else{
                    return 0;
                }
            case "String":
                String firstDataString = (String)firstNode.getValue();
                String secondDataString = (String)secondNode.getValue();
                if (firstDataString.length() > secondDataString.length()){
                    return 1;
                } else if (secondDataString.length() > firstDataString.length()){
                    return -1;
                } else {
                    return 0;
                }
           
        }        
        return 0;               
    }
}

