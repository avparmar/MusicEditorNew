package cs3500.music.controller;

import cs3500.music.model.IMusicModel;
import cs3500.music.view.GuiView;
import cs3500.music.view.IView;
import cs3500.music.controller.KeyboardListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by brendanreed on 6/21/16
 */
public class Controller implements ActionListener {

  private IMusicModel model;
  private IView view;
  private Runnable mode;
  private Timer timer;

  private KeyListener kl;
  private MouseListener ml;

  public Controller() {

  }

  public Controller(IMusicModel m, IView v) {
    this.model = m;
//    String cur = v.whatView();
 //   if (cur == "console") {
 //     this.view = v;
 //   }
  //  else if (cur.equals("gui")){
      GuiView g = (GuiView) v;


      configureKeyBoardListener();
      configureMouseListener();


      g.getPanel().addKeyListener(kl);


      g.getPanel().addMouseListener(ml);

    g.getPanel().setFocusable(true);
    g.getPanel().requestFocus();

 //   System.out.println(g.getPanel().getKeyListeners()[0]);
      this.view = g;
 //     this.view.addActionListener(this);
 //   }
    this.timer = new Timer();
    this.view.display();

  }


  public void setMode(Runnable r) {
    mode = r;
    this.mode.run();
  }

  public Runnable getMode() {
    return mode;
  }


  public void configureKeyBoardListener() {
    Map<Character, Runnable> keyTypes = new HashMap<>();
    Map<Integer, Runnable> keyPresses = new HashMap<>();
    Map<Integer, Runnable> keyReleases = new HashMap<>();

    keyPresses.put(KeyEvent.VK_R, new RemoveNote());
    keyPresses.put(KeyEvent.VK_A, new AddNote());
    keyPresses.put(KeyEvent.VK_KP_LEFT, new PageLeft());
    keyPresses.put(KeyEvent.VK_KP_RIGHT, new PageRight());
    keyPresses.put(KeyEvent.VK_KP_UP, new PageUp());
    keyPresses.put(KeyEvent.VK_KP_DOWN, new PageDown());
    keyPresses.put(KeyEvent.VK_P, new PlaySong());
    keyPresses.put(KeyEvent.VK_SPACE, new PauseSong());

    KeyboardListener kbd = new KeyboardListener(this);
    kbd.setKeyTypedMap(keyTypes);
    kbd.setKeyPressedMap(keyPresses);
    kbd.setKeyReleasedMap(keyReleases);
    this.kl = kbd;

  }

  public void configureMouseListener() {
    MouseListener ml = new MouseListener(this);
    this.ml = ml;

  }

  public KeyListener getKeyListener() {
    return kl;
  }

  public MouseListener getMouseListener() {
    return ml;
  }


  @Override
  public void actionPerformed(ActionEvent e) {

  }

  class PlaySong implements Runnable {
    public void run() {
      int totalTime = model.getTotalTime();
      Timer temp = new Timer();
      timer = temp;
      timer.schedule(new Play(), model.getCurrentTime(), totalTime);

    }
  }

  class PauseSong implements Runnable {
    public void run() {
      timer.cancel();
    }
  }

  class Play extends TimerTask {

    @Override
    public void run() {
      view.updatePanel(model);
    }
  }

  class PanHome implements Runnable {
    public void run() {
      int totalTime = model.getTotalTime();
      Timer temp = new Timer();
      timer = temp;
      timer.schedule(new Play(), 0, totalTime);

    }
  }

  class PanEnd implements Runnable {
    public void run() {
      int totalTime = model.getTotalTime();
      Timer temp = new Timer();
      timer = temp;
      timer.schedule(new Play(), totalTime - 5, totalTime);
    }
  }



  class RemoveNote implements Runnable {
    public void run() {
      view.displayRemoveNote();



    }
  }

  class AddNote implements Runnable {
    public void run() {
      view.displayAddNote();


    }
  }

  class PageLeft implements Runnable {
    public void run() {

      String pan = "left";
      view.panView(pan);

      }
    }


  class PageRight implements Runnable {
    public void run() {
      String pan = "right";

      view.panView(pan);

    }
  }

  class PageUp implements Runnable {
    public void run() {
      String pan = "up";
      view.panView(pan);


    }
  }

  class PageDown implements Runnable {
    public void run() {
      String pan = "down";
      view.panView(pan);


    }
  }
}
