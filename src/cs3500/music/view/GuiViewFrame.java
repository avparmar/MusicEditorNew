package cs3500.music.view;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.awt.event.MouseListener; // Possibly of interest for handling mouse events
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import cs3500.music.model.IMusicModel;
import cs3500.music.model.Note;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends javax.swing.JFrame implements IView {

  private final JPanel displayPanel; // You may want to refine this to a subtype of JPanel

  /**
   * Creates new GuiView
   */
  public GuiViewFrame() {
    this.displayPanel = new ConcreteGuiViewPanel();
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().add(displayPanel);
    this.pack();
  }

  //  @Override
  public void initialize() {
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1500, 500);
  }

  @Override
  public void display(IMusicModel m) {

  }

}
