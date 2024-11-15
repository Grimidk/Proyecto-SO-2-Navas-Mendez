/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxClasses;
import java.util.concurrent.Semaphore;
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
    
    public Hilo (int delay, Administrator admin){
        this.delay = delay;
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
}
