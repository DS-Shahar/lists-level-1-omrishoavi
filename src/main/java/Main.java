
public class Main {

	    public static void main(String[] args) {
	        int x = 1, y = 10, n=30;
	        Node<Integer> head = generateRandomNumbers(x, y, n);
	        System.out.println("Generated List: " + head);

	        int numberToCount = 5;
	        int occurrences = countOccurrences(head, numberToCount);
	        System.out.println("Number " + numberToCount + " appears " + occurrences + " times.");
	    }

	    
	    public static Node<Integer> generateRandomNumbers(int x, int y, int n) {
	       
	        Node<Integer> head = new Node<>((int) (Math.random() * (y - x + 1)) + x);
	        Node<Integer> current = head;

	        for (int i = 1; i < n; i++) {
	            Node<Integer> newNode = new Node<>((int) (Math.random() * (y - x + 1)) + x);
	            current.setNext(newNode);
	            current = newNode;
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
	}
