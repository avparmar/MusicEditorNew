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
    m.write(Tone.G, 7, 3);
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.C, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 7, 3);
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 3, 4);
    m.advance();
    m.advance();
    m.advance();
    m.advance();
    m.write(Tone.G, 8, 3);
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 4, 4);
    m.advance();
    m.advance();
    m.advance();
    m.advance();
    m.write(Tone.G, 2, 3);
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 4, 4);
    m.advance();
    m.advance();
    m.advance();
    m.advance();
    m.write(Tone.G, 8, 3);
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.C, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 8, 3);
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 8, 3);
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 8, 3);
    m.write(Tone.C, 8, 4);
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
    ArrayList<ArrayList<Note>> arrCur = new ArrayList<>();

    for (int a = 0; a < curMusic.size(); a++) {
      arrCur.add(new ArrayList<>());
      for (int z = 0; z < arrCur.get(a).size(); z++) {
        arrCur.get(a).add((Note) curMusic.get(a).get(z));
      }
    }

    int totalTime = m.getTotalTime();
    int first = 50;
    for (int i = 0; i < totalTime; i += 16) {
      String temp = Integer.toString(i);
      g.drawString(temp, first + i, 25);

      for (int x = 50; x < 900; x += 60) {
        for (int y = 30; y < 275; y += 20) {
          g.drawRect(x, y, 60, 20);
        }
      }

      for (int b = 0; b < totalTime; b++) {
        for (int c = 0; c < arrCur.size(); c++) {
          ArrayList a = arrCur.get(c);
          int space = 10;
          Graphics cube = g.create();
          cube.setColor(Color.blue);
          for (int s = 0; s < a.size(); s++) {
            cube.drawRect(40 + space, 20 + space, 10, 10);
          }
        }
      }


      first += 220;
    }

    ArrayList<Note> curTones = new ArrayList<>();

    for (int h = 0; h < curMusic.size(); h++) {
      if (curMusic.get(h).isEmpty()) {

      } else {
        Note tempTone = curMusic.get(h).get(0);
        curTones.add(tempTone);
      }
    }

    int j = 45;
    for (Note n : curTones) {
      String tone = n.getTone().getString();
      String oct = Integer.toString(n.getOctave());
      String tempStr = tone + oct;
      g.drawString(tempStr, 25, j);
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
