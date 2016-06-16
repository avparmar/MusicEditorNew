package cs3500.music.model;

/**
 * represents a note
 */
public class Note implements Comparable<Note> {

  // an enumeration representing the tone of a note


  private Tone tone;
  private int duration;
  private int octave;
  private int start;


  /**
   * constructs a note out of the things that determine how a note is
   *
   * @param tone     the tone of the note
   * @param duration the duration, in beats, of the note
   * @param octave   the octave of the note
   * @param start    the time the note will play
   */
  public Note(Tone tone, int duration, int octave, int start) {
    this.tone = tone;
    this.duration = duration;
    this.octave = octave;
    this.start = start;
  }


  /**
   * returns true if this note is equal to the given one, equal means all three fields are equal
   */
  public boolean equals(Note that) {
    return this.tone.equals(that.tone) && this.duration == that.duration &&
            this.octave == that.octave && this.start == that.start;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Note)) {
      return false;
    }
    Note that = (Note) o;

    return equals(that);
  }

  public int getDuration() {
    return duration;
  }

  public int getStart() {
    return start;
  }

  public int getOctave() {
    return octave;
  }

  public Tone getTone() {
    return tone;
  }

  /**
   * for use in comparing by time
   */
  @Override
  public int compareTo(Note that) {
    //  if (Integer.compare(start, that.start) != 0)
    return Integer.compare(start, that.start);
    //  return Integer.compare(that.duration, duration);

  }
}
