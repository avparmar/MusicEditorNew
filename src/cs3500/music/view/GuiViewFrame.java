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

  private final ConcreteGuiViewPanel displayPanel; // You may want to refine this to a subtype of JPanel

  /**
   * Creates new GuiView
   */
  public GuiViewFrame(IMusicModel m) {
    this.displayPanel = new ConcreteGuiViewPanel(m);
  }

  //  @Override
  public void initialize() {
    this.setVisible(true);
  }


  /**
   * Displays the GUI view
   */
  @Override
  public void display() {
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    this.displayPanel.setPreferredSize(new Dimension(this.displayPanel.setWidth(),
            this.displayPanel.setHeight()));
    JScrollPane scroll = new JScrollPane(displayPanel);
    scroll.setPreferredSize(new Dimension(800, 400));
    scroll.getHorizontalScrollBar();
    scroll.getVerticalScrollBar();
    this.add(scroll);
    this.pack();

  }

}
