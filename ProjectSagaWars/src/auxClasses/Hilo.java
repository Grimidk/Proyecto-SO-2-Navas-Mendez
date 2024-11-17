/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxClasses;
import java.net.URL;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import projectClasses.Administrator;
import projectClasses.Processor;

/**
 *
 * @author juanmendezl
 */
public class Hilo extends Thread{
    
    private float delay;
    private Semaphore sema;
    private boolean killSwitch;
    private Administrator admin;
    private Processor proc;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JTextField winnersL;
    private final JTextField winnersR;
    private final JTextField nameL;
    private final JTextField nameR;
    private final JTextField idL;
    private final JTextField idR;
    
    public Hilo (int delay, Administrator admin, Processor proc, JLabel jLabel3, JLabel jLabel4, JTextField winnersL, JTextField winnersR, JTextField nameL, JTextField nameR, JTextField idL, JTextField idR){
        this.delay = delay * 500;
        this.sema = new Semaphore(1);
        this.killSwitch = false;
        this.admin = admin;
        this.proc = proc;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.winnersL = winnersL;
        this.winnersR = winnersR;
        this.nameL = nameL;
        this.nameR = nameR;
        this.idL = idL;
        this.idR = idR;
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
                
                updateFighterImages();
                
                int countL = proc.getWinnersL().size();
                SwingUtilities.invokeLater(() -> {
                winnersL.setText(String.valueOf(countL));
                });
                
                int countR = proc.getWinnersR().size();
                SwingUtilities.invokeLater(() -> {
                winnersR.setText(String.valueOf(countR));
                });
                
                
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
    
    private void updateFighterImages(){
        
        if (admin.getActiveFighterL() != null && admin.getActiveFighterR() != null){
            String fighterLName = admin.getActiveFighterL().getName();
            String fighterRName = admin.getActiveFighterR().getName();
            int fighterLId = admin.getActiveFighterL().getId();
            int fighterRId = admin.getActiveFighterR().getId();
        
            SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                setIconForLabel(jLabel4, fighterLName);
                setIconForLabel(jLabel3, fighterRName);
                nameL.setText(fighterLName);
                nameR.setText(fighterRName);
                idL.setText(String.valueOf(fighterLId));
                idR.setText(String.valueOf(fighterRId));
            }
        });
        }
    }
    
    private void setIconForLabel(javax.swing.JLabel label, String fighterName){
        String imagePath;
        
        switch (fighterName){
            case "Darth Vader":
                imagePath = "/projectInterface/fighters/darth vader.jpg";
                break;
            case "Ben Kenobi":
                imagePath = "/projectInterface/fighters/ben kenobi.jpg";
                break;
            case "Han Solo":
                imagePath = "/projectInterface/fighters/han solo.jpg";
                break;
            case "Chewbaca":
                imagePath = "/projectInterface/fighters/chewbaca.jpg";
                break;
            case "Princess Leia":
                imagePath = "/projectInterface/fighters/princess leia.jpg";
                break;
            case "Master Yoda":
                imagePath = "/projectInterface/fighters/master yoda.jpg";
                break;
            case "R2-D2":
                imagePath = "/projectInterface/fighters/r2-d2.jpg";
                break;
            case "C3PO":
                imagePath = "/projectInterface/fighters/c3po.jpg";
                break;
            case "Luke Skywalker":
                imagePath = "/projectInterface/fighters/Luke skywalker.jpg";
                break;
            case "Emperor Palpatine":
                imagePath = "/projectInterface/fighters/emperor palpatine.jpg";
                break;
            case "Ambassador Spock":
                imagePath = "/projectInterface/fighters/ambassador spock.jpg";
                break;
            case "Admiral Picard":
                imagePath = "/projectInterface/fighters/admiral picard.jpg";
                break;
            case "Officer Worf":
                imagePath = "/projectInterface/fighters/officer worf.jpg";
                break;
            case "Captain Kirk":
                imagePath = "/projectInterface/fighters/captain kirk.jpg";
                break;
            case "Lieutenant Data":
                imagePath = "/projectInterface/fighters/lieutenant data.jpg";
                break;
            case "Vice Admiral Janeway":
                imagePath = "/projectInterface/fighters/vice admiral janeway.jpg";
                break;
            case "Dr. McCoy":
                imagePath = "/projectInterface/fighters/dr. mccoy.jpg";
                break;
            case "Commander Sisko":
                imagePath = "/projectInterface/fighters/commander sisko.jpg";
                break;
            case "Fleet Captain Pike":
                imagePath = "/projectInterface/fighters/fleet captain pike.jpg";
                break;
            case "Chief Engineer La Forge":
                imagePath = "/projectInterface/fighters/chief engineer la forge.jpg";
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
