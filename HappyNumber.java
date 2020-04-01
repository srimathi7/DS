import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

public class HappyNumber {

	public static void main(String args[]) {
		//Hashtable<Integer,Integer> hash = new Hashtable<Integer,Integer>();
		//hash.put(0,19);
			int n=1;
			boolean f = false;
			Set st = new HashSet();
			while(n!=0 && n!=1) {
			String temp = String.valueOf(n);
			int l = temp.length();
			int sum = 0, c=0;

			for(int i=0;i<l;i++)
			{
				c = temp.charAt(i) - '0';
			    sum += (int) Math.pow(c,2);
			}
			
			//hash.put(t,sum);
			n=sum;
			
			if(!st.contains(sum))
			{
				st.add(sum);
			}
			else
			{
				break;
			}
			}
			if(n==1)
			{
				f = true;
			}
		System.out.println(f);
	}
}
