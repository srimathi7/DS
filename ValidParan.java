import java.util.Stack;

public class ValidParan {

	public static void main(String args[]) {
		String s="";
		Stack<Character> st = new Stack<Character>();
		boolean f = false;
		if(s.equals("")) {
			f = true;
		}
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
			{
			st.push(s.charAt(i));
			}
			
			else if(s.charAt(i)==')')
			{
				if(!st.empty() && st.peek() == '(')
				{
					st.pop();
					f = true;
				}
				else
				{
					f = false;
					break;
				}
			}
			
			else if(s.charAt(i)==']')
			{
				if(!st.empty() && st.peek() == '[')
				{
					st.pop();
					f = true;
				}
				else
				{
					f = false;
					break;
				}
			}
			
			else if(s.charAt(i)=='}')
			{
				if(!st.empty() && st.peek() == '{')
				{
					st.pop();
					f = true;
				}
				else
				{
					f = false;
					break;
				}
			}
			if(st.empty()) 
			{ f = true; }
			else
			{
				f = false;}
		}
		
		System.out.println(f);
	}
}
