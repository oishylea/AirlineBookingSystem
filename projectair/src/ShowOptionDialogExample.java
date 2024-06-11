import javax.swing.*;
public class ShowOptionDialogExample {

  public static void main(String[] args) {
    /* Simple JOptionPane ShowOptionDialogJava example */    
    String[] options = { "rock", "paper", "scissors" };
    var selection = JOptionPane.showOptionDialog(null, "Select one:", "Let's play a game!", 
                                                      0, 3, null, options, options[0]);
    if (selection == 0) {
      JOptionPane.showMessageDialog(null, "You chose rock!");
    }
    if (selection == 1) { 
      JOptionPane.showMessageDialog(null, "You chose paper.");
    }
    if (selection == 2) { 
      JOptionPane.showMessageDialog(null, "You chose scissors!");
    }
  }
}