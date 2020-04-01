
public class Circular {

	static boolean isCircular(Node head) {
		Node node = head.next;
		
		while(node!=null && node!=head) {
			node = node.next;
		}
		
		return(node==head);
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
		Node node = newNode(1);
		node.next = newNode(2);
		node.next.next = newNode(3);
		
		System.out.println(isCircular(node)?"YES\n":"NO\n");
		
		node.next.next.next = node;
		
		System.out.println(isCircular(node)?"YES\n":"NO\n");
	}
}
