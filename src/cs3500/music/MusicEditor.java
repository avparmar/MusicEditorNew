package cs3500.music;

import cs3500.music.model.IMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.StringView;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;


public class MusicEditor {
  public static void main(String[] args) throws IOException, InvalidMidiDataException {
    IMusicModel model = new MusicModel();
    GuiViewFrame guiView = new GuiViewFrame();
    StringView strView = new StringView();
    MidiViewImpl midiView = new MidiViewImpl();
    midiView.playNote();
    guiView.initialize();
    guiView.display(model);
    strView.display(model);
    System.out.print(strView.getText());

    // You probably need to connect these views to your model, too...
  }
}
