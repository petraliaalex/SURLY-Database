import java.util.*;


public class tempRelation {
	
	   private LinkedList<Tuple> tuples;
	   private String name;
	   private int tupleCount;
	   private LinkedList<Attribute> schema;
	   private int colnum;
	   
	   public tempRelation(LinkedList<Attribute> schema){
	      this.tuples = new LinkedList<Tuple>();
	      this.name = schema.get(0).getValue();
	      schema.removeFirst();
	      this.schema = schema;
	   }
	   
	   public LinkedList<Tuple> getTuples(){
	      return tuples;
	   }
	   
	   public String getName(){
	      return name;
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
	   
}

