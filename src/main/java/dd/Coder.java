package dd;

// JavaBean
public class Coder {
    private String firstName;
    private String lastName;

    public Coder() {
    }

    public Coder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Coder [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
