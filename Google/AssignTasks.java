import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/* Code by Srimathi on April 5,2020 */

class Pair { 
    int x; 
    int y; 
  
public Pair(int x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
} 

public class Tasks 
{
	static int getValue(HashMap<Integer,Pair> hmap, Pair p)
	{
		int key = 0;
		for (Map.Entry<Integer,Pair> e : hmap.entrySet()) {

		    Pair value = e.getValue();
		    if(value.equals(p))
		    {
		    	key = e.getKey();       // Get key for a particular value i.e pair
		    	break;
		    }
		}
		return key;
	}
  
	static HashMap<Integer,Character> assign(ArrayList<Pair> pair, HashMap<Integer,Pair> hmap)
	{
		Pair C = new Pair(-1,-1); 
		Pair J = new Pair(-1,-1);     //(-1,-1) indicates no tasks are assigned yet
		int in = 0;
		HashMap<Integer,Character> hm = new HashMap<Integer,Character>();
		
		if(C.x==-1 && C.y==-1)        // If C is empty, initially assign first task to C 
		{
			in = getValue(hmap,pair.get(0)); // Get index of a pair as given by user 
			C = pair.get(0);
			hm.put(in,'C');             // Put in the same index which was assigned to a pair
		}
		for(int i=1;i<pair.size();i++)
		{
			int key = pair.get(i).x;    // Get first element of next pair
			
			if(isFreeC(C,key))          // Checks C is empty or free and first element of next is in between C
			{
				C = pair.get(i);
				in = getValue(hmap,pair.get(i));
				hm.put(in,'C');
			}
			else if(isFreeJ(J,key))      // Checks J is empty or free and first element of next is in between J
			{
				J = pair.get(i);
				in = getValue(hmap,pair.get(i));
				hm.put(in,'J');
			}
			else
			{
				hm.clear();               // Returns empty hashmap if all condition fails
			}
		}
		return hm;
	}
	
  
	static boolean isFreeC(Pair C, int key)
	{
		boolean f;
		if(C.x==-1 && C.y==-1)        // Assign to C as it holds no tasks
		{
			f = true;
		}
		else if(key>=C.x && key<C.y)  // Checks if value is in between 
		{
			f = false;
		}
		else 
		{
			f= true;
		}
		return f;
	}
	
	static boolean isFreeJ(Pair J, int key)
	{
		boolean f;
		if(J.x==-1 && J.y==-1)        // Assign to J as it holds no tasks
		{
			f = true;
		}
		else if(key>=J.x && key<J.y)  // Checks if value is in between 
		{
			f = false;
		}
		else 
		{
			f= true; 
		}
		return f;
	}
	
  
	static ArrayList<Pair> compare(ArrayList<Pair> pair, int n) 
	{ 
		// Comparator to sort the pair according to first element 
		Collections.sort(pair, new Comparator<Pair>() { 
			@Override public int compare(Pair p1, Pair p2) 
			{ 
				return p1.x - p2.x; 
			} 
		}); 

		for(int i=0;i<n;i++) {
			System.out.print(pair.get(i).x+" , "+pair.get(i).y+" "); // Prints the pairs in the sorted order
			System.out.println(); 
		}
		return pair;
	} 


	public static void main(String args[]) {

		 int testCases = 0;
		 int size = 0;
		 Scanner in = new Scanner(System.in);
		 testCases = in.nextInt(); //enter the number of test cases
		 
		 Vector<ArrayList<Pair>> pairSets = new Vector<ArrayList<Pair>>();   // Vector which stores pairs of each test cases
		 for(int i=0;i<testCases;i++)
		 {
			 size = in.nextInt(); //enter size of time pairs
			 ArrayList<Pair> pair = new ArrayList<Pair>();                    // ArrayList which stores list of pairs as per the given size
			 for(int j=0;j<size;j++)
			 {
				 int a = in.nextInt();
				 int b = in.nextInt();
				 pair.add(new Pair(a,b));
			 }
			 pairSets.add(i,pair);
		 }
		 
		 for(int v=0;v<pairSets.size();v++)
		 {
			 ArrayList<Pair> pair = pairSets.get(v);
			 HashMap<Integer,Pair> hmap = new HashMap<Integer,Pair>();        // HashMap to store the order of the pairs as given by the user
			 for(int i=0;i<pair.size();i++)
			 {
			 hmap.put(i,pair.get(i));
			 }
			 
			 pair = compare(pair, pair.size()); //Sorts list of pairs
			 
			 HashMap<Integer,Character> hm = assign(pair,hmap);               // Assigns tasks based on the conditions
			 
			 if(!hm.isEmpty())
			 {
			 for(Map.Entry<Integer,Character> e: hm.entrySet())
			 {
				 System.out.print(e.getValue());
			 }
			 }
			 else
			 {
				 System.out.print("IMPOSSIBLE");  
			 }
			 System.out.println();
		 }
	}
}
