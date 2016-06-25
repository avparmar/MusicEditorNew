package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

/**
 * Created by brendanreed on 6/21/16.
 */
public class KeyboardListener implements KeyListener {

  private Map<Character, Runnable> keyTypedMap;
  private Map<Integer, Runnable> keyPressedMap, keyReleasedMap;
  private Controller c;

  /**
   * Empty default constructor
   */
  public KeyboardListener(Controller c) {
    this.c = c;
  }

  /**
   * Set the map for key typed events. Key typed events in Java Swing are characters
   */

  public void setKeyTypedMap(Map<Character, Runnable> map) {
    keyTypedMap = map;
  }

  /**
   * Set the map for key pressed events. Key pressed events in Java Swing are integer codes
   */

  public void setKeyPressedMap(Map<Integer, Runnable> map) {
    keyPressedMap = map;
  }

  /**
   * Set the map for key released events. Key released events in Java Swing are integer codes
   */

  public void setKeyReleasedMap(Map<Integer, Runnable> map) {
    keyReleasedMap = map;
  }

  /**
   * This is called when the view detects that a key has been typed. Find if anything has been
   * mapped to this key character and if so, execute it
   */

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("keyTyped");
    if (keyTypedMap.containsKey(e.getKeyChar()))
      c.setMode(keyTypedMap.get(e.getKeyChar()));
  }

  /**
   * This is called when the view detects that a key has been pressed. Find if anything has been
   * mapped to this key code and if so, execute it
   */

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("keyTyped");

    if (keyPressedMap.containsKey(e.getKeyCode()))
      c.setMode(keyTypedMap.get(e.getKeyChar()));
  }

  /**
   * This is called when the view detects that a key has been released. Find if anything has been
   * mapped to this key code and if so, execute it
   */

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("keyTyped");

    if (keyReleasedMap.containsKey(e.getKeyCode()))
      c.setMode(keyTypedMap.get(e.getKeyChar()));
  }
}
