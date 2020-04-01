
public class AddOne {

	static Node addOneFinal(Node p) {
		
		Node res = p;
		Node temp = null;
		int carry = 1; 
		int sum;
		while(p!=null) {
			sum = carry + p.data;
			carry = (sum >=10)?1:0;
			sum = sum % 10;
			p.data = sum;
			temp = p;
			p = p.next;
		}
		if(carry > 0)
		{
			temp.next = newNode(carry);
		}
		return res;
	}
	
	static Node reverse(Node h) {
		Node current = h;
		Node prev=null;
		Node next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	static Node addOne(Node h) {
		
		h = reverse(h);
		
		h = addOneFinal(h);
		
		return reverse(h);
		
	}
	
	static void printList(Node node) {
		while(node!=null) {
			System.out.print(node.data);
			node = node.next;
		}
		System.out.println();
	}
	
	static Node newNode(int d) {
		Node head = new Node();
		head.data = d;
		head.next = null;
		return head;
	}
	
	static class Node{
		int data;
		Node next;
	}
	
	public static void main(String args[])
	{
		Node head = newNode(1);
		head.next = newNode(9);
		head.next.next = newNode(9);
		head.next.next.next = newNode(9);
		
		printList(head);
		
		head = addOne(head);
		
		printList(head);
	}
	
	
}
		