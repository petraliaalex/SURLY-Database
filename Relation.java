import java.util.*;


public class Relation {
	
	   private LinkedList<Tuple> tuples;
	   private String name;
	   private int tupleCount;
	   private LinkedList<Attribute> schema;
	   private int colnum;
	   
	   public Relation(LinkedList<String> inputvalues){
	      this.tuples = new LinkedList<Tuple>();
	      this.name = inputvalues.get(0);
	      inputvalues.removeFirst();
	      this.schema = defineSchema(inputvalues);
	   }
	   
	   public void insert(LinkedList<String> args){
	      if (args.size() != colnum){
	         System.out.println("ERROR: wrong number of attributes for insert");
	      }else{
	         Tuple newtuple = new Tuple(args, schema);
	         boolean correct_attr = true;
	         for(int i = 0; i < newtuple.getAttributes().size();i++) {
	        	 if(newtuple.getAttributes().get(i).getValue().equals("-1")) {
	        		 correct_attr = false;
	        	 }
	         }
	         if(correct_attr == true) {
	        	 tuples.add(newtuple);
        		 tupleCount++;
	         }
	      }
	   }
	   
	   public LinkedList<Tuple> getTuples(){
	      return tuples;
	   }
	   
	   public String getName(){
	      return name;
	   }
      
      //new function
      public void changeName(String newName){
        this.name = newName;
      }
	   
      //new function
      public void changeSchema(LinkedList<String> newInputValues){
         this.schema = defineSchema(newInputValues);
      }
      
	   public int getTupleCount(){
	      return tupleCount;
	   }
	   
	   public LinkedList<Attribute> getSchema(){
	      return schema;
	   }
	   
	   public int getColnum(){
	      return colnum;
	   }
	   
	   private LinkedList<Attribute> defineSchema(LinkedList<String> args){
	      LinkedList<Attribute> schemaSet = new LinkedList<Attribute>();
	      int argcount = args.size();
	      for (int i = 0; i < argcount; i++){
	         if (i%3 == 0){
	            Attribute schemaVal = new Attribute(args.get(i), "schema", null, 0);
	            schemaSet.add(schemaVal);
	         }else if (i%3 == 1){
	            Attribute currentAtt = schemaSet.get(i/3); 
	            currentAtt.setDatatype(args.get(i));
	         }else{
	            Attribute currentAtt = schemaSet.get(i/3);
	            try {
	            	currentAtt.setMaxLen(Integer.parseInt(args.get(i)));
	            	colnum++;
	            } catch (NumberFormatException e) {
	            	System.out.println("Incorrect schema of format");
	            }
	         }
	      }
	      return schemaSet;
	   }
	   
	   
}

