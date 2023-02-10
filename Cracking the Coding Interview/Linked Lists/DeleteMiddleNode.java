//Alonso Ortiz - 30/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class DeleteMiddleNode {

    /*
     * 2.3. Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first
     * and last node, not necessarily the exact middle) of a singly linked list, given only ACCESS to THAT NODE (mid Node).
     *
     * EXAMPLE:
     * Input: the node c from the linked list a -> b-> c -> d -> e -> f
     * Result: nothing is returned, but the new linked list looks like a - > b -> d -> e -> f
     */

    public static void deleteMidNode(Node toDelete) {

        if(toDelete == null || toDelete.next == null) 
            return;

        Node newVal = toDelete.next;

        //Update current value with the next node value and then skip next "repeated" node
        toDelete.data = newVal.data;
        toDelete.next = newVal.next;
        
    }

    public static void main(String[] args) throws IOException {

        Node n = new Node();

        n.generateList(9);

        System.out.print("Original List: ");
        n.printLinkedList();

        int mid = (int)Math.ceil(n.getLinkedListSize() / 2.0);
        
        Node n2 = n;
        int i = 0;

        while(n != null) {
            i++;

            if(i == mid)
                break;
            
            n2 = n2.next;
        }

        deleteMidNode(n2);

        System.out.print("New List:      ");
        n.printLinkedList();

    }
}
