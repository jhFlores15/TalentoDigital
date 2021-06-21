package ListAssigment;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    //Los metodos de la SLL van aqui. Al principio, les mostraremos cómo agregar nodos a la lista.
    public void add(int value) {
        Node newNode = new Node(value);
        if(this.head == null) {
            this.head = newNode;
        } else {
            Node runner = this.head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    
    public void remove() {
    	 Node runner = this.head;
    	 Node runnerTemp =  this.head;
    	 
    	 if(this.head == null || this.head.next == null) {
    		 this.head = null;
    	 }
    	 else {
    		 while(runner.next != null) {
            	 runnerTemp = runner; //capturar el penultimo nodo
                 runner = runner.next;
             }
             
             runnerTemp.next = null;
    	 }
    	 
         
    }
    
    public void printValues() {
    	if(this.head == null) {
   		 System.out.println("Lista vacia");
   	 	}
    	else {
    		Node node = this.head;
    		while(node.next != null) {
    			System.out.println(node.value);
    			node = node.next;
    	    }
    		System.out.println(node.value);
    	}
    }
    
    public Node find(int value) {
    	if(this.head == null) {
      		return null;
      	}
       	else {
       		Node node = this.head;
       		while(node.next != null) {
       			if(node.value == value) {
       				return node;
       			}
       			node = node.next;
       	    }
       		if(node.value == value) {
   				return node;
   			}
       	}
    	
    	return null;
    }
    
    public void removeAt (int value) {
    	int item = 0;
    	if(this.head != null) {
    		Node node = this.head;
    		
    		if(value == 0 && node.next == null) {
   				this.head = null;
   			}
   			else if(value == 0 && node.next != null) {
   				if(node.next != null) {
   					this.head = node.next;
   				}
   				else {
   					this.head = null;
   				}
   			}
   			else {
   				while(node.next != null) {    			
   	    			Node nodeTemp = node;
   	       			node = node.next;
   	       			
   	       			if(item+1 == value && node.next != null) {
   	       				if(node.next != null) {
   	       					nodeTemp.next = node.next;
   	       				}
   	       				else {
   	       					nodeTemp.next = null;
   	       				}
   	       			}
   	       			else if (item+1 == value && node.next == null) {
   	       				nodeTemp.next = null;
   	       			}
   	    			
   	       			item++;
   	       	    }
   			}
    		
    		
    	}
    }
    
    
}