
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RegisteredAccounts {

    public RegisteredAccounts() {
        try(Scanner scn = new Scanner(new BufferedReader(new FileReader("Users.txt")))){
            while(scn.hasNextLine()){
                String UsersInfo = scn.nextLine();
                String[] array = UsersInfo.split(",");
                Accounts.User_List.add(new Accounts(array[0],array[1]));
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "The file cannot be found!");
        }
    }
    
}
