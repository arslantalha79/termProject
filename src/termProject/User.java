package termProject;


public class User implements IEntity {
	private int id;
	private int age;
	private String job;
	private String telNumber;
	private String name;
	private String surname;
	private String userName;
	private String password;
	private String securityQuestion;
	private String answer;


	public User() {
		
	}
	
	public User(int id,String name,String surname,int age,String userName,String password,String securityQuestion,String answer) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	
	public User(int id,String name,String surname,int age,String userName,String password,String securityQuestion,String answer,String telNumber,String job) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.telNumber = telNumber;
		this.job = job;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

