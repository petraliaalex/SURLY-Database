/*
Project class 
--------------------------
Returns the specified attributes of a relation in a new, temporary relation.
Syntax:

temprelationname = PROJECT <attribute names> FROM relationname;

Example:

P = PROJECT CREDITS, CNUM FROM COURSE;
*/

class proj_command extends Base_Commands{
   
   int index;
	String proj_database;
	Relation proj;

   public proj_command(Database mdatabase){
      super(mdatabase);
   }
   
   public void start(int n_index) {
      this.index = n_index;
      run();
   }
   
   public void run() {
      rel = s_database.getRelationByName(queries.get(index).get(0));
		if(rel == null) {
			System.out.println("ERROR: Insert error at line " + (index+1));
         //ERROR: "=" clause causes a problem in the database class, returns null
		} else {
			queries.get(index).remove(0);
         
         //1. identify "PROJECT" clause
         
         //2. point to the attribute names
         
         //3. account for "FROM" clause
         
         //4. grab attributes from the given relation
      }
         
   
   
   
   
   }
}
   
//------------------------------------------------------------
/*
   String inputStrig = "PROJECT CREDITS, CNUM FROM COURSE";
   String[] strigSplit = inputStrig.split(" ");
   public static void main(String[] args){
;
   }
   
   static void projSaves(String[] strigArray){
      System.out.println(strigArray);
   }
   projSaves(strigSplit);

}
*/
