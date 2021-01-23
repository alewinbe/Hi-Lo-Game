import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
// page 66
@SuppressWarnings("serial")
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private JButton btnPlayAgain;
	private JButton btnNewButton;
	int numberofTries = 0;
	public void checkGuess() {
		numberofTries = numberofTries + 1;
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				 message = guess + " is too high. Try again.";
			else {
				 message = guess + " is correct! You won in" + " " + numberofTries + " " + "tries" + ". Play again!";
				 btnPlayAgain.setVisible(true);
				 btnNewButton.setVisible(false);
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
				 lblOutput.setText(message);
				 txtGuess.requestFocus();
				 txtGuess.selectAll();
		}
	}	 
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		numberofTries = 0;
		btnNewButton.setVisible(true);
		btnPlayAgain.setVisible(false);
	}
	public GuessingGame() {
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Aku's Hi-Lo Guessing Game.");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aku's Hi-Lo Guessing Game.");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 564, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100: ");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 108, 227, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(242, 103, 100, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		btnNewButton = new JButton("Guess!");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setVisible(true);
		btnNewButton.setBounds(232, 164, 119, 33);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(85, 212, 414, 33);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play again?");
		btnPlayAgain.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayAgain.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOutput.setText("Enter a number above and click Guess!");
				newGame();
			}
		});
		btnPlayAgain.setBounds(228, 160, 127, 40);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(600,400));
		theGame.setVisible(true);

	}
}
