package cs3500.music.view;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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

  private IMusicModel m; //= new MusicModel();

  public ConcreteGuiViewPanel(IMusicModel m) {
    this.m = m;
  }

/*
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
  }*/


  @Override
  public void paintComponent(Graphics g) {

    // Handle the default painting
    super.paintComponent(g);
//    Graphics cur = g.create();
    // Look for more documentation about the Graphics class,
    // and methods on it that may be useful
 //   this.initData();
    List<List<Note>> curMusic = m.getMusic();
    ArrayList<ArrayList<Note>> arrCur = new ArrayList<>();

    for (int a = 0; a < curMusic.size(); a++) {
      arrCur.add(new ArrayList<>());
      for (int z = 0; z < arrCur.get(a).size(); z++) {
        arrCur.get(a).add((Note) curMusic.get(a).get(z));
      }
    }

    int maxO = -1;
    int minO = 11;
    int maxT = 0;
    int minT = 11;



    int len;
    Note n;
    for (int i = 0; i < 12; i++) {
      len = curMusic.get(i).size();
      for (int j = 0; j < len; j++) {
        n = curMusic.get(i).get(j);
        if (n.getOctave() >= maxO) {
          maxO = n.getOctave();
        }
        if (n.getOctave() <= minO) {
          minO = n.getOctave();
        }
      }


    }

    for (int a4 = 0; a4 < 12; a4++) {
      len = curMusic.get(a4).size();
      for (int a5 = 0; a5 < len; a5++) {
        n = curMusic.get(a4).get(a5);
        if (n.getOctave() == maxO) {
          if (n.getTone().ordinal() > maxT) maxT = n.getTone().ordinal();
        }
        if (n.getOctave() == minO) {
          if (n.getTone().ordinal() < minT) minT = n.getTone().ordinal();
        }
      }
    }

    int width = (12 - minT) + (1 + maxT) + (12 * (maxO - minO - 1));


    int totalTime = m.getTotalTime();
   // System.out.println(totalTime);
    int first = 50;
    for (int i = 0; i <= totalTime; i += 16) {
      String temp = Integer.toString(i);
      g.drawString(temp, 50 + (15 * i), 25);
      //first += 230;
    }


     // first += 220;

    int x = 50;
    int y = 30;
    Graphics cube = g.create();

    for (int a0 = 0; a0 < 12; a0++) {
      len = curMusic.get(a0).size();
      for (int a9 = 0; a9 < len; a9++) {
        n = curMusic.get(a0).get(a9);
        cube.setColor(Color.black);
        y = 30 + ((maxO - n.getOctave()) * 12 + (maxT - n.getTone().ordinal())) * 20;
        x = 50 + n.getStart() * 15;
        cube.drawRect(x, y, 15, 20);
        cube.fillRect(x, y, 15, 20);

        cube.setColor(Color.ORANGE);
        cube.drawRect(x + 15, y, 15 * (n.getDuration() - 1), 20);
        cube.fillRect(x + 15, y, 15 * (n.getDuration() - 1), 20);
      }
    }

    for (x = 0; x < totalTime/4; x++) {
      for (y = 0; y < width; y ++) {
        g.drawRect(x * 60 + 50, y * 20 + 30, 60, 20);
      }
    }

    /*
    for (int r = 0; r < curMusic.size(); r++) {
      int x = 50;
      int n1 = 0;

      boolean hasRow;
      if (curMusic.get(r).isEmpty()) {
        hasRow = false;
      } else {
        hasRow = true;
      }
      for (int b = 0; b < totalTime; b++) {
        if (n1 >= curMusic.get(r).size()) {
          break;
        }
        Note curNote = curMusic.get(r).get(n1);

        if (curNote.getStart() == b) {
          cube.setColor(Color.black);
          cube.drawRect(x, y, curNote.getDuration() * 15, 20);
          cube.fillRect(x, y, curNote.getDuration() * 15, 20);
          x += 15;
        } else if (curNote.getStart() == b - 1) {
          cube.setColor(Color.blue);
          cube.drawRect(x, y, (curNote.getDuration() - 1) * 15, 20);
          cube.fillRect(x, y, (curNote.getDuration() - 1) * 15, 20);
          x += 15;
          n1 += 1;
        } else {
          x += 15;
        }
      }

      if (hasRow) {
        y += 20;
      }
    }*/
/*
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
    }*/


    int currO = maxO;
    int currT = maxT;
    String tone="";
    String oct="";
    int border=45;
    for (int a3 = 0; a3 < width; a3++) {
      tone = "";
      oct = "";
      switch (currT) {
        case 0: tone+= "C";
          break;
        case 1: tone+= "C#";
          break;
        case 2: tone+= "D";
          break;
        case 3: tone+= "D#";
          break;
        case 4: tone+= "E";
          break;
        case 5: tone+= "F";
          break;
        case 6: tone+= "F#";
          break;
        case 7: tone+= "G";
          break;
        case 8: tone+= "G#";
          break;
        case 9: tone+= "A";
          break;
        case 10: tone+= "A#";
          break;
        case 11: tone+= "B";
          break;
      }
      oct+=currO;

      g.drawString(tone+oct, 25, border);

      if (currT == 0) {
        currT = 11;
        currO--;
      }
      else currT--;
      border+=20;
    }




  }
/*
  public void renderBeats(Graphics g) {
    super.paintComponent(g);
    List<List<Note>> curMusic = m.getMusic();
    int totalTime = m.getTotalTime();
    System.out.println(totalTime);
    for (int i = 0; i < totalTime; i += 16) {
      String temp = Integer.toString(i);
      g.drawString(temp, 25, 50 + i);
    }
    System.out.println(totalTime);
  }*/

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
