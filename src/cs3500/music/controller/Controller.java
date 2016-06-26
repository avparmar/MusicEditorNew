package cs3500.music.controller;

import cs3500.music.model.IMusicModel;
import cs3500.music.view.CompositeView;
import cs3500.music.view.GuiView;
import cs3500.music.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.plaf.basic.BasicComboBoxUI;

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
    String cur = v.whatView();
 //   if (cur == "console") {
 //     this.view = v;
 //   }
  //  else if (cur.equals("gui")){
    if (cur.equals("gui")) {
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

      //     this.view.addActionListener(this);
      //   }
      this.view.display();
    }
    else if (cur.equals("composite")) {
      CompositeView cv = (CompositeView) v;

      configureMouseListener();
      configureKeyBoardListener();

      cv.getPanel().addKeyListener(kl);
      cv.getPanel().addMouseListener(ml);

      cv.getPanel().setFocusable(true);
      cv.getPanel().requestFocus();
      this.view = cv;
      this.view.display();
    }

    else if (cur.equals("midi")) {
      System.out.print("5");
  //    MidiViewImpl mv = new MidiViewImpl(m);
  //    mv.display();
      this.view = v;


      this.view.display();

      try {
        Thread.sleep(m.getTotalTime() * 200);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }


  public void setMode(Runnable r) {
    mode = r;
    mode.run();
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
    keyPresses.put(KeyEvent.VK_HOME, new PanHome());
    keyPresses.put(KeyEvent.VK_END, new PanEnd());

    keyPresses.put(KeyEvent.VK_P, new PlaySong());
    keyPresses.put(KeyEvent.VK_SPACE, new PauseSong());


    KeyboardHandler kbd = new KeyboardHandler(this);
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

  public void setKeyboardHandler(KeyboardHandler k) {
    this.kl = k;
  }

  public void setView(IView v) {
    this.view = v;
  }

  public IView getView() {
    return this.view;
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
