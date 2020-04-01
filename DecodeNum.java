
public class DecodeNum {

	static int decodeNum(String str) {
		int count = 1;
		int lastCount = 1;
		for(int i=0;i<str.length();i++){
			int temp = 0;
			if(str.charAt(i) !='0')
			{
				temp = count;
			}
			
			if(i>0)
			{
				int sum = (str.charAt(i-1) - '0') * 10 + (str.charAt(i) - '0');
				if(sum >=10 && sum <=26)
				{
					temp += lastCount;
				}
			}
			
			if(temp == 0 )
				return 0;
			
			lastCount = count;
			count = temp;
		}

		return count;
	}
	
	public static void main(String args[]) {
		String s = "226";
		int c = decodeNum(s);
		System.out.println(c);
	}
}
