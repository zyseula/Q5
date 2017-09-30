
public class Trinary {
	public Trinary(){
		
	}
	
	public void trinary(int key, int start, int end, int[] array, int searchtime){
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
				searchtime++;
				System.out.println("Trinary "+searchtime+"th search, ");
				System.out.println("array["+(end-1)+"] is "+array[end-1]);
				System.out.println("Success! Key number is in position "+(end-1)+". The number of comparisons is "+searchtime);
			}
			else if(array[end]==key){
				searchtime += 2;
				System.out.println("Trinary "+searchtime+"th search, ");
				System.out.println("array["+end+"] is "+array[end]);
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
	
	public void binary(int key, int start, int end, int[] array, int searchtime){
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
				System.out.println("array["+start+"] is "+array[start]);
				System.out.println("Success! Key number is in position"+start+". The number of comparisons is"+searchtime);
		    }
			else if(array[end]==key){
				System.out.println("array["+end+"] is "+array[end]);
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
