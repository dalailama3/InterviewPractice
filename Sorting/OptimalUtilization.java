//Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
//Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
//Return a list of ids of selected elements. If no pair is possible, return an empty list.
import java.util.*;
public class OptimalUtilization {


    public static List<List<Integer>> findOptimalPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // sort both lists
        //convert them to lists
        Collections.sort(a, new Comparator<List<Integer>> () {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                return Integer.compare(l1.get(1),l2.get(1));
            }

        });
        System.out.println("a: " + a);
        Collections.sort(b, new Comparator<List<Integer>> () {
                    @Override
                    public int compare(List<Integer> l1, List<Integer> l2) {
                        return Integer.compare(l1.get(1),l2.get(1));
                    }

        });
        System.out.println("b: " + b);
        // a and b are sorted

        int leftA = 0;
        int rightB = b.size() - 1;
        int optimal = -1;

        helper(result, leftA,rightB, target, a, b,optimal);
        System.out.println(result);

        leftB = 0;
        helper(result, leftA,rightB, target, a, b,optimal);
        System.out.println(result);



        return result;

    }

    public static void helper(List<List<Integer>> result, int left, int right, int target,List<List<Integer>> a,List<List<Integer>> b,int optimal) {
            while (left < right) {
                    int sum = a.get(left).get(1) + b.get(right).get(1);
                    if (sum < target) {
                        //check if sum is better than optimal
                        if (sum >= optimal) {
                            optimal = sum;
                            //clear everything in result
                            result.clear();
                            ArrayList<Integer> pair = new ArrayList<>();
                            pair.add(a.get(left).get(0));
                            pair.add(b.get(right).get(0));
                            result.add(pair);
                        }
                        left++;
                    } else if (sum == target) {
                        optimal = sum;
                        result.clear();
                        ArrayList<Integer> pair = new ArrayList<>();
                        pair.add(a.get(left).get(0));
                        pair.add(b.get(right).get(0));
                        result.add(pair);
                        break;


                    } else {
                        right--;
                    }
                }
    }


    public static void main(String[] args) {
//        Input:
//        a = [[1, 3], [2, 5], [3, 7], [4, 10]]
//        b = [[1, 2], [2, 3], [3, 4], [4, 5]]
//        target = 10
//
//        Output: [[2, 4], [3, 2]]
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        list1.add(Arrays.asList(1,3));
        list1.add(Arrays.asList(2,5));
        list1.add(Arrays.asList(3,7));
        list1.add(Arrays.asList(4,10));

        list2.add(Arrays.asList(4,5));
        list2.add(Arrays.asList(2,3));
        list2.add(Arrays.asList(3,4));
        list2.add(Arrays.asList(1,2));

        findOptimalPairs(list1,list2,10);

    }

}