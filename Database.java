
//creates database linked list of relations
import java.util.*;


public class Database{
	
   LinkedList<Relation> database;
   
   public Database(){
      database = new LinkedList<Relation>();
   }
   
   public LinkedList<LinkedList<String>> newData(){
	      Scanner file = mainMethod.getFile();
	      LinkedList<LinkedList<String>> data = parser.parse(file);
	      return data;
	}
   
   
   public void insert(LinkedList<String> args){
	      Relation newRelation = new Relation(args);
	      database.add(newRelation);
	}
   
   
   // New function to get the size of the database. Seems like it can be pretty useful
   public int size() {
	   return database.size();
   }
   
   // Return each relation in the database (aka linked list of relations) at a given index
   public Relation get_relation(int index) {
	   return database.get(index);
   }
   
   public Relation getRelationByName(String name){
	      for (int i = 0; i < size(); i++){
	         Relation cur_rel = database.get(i);
	         String relName = cur_rel.getName();
	         if (relName.equals(name)){
	            return cur_rel;
	         }
	      }
	      return null;
   }
   
   
}
