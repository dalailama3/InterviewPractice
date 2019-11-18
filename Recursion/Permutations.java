import java.util.*;

public class Permutations {
  public static List<List<Integer>> permute(int[] nums) {
    // sort the nums array and then call getNextPermutation n! times for a time complexity of O(n * n!)
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<Integer>();
    for (int num : nums) {
      list.add(num);
    }
    Collections.sort(list);
    System.out.println("sorted: " + list);
    while (!list.isEmpty()) {
      //System.out.println(list);
      // need to create a new copy of list
      result.add(new ArrayList<>(list));
      list = getNextPermutation(list);

    }
    return result;
  }


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
      Arrays.asList(2,1,3));

    int[] arr1 = {1,2,3,4,5};

    //System.out.println(getNextPermutation(arr));
    System.out.println(permute(arr1));
  }
}
