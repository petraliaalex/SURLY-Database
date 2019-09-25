import java.util.*;
public class Tuple {
    private LinkedList<Attribute> attributes;
    
    public Tuple (LinkedList<String> input, LinkedList<Attribute> schema) {
      this.attributes = new LinkedList<Attribute>();
      int inputlen = input.size();
      for (int i =0; i < inputlen; i++){
         //check that input[i] matches the schema requirements.
         Attribute schemaAtt = schema.get(i);
         if (checkSchema(input.get(i), schemaAtt)){
            Attribute newAtt = new Attribute(input.get(i), schemaAtt.getValue(), schemaAtt.getDatatype(), schemaAtt.getMaxLen());
            attributes.add(newAtt);
         }else{ //does not meet schema requirements
            System.out.println("ERROR: Tuple input value does not meet schema requirements");
            Attribute newAtt = new Attribute("-1", schemaAtt.getValue(), schemaAtt.getDatatype(), schemaAtt.getMaxLen());
            attributes.add(newAtt);
         }
         
      }
    }
    
    public LinkedList<Attribute> getAttributes(){
      return attributes;
    }
    
    private boolean checkSchema(String inputstr, Attribute schemaAtt){
      int inputlen = inputstr.length();
      if (inputlen > schemaAtt.getMaxLen()){
         return false;
      }
      String schemaval = schemaAtt.getDatatype();
      if (schemaval.equals("NUM") ){
         try{
            int x = Integer.parseInt(inputstr);
         }catch (NumberFormatException e){
            return false;
         }   
      }
      return true;   
    }
}