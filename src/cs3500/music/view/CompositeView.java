package cs3500.music.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

import cs3500.music.controller.KeyboardListener;
import cs3500.music.model.IMusicModel;

/**
 * Created by brendanreed on 6/22/16.
 */
public class CompositeView implements GuiView {

  private GuiView gui;
  private IView midi;

  public CompositeView(GuiView g, IView m) {
    this.gui = g;
    this.midi = m;
  }

  @Override
  public void display() {
    int beat = 0;
    gui.getPanel().add(new JRadioButton("Remove"));
    gui.getPanel().add(new JRadioButton("Add"));
    gui.display();

    midi.display();
  }

  @Override
  public void addActionListener(ActionListener a) {

  }

 /*@Override
  public void addKeyListener(KeyListener listener) {

  }*/

 /* @Override
  public void addActionListener(ActionListener a) {

  }*/

  @Override
  public void addKeyListener(KeyListener listener) {

  }

  @Override
  public void panView(String s) {

  }

  @Override
  public void displayRemoveNote() {

  }

  @Override
  public void displayAddNote() {

  }

  @Override
  public void displayLine() {


  }

  @Override
  public ConcreteGuiViewPanel getPanel() {
    return null;
  }

  @Override
  public void updatePanel(IMusicModel m) {

  }




  public void addKeyListener(KeyboardListener kbd) {

  }

  @Override
  public void resetFocus() {

  }

  @Override
  public String whatView() {
    return "composite";
  }




}
