
import java.util.Scanner;
public class Main {

	public static Scanner reader = new Scanner (System.in);



	public static Node<Integer> generateRandomNumbers(int x, int y, int n) {

		Node<Integer> head = new Node<>((int) (Math.random() * (y - x + 1)) + x);
		Node<Integer> current = head;

		for (int i = 1; i < n; i++) {
			Node<Integer> newNode = new Node<>((int) (Math.random() * (y - x + 1)) + x);
			current.setNext(newNode);
			current = current.getNext();
		}

		return head; 
	}


	public static int countOccurrences(Node<Integer> head, int target) {
		int count = 0;
		Node<Integer> current = head;

		while (current != null) {
			if (current.getValue() == target) {
				count++;
			}
			current = current.getNext();
		}

		return count;
	}

	public static Node<Integer> buildListFromArr(int[] arr) {
		Node<Integer> head = new Node<>(arr[0]);
		Node<Integer> current = head;
		for(int i=1; i<arr.length; i++) {
			Node<Integer> newNode = new Node<>(arr[i]);
			current.setNext(newNode);
			current = newNode;
		}
		return head;
	}

	public static void printList(Node<Integer> head) {
		Node<Integer> current = head;
		while (current != null) {
			System.out.println(current.getValue());
			current = current.getNext();
		}
	}

	public static void printListRecursive(Node<Integer> head) {

		if (head == null) {
			return;
		}
		System.out.println(head.getValue());
		printListRecursive(head.getNext());
	}

	public static void printOppositeListRecursive(Node<Integer> head) {

		if (head == null) {
			return;
		}
		printOppositeListRecursive(head.getNext());
		System.out.println(head.getValue());

	}	

	public static Node<Integer> buildList() {
		Node<Integer> head = new Node<Integer>(null);
		Node<Integer> current = head;

		System.out.println("Enter numbers possitive or -1");
		int num = reader.nextInt();
		while(num != -1) {
			Node<Integer> newNode = new Node<Integer>(num);
			current.setNext(newNode);
			current = newNode;
			System.out.println("Enter number or -1 to end:");
			num = reader.nextInt();
		}
		return head.getNext();
	}

	public static void printListEven(Node<Integer> head) {
		while(head != null) {
			if ((head.getValue())%2==0) {
				System.out.println(head.getValue());
			}
			head = head.getNext();
		}
	}


	public static Node<Integer> deleteNodeByValue(Node<Integer> head, int x){
		head = new Node<>(null, head);
		Node<Integer> current = head;

		while (current != null) {
			if(current.getNext().getValue().equals(x)){
				current.setNext(current.getNext().getNext());
				return head.getNext();
			}
			current = current.getNext();
		}
		return head.getNext();
	} 

	public static Node<Integer> deleteNodeByIndex(Node<Integer> head, int x){
		head = new Node<>(null, head);
		Node<Integer> current = head;
		int nodeCount=1;

		while (current != null) {
			if(nodeCount==x){
				current.setNext(current.getNext().getNext());
				return head.getNext();
			}
			nodeCount++;
			current = current.getNext();
		}
		return head.getNext();
	} 

	private static boolean ifL1InL2TailRecursive(Node<Integer> head1, Node<Integer> head2,Node<Integer> current) {
		if (head1 == null) {
			return true;  
		}
		if (current == null) {
			return false;  
		}

		if (head1.getValue() == current.getValue()) {
			return ifL1InL2TailRecursive(head1.getNext(),head2,head2);
		} 
		else {
			return ifL1InL2TailRecursive(head1, head2,current.getNext());
		}
	}

	private static void printL1InL2(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> current = head2;

		while (head1 != null) {
			while (current != null) {
				if(head1.getValue() == current.getValue()){
					System.out.println(current.getValue());
					current=null;
				}
				else {
					current=current.getNext();
				}
			}
			current = head2;
			head1=head1.getNext();
		}
	}
	
	private static Node<Integer> listFromL1L2(Node<Integer> head1, Node<Integer> head2) {
		
		Node<Integer> head3 = new Node<Integer>(null,null);
		Node<Integer> newCurrent = head3;
		Node<Integer> current = head2;

		while (head1 != null) {
			while (current != null) {
				if(head1.getValue() == current.getValue()){
					newCurrent.setValue(current.getValue());
					if (head1.getNext() == null) {
						return head3;
					}
					Node<Integer> newNode = new Node<Integer>(null,null);
					newCurrent.setNext(newNode);
					newCurrent=newNode;
					current=null;
				}
				else {
					current=current.getNext();
				}
			}
			current = head2;
			head1=head1.getNext();
		}
		
		return head3;
	}
	
	private static Node<Integer> delL1InL2(Node<Integer> head1, Node<Integer> head2) {

	    Node<Integer> head0 = new Node<>(null, head1); 
	    Node<Integer> current1 = head0; 
	    Node<Integer> current2;

	    while (current1.getNext() != null) {
	        boolean shouldDelete = false;
	        current2 = head2;

	        while (current2 != null) {
	            if (current1.getNext().getValue() == current2.getValue()) {
	                shouldDelete = true;
	                break;
	            }
	            current2 = current2.getNext();
	        }

	        if (shouldDelete) {
	            current1.setNext(current1.getNext().getNext());
	        } else {
	            current1 = current1.getNext();
	        }
	    }
	    return head0.getNext();
	}

	
	
	
	
	
	
	public static void main(String[] args) {

		int [] a = {5,6,5,122,456,8,8,11,15,12};
		int [] b = {5,6,7,8,11,11,15,15};
		Node<Integer> head1 = buildListFromArr(a);
		Node<Integer> head2 = buildListFromArr(b);
		head1 = listFromL1L2(head1,head2);
		System.out.println(delL1InL2(head1,head2));

	}
}
