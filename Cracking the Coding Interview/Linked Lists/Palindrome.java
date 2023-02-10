//Alonso Ortiz - 11/Sep/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Palindrome {

    /*
     * 2.6. Implement a function to check if a linked list is a palindrome.
     */
    public static Node rightSide(Node head, Node right) {
        if(right == null) {
            right = new Node(head.data);
        } else {
            head.next = right;
            right = head;
        }

        return right;
    }

    public static boolean isPalindrome(Node head) {

        if(head == null) return false;
                
        int listSize = head.getLinkedListSize();
        boolean isOdd = false;
        boolean isPalindrome = true;
        
        if(listSize%2 != 0) 
            isOdd = true;

        int mid = listSize/2;
        Node left, right, curr;
        left = right = curr = null;
        int i = 1;

        while(head != null) {
            Node next = head.next;
            head.next = null;

            if(i <= mid) {
                if(left == null) {
                    left = new Node(head.data);
                    curr = left;
                } else {
                    curr.next = head;
                    curr = head;
                }
            } else {
                if(isOdd) {
                    head = head.next;
                    isOdd = false;
                } else {
                    right = rightSide(head, right);
                }
            }
            
            head = next;
            i++;
        }

        while(left != null && right != null) {
            if(left.data != right.data) {
                isPalindrome = false;
                break;
            }

            left = left.next;
            right = right.next;
        }

        return isPalindrome;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        Node n = new Node(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(1);

        System.out.print("List: ");
        n.printLinkedList();

        boolean palindrome = isPalindrome(n);
        System.out.println("Is the list a palindrome? -> " + palindrome);
                
    }
}