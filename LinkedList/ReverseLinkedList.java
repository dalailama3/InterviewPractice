public class ReverseLinkedList {
  public static ListNode reverse(ListNode head) {
    //take a head and returns head of reversed list
    // 1 -> 2 -> 3 -> 4 -> null    =>    4 -> 3 -> 2 -> 1 -> null
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextNode = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextNode;
    }
    return prev;
  }

  public static ListNode recursiveReverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode nextNode = head.next;
    ListNode n = recursiveReverse(nextNode);
    System.out.println("n is: " + n.val + "and head is " + head.val);
    head.next.next = head;
    head.next = null;
    return n;

  }

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
    ListNode head = recursiveReverse(dummy.next);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
