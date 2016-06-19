package cs3500.music;

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
    GuiViewFrame guiView = new GuiViewFrame(m);
    StringView strView = new StringView(m);
    MidiViewImpl midiView = new MidiViewImpl(m);

    switch (view) {
      case "console":
        strView.display();
        System.out.print(strView.getText());
        break;
      case "midi":
        midiView.display();
        break;
      case "gui":
        guiView.initialize();
        guiView.display();
        break;
      default:
        System.out.print("Invaid view");
        break;
    }

  }
}
