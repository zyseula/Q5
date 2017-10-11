//This is singlylinkedlist that shows each element and the number of element by using two methods,
//iterate and recursive.
import java.util.Scanner;

public class SinglyLinkedList {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//Enter numbers by console
		Scanner kb=new Scanner(System.in);
		linkList list =new linkList();
		do{
		System.out.print( "Enter integer number: ");		
		list.insertAt(kb.nextInt());
		System.out.println( "Do you want to continue? Y/N ");	
		}while(kb.next().charAt(0)== 'y');	
		list.display();
		list.getSizeIterator();
		System.out.println("The number of element recusively is: "+ list.getSizeRecusive(list.head));
		kb.close();
	}
}
//This class create each element with two things, value, pointer.
class Node{
	protected int data;
	protected Node next;
	
	//This is a constructor for initializing the instance variables.
	public Node(){
		data=0;
		next=null;		
	}
	//Constructor 
	public Node(int value){
		data=value;
		next=null;
	}
	public void setData(int d){
		data=d;		
	}
	public void setNext(Node n){
		next=n;
	}
	public int getData(){
		return data;
	}
	public Node getNext(){
		return next;
	}	
	public void display(){
		System.out.println(data);
	}
}

//This class is used to connect, insert, and display elements
class linkList{
	protected Node head;
	protected Node tail;
	 public void insertAt(int data){
		    if(head == null){ 
		    head = new Node(data);     
		    return;
		     } 
		    tail().next = new Node(data);
		     }
		   private Node tail() {
		    Node tail = head; // Find last element of linked list known as tail
		    while(tail.next != null){
		     tail = tail.next;
		      }
		       return tail; 
		      }	
//This method is used to display the number of elements iteratively.	   
	 public void getSizeIterator(){
		 int count=0;
		 Node curr=head;
		 while (curr !=null){
			 count++;
			 curr=curr.next;
		 }
		 System.out.println("The number of element iterately is: "+count);
	 }
//	This method is used to display the number of elements recursively.	   
	 public int getSizeRecusive(Node node){
		 if (node==null)
			 return 0;
		 return 1+ getSizeRecusive(node.next);			 
	 }
//This method is used to display elements.	  	 
	public void display(){
		if(head==null){
			return;
		}
		Node current=head;
		while(current!=null){
			System.out.print(current.data + "-->>");
			current=current.next;						
		}	
		System.out.println(current+"\n");
	}	
}
