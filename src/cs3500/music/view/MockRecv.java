package cs3500.music.view;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

/**
 * Created by brendanreed on 6/19/16.
 */
public class MockRecv implements Receiver {

  private StringBuilder s;

  public MockRecv(StringBuilder s) {
    this.s = s;
  }

  @Override
  public void send(MidiMessage message, long timeStamp) {

    String mMessage = message.getMessage().toString();
    String mStatus = Integer.toString(message.getStatus());
    String mTimeStamp = Long.toString(timeStamp);
    this.s.append(mStatus + mMessage + mTimeStamp);

  }

  @Override
  public void close() {

  }
}
