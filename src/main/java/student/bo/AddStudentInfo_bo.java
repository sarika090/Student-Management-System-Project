package student.bo;

public class AddStudentInfo_bo {

	private int id;
	private String name;
	private String email;
	private String age;
	private String city;
	private String gender;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Override
	public String toString() {
		return "AddStudentInfo_bo [name ="+ name + ",email="+ email + ", age="+ age +", city=" 
	                      + city + ", gender= " + gender +"]";
	}

	
	public AddStudentInfo_bo(String name, String email, String age, String city, String gender) {
		super();

		this.name = name;
		this.email = email;
		this.age = age;
		this.city = city;
		this.gender = gender;
	}
	
	public AddStudentInfo_bo() {
		super();
		
	}
	
	
}
