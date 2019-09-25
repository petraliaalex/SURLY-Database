import java.util.*;
public class Attribute {
   private String value;
   private String name; 
   private String datatype;
   private int maxLen;
   
   public Attribute (String inValue, String inName, String inDatatype, int inMaxLen) {
      this.value = inValue;
      this.name = inName;
      this.datatype = inDatatype;
      this.maxLen = inMaxLen;
   }
   
   public String getValue(){
      return value;
   }
   
   public void setValue(String newValue){
      value = newValue;
   }
   
   public String getName(){
      return name;
   }
   
   public void setName(String newName){
      name = newName;
   }
   
   public String getDatatype(){
      return datatype;
   }
   
   public void setDatatype(String newDatatype){
      datatype = newDatatype;
   }
   public int getMaxLen(){
      return maxLen;
   }
   
   public void setMaxLen(int newMaxLen){
      maxLen = newMaxLen;
   }
}