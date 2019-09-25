
public class Print_command extends Base_Commands{
	
	int index;

	public Print_command(Database mdatabase) {
		super(mdatabase);
	}
	
	
	public void start(int n_index){
		this.index = n_index;
		run();
	}
	
	public void run() {
		for(int j = 0; j < s_database.size(); j++) {
			String cur_relation = s_database.get_relation(j).getName();
			
			if(queries.get(index).contains(cur_relation)) {
				System.out.println(s_database.get_relation(j).getName() + " RELATION");
				Relation relation_cur = s_database.get_relation(j);
				
				for(int k = 0; k < relation_cur.getSchema().size(); k++) {
					System.out.printf("%-29s ", relation_cur.getSchema().get(k).getValue());
				}
				
				System.out.println(""); // to separate the titles from the first value of the tables
				
				for(int s = 0 ; s < relation_cur.getTupleCount(); s++) {
					for(int k = 0; k < relation_cur.getColnum();k++) {
						
						System.out.printf("%-29s ",relation_cur.getTuples().get(s).getAttributes().get(k).getValue());
					}
					System.out.println("");
				}
				System.out.println("\n");
			}
		}
	}



}


