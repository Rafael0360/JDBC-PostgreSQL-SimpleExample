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
		
		Person person = new Person();
		person.setName("Chloe");
		person.setIdentity("ZAA21");
		person.setBirthday("10/10/1980");
		pjdbc.addPerson(person);
		
		
		ArrayList<Person> array = pjdbc.getAllPersons();
		
		for (Person i : array) {
			System.out.println(i.getName()+ ", your id is "+ i.getId()+ 
					", "+ i.getBirthday());
		}
		

	}

}
