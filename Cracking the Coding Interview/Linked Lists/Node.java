//Alonso Ortiz - 28/Aug/2019

import java.io.*;
import java.math.*;
import java.util.*;


public class Node{
    //Cracking the Coding Interview 6th Ed.
    Node next = null;
    int data;

    //Alonso Ortiz
    public Node(){
        Random ran = new Random();
        int randomInt = ran.nextInt(10);

        data = randomInt;
    }

    //Cracking the Coding Interview 6th Ed.
    public Node(int d){
        data = d;
    }

    //Cracking the Coding Interview 6th Ed.
    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    //Cracking the Coding Interview 6th Ed.
    public Node deleteNode(Node head, int d) {
        Node n = head;

        if(n.data == d) {
            return head.next; /* moved head */
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head; /* head didn't change */
            }
            n = n.next;
        }

        return head;
    }  

    //Alonso Ortiz
    public void generateList(int d) {
        Node head = this;
        Random ran = new Random();

        for(int i = 0; i < d; i++) {
            int randomInt = ran.nextInt(10);
            head.appendToTail(randomInt);
        }
    }

    //Alonso Ortiz
    public void printLinkedList(){
        Node n = this;
        int i = 0;

        while(n != null){
            if(i == 0) {
                System.out.print(n.data); 
                i++;
            } else {
                System.out.print("->" + n.data);
            }
            
            n = n.next;
        }

        System.out.println("");
    }

    //Alonso Ortiz
    public int getLinkedListSize() {
        Node n = this;
        int counter = 0;

        while (n != null) {
            counter++;
            n = n.next;
        }

        return counter;
    } 

    //Alonso Ortiz
    public Node prepend(Node newHead) {
        Node head = this;

        newHead.next = head;
        head = newHead;
        
        return head;

    }

    //Alonso Ortiz - Next methods are based on the exercises from "Práctica 1: Listas Encadenadas" by Professor Ariel Ortiz (ariel.ortiz@itesm.mx)
    public Node get(int index) {

        if (this == null) 
            return null; 

        Node n = this;
        int i = 0;

        while (n != null) {
            if (i == index) break;
            
            i++;
            n = n.next;
        }

        return n;

    }

    public Node set(int index, Node newNode) {
        
        if (this == null) 
            return null; 

        Node head = this;

        if(index == 0) { // change head
            newNode.next = head.next; //Point new node to the next index
            head = newNode; //newNode is the new head
            return head;
        }

        Node curr = head;
        Node prev = null;
        int i = 0;

        while (curr != null) {
            if (i == index) {
                newNode.next = curr.next; //Point new node to the next index
                prev.next = newNode; //Don't lose previous nodes
                break;
            }

            prev = curr; //track linked list
            i++;
            curr = curr.next;
        }

        return head;
    }

    public void add(int index, Node newNode) {

        if (this == null) 
            return; 

        Node head = this;
        Node curr = head;
        Node prev = null;
        int i = 0;

        while (curr != null) {
            if(curr.next == null) { //append to tail (index+1)
                if (i+1 == index) {
                    curr.next = newNode;
                    break;
                }
            }

            if (i == index) {
                newNode.next = curr;
                prev.next = newNode;
                break;
            }

            prev = curr;
            i++;
            curr = curr.next;
        }
    }

    public Node remove(int index) { 
        
        if (this == null) 
            return null; 

        Node head = this;
        Node curr = head;

        if(index == 0) { // change head
            head = head.next;
            return head;
        }

        Node prev = null;
        int i = 0;

         while (curr != null) { 
            if (i == index) { 
                prev.next =curr.next;
            }

            prev = curr;
            i++;
            curr = curr.next;
         }

        return head;

    } 

}