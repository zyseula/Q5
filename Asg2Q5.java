

public class Asg2Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListQ5 linkedlist=new LinkedListQ5();
		int number=0;
		for(int i=1;i<=10;i++){
			number +=(int) Math.ceil(Math.random() * 50);
			linkedlist.add(number);
		}	
		System.out.println("The original linked list is:");
		linkedlist.print();
		System.out.println();
		linkedlist.reverse(linkedlist.getHead());
		System.out.println("The reversed linked list is:");
		linkedlist.print();
		System.out.println();
	}

}
