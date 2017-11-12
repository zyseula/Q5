
public class heap {
	final int heapLength = 45;
	//final boolean  minheap = true;
	
	double [] array = new double[heapLength];
	int endNode;
	
	public heap(){
		endNode = 0;
	}
	
	public void insert(double GPA){
		array[endNode] = GPA;
		int temp = endNode;
		UPHeapBalance(temp);
		endNode++;
	}
	
	public double removeMin(){
		double temp = array[0];
		array[0] = array[endNode-1];
		array[endNode-1] = 0;
		endNode --;
		DownHeapBalance(0);
		return temp;
	}
	
	public void DownHeapBalance(int index){
		if(array[index] == 0)
			return;
		if(index > heapLength)
			return;
		if(array[(index+1)*2-1] < array[index]){
			double temp = array[index];
			array[index] = array[(index+1)*2-1];
			array[(index+1)*2-1] = temp;
			DownHeapBalance((index+1)*2-1);
		}
		else if(array[(index+1)*2] < array[index]){
			double temp = array[index];
			array[index] = array[(index+1)*2];
			array[(index+1)*2] = temp;
			DownHeapBalance((index+1)*2-1);
		}
	}
	
	private void UPHeapBalance(int index){
		if(index < 0 )
			return;
		if(array[index] < array[(index-1)/2]){
			double temp = array[index];
			array[index] =  array[(index-1)/2];
			array[(index-1)/2] = temp;
			UPHeapBalance((index-1)/2);
		}
		else
			return;
	}
	
	public void print(){
		int count = 0;
		for(int i = 0;i<6;i++){
			if(Math.pow(2, i)-1 ==63){
				
			}
			else{
				for(int j = 0;j<(64-Math.pow(2, i))/2;j++){
					System.out.print("   ");
				}
			}
			for(int k=0;k<Math.pow(2, i);k++){
				if(count>=45)
					System.out.print("");
				else
					System.out.print(array[count]+" ");
				count++;
			}
			System.out.println();
			System.out.println();
		}
	}
}
