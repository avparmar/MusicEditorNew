package cs3500.music.controller;

import cs3500.music.model.IMusicModel;
import cs3500.music.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brendanreed on 6/21/16.
 */
public class Controller implements ActionListener {

  private IMusicModel model;
  private IView view;

  public Controller(IMusicModel m, IView v) {
    this.model = m;
    this.view = v;
    configureKeyBoardListener();
    this.view.addActionListener(this);
  }


  public void configureKeyBoardListener() {
    Map<Character, Runnable> keyTypes = new HashMap<>();
    Map<Integer, Runnable> keyPresses = new HashMap<>();
    Map<Integer, Runnable> keyReleases = new HashMap<>();


    KeyboardListener kbd = new KeyboardListener();
    kbd.setKeyTypedMap(keyTypes);
    kbd.setKeyPressedMap(keyPresses);
    kbd.setKeyReleasedMap(keyReleases);

    view.addKeyListener(kbd);

  }


  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
