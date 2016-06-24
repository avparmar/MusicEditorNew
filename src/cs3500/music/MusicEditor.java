package cs3500.music;

import cs3500.music.controller.Controller;
import cs3500.music.model.IMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Tone;
import cs3500.music.util.MusicModelBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.StringView;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;


public class MusicEditor {
  public static void main(String[] args) throws IOException, InvalidMidiDataException {
    MusicReader mr = new MusicReader();
    Scanner init = new Scanner(System.in);
    System.out.print("Enter the file you want to play: ");
    String file = init.nextLine();
    System.out.print("Enter the view to display: ");
    String view = init.nextLine();
    IMusicModel m = mr.parseFile(new FileReader(file), new MusicModelBuilder());
    StringView strView = null;
    GuiViewFrame guiView = null;
    MidiViewImpl midiView = null;
    Controller c;

    switch (view) {
      case "console":
        strView = new StringView(m);
        c = new Controller(m, strView);
        strView.display();
        System.out.print(strView.getText());
        break;
      case "gui":
        guiView = new GuiViewFrame(m);
        c = new Controller(m, guiView);

        guiView.initialize();
        guiView.display();
        guiView.displayAddNote();
        break;
      case "midi":
        midiView = new MidiViewImpl(m);
        c = new Controller(m, midiView);
        midiView.display();
      default:
        break;
    }


  }
}
