
public class PureBinarySearch {
	public PureBinarySearch(){
		
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
			if(key<array[pivot])
				binary(key,start,pivot,array,searchtime);
			else
				binary(key,pivot,end,array,searchtime);
		}
	}
}
