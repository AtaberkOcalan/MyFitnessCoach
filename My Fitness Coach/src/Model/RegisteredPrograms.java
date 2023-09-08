
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RegisteredPrograms extends Accounts{
    
    static ArrayList<String> Programs = new ArrayList<>();
    static ArrayList<String> ProgramsName = new ArrayList<>();
    
    
    
    
    public RegisteredPrograms(){
        Accounts acn = Accounts.ActiveAccount();
        
        try(Scanner scn = new Scanner(new BufferedReader(new FileReader("Programs.txt")))){
            Programs.clear();
            ProgramsName.clear();
            while(scn.hasNextLine()){
                String ProgramInfo = scn.nextLine();
                String[] Array = ProgramInfo.split(",");
                if(Array[0].equals(acn.getUsername())){
                    Programs.add(ProgramInfo);
                    ProgramsName.add(Array[1]);
                }
                
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "The file cannot be found!");
        }
    }
    
    
    
    static void deleteLine(int Number){
        
        try (Scanner scn = new Scanner(new BufferedReader(new FileReader("Programs.txt")))){
            int x = 0;
            while(scn.hasNextLine()){
                x++;
                String oneLine = scn.nextLine();
                if ( x != Number ){
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProgramsCopy.txt",true))){
                        writer.write(oneLine+"\n");
                    }
                }  
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegisteredPrograms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisteredPrograms.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Programs.txt"))){
            
            writer.write("");
            
        } catch (IOException ex) {
            Logger.getLogger(RegisteredPrograms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (Scanner scn = new Scanner(new BufferedReader(new FileReader("ProgramsCopy.txt")))){
            while (scn.hasNextLine()){
                String ProgramInfo = scn.nextLine();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Programs.txt",true))){
                        writer.write(ProgramInfo+"\n");
                } catch (IOException ex) {
                    Logger.getLogger(RegisteredPrograms.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegisteredPrograms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProgramsCopy.txt"))){
            writer.write("");
        } catch (IOException ex) {
            Logger.getLogger(RegisteredPrograms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
