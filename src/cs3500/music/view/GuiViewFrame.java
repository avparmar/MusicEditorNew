package cs3500.music.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener; // Possibly of interest for handling mouse events
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import cs3500.music.controller.KeyboardListener;
import cs3500.music.model.IMusicModel;
import cs3500.music.model.Note;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends javax.swing.JFrame implements GuiView {

  protected ConcreteGuiViewPanel displayPanel; // You may want to refine this to a subtype of JPanel

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
    /*
    ButtonGroup addRemove = new ButtonGroup();
    JRadioButton add = new JRadioButton("Add");
    JRadioButton remove = new JRadioButton("Remove");
    addRemove.add(add);
    addRemove.add(remove);
    this.displayPanel.add(add);
    this.displayPanel.add(remove);
    */
    JScrollPane scroll = new JScrollPane(displayPanel);
    scroll.setPreferredSize(new Dimension(800, 400));
    scroll.getHorizontalScrollBar();
    scroll.getVerticalScrollBar();
    this.add(scroll);
    this.pack();
    setVisible(true);

  }

  @Override
  public void addActionListener(ActionListener listener) {

  }

  @Override
  public void panView(String s) {

  }

  @Override
  public void displayRemoveNote() {
    JFrame temp = new JFrame();
    JPanel main = new JPanel();
    main.setLayout(new FlowLayout());
    main.add(new JLabel("To remove a note, click on its head"));
    temp.add(main);
    temp.setSize(new Dimension(500, 200));
    temp.setVisible(true);



  }

  @Override
  public void displayAddNote() {

    JFrame temp = new JFrame();
    JPanel main = new JPanel();
    main.setLayout(new FlowLayout());
    JPanel t = new JPanel();
    t.add(new JLabel("Pick a tone: "));
    DefaultComboBoxModel options = new DefaultComboBoxModel();
    options.addElement("C");
    options.addElement("C#");
    options.addElement("D");
    options.addElement("D#");
    options.addElement("E");
    options.addElement("F");
    options.addElement("F#");
    options.addElement("G");
    options.addElement("G#");
    options.addElement("A");
    options.addElement("A#");
    options.addElement("B");
    JComboBox combo = new JComboBox(options);
    t.add(combo);
    JPanel o = new JPanel();
    o.add(new JLabel("Input an Octave: "));
    JTextField text1 = new JTextField();
    text1.setColumns(5);
    o.add(text1);
    JPanel b = new JPanel();
    b.add(new JLabel("Input number of beats: "));
    JTextField text2 = new JTextField();
    text2.setColumns(5);
    b.add(text2);
    JPanel v = new JPanel();
    v.add(new JLabel("Input volume: "));
    JTextField text3 = new JTextField();
    text3.setColumns(5);
    v.add(text3);
    JPanel i = new JPanel();
    i.add(new JLabel("Input instrument: "));
    JTextField text4 = new JTextField();
    text4.setColumns(5);
    i.add(text4);
    main.add(v);
    main.add(i);
    main.add(b);
    main.add(t);
    main.add(o);
    temp.add(main);

    temp.setSize(new Dimension(500, 200));
    temp.setVisible(true);
  }

  @Override
  public void displayLine() {

  }

  @Override
  public ConcreteGuiViewPanel getPanel() {
    return this.displayPanel;
  }

  @Override
  public void updatePanel(IMusicModel m) {
    this.displayPanel.updateBeat();

  }


  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public String whatView() {
    return "gui";
  }

}
