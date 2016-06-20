package cs3500.music.view;

import javax.sound.midi.Instrument;

import cs3500.music.model.IMusicModel;

/**
 * Created by brendanreed on 6/19/16.
 */
public class MockMidiDevice implements IView {

  private final IMusicModel m;
  private StringBuilder s;
  private Instrument[] band;


  @Override
  public void display() {

  }
}
