//This is an implmentation of Floyd's cycle finding, also known
//as the tortoise and hare, algorithm for linked lists. I have used
//this for a hackerrank problem


/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    
    boolean result = false;
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null){
    	slow = slow.next;	//single increment
    	fast = fast.next.next;	//double increment

    	if (fast == slow){
    		result = true;
    		fast = null;
    	}
    }
    
    
    return result;
}
