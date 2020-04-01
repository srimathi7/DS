
public class TortoiseHare {

	static int tortoiseHare(int[] arr)
	{
		int tortoise = 0 , hare = 0;
		tortoise = arr[0];
		hare = arr[0];
		int ptr1 = 0, ptr2 = 0;
		
		while(true) {
			tortoise = arr[tortoise];
			hare = arr[arr[hare]];
			if(tortoise==hare)
				break;
		}
			ptr1=arr[0];
			ptr2=tortoise;
			while(ptr1!=ptr2) {
				ptr1=arr[ptr1];
				ptr2=arr[ptr2];
		}
		return ptr1;
	}
	
	public static void main(String args[]) {
		int [] arr = {5,2,1,3,4,2};
		int res = tortoiseHare(arr);
		System.out.println(res);
	}
}
