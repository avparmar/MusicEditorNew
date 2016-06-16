package cs3500.music.view;

import cs3500.music.model.IMusicModel;

/**
 * represents a view to represent its model in the console
 */
public class StringView implements IView {

  private String text;

  public StringView() {
    this.text = "";
  }

  public String getText() {
    return this.text;
  }

  @Override
  public void display(IMusicModel m) {
    this.text = m.toString();
  }

}