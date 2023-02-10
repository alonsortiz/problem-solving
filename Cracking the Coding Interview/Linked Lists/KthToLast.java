//Alonso Ortiz - 29/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class KthToLast {

    /*
     * 2.2. Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
     */

    //Iterative Solution
    public static void itKthElement(Node head, int k) {

        if(head == null) 
            return;

        Node curr = head;

        int listSize = curr.getLinkedListSize();
        int pos = listSize-k;
        int kVal, i;
        kVal = i = 0;

        while (curr != null) {
            if(i == pos) {
                kVal = curr.data;
                break;
            }
            curr = curr.next;
            i++;
        }

        System.out.println("Kth element to last: " + kVal);
        
    }

    //Recursive Solution
    public static int recKthElement(Node head, int k) {
        
        if(head == null) 
            return 0;

        Node curr = head;

        int i = recKthElement(curr.next, k) + 1;

        if(i == k) 
            System.out.println("Kth element to last: " + curr.data);

        return i;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        Node n = new Node();

        n.generateList(9);

        System.out.print("Original List: ");
        n.printLinkedList();

        System.out.print("Type the kth element: ");
        int k = scanner.nextInt(); 

        //itKthElement(n, k);
        int kVal = recKthElement(n, k);
        
        scanner.close();

        System.out.println("\n****Testing get, set, add, remove and prepend methods from Node class.****");

        Node specific = n.get(2);

        System.out.println("Get 2nd position from list: "+specific.data);

        Node n1 = n.set(1, new Node(21));
        System.out.print("List after Set:       ");
        n1.printLinkedList();

        n1.add(6, new Node(11));
        System.out.print("List after Add:       ");
        n1.printLinkedList();

        Node n2 = n1.remove(3);
        System.out.print("List after Remove:    ");
        n2.printLinkedList();

        Node n3 = n2.prepend(new Node(12));
        System.out.print("List after Prepend:   ");
        n3.printLinkedList();
                
    }
}