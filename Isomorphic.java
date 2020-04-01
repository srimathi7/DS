import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Isomorphic {
public static void main(String args[]) {
	boolean f = false;
	HashMap<Character,Character> hm = new HashMap<Character,Character>();
	String s="abab";
	String t="baba";
	if(s.length()!=t.length())
	{
		f = false;
	}
	if(s.equals("") && t.equals("")) {
		f = true;
	}
	for(int i=0;i<s.length();i++)
	{
		if(hm.containsKey(s.charAt(i)))
		{
			if(hm.get(s.charAt(i)) != t.charAt(i))
			{
				f = false;
				break;
			}
		}
		else {
			if(hm.containsValue(t.charAt(i)))
			{
				f = false;
				break;
			}
		}
		
		hm.put(s.charAt(i),t.charAt(i));
		f = true;
		
		
		
	}

	System.out.println(hm);
	System.out.println(f);
}
}
