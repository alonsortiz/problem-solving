//Alonso Ortiz - 27/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class RemoveDuplicates {

    /*
     * 2.1. Remove Dups: Write code to remove duplicates from an unsorted linked list.
     */

    //Solution with buffer
    public static void removeDups(Node head) {

        if(head == null) 
            return;

        HashSet<Integer> h = new HashSet<Integer>(); 
        Node curr = head;
        Node prev = null;

        while(curr != null) {
            if(!h.contains(curr.data)) {
                h.add(curr.data);
                prev = curr; //keep tracking the prev Node
            } else {
                prev.next = curr.next; //skip the duplicated Node
            }
            curr = curr.next;
        }
        
    }

    //Solution without buffer
    public static void removeDupsNoExtra(Node head) {
        
        if(head == null) 
            return;

        Node curr = head;
        Node runner = null;

        while(curr != null && curr.next != null) {
            runner = curr;
            while(runner.next != null) {
                if(runner.next.data == curr.data) { //compare the rest of the Linked List with the actual Node n
                    runner.next = runner.next.next; //skip node
                } else {
                    runner = runner.next; //keep searching
                }
            }
            curr = curr.next; //move to the next node and then loop again
        }

    }

    public static void main(String[] args) throws IOException {

        Node n = new Node();

        n.generateList(9);

        System.out.print("Original List: ");
        n.printLinkedList();


        removeDups(n);
        //removeDupsNoExtra(n);

        System.out.print("New List:      ");
        n.printLinkedList();
        
    }
}
