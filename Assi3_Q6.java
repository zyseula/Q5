
//This program is about using Fold Method via UTF-8 coding in order to make hash table.
//In order to solving collision, we use Quadratic Method.
import java.io.*;

public class Assi3_Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create object of hash function.read file line by line. 
		HashFunction ht = new HashFunction();
		
		//Read file line by line.
		File file = new File("C:\\Users\\h_hajiba\\Desktop\\ds17s-asg2-data.txt");
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String lines;
			while ((lines = br.readLine()) != null) {
				// System.out.println(lines);
				ht.addVal(lines.trim());
			}

		} catch (FileNotFoundException e) {

			System.out.println("File not Found" + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to Read file" + file.toString());
		}
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Unable to Close file" + file.toString());
		} catch (NullPointerException ex) {
			// File probably never opened.
		}
		
		//Search some keys that exist in array.
		 String [] strArr= {"Azevedo, Ana", "Silva, Rui","Boussebough, Imane",
		 "Terracina, Giorgio", "Lefebvre, Peter", "Houghten, Sher", "Revesz, Peter"};
		 System.out.println("Start searching with hasing......\n");
		 for(int i=0; i < strArr.length; i++){
		    ht.SearchKey(strArr[i]);		
		 }
	}
}

//Hash function class: define instance variable.
class HashFunction {

	public Object SearchKey;
	private String key;
	private final int M = 2657;
	private String[] HT;
	
	//Create constructor
	public HashFunction() {
		HT = new String[M];
		for (int i = 0; i < HT.length; i++) {
			HT[i] = null;
		}
		key = null;
	}
	
	//Create constructor
	public HashFunction(String str) {
		key = str;
	}
	
	//Set and get function
	public void setKey(String str) {
		key = str;
	}

	public String getKey() {
		return key;
	}
	
	//Put  names list on hash table.
	public void addVal(String str) {
		int prob = 0;
		int h_pos = HT(str, prob);
		if (HT[h_pos] == null) {
			HT[h_pos] = str;
//			System.out.println("hpos=   " + h_pos + HT[h_pos]);
			prob = -1;
		} else {
			if (h_pos == HT.length - 1)
				prob = 0;
			else
				prob = h_pos + 1;
		}
		while ((prob != -1) && (prob != h_pos)) {
			if (HT[prob] == null) {
				HT[prob] = str;
//				System.out.println("Prob_pos=   " + prob + HT[prob]);
				prob = -1;
			} else {
				if (prob == HT.length - 1)
					prob = 0;
				else
					prob++;
			}
		}
		if (prob == h_pos)
			System.out.println("Sorry,Table is Full");
	}
	//Using Fold Method via UTF_* code in order to make hashmap.
	public int HashMap(String str) {

		int sum = 0;
		try {
			byte[] bytes = str.getBytes("UTF-8");
			for (int i = 0; i < bytes.length; i++) {
				sum += bytes[i] & 0xFF;

			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return (sum);
	}
	//Using Open Address, Quadratic Method, for solving collision. 
	public int HT(String str, int prob) {
		int h_pos = HashMap(str);
		int prob1 = (int) Math.pow(prob, 2);
		return (h_pos + prob1) % M;

	}
	
	//Searching keys in given array.
	public String SearchKey(String key) {
		int prob = 0;
		int CountProb = 0;
		int h_pos = HT(key, prob);
		if (HT[h_pos] == null) {
			CountProb++;
			System.out.println("Sorry, Result Not Found for \"" + key + "\" and the number of prob for searching is "
					+ CountProb + ".");
			return null;
		} else if (HT[h_pos].equals(key)) {
			CountProb++;
			System.out.println("Number of prob for searching \"" + key + "\" is " + CountProb + ".");
			return HT[h_pos];
		} else {
			if (h_pos == HT.length - 1) {
				CountProb++;
				prob = 0;
			} else {
				CountProb++;
				prob = h_pos + 1;
			}
		}
		while ((prob != -1) && (prob != h_pos)) {
			if (HT[prob] == null) {
				CountProb++;
				System.out.println("Sorry, Result Not Found for \"" + key
						+ "\" and the number of prob for searching is " + CountProb + ".");
				return null;
			} else if (HT[prob].equals(key)) {
				CountProb++;
				System.out.println("Number of prob for searching \"" + key + "\" is " + CountProb + ".");
				return HT[prob];
			} else {
				if (prob == HT.length - 1) {
					CountProb++;
					prob = 0;
				} else {
					CountProb++;
					prob++;
				}
			}
		}
		System.out.println("Sorry, Result Not Found for \"" + key + "\" and the number of prob for searching is "
				+ CountProb + ".");
		return null;
	}

}