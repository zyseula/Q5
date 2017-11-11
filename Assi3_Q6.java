import java.io.*;
import java.util.*;
public class Assi3_Q6 {	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);	
		HashFunction ht=new HashFunction();
		File file =new File ("C:\\Users\\h_hajiba\\Desktop\\ds17s-asg2-data.txt");
		BufferedReader br=null;
		try {			
			FileReader fr= new FileReader(file);
		     br= new BufferedReader(fr);						
			String lines;	
			while((lines=br.readLine())!= null){
	//			System.out.println(lines);
				ht.addVal(lines.trim());
			}
			
		}catch (FileNotFoundException e){
			
			System.out.println("File not Found"+file.toString());		
		}catch (IOException e){
			System.out.println("Unable to Read file"+file.toString());			
		}
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Unable to Close file"+file.toString());	
		} catch (NullPointerException ex) {
			//File probably never opened.	
		}
		System.out.println( "Please Enter Search Key \"Surname, Name\": ");
		String str=kb.nextLine();
		if(ht.SearchKey(str.trim())== null)
			System.out.println("Sorry, Result Not Found.");		
		kb.close();
		
			

}
	
	

}
class HashFunction{
	
	public Object SearchKey;
	private String key;
	private final int M=2657;
	private String [] HT;
	
	
	public HashFunction(){	
		HT=new String [M];
		for(int i=0; i < HT.length; i++){
			HT[i]= null;		   
		}
		key=null;
	}
	
	public HashFunction(String str ){
		key=str;
	}
	public void setKey(String str){
		key=str;
	}
	public String getKey(){
		return key;
	}
	public void addVal(String str){
		int prob=0;	
			int h_pos= HT (str,prob);
			if(HT[h_pos]==null){
				HT[h_pos]=str;
				System.out.println("hpos=   "+h_pos+HT[h_pos]);	
				prob = -1;
			}
			else{
				if(h_pos == HT.length-1)
				   prob=0;	
				else
					prob = h_pos + 1;
			}
			while ((prob !=-1) && (prob != h_pos)){				
				if(HT[prob]==null){
					HT[prob]=str;
					System.out.println("Prob_pos=   "+prob+HT[prob]);
					prob = -1;					
				}
				else{
					if(prob == HT.length-1)
						   prob=0;	
						else
							prob++;
				}
			}	
			if(prob == h_pos)
				System.out.println("Sorry,Table is Full");
	}
	
	public int HashMap(String str){
		
		int sum=0;
		try {				
			for(int i=0;i<str.length();i++ ){		    
		    byte[] bytes=str.getBytes();
		    String newStr=new String(bytes,"UTF-8");
		    sum+=(int)newStr.charAt(i);
//		    System.out.println(sum);
			}
		    
		} catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		}	
		return( sum );		
	}	
	public int HT(String str, int prob){
		int h_pos= HashMap(str);
		return (h_pos+prob) % M;		
		
	}
	public String SearchKey(String key){
		int prob=0;
		int CountProb=0;
		int h_pos = HT( key, prob);
		if (HT[h_pos] == null)
			return null;
		else if (HT[h_pos].equals(key)){
			CountProb++;
			System.out.println("Number of prob for searching "+ key+ " is "+ CountProb+".");
			return HT[h_pos];
		}
		else {
			if(h_pos == HT.length-1){
				CountProb++;
				   prob=0;
			}
				else{
					CountProb++;
					prob = h_pos + 1;
				}
		}
		while ((prob !=-1) && (prob != h_pos)){				
			if(HT[prob]==null){
				return null;										
			}
			else if (HT[prob].equals(key)){	
				CountProb++;
				System.out.println("Number of prob for searching "+ key + " is "+ CountProb+".");
			    return HT[prob];
			}
			else{
				if(prob == HT.length-1){
					CountProb++;
					   prob=0;
				}
					else{
						CountProb++;
						prob++;
					}
			}
		}	
		return null;
	}
	
}
