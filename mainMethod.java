import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class mainMethod {
	private static Scanner file = null;
	public static void main(String[] args) {
		
	      Scanner fileIn = new Scanner(args[0]);
	      String fileInput1 = fileIn.nextLine();
	      String fileInput = fileInput1.toString();
	      Base_Commands cmd_helper;
	      //catches if too many arguments
	      if(args.length > 1){
	         System.out.print("Too many arguments");
	         //correct end statement?
	      }
	      //catches if wrong format
	      try{
	         file = new Scanner(new File(fileInput));
	      }catch(Exception e){
	         System.out.println("-------------------");
	         System.out.println("Could not find file");
	         System.out.println("-------------------");
	      }
	      
			Database db = new Database();
			cmd_helper = new Base_Commands(db);
			cmd_helper.run();
	}
	
	public static Scanner getFile(){
	      return file;
	}
}
