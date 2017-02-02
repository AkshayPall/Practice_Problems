/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        //at least head exists so length is 1
        int length = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        temp.next = head;//reaching the end of the list, connect back to head so you can loop
        k%=length; //the real amount to shift by
        temp = head;
        int tempLen = length-k;
        while(tempLen > 0){
            temp = temp.next; //becomes new head
            tempLen--;
        }
        ListNode copy = new ListNode(temp.val);
        ListNode curr = copy;
        while(length > 1){
            temp = temp.next;
            ListNode newTemp = new ListNode(temp.val);
            curr.next = newTemp;
            curr = newTemp;
            length--;
        }
        return copy;
    }
}
