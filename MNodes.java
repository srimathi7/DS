
public class MNodes {

	static void skipMdeleteN(Node h, int M, int N) {
		Node curr = h, t;
		while(curr!=null) {
		for(int count = 1; count < M && curr!=null; count++)
		{
			curr = curr.next;
		}
		 
		if(curr==null) {
			return;
		}
		
		t = curr.next;
		for(int c = 1; c <= N && t!=null; c++) {
			t = t.next;
		}
		
		curr.next = t;
		curr = t;
		}
	}
	
	static void printList(Node h) {
		while(h!=null) {
			System.out.print(h.data);
			h = h.next;
		}
		System.out.println();
	}
	
	static Node push(Node h, int d) {
		Node new_node = new Node();
		new_node.data = d;
		new_node.next = h;
		h = new_node;
		return h;
	}
	
	static class Node{
		int data;
		Node next;
	}
	
	public static void main(String args[]) {
		Node head = null;
		int M=1,N=2;
		head=push(head,11);
		head=push(head,10);
		head=push(head,9);
		head=push(head,8);
		head=push(head,7);
		head=push(head,6);
		head=push(head,5);
		head=push(head,4);
		head=push(head,3);
		head=push(head,2);
		head=push(head,1);
		
		printList(head);
		
		skipMdeleteN(head,M,N);
		
		printList(head);
	}
}
