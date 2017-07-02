package main.src.java;

import javax.swing.JFrame;

public class MainBaseballFrame extends JFrame
{
  public MainBaseballFrame() {
    this.setSize(350,200);
    this.setLocation(200,200);
    //When the user closes the window, the application will shut down.
    //TODO: add clean-up code to close connections to database
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

  //Makes the frame visible.
  public void showFrame() {
    this.setVisible(true);
  }

  //Makes the frame visible and sets the title text.
  public void showFrame(String title) {
    this.setTitle(title);
    this.setVisible(true);
  }

  //Overloaded method to set title and position of the frame
  public void showFrame(String title, int x, int y) {
    this.setTitle(title);
    this.setLocation(x,y);
    this.setVisible(true);
  }

  public void hideIt() {
    this.setVisible(false);
  }
}
