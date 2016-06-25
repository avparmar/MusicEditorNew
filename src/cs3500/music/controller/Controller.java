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

/**
 * Created by brendanreed on 6/21/16
 */
public class Controller implements ActionListener {

  private IMusicModel model;
  private IView view;
  private Runnable mode;

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
 //     configureMouseListener();

      g.getPanel().addKeyListener(kl);

  //    g.getPanel().addMouseListener(ml);
      this.view = g;
      this.view.addActionListener(this);
 //   }
    this.view.display();
  }


  public void setMode(Runnable r) {
    mode = r;
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

    KeyListener kbd = new KeyboardListener(this);
 //   kbd.setKeyTypedMap(keyTypes);
//    kbd.setKeyPressedMap(keyPresses);
  //  kbd.setKeyReleasedMap(keyReleases);
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

  class RemoveNote implements Runnable {
    public void run() {


    }
  }

  class AddNote implements Runnable {
    public void run() {
      System.out.print("I got here");
      GuiView g = (GuiView) view;
      g.displayAddNote();
    }
  }

  class PageLeft implements Runnable {
    public void run() {
      String pan = "left";
      String curView = view.whatView();
      switch (curView) {
        case "gui":
          GuiView gui = (GuiView) view;
          gui.panView(pan);
          break;
        case "midi":
          break;
        case "combo":
          GuiView combo = (GuiView) view;
          combo.panView(pan);
          break;
        default:
          curView = "Invalid input";
          break;
      }
    }
  }

  class PageRight implements Runnable {
    public void run() {
      String pan = "right";
      String curView = view.whatView();
      switch (curView) {
        case "gui":
          GuiView gui = (GuiView) view;
          gui.panView(pan);
          break;
        case "midi":
          break;
        case "combo":
          GuiView combo = (GuiView) view;
          combo.panView(pan);
          break;
        default:
          curView = "Invalid input";
          break;
      }

    }
  }

  class PageUp implements Runnable {
    public void run() {
      String pan = "up";
      String curView = view.whatView();
      switch (curView) {
        case "gui":
          GuiView gui = (GuiView) view;
          gui.panView(pan);
          break;
        case "midi":
          break;
        case "combo":
          GuiView combo = (GuiView) view;
          combo.panView(pan);
          break;
        default:
          curView = "Invalid input";
          break;
      }

    }
  }

  class PageDown implements Runnable {
    public void run() {
      String pan = "down";
      String curView = view.whatView();
      switch (curView) {
        case "gui":
          GuiView gui = (GuiView) view;
          gui.panView(pan);
          break;
        case "midi":
          break;
        case "combo":
          GuiView combo = (GuiView) view;
          combo.panView(pan);
          break;
        default:
          curView = "Invalid input";
          break;
      }

    }
  }
}
