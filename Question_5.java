
public class Question_5 {
	static SortTextFile NameList = new SortTextFile();
	static int binarySearchCount = 0;
	static int DictionarySearchCount = 0;
	static String [] list = {"Azevedo, Ana","Silva, Rui","Boussebough, Imane","Terracina, Giorgio",
			"Lefebvre, Peter","Houghten, Sher","Revesz, Peter","Zela Moraya, Wester"};
	public static void main(String[] args) 
	{
		for(int i = 0;i<8;i++){
			System.out.println("Start searching "+list[i]+"-----------------");
			//binarySearch(list[i], 0, NameList.name.length-1);
			//System.err.println("Total binary search "+binarySearchCount);
			dictionarySearch(list[i]);
			System.out.println("Total Dictionary search "+DictionarySearchCount);
			System.out.println();
			binarySearchCount = 0;
			DictionarySearchCount = 0;
			
		}
	}
	public static void binarySearch(String targetString, int startIndex, int endIndex)
	{
		int privot = (endIndex - startIndex) /2 + startIndex;
		//System.out.println(startIndex+" "+endIndex+" "+privot+" "+NameList.name[privot].trim().equals(targetString));
		if(startIndex == privot)
		{ 
			binarySearchCount++;
			if(NameList.name[privot].trim().equals(targetString) || NameList.name[endIndex].trim().equals(targetString))
			{
				System.out.println("B="+" "+NameList.name[privot]);
				return;
			}
			else 
				return;
		}
		else if(NameList.name[privot].trim().equals(targetString))
		{
			System.out.println("B="+" "+NameList.name[privot]);
			binarySearchCount++;
			return ;
		}
		else if (startIndex < privot)
		{
			if(NameList.name[privot].trim().compareTo(targetString) < 0)
			{
				binarySearchCount++;
				binarySearch(targetString, privot,  endIndex);
			}
			else if(NameList.name[privot].trim().compareTo(targetString) > 0)
			{
				binarySearchCount++;
				binarySearch(targetString, startIndex,  privot);
			}
		}
	}
	
	public static int dictionarySearch(String targetString){
		int left = 0 ;
		int right = NameList.name.length - 2;
		int index = 0;
		while(left <=  right){
			DictionarySearchCount++;
			if(left == right)
			{
				System.err.println(targetString+" ="+" "+NameList.name[left]);
				return left;
			}
			else
			{
				try{
					//System.err.println(NameList.name[left]);
				
					double temp_A = compareTo(targetString,NameList.name[left],index,false);
					
					double temp_B = compareTo(NameList.name[right],NameList.name[left],index,false);
							//NameList.name[right].toLowerCase().compareTo(NameList.name[left].toLowerCase());
					double temp_C = (temp_A / temp_B);
					if(temp_C < 0 || temp_C > 1)
						throw new Exception();
					int pos = (int) (left + Math.floor(temp_C *(right - left)));
					//System.err.println(" "+left+" "+right+" "+pos+" "+index+" ");
					//System.err.println("temp_A = "+temp_A+", temp_B = "+temp_B+", temp_C = "+temp_C+" ");
					
					//float temp_D = compareTo(targetString,NameList.name[pos],index);
					
					if(targetString.toLowerCase().compareTo(NameList.name[pos].toLowerCase()) == 0)
					{
						System.err.println(targetString+" ="+" "+NameList.name[pos]);
						return pos;
					}
					else if(targetString.toLowerCase().compareTo(NameList.name[pos].toLowerCase())< 0)
					{
						//System.err.println(targetString+" <"+" "+NameList.name[pos]);
						right = pos - 1;
					}
					else if(targetString.toLowerCase().compareTo(NameList.name[pos].toLowerCase())> 0)
					{
						//System.err.println(targetString+" >"+" "+NameList.name[pos]);
						left = pos + 1;
					}
					if(targetString.substring(0, index).compareTo(NameList.name[left].substring(0, index)) == 0 
							||targetString.substring(0, index).compareTo(NameList.name[right].substring(0, index)) == 0)
					{
						index++;
					}
				}
				catch(Exception e){
					System.err.println("Left is "+left+", left key is: "+NameList.name[left]);
					System.err.println("Right is "+right+", right key is: "+NameList.name[right]);
					System.err.println("Target is "+targetString);
					System.err.println("Current index is "+index);
					System.err.println("temp_A is "+compareTo(targetString, NameList.name[left],index, true));
					System.err.println("temp_B is "+compareTo(NameList.name[right], NameList.name[left],index, true));
					//System.err.println("temp_C is "+compareTo(targetString, NameList.name[left],index, true)/compareTo(NameList.name[right], NameList.name[left],index, true));
					left = right +1;
				}
			}
		}
		return -1;
	}
	
	public static double compareTo(String stringA, String stringB,int index,boolean debug){
		stringA = stringA.toLowerCase().replaceAll(",", "").replaceAll("\\s+","");
		stringB = stringB.toLowerCase().replaceAll(",", "").replaceAll("\\s+","");
		
		int minLength = Math.min(stringA.length(), stringB.length());
		int minIndex = Math.min(index, minLength);
		int MaxLength = 17;
		double returnValue = 0;
		for(int i=0;i< minIndex;i++){
			returnValue += ((stringA.charAt(i) - stringB.charAt(i)) * Math.pow(2, MaxLength)
					*Math.pow(1/26, i));
			if(debug){
				System.err.println("stringA.charAt(i) is:"+stringA.charAt(i)+", stringB.charAt(i) is:"+stringB.charAt(i));
				System.err.println("stringA.charAt(i) - stringB.charAt(i) is:"+(stringA.charAt(i)-stringB.charAt(i)));
				System.err.println("Math.pow(2,"+MaxLength+") is:"+Math.pow(2, MaxLength));
			}
			MaxLength --;
		}
        return returnValue;
	}
	//public int sumValue(string )
}
