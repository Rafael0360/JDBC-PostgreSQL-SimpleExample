import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonJDBC implements PersonDAO{
	
	private Connection connection;
	
	public PersonJDBC(String url, String user, String password) throws ClassNotFoundException, SQLException {
		//load driver communication of postgresql.
		Class.forName("org.postgresql.Driver");
		//open the connection
		this.connection = DriverManager.getConnection(url, user, password);
	}

	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void removePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public Person getPerson(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Person> getAllPersons() throws SQLException {
		ArrayList<Person> array = new ArrayList<Person>();
		
		//get all persons
		//query of postgresql
		ResultSet result = this.connection.prepareStatement("select * from person").executeQuery();
		while(result.next()) {
			//new Person
			Person person = new Person();
			//get column of name
			person.setName(result.getString("name"));
			person.setId(result.getInt("id_person"));
			person.setIdentity(result.getString("identity"));
			person.setBirthday(result.getString("birthday"));
			array.add(person);
		}
		return array;
	}
}
