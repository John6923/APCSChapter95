package p95;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Main extends JApplet implements Commons{
	
	private boolean won = false;
	
	private int number = (new Random()).nextInt(100) + 1;
	private int tries = 0;
	
	private JTextField field = new JTextField(GUESS_THE_NUMBER);
	private JButton button = new JButton(GUESS);
	private JTextArea description = new JTextArea(DESCRIPTION);
	private JTextArea tryField = new JTextArea(TRIES + 0);
	
	@Override
	public void init() {
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,2,5,5));
		button.addActionListener(new GuessHandler());
		c.add(description);
		c.add(tryField);
		c.add(field);
		c.add(button);
	}
	
	private class GuessHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(won) return;
			tries++;
			tryField.setText(TRIES + tries);
			int guess = (int)Double.parseDouble(field.getText());
			if(guess == number){
				won = true;
				field.setText(YOU_WON);
				description.setText(GOT_IT + tries + GOT_IT_TWO);
			}
			else {
				if(guess < number){
					description.setText(TOO_LOW);
				}
				else {
					description.setText(TOO_HIGH);
				}
			}
		}
	}
}
