
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trinary trinarySearch =new Trinary() ;
		PureBinarySearch pureBinarySearch = new PureBinarySearch();
		int[] array=new int[1500];
		array[0]=(int) Math.ceil(Math.random() * 100);
		int increment=(int) Math.ceil(Math.random() * 100);
		for(int i=1;i<1500;i++){
			array[i]=array[i-1]+increment;
		}
		int key=(int) Math.ceil(Math.random() * 10000);
        int searchtime=0;
        System.out.println("Let's start pure Binary search!");
        System.out.println("");
	System.out.println("Target number is: "+key);
        pureBinarySearch.binary(key, 0, 1499, array, searchtime);
        System.out.println("");
        System.out.println("Let's start Trinary & Bibary search!");
        System.out.println("");
	System.out.println("Target number is: "+key);	
        trinarySearch.trinary(key, 0, 1499, array, searchtime); 
	}

}
