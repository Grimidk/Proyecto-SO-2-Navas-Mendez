/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juanmendezl
 */
public class Hilo extends Thread{
    
    private float delay;
    private Semaphore sema;
    private boolean killSwitch;
    
    public Hilo (int permits){
//        this.delay = (simu.getDuration()*1000)/48;
        this.sema = new Semaphore(permits);
        this.killSwitch = false;
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
        while (!this.killSwitch){
            
            try{
                this.sema.acquire();
                
                sleep((long) (delay));
                
                this.sema.release();
                sleep((long) (delay));
                
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
