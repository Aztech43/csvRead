package om.omantel.csv;
public class Data {

	private String FirstName;
	private String LastName;
	private String ArabicName;
	private String DOB;
    private String Gender;
    private String Nationality;
    private String Degree;
    private String GPA;
    private int Salary;

	public String getFN() {
		return FirstName;
	}
	public void setFN(String FirstName) {
		this.FirstName = FirstName;
	}
	public String getLN() {
		return LastName;
	}
	public void setLN(String LastName) {
		this.LastName = LastName;
	}
	public String getAN() {
		return ArabicName;
	}
	public void setAN(String ArabicName) {
		this.ArabicName = ArabicName;
	}

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}

    public String getNat() {
		return Nationality;
	}
	public void setNat(String Nationality) {
		this.Nationality = Nationality;
	}

    public String getDeg() {
		return Degree;
	}
	public void setDeg(String Degree) {
		this.Degree = Degree;
	}

    public String getGPA() {
		return GPA;
	}
	public void setGPA(String GPA) {
		this.GPA = GPA;
	}

	public int getSalary() {
		return Salary;
	}
	public void setSalary(int Salary) {
		this.Salary = Salary;
	}
	
	@Override
	public String toString(){
		return getFN() +" "+ getLN()+" is an " + getNat()+" and has a degree of "+getDeg()+" with a GPA of "+getGPA()+" and is earning " +getSalary() *12 + " yearly. The arabic name is "+getAN() + "\n";
        
    
        //"First Name = "+getFN()+"Last Name = "+getLN()+"Arabic Name = " + getAN()+" Date of Birth = "+getDOB()+" Gender = "+getGender()+" Nationality = " +getNat()+ " Degree = "+getDeg()+ " GPA = "+getGPA()+" Salary(Monthly)"+getSalary();
	}
    
}
