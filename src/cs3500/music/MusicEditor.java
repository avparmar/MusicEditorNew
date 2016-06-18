package cs3500.music;

import cs3500.music.model.IMusicModel;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Tone;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.StringView;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;


public class MusicEditor {
  public static void main(String[] args) throws IOException, InvalidMidiDataException {
    IMusicModel model = new MusicModel();
    model.writeTime(Tone.C, 2, 4, 0);
    model.writeTime(Tone.Asharp, 2, 3, 2);
    model.writeTime(Tone.Gsharp, 2, 3, 4);
    GuiViewFrame guiView = new GuiViewFrame();
    StringView strView = new StringView();
    MidiViewImpl midiView = new MidiViewImpl();
    model.setTempo(200000);
    midiView.display(model);
 //   midiView.playNote();
    guiView.initialize();
    guiView.display(model);
    strView.display(model);
    System.out.print(strView.getText());

    // You probably need to connect these views to your model, too...
  }
}
