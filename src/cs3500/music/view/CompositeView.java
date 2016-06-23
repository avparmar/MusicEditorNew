package cs3500.music.view;

import java.awt.event.ActionListener;

import cs3500.music.controller.KeyboardListener;

/**
 * Created by brendanreed on 6/22/16.
 */
public class CompositeView implements IView{

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

  @Override
  public void addActionListener(ActionListener a) {

  }

  @Override
  public void addKeyListener(KeyboardListener kbd) {

  }

  @Override
  public void resetFocus() {

  }

  @Override
  public String whatView() {
    return null;
  }




}
