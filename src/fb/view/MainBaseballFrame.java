package src.fb.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainBaseballFrame extends JFrame
{
  private Toolkit tk = Toolkit.getDefaultToolkit();
  //all panels needed by this application
  private static TeamList tl;
  private static String user;
  private static String password;
  
  public MainBaseballFrame() {
    this.setSize(400,300);
    this.setLocation(tk.getScreenSize().width / 3,
                     tk.getScreenSize().height / 3);
    //NOTE: adjust path !!!
    String path = 
            "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";
    String file = "baseballpic.jpg";

    //Add features
    JLabel titleOfApp = new JLabel("Fantasy Fantasy Baseball");
    JLabel welcomePic;
    Image thePic = tk.getImage(path + file);
    JButton loginButton = new JButton("Welcome!");
  
    JPanel welcomeWindow;
 
    welcomeWindow = new JPanel();
    welcomeWindow.setLayout(new BorderLayout());
    //Add the title
    titleOfApp.setFont(new Font("Optima", Font.PLAIN, 24));
    titleOfApp.setForeground(Color.BLACK);
    //Add the image
    welcomeWindow.add(titleOfApp, BorderLayout.NORTH);
    thePic = thePic.getScaledInstance(400, 300, Image.SCALE_DEFAULT);
    welcomePic = new JLabel(new ImageIcon(thePic));
    welcomeWindow.add(welcomePic, BorderLayout.CENTER);
    //Add the login button
    welcomeWindow.add(loginButton, BorderLayout.SOUTH);
    //Add the welcome window to the frame's content pane
    Container contentPane = getContentPane();
    contentPane.add(welcomeWindow);

    loginButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          PasswordDialog pd = new PasswordDialog(MainBaseballFrame.this, true);
          //The program should exit if the user fails both to provide valid
          //login info and to set up a new session.
          
          pd.addWindowListener(new WindowAdapter() {
              @Override public void windowClosing(WindowEvent e) {
                  //TODO: more graceful way?
                  System.exit(1);
              }
          }); 
          pd.setVisible(true);
          
          //user inputs login information and we move on to next screen
          String[] loginInfo = pd.getValidatedText();
          if (loginInfo != null) {
            user = loginInfo[0];
            password = loginInfo[1];
            tl = new TeamList();
            switchPanel(MainBaseballFrame.this, tl);
          } else {
              //CLEAN UP: TODO -- add clean up utility method?
              System.exit(1);
          }
           
       } //actionPerformed
    }); //actionListener
  } //constructor

  public static String getSessionUser() {
      return user;
  }
  
  public static String getSessionPassword() {
      return password;
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
  
  public void switchPanel(JFrame base, JPanel newPanel) {
      Container contentPane = base.getContentPane();
      contentPane.removeAll();
      contentPane.add(newPanel);
      contentPane.revalidate();
      contentPane.repaint();
  }

 private static void createAndShowGUI() {
       //When the user closes the window, the application will shut down.
    //TODO: add clean-up code to close connections to database
    //This will involve a window listener, see JDBC tutorial
    MainBaseballFrame mbf = new MainBaseballFrame();
    mbf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mbf.setTitle("Fantasy Fantasy Baseball");
    mbf.pack();
    mbf.setVisible(true);
 }
 //Driver method -- one frame will rotate panels in and out
 public static void main(String[] args) { 
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
 }

}
