
public class LinkedListQ5 {
		private Node head;
		//LinkedList constructor
		public LinkedListQ5(){
			head=new Node();
		}
		public void add(int data){
			Node temp=new Node(data);
			Node current=head;
			while(current.getNext()!=null){
				current=current.getNext();
			}
			current.setNext(temp);
		}
		public Node getHead(){
			return head;
		}
		
		public void setHead(Node node){
			head=node;
		}
		
		public void print(){
			Node current=head.getNext();
			while(current!=null){
				System.out.print("["+current.getData()+"]  ");
				current=current.getNext();
			}
		}
		
		public void reverse(Node node) {
	        Node previous=null;
	        Node current=node.getNext();
	        Node next=null;
	        while(current!=null){
	        	next=current.getNext();
	        	current.setNext(previous);
	        	previous=current;
	        	current=next;
	        }
	        head.setNext(previous);
	    
	    }
		//Node Class
		private class Node{
			Node next;
			int data;
			
			public Node() {
			}
			
			public Node(int _data){
				next = null;
				data = _data;
			}
		
			public int getData(){
				return data;
			}
			
			public Node getNext(){
				return next;
			}
			
			public void setNext(Node _next){
				next=_next;
			}
		}

}

