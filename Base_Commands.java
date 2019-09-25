import java.util.*;


public class Base_Commands implements Icommand {
	
	Database s_database;
	LinkedList<LinkedList<String>> queries; // All queries
	int num_queries;
   
   
	static boolean cmdCount = true;
   
	public Base_Commands(Database mdatabase) {
      this.s_database = mdatabase;
		this.queries = mdatabase.newData();
		this.num_queries = queries.size();

	}

	public void run() {	
		Relation_command re_command = new Relation_command(s_database);
		Insert_command in_command = new Insert_command(s_database);
		Print_command pr_command = new Print_command(s_database);
      Select_command sel_command = new Select_command(s_database);
      proj_command proj_command = new proj_command(s_database);
      
		for(int i = 0; i < num_queries; i++) {
         LinkedList<String> tempQ = queries.get(i);
			if(queries.get(i).get(0).compareTo("RELATION") == 0) {
				queries.get(i).remove(0);
				re_command.start(i);
			} else if(queries.get(i).get(0).compareTo("INSERT") == 0) {
				queries.get(i).remove(0); // removes insert from linked list queries
				in_command.start(i);
			} else if(queries.get(i).get(0).compareTo("PRINT") == 0) {
            queries.get(i).remove(0);
				pr_command.start(i);
         
			} else if(queries.get(i).get(1).compareTo("=") == 0){
            if(queries.get(i).get(2).compareTo("SELECT") == 0){
               int relIndex = 0; 
               for(int z = 0; z < s_database.size(); z++){//grabs the index of the relation, requires all Relation queries to be at the top of the .txt file
                  if(s_database.get_relation(z).getName().equals(queries.get(i).get(3))){
                     relIndex = z;
                  }
               }
               s_database.insert(queries.get(relIndex));
               s_database.get_relation(relIndex).changeName(queries.get(i).get(0));
             
            }else if(queries.get(i).get(2).compareTo("PROJECT") == 0){
               int relIndex2 = 0;
               int qLength = queries.get(i).size() - 1; //index of the relation name on the current query
               LinkedList<String> tempQuer = queries.get(i); //current query we are looking to execute
               String relString = queries.get(i).get(qLength); //name of the relation we are looking at
               Relation tempRelation = s_database.getRelationByName(relString); //doesn't work if the Relation was used in a temp relation
               LinkedList<Attribute> tempSchema = tempRelation.getSchema(); //copy of the schema for the relation we want to look at
               for(int x = 0; x < s_database.size(); x++){//grabs the index of the relation, requires all Relation queries to be at the top of the .txt file
                  if(s_database.get_relation(x).getName().equals(queries.get(i).get(qLength))){
                     relIndex2 = x;
                  }
               }
               LinkedList<String> curRelquery = queries.get(relIndex2);//query String we want to look at and change
               String[] attrArray = new String[qLength - 4];
               attrArray[0] = tempQuer.get(qLength);
               int arrayCount = 0;
               for(int w = 3; w < qLength - 1; w++){ //captures all the attributes we want to look at in the query
                  attrArray[arrayCount] = tempQuer.get(w);
                  arrayCount++;
               }
               LinkedList<String> finalRelQuery = new LinkedList<String>();
               finalRelQuery.add(relString);  
               for(int u = 0; u < attrArray.length; u++){ //iterartes through the array of attributes
                  for(int y = 0; y < curRelquery.size(); y++) {   //if ordering of the attributes is messed up in prints look at this for changes
                     if(attrArray[u].equals(curRelquery.get(y))){ //if an attribute name is matched
                        finalRelQuery.add(curRelquery.get(y));
                        finalRelQuery.add(curRelquery.get(y+1));
                        finalRelQuery.add(curRelquery.get(y+2));    //adds to final query we will use for PROJECT
                     }
                  }
               }
               s_database.insert(finalRelQuery);
               s_database.get_relation(s_database.size()-1).changeName(queries.get(i).get(0));                                        
               //----------------relation is now created---------------------
               //----------------now adding tuples---------------------------
               
               //descending down the LinkedList of LinkedLists
               LinkedList<Tuple> tuplesLL = tempRelation.getTuples();
               Tuple tuplesList = tuplesLL.get(0);
               LinkedList<Attribute> attributeLL = tuplesList.getAttributes();
               Attribute attributesInfo = attributeLL.get(0); //getters&setters for value, name, datatype, maxLen
               System.out.println("Check");
               
               LinkedList<Tuple> tuplesLLX = tempRelation.getTuples();;
               Tuple tuplesListX;
               LinkedList<Attribute> attributeLLX;
               Attribute attributesInfoX;
               System.out.println("Check");
               
               //----final tuples we will add to
               
               
               LinkedList<Tuple> finalTuples;
               
               
               //-----
               
               //makes new tuples for the new relation
               for(int a = 0; a < attrArray.length; a++){            //2 iterations for 2 attributes
                  for(int b = 0; b < tuplesLLX.size(); b++){         //2 iterations
                     tuplesListX = tuplesLLX.get(b);                 //2 attributes grabbed 
                     attributeLLX = tuplesListX.getAttributes();
                     for(int c = 0; c < attributeLLX.size(); c++){   //2 iterations
                        attributesInfoX = attributeLLX.get(c);       //1 attribute info grabbed
                        String aValue = attributesInfoX.getValue();
                        String aName = attributesInfoX.getName();
                        String aDatatype = attributesInfoX.getDatatype();
                        int aMaxLen = attributesInfoX.getMaxLen();
                        if(aName.equals(attrArray[a])){                   //if the name of the attribute matches
                           finalTuples
                        
                        }
                     }
                  }
               }       
            }
         }
      }
   }
}




               
               
               
               
                //LinkedList<String> queryCop = queries.get(i);
                //Relation relCopy = s_database.getRelationByName(queries.get(i).get(3));
                //s_database.insert(queries.get(
                //String tempRelName = relCopy.getName();        //grabs temp relation name
               // 
                //LinkedList<String> tempQuery = queriesCopy.get(z); //makes a copy of the relation
                //tempQuery.set(1 , tempRelName);                    //changes the name of the relation
                //queries.set(i, tempQuery);
                //re_command.start(i);
                                                                   //System.out.print(tempQuery);
            

            
            
            
            
            
            
            
            
         
            /*
               //Select_command.Select_command_constr(queries, queriesCopy, i);
               //queries.get(i).remove(0);
               for(int z = 0; z < num_queries; z++){
                  if(queries.get(i).size() >  2                                           //checks index               
                  & queriesCopy.get(z).get(0).compareTo("RELATION") == 0                      //check if a Relation
                  & queriesCopy.get(z).get(1).compareTo(queries.get(i).get(3)) == 0){         //check for Relation name match
                 //if the indexed query is a relation
                 //if both are true, continue
                     String tempRelName = queries.get(i).get(0);        //grabs temp relation name
                     LinkedList<String> tempQuery = queriesCopy.get(z);     //makes a copy of the relation
                     tempQuery.set(1 , tempRelName);                    //changes the name of the relation
                     queries.set(i, tempQuery);
                     re_command.start(i);
                     //System.out.print(tempQuery);
               }
            */
               
            
            //sel_command.start(i);  