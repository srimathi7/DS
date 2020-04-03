//02-04-2020

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class LongestSub {

	public static int longestSub(String s)
	{
		HashSet hs = new HashSet();
		Hashtable hm = new Hashtable();
		if(!s.equals("") && s.trim().length()!=0){
		for(int i=0;i<s.length();i++)
		{
			for(int j=i;j<s.length();j++)
			{
				if(i==j) {
					hs.add(s.charAt(i));
				}
				else if(!hs.contains(s.charAt(j)))
				{
					hs.add(s.charAt(j));
				}
				else if(hs.contains(s.charAt(j))){
					hm.put(hs.size(),hs);
					hs.removeAll(hs);
					break;
				}
			}
		}
		}
		else if(s.length()>0)
        {
            return 1;
        }
		else
		{
			return 0;
		}
		System.out.println(hm);
		System.out.println(hs);
		return (int) Collections.max(hm.keySet());
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcabcbb";
		
		int sl = longestSub(s);
		
		System.out.println(sl);
	}

}
