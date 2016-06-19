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

import javax.sound.midi.InvalidMidiDataException;


public class MusicEditor {
  public static void main(String[] args) throws IOException, InvalidMidiDataException {
    MusicReader mr = new MusicReader();
    IMusicModel m = mr.parseFile(new FileReader("df-ttfaf.txt"), new MusicModelBuilder());
  /*  m.write(Tone.G, 7, 3, 60, 4);
    m.write(Tone.E, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.C, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 7, 3, 60, 4);
    m.write(Tone.E, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.E, 3, 4, 60, 4);
    m.advance();
    m.advance();
    m.advance();
    m.advance();
    m.write(Tone.G, 8, 3, 60, 4);
    m.write(Tone.D, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.D, 4, 4, 60, 4);
    m.advance();
    m.advance();
    m.advance();
    m.advance();
    m.write(Tone.G, 2, 3, 60, 4);
    m.write(Tone.E, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 2, 4, 60, 4);
    m.advance();
    m.advance();
    m.write(Tone.G, 4, 4, 60, 4);
    m.advance();
    m.advance();
    m.advance();
    m.advance();
    m.write(Tone.G, 8, 3, 60, 4);
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
    m.write(Tone.C, 8, 4);*/
    GuiViewFrame guiView = new GuiViewFrame(m);
    StringView strView = new StringView(m);
    MidiViewImpl midiView = new MidiViewImpl(m);
  //  m.setTempo(200000);
    midiView.display();
 //   midiView.playNote();
    guiView.initialize();
    guiView.display();
    strView.display();
    System.out.print(strView.getText());

    // You probably need to connect these views to your model, too...
  }
}
