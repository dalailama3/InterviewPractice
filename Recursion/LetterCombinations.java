import java.util.*;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinations {
  public static List<String> letterCombinations(String digits) {
       if (digits.equals("")) return Collections.emptyList();
       String[] MAPPING = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       List<String> result = new ArrayList<String>();
       helper(0,digits,MAPPING,"",result);
       return result;
   }

   public static void helper(int offset, String digits, String[] mapping, String partialStr, List<String> result) {

     if (offset == digits.length()) {
       result.add(partialStr);
     } else {
       int digit = digits.charAt(offset) - '0';
       for (int i = 0; i < mapping[digit].length(); ++i) {
          partialStr = partialStr.concat(Character.toString(mapping[digit].charAt(i)));
          helper(offset+1,digits,mapping,partialStr,result);
          System.out.println(partialStr);
          partialStr = partialStr.substring(0,partialStr.length()-1);
       }
     }
   }

   public static void main (String[] args) {
     System.out.println(letterCombinations(args[0]));
   }

}
