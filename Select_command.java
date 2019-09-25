/*
SELECT WHERE
Returns all tuples in a relation that meet the specified 
conditions in a new, temporary relation. The where clause 
should handle multiple conditions. If no where clause is 
included, all tuples are returned.

Syntax:

temprelationname = SELECT relationname WHERE <conditions>;

Examples:

C = SELECT COURSE;
T1 = SELECT OFFERING WHERE CID = CSCI241 and SECTION > 27922;
PRE = SELECT PREREQ WHERE CNBR = CSCI241 or CNBR = CSCI145 and PNBR != CSCI141;
*/
import java.util.LinkedList;

public class Select_command extends Base_Commands {
   int index;
	String sel_database;
	Relation rel;
   tempRelation tempRel;
   LinkedList<LinkedList<String>> queries;
   LinkedList<LinkedList<String>> queriesCopy;

   public Select_command(Database mdatabase){
      super(mdatabase);
   }
   
   public void Select_command_constr(LinkedList<LinkedList<String>> i_queries, LinkedList<LinkedList<String>> i_queriesCopy, int i){
      this.index = i;
      this.queries = i_queries;
      this.queriesCopy = i_queriesCopy;
   }

   
   public void start(int n_index) {
      this.index = n_index;
      run();
   }
   
   public void run() {
      /*rel = s_database.getRelationByName(queries.get(index - 1).get(3));  //-1 on index b/c i think the size is skipping "="
		if(rel == null) {
			System.out.println("ERROR: Insert error at line " + (index+1));
      */
      if (queries.get(index - 1).get(4) == "WHERE"){  //-1 on index b/c i think the size is skipping "="
         //logic for WHERE clause
      
      } else {
         
         
		}
	}
}

/*               
               for(int z = 0; z < queries.size(); z++){
                  //queries.get(z).get(0) == "RELATION" & 
                  if(queries.get(z).get(1) == queries.get(i).get(3)){ //if it's a relation and the Relation names match
                     String tempRelName = queries.get(i).get(0); //grabs temp relation name
                     LinkedList<String> tempQuery = queries.get(z); //makes a copy of the relation
                     tempQuery.set(1 , tempRelName); //changes the name of the relation
                     queries.set(i, tempQuery);
                     re_command.start(i);
                     System.out.print(tempQuery);
                  }
               
               }
*/















