public class Information {
    private String firstName;

    private String lastName;

    private String middleInitial;

    private String gender;

    private String guardianName;

    private String contactNo;

    public String getFirstName(){
        return  firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getMiddleInitial(){
        return middleInitial;
    }

    public String getGender(){
        return gender;
    }

    public String getGuardianName(){
        return guardianName;
    }

    public String getContactNo(){
        return contactNo;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMiddleInitial(String middleInitial){
        this.middleInitial = middleInitial;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setGuardianName(String guardianName){
        this.guardianName = guardianName;
    }

    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
}
