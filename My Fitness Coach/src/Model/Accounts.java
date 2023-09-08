package Model;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Accounts extends MuscleActivation{
    private String Username;
    private String Password;
    private boolean Active = false;
    static ArrayList<Accounts> User_List = new ArrayList<>();
    
    
    

    public static ArrayList<Accounts> getUser_List() {
        return User_List;
    }

    public static void setUser_List(ArrayList<Accounts> User_List) {
        Accounts.User_List = User_List;
    }
    
    public Accounts(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }
    
    public Accounts(){
        
    }
    
    public static boolean Register(String tryUsername, String tryPassword){
        
        for(Accounts accounts : User_List){
            if(accounts.getUsername().equals(tryUsername)){
                JOptionPane.showMessageDialog(null, "This username already is taken.");
                return false;
            }
        }
        if( tryUsername.length() >= 5 && tryPassword.length() >= 5){
            JOptionPane.showMessageDialog(null, "Account created successfully.\nRedirecting to a login screen...");
            return true;
        }
        else if ( tryUsername.length() >= 5 && tryPassword.length() < 5 ){
            JOptionPane.showMessageDialog(null, "Password must consist of at least 5 letters.");
        }
        else if ( tryUsername.length() < 5 && tryPassword.length() >= 5 ){
            JOptionPane.showMessageDialog(null, "Username must consist of at least 5 letters.");
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }
        return false;
    }

    static Accounts ActiveAccount(){
        for(Accounts acn : User_List){
            if(acn.isActive()){
                return acn;
            }
        }
        return null;
    }
    
    

    
    
    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
