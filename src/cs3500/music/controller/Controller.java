package cs3500.music.controller;

import cs3500.music.model.IMusicModel;
import cs3500.music.view.GuiView;
import cs3500.music.view.IView;

import java.awt.*;
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

    keyPresses.put(KeyEvent.VK_R, new RemoveNote());
    keyPresses.put(KeyEvent.VK_A, new AddNote());
    keyPresses.put(KeyEvent.VK_KP_LEFT, new PageLeft());
    keyPresses.put(KeyEvent.VK_KP_RIGHT, new PageRight());
    keyPresses.put(KeyEvent.VK_KP_UP, new PageUp());
    keyPresses.put(KeyEvent.VK_KP_DOWN, new PageDown());


    KeyboardListener kbd = new KeyboardListener();
    kbd.setKeyTypedMap(keyTypes);
    kbd.setKeyPressedMap(keyPresses);
    kbd.setKeyReleasedMap(keyReleases);

    view.addKeyListener(kbd);

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
