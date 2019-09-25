import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
class parser{
   static LinkedList<LinkedList<String>> queryLL = new LinkedList();
   
   //-----------------------------------------String Array Method---------------------------------------------
   public static LinkedList<LinkedList<String>> parse(Scanner file){
      
      Scanner fileCopy = file;
      int rowCount = 0;
      int columnCount = 0;
      String curString = "";
      
      while(file.hasNext()){
      
         String line = file.nextLine();
         //String[] relArray = line.split("(),;", 5);
         line = line.replaceAll("[()]", "");
         line = line.replaceAll(";","");
         
         line  = line.replaceAll(",","");
         //String[] relArray = line.split(" ");
         int lineLength = line.length();
         LinkedList<String> relArray = new LinkedList();
         String charsWatch = "' ";
         int inquotes = 0;
         char quo = charsWatch.charAt(0);
         for(int i = 0; i < lineLength; i++){
            if (line.charAt(i) == quo){
               inquotes = 1 - inquotes;
            }else if(inquotes != 1){
               while (line.charAt(i) == ' '){
                  i++;
               }   
               int j = i;
               while (line.charAt(i) != ' '){
                  if (i == lineLength-1){
                     i++;
                     break;
                  }
                  i++;   
               }
               String subString = line.substring(j, i);
               relArray.add(subString);
            }else if (inquotes == 1){
               int j = i;
               while(line.charAt(i) != quo){
                  if(line.charAt(i) == 0){
                     System.out.println("ERROR: invalid number of ' in string");
                     System.exit(0);
                  
                  }
                  i++;
               
               }
               String subString = line.substring(j, i);
               relArray.add(subString);
               i--;
            }
            
         }
         
         String relArrayLink = relArray.peek();
         queryLL.add(relArray);
      }
   return queryLL;   
      
   }
}