package cs3500.music.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

import cs3500.music.controller.Controller;
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


    gui.display();

   midi.display();
  }

  public ConcreteGuiViewPanel getPanel() {
    return gui.getPanel();
  }

  @Override
  public void updatePanel(IMusicModel m) {
    gui.updatePanel(m);

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
    gui.displayRemoveNote();

  }

  @Override
  public void displayAddNote() {
    gui.displayAddNote();

  }

  @Override
  public void displayLine() {


  }


  @Override
  public void resetFocus() {

  }

  @Override
  public String whatView() {
    return "composite";
  }

  public void setController(Controller c){
    gui.setController(c);
  }

  public Controller getController() {
    return gui.getController();
  }

  @Override
  public String[] getInfo() {
    String[] res = new String[7];
    Component[] work = gui.getTemp().getComponents();

    JRootPane w1 = (JRootPane) work[0];
    JTextField jtf1 = (JTextField) w1.getComponent(1);

    res[0] = jtf1.getText();

    JPanel w2 = (JPanel) work[1];
    JTextField jtf2 = (JTextField) w2.getComponent(1);

    res[1] = jtf2.getText();

    JPanel w3 = (JPanel) work[2];
    JTextField jtf3 = (JTextField) w3.getComponent(1);

    res[2] = jtf2.getText();

    JPanel w4 = (JPanel) work[3];
    JComboBox jcb = (JComboBox) w4.getComponent(1);
    res[3] = (String) jcb.getSelectedItem();

    JPanel w5 = (JPanel) work[4];
    JTextField jtf4 = (JTextField) w5.getComponent(1);

    res[4] = jtf4.getText();


    return res;
  }

  public JFrame getTemp() {
    return gui.getTemp();
  }


}
