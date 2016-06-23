import cs3500.music.model.IMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Tone;
import cs3500.music.util.MusicModelBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.StringView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;


public class MusicEditor {

  public static void main(String[] args) {
    MusicReader mr = new MusicReader();
    Scanner init = new Scanner(System.in);
    System.out.print("Enter the file you want to play: ");
    String file = init.nextLine();
    System.out.print("Enter the view to display: ");
    String view = init.nextLine();
    IMusicModel m = null;
    try {
      m = mr.parseFile(new FileReader(file), new MusicModelBuilder());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    StringView strView = null;
    GuiViewFrame guiView = null;
    MidiViewImpl midiView = null;

    switch (view) {
      case "console":
        strView = new StringView(m);
        strView.display();
        System.out.print(strView.getText());
        break;
      case "midi":
        midiView = new MidiViewImpl(m);
        midiView.display();
      case "gui":
        guiView = new GuiViewFrame(m);
        guiView.initialize();
        guiView.display();
        break;
      default:
        System.out.print("Invaid view");
        break;
    }


  }
}
