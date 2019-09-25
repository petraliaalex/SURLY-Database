import java.util.LinkedList;

public class Relation_command extends Base_Commands{
	
	int index;
	Relation newrel;

	public Relation_command(Database mdatabase) {
		super(mdatabase);
	}
	
	
	public void start(int n_index) {
		this.index = n_index;
		run();
	}
	
	public void run() {
		if(s_database.getRelationByName(queries.get(index).get(0)) == null) {
			s_database.insert(queries.get(index));
		}
	}
}
