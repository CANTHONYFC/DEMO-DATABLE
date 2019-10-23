/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.utilities;

/**
 *
 * @author sistem16user
 */
public abstract class HiloSecundario extends Thread {
    
    public abstract void accion();
    
    @Override
    public void run() {
        accion();
    }
    
}