
public class Insert_command extends Base_Commands{
	
	int index;
	String rel_database;
	Relation rel;

	public Insert_command(Database mdatabase) {
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
		} else {
			queries.get(index).remove(0);
			rel.insert(queries.get(index));
		}
	}
	
	
	
}

