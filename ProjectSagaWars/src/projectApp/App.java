/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectApp;
import auxClasses.Hilo;
import javax.swing.SwingUtilities;
import projectClasses.Administrator;
import projectClasses.Processor;
import projectInterface.Init;

/**
 *
 * @author juanmendezl
 */
public class App {
    public static void start(){
        String[] CharactersStarWars = {"Darth Vader", "Ben Kenobi", "Han Solo", "Chewbaca", "Princess Leia", "Master Yoda", "R2-D2", "C3PO", "Luke Skywalker", "Emperor Palpatine"};
        String[] CharactersStarTrek = {"Ambassador Spock", "Admiral Picard", "Officer Worf", "Captain Kirk", "Lieutenant Data", "Vice Admiral Janeway", "Dr. McCoy", "Commander Sisko", "Fleet Captain Pike", "Chief Engineer La Forge"};
        
        Administrator admin = new Administrator(new Processor());
        Hilo thread = new Hilo(admin.getProcessor().getDuration(),admin);
        thread.run();
        
        SwingUtilities.invokeLater(() -> {
           Init ini = new Init();
            ini.setVisible(true); 
        });
    }
}
