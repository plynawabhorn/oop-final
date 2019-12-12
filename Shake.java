/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefinal;

import javax.swing.JFrame;

/**
 *
 * @author 61070020
 */
public class Shake {


  private final static int VIBRATION_LENGTH = 20;
  private final static int VIBRATION_VELOCITY = 5;
  
  private Shake() { }
  
  public static void vibrate(JFrame frame) { 
    try { 
      final int originalX = frame.getLocationOnScreen().x; 
      final int originalY = frame.getLocationOnScreen().y; 
      for(int i = 0; i < VIBRATION_LENGTH; i++) { 
        Thread.sleep(10); 
        frame.setLocation(originalX, originalY + VIBRATION_VELOCITY); 
        Thread.sleep(10); 
        frame.setLocation(originalX, originalY - VIBRATION_VELOCITY);
        Thread.sleep(10); 
        frame.setLocation(originalX + VIBRATION_VELOCITY, originalY);
        Thread.sleep(10); 
        frame.setLocation(originalX, originalY); 
      } 
    } 
    catch (Exception err) { 
      err.printStackTrace(); 
    } 
  }
}
