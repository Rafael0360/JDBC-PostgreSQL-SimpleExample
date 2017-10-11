import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//you need create database with this name 'github-example-jdbc'
		String url = "jdbc:postgresql://localhost:5432/github-example-jdbc";
		//user default
		String user = "postgres";
		//your password. root is default
		String password = "root";
		PersonJDBC pjdbc = new PersonJDBC(url, user, password);
		ArrayList<Person> array = pjdbc.getAllPersons();
		
		for (Person person : array) {
			System.out.println(person.getName()+ ", your id is "+ person.getId());
		}
		

	}

}
