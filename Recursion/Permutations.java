import java.util.*;

public class Permutations {
  // public static List<List<Integer>> permute(int[] nums) {
  //
  // }


  public static List<Integer> getNextPermutation(List<Integer> array) {
    // start from the end and find first a[i] < a[i+1]
    int pivotPoint = -1;
    for (int i = array.size()-2; i >= 0; i--) {
      if (array.get(i) < array.get(i+1)) {
        pivotPoint = i;
        break;
      }
    }
    if (pivotPoint == -1) return new ArrayList<>();
    // start from the end and find first number greater than arr[pivotPoint], then swap these two
    for (int idx = array.size()-1; idx > pivotPoint; idx--) {
      if (array.get(idx) > array.get(pivotPoint)) {
        Collections.swap(array,pivotPoint,idx);
        break;
      }
    }
    //reverse sublist arr[pivotPoint + 1..]
    Collections.reverse(array.subList(pivotPoint+1,array.size()));
    return array;

  }

  public static void main (String[] args) {
    List<Integer> arr = new ArrayList<>(
      Arrays.asList(2,9,8,5));


    System.out.println(getNextPermutation(arr));
  }
}
