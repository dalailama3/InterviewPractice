public class SwapNodePairs {
  public static void main (String[] args) {

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

public class ListNode {
  int val;
  ListNode next;
  public ListNode (int val) {
    this.val = val;
    this.next = null;
  }

  public setNext(ListNode next) {
    this.next = next;
  }
}
