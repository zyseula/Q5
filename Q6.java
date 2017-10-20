import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream("/Users/mac/Documents/workspace/5511Asg2Q6/src/ds17s-asg2-data.txt"));//ds17s-asg2-data
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found or could not be opened.");
			System.exit(0);
		}
		
		int number = 0;
		int index = 0;
		while (inputStream.hasNextLine()) {
		    String line = inputStream.nextLine(); 
		    number++;
		}
		inputStream.close();
		String[] name = new String[number];
		
		Scanner inputStream_1 = null;
		try{
			inputStream_1 = new Scanner(new FileInputStream("/Users/mac/Documents/workspace/5511Asg2Q6/src/ds17s-asg2-data.txt"));//ds17s-asg2-data
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found or could not be opened.");
			System.exit(0);
		}
		while (inputStream_1.hasNextLine()) {
			name[index] = inputStream_1.nextLine().trim();
			index++;
		}
		inputStream_1.close();
		/*System.out.println("Let's use seletion sort!");
		System.out.println(LocalDateTime.now());
		SelectionSort(name);
		System.out.println(LocalDateTime.now());
		System.out.println();*/
		System.out.println(LocalDateTime.now());
		QuickSort(name,0,number-1);
		System.out.println(LocalDateTime.now());
		System.out.println("Let's use quick sort!");
		for(int k=0;k<name.length;k++){
			System.out.println(name[k]);
		}
		
	}
	
	public static void SelectionSort(String[] name){
		for(int i=0;i<name.length;i++){
			for(int j=i+1;j<name.length;j++){
				if(name[i].compareToIgnoreCase(name[j])>0){
					String temp = name[i];
					name[i] = name[j];
					name[j] = temp;
				}
			}	
		}
	}
	
	public static void QuickSort(String[] name, int i, int j){
		if(j<=i)
			{
				return;
			}
		if(j-i==1){
			if(name[i].compareToIgnoreCase(name[j])>0){
				String temp = name[i];
				name[i] = name[j];
				name[j] = temp;
			}
			return;
		}
		
		/*for(int k=0;k<name.length;k++)
			System.out.println(k+" "+name[k]);*/
		int index = Partition(name, i, j);
		QuickSort(name,i,index-1); 
		QuickSort(name,index,j);
	}
	public static int Partition(String[] name, int i, int j){
		int pivotindex=j;
		String privotString = name[pivotindex];
		//System.out.println("pivotindex is "+j+", privotString is "+name[pivotindex]);
		while(i < j){
			while(name[i].compareToIgnoreCase(privotString)<0&&i<j)
			{
				//System.out.println("fetching next i "+i);
				i++;
			}
			//System.out.println("i is "+i+", string in index i is "+name[i]+", compare to pivot string is "+
			//		name[i].compareToIgnoreCase(privotString));
			while(name[j].compareToIgnoreCase(privotString)>0&&j>i)
			{
				j--;
			}
			//System.out.println("j is "+j+", string in index j is "+name[j]+", compare to pivot string is "+
			//		name[j].compareToIgnoreCase(privotString));
			if(name[i].compareToIgnoreCase(name[j]) >=0 && j>i){
				//System.out.println("swaping i and j... ");
				if(i == pivotindex)
					pivotindex = j;
				if(j == pivotindex)
					pivotindex = i;
				String temp = name[i];
				name[i] = name[j];
				name[j] = temp;
				if(j-i == 1)
				{
					//System.out.println("loop ends... ");
					break;
				}
				i++;
				if(j-i == 1)
				{
				}
				else if(j >0)
					j--;
			}
		}
		if(pivotindex <=i && name[i].compareToIgnoreCase(name[pivotindex]) <=0){
			//System.out.println(name[pivotindex]+" "+pivotindex+" + "+i+" "+name[i]);
			String temp = name[i];
			name[i] = name[pivotindex];
			name[pivotindex] = temp;
		}
		return i;
	}
}

