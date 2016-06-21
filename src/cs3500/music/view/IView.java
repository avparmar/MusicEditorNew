package cs3500.music.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import cs3500.music.controller.KeyboardListener;
import cs3500.music.model.IMusicModel;

/**
 * represents a view
 */
public interface IView {

  /**
   * Displays the view
   */
  void display();

  void addActionListener(ActionListener a);


  void addKeyListener(KeyboardListener kbd);
}
