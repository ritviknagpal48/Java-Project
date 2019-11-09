package myProject;
import com.mongodb.*;
import java.util.*;
import java.util.logging.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;



class todoList {
	
	static void printTodo()
	{
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
		
		
        String uri = "mongodb+srv://ritviknagpal48:retroa55@testingapi-yy853.mongodb.net/test";
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));

        
        DB database = mongoClient.getDB("test");
        DBCollection collection = database.getCollection("javaProject");
		
		BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John");
        DBCursor cursor = collection.find();
         
        while (cursor.hasNext()) {
        	DBObject ob = cursor.next();
        	System.out.println("Task Number: " + ob.get("Task Number"));
        	System.out.println("Date Of Creation: " + ob.get("Date Of Creation"));
        	System.out.println("Task Data: " + ob.get("Task"));
        	System.out.println("");
//            System.out.println(cursor.next());
        }
		
	}
	
	static void insertInTodo()
	{
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
		
		
        String uri = "mongodb+srv://ritviknagpal48:retroa55@testingapi-yy853.mongodb.net/test";
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));

        
        DB database = mongoClient.getDB("test");
        DBCollection collection = database.getCollection("javaProject");
       
        
      
        System.out.println("Enter your task description");
        Scanner input = new Scanner(System.in);
        String desc = input.nextLine();
        
        CommandResult resultSet = database.getCollection("javaProject").getStats();
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	int num = (int)resultSet.get("count");
        DBObject person = new BasicDBObject("Task Number", num+1)
                .append("Task", desc)
                .append("Date Of Creation", dateFormat.format(date));
        collection.insert(person);
		
	}
	
	static void deleteFromTodo()
	{
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
		
		
        String uri = "mongodb+srv://ritviknagpal48:retroa55@testingapi-yy853.mongodb.net/test";
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));

        
        DB database = mongoClient.getDB("test");
        DBCollection collection = database.getCollection("javaProject");
		System.out.println("Enter the Task Number that you wanna delete");
		Scanner input = new Scanner(System.in);
		
		int temp = input.nextInt();
        
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Task Number", temp);
         
        collection.remove(searchQuery);
	}
	
	static void updateTodo()
	{
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
		
		
        String uri = "mongodb+srv://ritviknagpal48:retroa55@testingapi-yy853.mongodb.net/test";
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));

        
        DB database = mongoClient.getDB("test");
        DBCollection collection = database.getCollection("javaProject");
		
        BasicDBObject query = new BasicDBObject();
        
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        
        
        System.out.println("Enter the Task Number that you wanna update");
        int temp = input.nextInt();
        System.out.println("Enter the updated Task data");
        String up = input2.nextLine();
        
query.put("Task Number", temp);
BasicDBObject newDocument = new BasicDBObject();
newDocument.put("Task", up);
BasicDBObject updateObject = new BasicDBObject();
updateObject.put("$set", newDocument);
collection.update(query, updateObject);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        
        System.out.println("Welcome to MyDaily, a Java Based Todo List !!!");
        
        System.out.println("Enter your option: ");
        System.out.println("1) View My TodoList");
        System.out.println("2) Insert In My TodoList");
        System.out.println("3) Update in My TodoList");
        System.out.println("4) Delete from My TodoList");
        System.out.println("5) Exit");
        Scanner input = new Scanner(System.in);

        
        int choice = input.nextInt();
        while(choice != 5)
        {
        	if(choice == 1)
        	{
        		printTodo();
        		
        		
        	}
        	
        	else if(choice == 2)
        	{
        		insertInTodo();
        		
        	}
        	
        	
        	else if(choice == 3)
        	{
        		updateTodo();
        		
        	}
        	
        	
        	else if(choice == 4)
        	{
        		deleteFromTodo();
        	}
        	
        	else if(choice == 5)
        	{
        		break;
        	}
        	
        	else
        	{
        		break;
        	}
        	
        	
        	System.out.println("Enter your next choice");
    		int ch = input.nextInt();
    		choice = ch;
        }
        
        System.out.println("Exited successfully !!!");
        
        



        
        //  ***insert***


        
        // ***update***

        
        
        
        //  ***delete***

        
        
        
//         ***display all***
        
        
        
        
        
        

        
        



	}

}
