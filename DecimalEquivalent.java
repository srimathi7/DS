
public class DecimalEquivalent {

	
	static long decimal(Node head) {
		int count = 0;
		long sum = 0;
		int two = 0;
		
		if(head==null) {
			return 0;
		}
		
		while(head!=null) {
			two = head.data * 2;
			sum = (long) (sum + Math.pow(two,count));
			head = head.next;
			count++;
			}
			return sum;
	}
	
	static Node reverse(Node head)
	{
		Node prev = null,next = null,curr = null;
		curr = head;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data);
			head = head.next;
		}
		System.out.println();
	}
	
	static Node newNode(int d) {
		Node new_node = new Node();
		new_node.data = d;
		new_node.next = null;
		return new_node;
	}
	
	static class Node{
		int data;
		Node next;
	}
	
	public static void main(String args[]) {
		Node head = newNode(1);
		head.next = newNode(0);
		head.next.next = newNode(1);
		head.next.next.next = newNode(1);
		/*
		 * head.next.next.next.next = newNode(1); head.next.next.next.next.next =
		 * newNode(0); head.next.next.next.next.next.next = newNode(0);
		 * head.next.next.next.next.next.next.next = newNode(1);
		 * head.next.next.next.next.next.next.next.next = newNode(0);
		 */
		
		printList(head);
		
		head = reverse(head);
		
		printList(head);
		
		long sum = decimal(head);
		
		System.out.println(sum);
	}
	
}
