import java.util.*;
public class Main {

	public static Scanner reader = new Scanner (System.in);
	public static void main(String[] args) {

		int x = 1, y = 10, n=30;
		int [] a = {5,6,7,8,9,10};
		Node<Integer> head = buildListFromArr(a);
		System.out.println(ifOccurres(head,11));
		printListEven(head);

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

	public static boolean ifOccurres(Node<Integer> head, int target) {

		if (head.getValue() == target) {
			return true;
		}
		if (head.getNext() == null) {
			return false;
		}
		return (ifOccurres(head.getNext(), target));
	}




}
