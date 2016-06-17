package cs3500.music.view;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.swing.*;

import cs3500.music.model.IMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Note;
import cs3500.music.model.Tone;

/**
 * A dummy view that simply draws a string
 */
public class ConcreteGuiViewPanel extends JPanel {

  private IMusicModel m = new MusicModel();

  public void initData() {
    this.m.write(Tone.A, 8, 3);
    this.m.write(Tone.B, 6, 3);
  }


  @Override
  public void paintComponent(Graphics g) {

    // Handle the default painting
    super.paintComponent(g);
    Graphics cur = g.create();
    // Look for more documentation about the Graphics class,
    // and methods on it that may be useful
    this.initData();
    List<List<Note>> curMusic = m.getMusic();
    int totalTime = m.getTotalTime();
    for (int i = 0; i < totalTime; i += 16) {
      String temp = Integer.toString(i);
      g.drawString(temp, 50 + i, 25);

      for (int x = 50; x < 900; x += 60) {
        for (int y = 30; y < 275; y += 20) {
          g.drawRect(x, y, 60, 20);

        }
      }
    }

    ArrayList<Note> curTones = new ArrayList<>();

    for (int i = 0; i < curMusic.size(); i++) {
      if (curMusic.get(i).isEmpty()) {

      } else {
        Note temp = curMusic.get(i).get(0);
        curTones.add(temp);
      }
    }

    int j = 45;
    for (Note n : curTones) {
      String tone = n.getTone().getString();
      String oct = Integer.toString(n.getOctave());
      String temp = tone + oct;
      g.drawString(temp, 25, j);
      j += 20;
    }









  }

  public void renderBeats(IMusicModel m, Graphics g) {
    super.paintComponent(g);
    List<List<Note>> curMusic = m.getMusic();
    int totalTime = m.getTotalTime();
    for (int i = 0; i < totalTime; i += 16) {
      String temp = Integer.toString(i);
      g.drawString(temp, 25, 50 + i);
    }
  }

  public void renderTones(IMusicModel m, Graphics g) {
    super.paintComponent(g);
    List<List<Note>> curMusic = m.getMusic();
    ArrayList<Note> curTones = new ArrayList<>();

    for (int i = 0; i < curMusic.size(); i++) {
      if (curMusic.get(i).isEmpty()) {

      } else {
        Note temp = curMusic.get(i).get(0);
        curTones.add(temp);
      }

    }

    for (int j = 0; j < curTones.size(); j++) {
      int start = 25;
      int inc = 15 + j;
      String tone = curTones.get(j).getTone().getString();
      String oct = Integer.toString(curTones.get(j).getOctave());
      String temp = tone + oct;
      g.drawString(temp, 25, start + inc);
    }

  }

  //public void addSpace(IMusicModel m, Graphics g);



}
