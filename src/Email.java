import java.util.Scanner;

public class Email {

   private String firstName;
   private String lastName;
   private String password;
   private String department;
   private int mailBoxCapacity = 500;
   private int defaultPasswordLength = 10;
   private String email;
   private String alternateEmail;
   private String companySufix = "aeycompany.com";

   // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName= firstName;
        this.lastName= lastName;
       // System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
       // System.out.println("Department: " + this.department);

        // Call a method that return a random passowrd
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your passowrd is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySufix;
        System.out.println("Your email is: " + email);
    }

    // Ask for the department
    private String setDepartment(){
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in= new Scanner(System.in);
        int depChoice= in.nextInt();
        if (depChoice == 1){
            return "sales";
        } else if (depChoice == 2){
            return "dev";
        } else if(depChoice== 3){
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passowrdSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passowrdSet.length());
            password[i] = passowrdSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateEmail(){
        return  alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }

}
