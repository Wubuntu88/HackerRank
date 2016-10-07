import java.util.*;
/**
 * Solution to the hackerrank.com problem Tag Context Extractor.
 * To see it run, paste text into the box at 
 * https://www.hackerrank.com/challenges/tag-content-extractor
 * To solve this problem I looked at someone else's code first before I wrote it
 * on my own (my first attempt failed).
 * @author William Gillespie
 *
 */

public class Solution{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){         
         String line = in.nextLine();
         boolean isNone = true;
         int current = 0;
         while(true) {
             int startIndex = line.indexOf("<", current);
             if(startIndex < 0) {
                 break;
             }
             
             int endIndex = line.indexOf(">", startIndex+1);
             if(endIndex < 0) {
                 break;
             }
             
             String tag = line.substring(startIndex + 1, endIndex);
             if(tag.length() == 0 || tag.charAt(0) == '/'){
                 current = endIndex + 1;
                 continue;
             }
             
             String closingTagStr = "</"+tag+">";
             int indexOfMatchingClosingTag = line.indexOf(closingTagStr, endIndex+1);
             if (indexOfMatchingClosingTag >= 0){
                 String candidate = line.substring(endIndex + 1, indexOfMatchingClosingTag);
                 int indexOfAnyOpenAngleBracket = candidate.indexOf("<");
                 if(candidate.length() > 0 && 
                    indexOfAnyOpenAngleBracket < 0){//if there was no "<" character
                     System.out.println(candidate);
                     isNone = false;                     
                 }
             }
             
             current = endIndex + 1;
         }
          
         if(isNone){
             System.out.println("None");
         }
         
         testCases--;
      }
   }
}
