import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public void addPerson(Person person) throws SQLException {
		//query of postgresql
		String sql = "insert into person(name, identity, birthday)"
				+ "values (?,?,?)";
		
		PreparedStatement ps = this.connection.prepareStatement(sql);
		// 1 = first '?' 
		ps.setString(1, person.getName());
		// 2 - second '?'
		ps.setString(2, person.getIdentity());
		// 3 = third '?'
		ps.setString(3, person.getBirthday());
		
		//use execute update when the database return nothing
		ps.executeUpdate();
		
	}

	public void removePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public Person getPerson(String name) throws SQLException {
		//get all persons
		ArrayList<Person> array = getAllPersons();
		for (Person person : array) {
			if(person.getName().equals(name)) {
				return person;
			}
		}
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
		result.close();
		return array;
		
	}
}
