package cbinetsheriff_garnettgrant_comp228_lab5;

public class Player {




    public int ID;
    public String FirstName;
    public String LastName;
    public String Address;

    public String Postal_Code;
    public String Province;
    public String Phone;

    //Getters and Setters
    public int getID(){
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostal_Code() {
        return Postal_Code;
    }

    public void setPostal_Code(String postal_Code) {
        Postal_Code = postal_Code;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


    //Constructor for use from database
    public Player(int id, String name, String lname,String address, String postal, String province, String phone){
        ID = id;
        FirstName = name;
        LastName = lname;
        Address = address;
        Postal_Code = postal;
        Province = province;
        Phone = phone;
    }

    //constructor for player without id for creation of player object before insert into database
    public Player( String name, String lname, String address, String postal, String province, String phone){
        FirstName = name;
        LastName = lname;
        Address = address;
        Postal_Code = postal;
        Province = province;
        Phone = phone;
    }

    @Override
    public String toString() {
        return FirstName;
    }
}
