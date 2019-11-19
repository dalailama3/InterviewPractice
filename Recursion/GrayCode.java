import java.util.*;
public class GrayCode {
  //generate a 2**n length code in which every number differs by 1 bit from previous a[i-1]
  public static List<Integer> grayCode(int numBits) {
    List<Integer> list = new ArrayList<Integer>();
    Set<Integer> set = new HashSet<Integer>();
    set.add(0);
    list.add(0);
    helper(numBits,set,list);
    return list;
  }

  public static boolean helper(int numBits,Set<Integer> set, List<Integer> result) {
    //base case
    if (result.size() == (1 << numBits)) {
      return differsByOneBit(result.get(0), result.get(result.size()-1));
    }

    for (int i = 0; i < numBits; ++i) {
      int lastNum = result.get(result.size()-1);
      // this will change a 1 to 0 or 0 to 1
      int tryNum = lastNum ^ (1 << i);
      if (!set.contains(tryNum)) {
        result.add(tryNum);
        set.add(tryNum);
        //make recursive call
        if (helper(numBits,set,result)) {
          return true;
        }
        set.remove(tryNum);
        result.remove(result.size()-1);
      }
    }
    return false;

  }

  public static boolean differsByOneBit(int a, int b) {
    int diff = a ^ b;
    return diff != 0 && (diff & (diff - 1)) == 0;
  }

  public static void main(String[] args) {
    System.out.println(grayCode(Integer.parseInt(args[0])));
  }
}
