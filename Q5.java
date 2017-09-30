

public class Q5 {

	public static void main(String[] args) {
		int[] array=new int[1500];
		array[0]=(int) Math.ceil(Math.random() * 100);
		int increment=(int) Math.ceil(Math.random() * 100);
		for(int i=1;i<1500;i++){
			array[i]=array[i-1]+increment;
		}
		int key=(int) Math.ceil(Math.random() * 10000);
        int searchtime=0;
        System.out.println("Searching start.....");
        System.out.println("Target number is: "+key);
        trinary(key,0,1499,array,searchtime);
	}
	
	public static void trinary(int key, int start, int end, int[] array, int searchtime){
		searchtime++;
		int pivot=(end-start)/3+start;
		System.out.println("Trinary "+searchtime+"th search, ");
		System.out.println("start is "+start+", end is "+end);
		System.out.println("array["+pivot+"] is "+array[pivot]);
		//TODO: Implement new feature to track searching time 
		if(key==array[pivot]){
			System.out.println("Success! Key number is in position"+pivot+". The number of comparisons is "+searchtime);
		}
		else if((end-start)<=2){
			if(array[start]==key){
				System.out.println("Success! Key number is in position"+start+". The number of comparisons is "+searchtime);
		    }
			else if(array[end-1]==key){
				System.out.println("Success! Key number is in position "+(end-1)+". The number of comparisons is "+searchtime);
			}
			else if(array[end]==key){
				System.out.println("Success! Key number is in position "+end+". The number of comparisons is "+searchtime);
			}
			else
				System.out.println("Failure! The number of comparisons is "+searchtime);
		}
		else{
			if(key<array[pivot]){
				trinary(key,start,pivot,array,searchtime);
			}
			else 
				binary(key,pivot,end,array,searchtime);
		}
	}
	
	public static void binary(int key, int start, int end, int[] array, int searchtime){
		searchtime++;
		System.out.println("Binary "+searchtime+"th search, ");
		System.out.println("start is "+start+", end is "+end);
		int pivot=(end-start)/2+start;
		System.out.println("array["+pivot+"] is "+array[pivot]);
		if(key==array[pivot]){
			System.out.println("Success! Key number is in position"+pivot+". The number of comparisons is"+searchtime);
		}
		else
		{
			if((end-start)==1){
			if(array[start]==key){
				System.out.println("Success! Key number is in position"+start+". The number of comparisons is"+searchtime);
		    }
			else if(array[end]==key){
				System.out.println("Success! Key number is in position"+end+". The number of comparisons is"+searchtime);
			}
			else
				System.out.println("Failure! The number of comparisons is"+searchtime);
		}
		else{
			if(key<array[pivot])
				trinary(key,start,pivot,array,searchtime);
			else
				trinary(key,pivot,end,array,searchtime);
		}
		}
	
	}

}
