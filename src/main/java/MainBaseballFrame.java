package main.src.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainBaseballFrame extends JFrame
{
  public MainBaseballFrame() {
    this.setSize(350,200);
    this.setLocation(200,200);
    //When the user closes the window, the application will shut down.

    //TODO: add clean-up code to close connections to database
    //This will involve a window listener, see JDBC tutorial
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add features
    JLabel titleOfApp = new JLabel("Fantasy Fantasy Baseball");
    ImageIcon welcomePic = new ImageIcon("../resources/baseballpic.jpg");
    JButton loginButton = new JButton("Login");
    
    //The pane to "glue" into the frame
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    //Add the components
    contentPane.add(titleOfApp, BorderLayout.NORTH);
    //TODO: figure out how to get the image added
    contentPane.add(loginButton, BorderLayout.SOUTH);


    //TODO: Either open a dialog for the button click or create a new frame
    loginButton.addActionListener(new ActionListener() {

       String username = JOptionPane.showInputDialog(
		MainBaseballFrame.this, "Username");
    });
    
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


 //TODO: driver method, may be moved to another class eventually
 public static void main(String[] args) {
   
    MainBaseballFrame mbf = new MainBaseballFrame();
    mbf.pack();
    mbf.showFrame("Fantasy Fantasy Baseball");
 }

}
