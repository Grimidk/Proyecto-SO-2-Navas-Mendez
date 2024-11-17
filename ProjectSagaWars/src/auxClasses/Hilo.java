/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxClasses;
import java.net.URL;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import projectClasses.Administrator;

/**
 *
 * @author juanmendezl
 */
public class Hilo extends Thread{
    
    private float delay;
    private Semaphore sema;
    private boolean killSwitch;
    private Administrator admin;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    public Hilo (int delay, Administrator admin){
        this.delay = delay * 500;
        this.sema = new Semaphore(1);
        this.killSwitch = false;
        this.admin = admin;
    }
    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public Semaphore getSema() {
        return sema;
    }

    public void setSema(Semaphore sema) {
        this.sema = sema;
    }

    public boolean isKillSwitch() {
        return killSwitch;
    }

    public void setKillSwitch(boolean killSwitch) {
        this.killSwitch = killSwitch;
    }
    
    @Override
    public void run(){
        while (!killSwitch){
            
            try{
                sema.acquire();
                
                admin.adminRun();
                sleep((long) (delay));
                
                sema.release();
                sleep((long) (delay));
                
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
    
    private void updateFighterImages(){
        String fighterLName = admin.getActiveFighterL().getName();
        String fighterRName = admin.getActiveFighterR().getName();
        
        SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run() {
            setIconForLabel(jLabel4, fighterLName);
            setIconForLabel(jLabel3, fighterRName);
        }
    });
    }
    
    private void setIconForLabel(javax.swing.JLabel label, String fighterName){
        String imagePath;
        
        switch (fighterName){
            case "Darth Vader":
                imagePath = "/projectInterface.fighters/dart vader.png";
                break;
            case "Ben Kenobi":
                imagePath = "/projectInterface.fighters/ben kenobi.png";
                break;
            case "Han Solo":
                imagePath = "/projectInterface.fighters/han solo.png";
                break;
            case "ChewBaca":
                imagePath = "/projectInterface.fighters/chewbaca.png";
                break;
            case "Princess Leia":
                imagePath = "/projectInterface.fighters/princess leia.png";
                break;
            case "Master Yoda":
                imagePath = "/projectInterface.fighters/master yoda.png";
                break;
            case "R2-D2":
                imagePath = "/projectInterface.fighters/r2-d2.png";
                break;
            case "C3PO":
                imagePath = "/projectInterface.fighters/c3po.png";
                break;
            case "Luke Skywalker":
                imagePath = "/projectInterface.fighters/Luke skywalker.png";
                break;
            case "Emperor Palpatine":
                imagePath = "/projectInterface.fighters/emperor palpatine.png";
                break;
            case "Ambassador Spock":
                imagePath = "/projectInterface.fighters/ambassador spock.png";
                break;
            case "Admiral Picard":
                imagePath = "/projectInterface.fighters/admiral picard.png";
                break;
            case "Officer Worf":
                imagePath = "/projectInterface.fighters/officer worf.png";
                break;
            case "Captain Kirk":
                imagePath = "/projectInterface.fighters/captain kirk.png";
                break;
            case "Lieutenant Data":
                imagePath = "/projectInterface.fighters/lieutenant data.png";
                break;
            case "Vice Admiral Janeway":
                imagePath = "/projectInterface.fighters/vice admiral janeway.png";
                break;
            case "Dr. McCoy":
                imagePath = "/projectInterface.fighters/dr. mccoy.png";
                break;
            case "Commander Sisko":
                imagePath = "/projectInterface.fighters/commander sisko.png";
                break;
            case "Fleet Captain Pike":
                imagePath = "/projectInterface.fighters/fleet captain pike.png";
                break;
            case "Chief Engineer La Forge":
                imagePath = "/projectInterface.fighters/chief engineer la forge.png";
                break;
            default:
                imagePath = null;
                break;
        }
        
        if (imagePath != null){
            URL imageUrl = getClass().getResource(imagePath);
            
            if (imageUrl != null){
                ImageIcon icon = new ImageIcon(imageUrl);
                label.setIcon(icon);
            } else {
                label.setText("image not found");
                label.setIcon(null);
            }
        } else {
            label.setText("No image for: " + fighterName);
            label.setIcon(null);
        }
    }
}
