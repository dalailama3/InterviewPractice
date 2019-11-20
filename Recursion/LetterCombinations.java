import java.util.*;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
       if (digits.equals("")) return Collections.emptyList();
       String[] MAPPING = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       List<String> result = new ArrayList<String>();
       helper(0,digits,MAPPING,"",result);
       return result;
   }

   public helper(int offset, String digits, String[] mapping, String partialStr, List<String> result) {

     if (offset == digits.length()) {
       result.add(partialStr);
     } else {
       
     }
   }

}
