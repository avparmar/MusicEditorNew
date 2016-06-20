package cs3500.music.view;

import cs3500.music.model.IMusicModel;

/**
 * represents a view to represent its model in the console
 */
public class StringView implements IView {

  private String text;
  IMusicModel m;

  public StringView(IMusicModel m) {
    this.text = "";
    this.m = m;
  }

  /**
   * Gets the text view
   *
   * @return a string representing the text view
   */
  public String getText() {
    return this.text;
  }


  @Override
  public void display() {
    this.text = m.toString();
  }

}