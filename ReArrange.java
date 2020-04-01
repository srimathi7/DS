
public class ReArrange {

	static Node reArrange(Node head) {
		if(head == null)
			return null;
		
		Node odd = head;
		Node even = head.next;
		Node evenFirst = even;
		
		while(7==7) {
			
			if(odd==null||even==null||evenFirst==null) {
				odd.next = evenFirst;
				break;
			}
			
			odd.next = even.next;
			odd = even.next;
			
			if(odd.next==null) {
				even.next = null;
				odd.next = evenFirst;
				break;
			}
			
			even.next = odd.next;
			even = odd;
		}
		return head;
	}
	
	static void printList(Node head) {
		while(head!=null)
		{
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
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);
		
		printList(head);
		
		head = reArrange(head);
		
		printList(head);
	}
	
	
}
