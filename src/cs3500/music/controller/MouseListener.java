package cs3500.music.controller;

import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * Created by brendanreed on 6/22/16.
 */
public class MouseListener implements java.awt.event.MouseListener {

  private Map<MouseEvent, Runnable> mouseClickedMap;

  public MouseListener() {

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    Integer x = e.getXOnScreen();
    Integer y = e.getYOnScreen();



  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
