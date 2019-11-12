import java.util.*;

public class SwapNodePairs {
  public static void main (String[] args) {
    int[] arr = {1,2,3,4,5};
    ListNode dummy = new ListNode(0);
    ListNode prev = new ListNode(arr[0]);
    dummy.next = prev;
    for (int i = 1; i < arr.length; i++) {
      ListNode newNode = new ListNode(arr[i]);
      prev.next = newNode;
      prev = newNode;
    }
    System.out.println(dummy.next.val);
    ListNode swappedHead = swapPairs(dummy.next);
    List<Integer> list = new ArrayList<Integer>();
    while (swappedHead != null) {
      list.add(swappedHead.val);
      swappedHead = swappedHead.next;
    }
    System.out.println(list);

  }


  public static ListNode swapPairs(ListNode head){

    ListNode n;
    if (head == null || head.next == null) {
      return head;
    }
    //store head's next
    n = head.next;
    head.next = swapPairs(head.next.next);
    n.next = head;
    return n;
  }




}

class ListNode {
  int val;
  ListNode next;
  public ListNode (int val) {
    this.val = val;
    this.next = null;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }
}
