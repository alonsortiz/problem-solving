//Alonso Ortiz - 06/Sep/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class SumLists {

    /*
     * 2.5. You have two numbers represented by a linked list, where each node contains a single digit. 
     * The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * EXAMPLE:
     * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
     * Output: 2 -> 1 -> 9. That is, 912.
     */

    //Solution without integers conversion
    public static Node recursiveSumLists(Node n1, Node n2, Node head, int carry) {

        if(n1 == null && n2 == null) return head; 

        int i = n1.data + n2.data;

        if(carry == 1) 
            i += 1;
        
        int decimal = i;

        if(n1.next != null && n2.next != null) 
            decimal = decimal%10;    
                
        if(head == null) {
            head = new Node(decimal);
        } else {
            if(decimal/10 == 0) {
                head.appendToTail(decimal);
            } else {
                head.appendToTail(decimal%10);
                head.appendToTail(decimal/10);
            }

            //FOLLOW UP: Suppose the digits are stored in forward order -> Comment above lines and uncomment below lines
            /*
            Node newDigit = null;
            
            if(decimal/10 == 0) {
                newDigit = new Node(decimal);
                newDigit.next = head;
                head = newDigit;
            } else {
                newDigit = new Node(decimal%10);
                newDigit.next = head;
                head = newDigit;

                newDigit = new Node(decimal/10);
                newDigit.next = head;
                head = newDigit;
            }
            */
        }

        return recursiveSumLists(n1.next, n2.next, head, i/10);
    }


    //Solution with integers conversion
    public static int listToNum(Node head) {

        Node curr = head;

        if(curr == null) return 0;

        return Integer.valueOf(String.valueOf(listToNum(curr.next)) + String.valueOf(curr.data));
   
    }

    public static Node sumLists(Node n1, Node n2) {

        int num1 = listToNum(n1);
        int num2 = listToNum(n2);
        int sum = num1 + num2;
        
        System.out.println(num1 + " + " + num2 + " = " + sum);

        String a = String.valueOf(sum);
        Node sumList = null;

        for (char c : a.toCharArray()) {
            Node digit = new Node(Character.getNumericValue(c));

            if(sumList == null) {
                sumList = digit;
            } else {
                //Prepend node
                digit.next = sumList;
                sumList = digit;
            }
        }

        return sumList;
        
    }

    public static void main(String args[]) throws IOException {

        Node n1 = new Node();
        n1.generateList(2);

        System.out.print("List 1:   ");
        n1.printLinkedList();

        Node n2 = new Node();
        n2.generateList(2);

        System.out.print("List 2:   ");
        n2.printLinkedList();


        //Test soultion without integers conversion
        Node resultList = null;

        Node sum = recursiveSumLists(n1, n2, resultList, 0);
        System.out.print("Sum List: ");
        sum.printLinkedList();


        //Test soultion with integers conversion
        /*Node sum = sumLists(n1, n2);

        System.out.print("Sum List: ");
        sum.printLinkedList();*/
         
    }
}