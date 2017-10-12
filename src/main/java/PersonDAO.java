import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonDAO {
	
	/*
	 * add person in database
	 */
	public void addPerson(Person person) throws SQLException;
	/*
	 * remove person of database
	 */
	public void removePerson(Person person) throws SQLException;
	/*
	 * get one person with similar name.
	 */
	public Person getPerson(String name) throws SQLException;
	/*
	 * get all persons
	 */
	public ArrayList<Person> getAllPersons() throws SQLException;
}
