import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// page 66
@SuppressWarnings("serial")
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber)
			message = guess + " is too low. Try again.";
		else if (guess > theNumber)
			 message = guess + " is too high. Try again.";
			 else
				 message = guess + " is correct. You win!";
		lblOutput.setText(message);
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Aku's Hi-Lo Guessing Game.");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aku's Hi-Lo Guessing Game.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 112, 227, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(247, 109, 119, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(172, 157, 89, 23);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 212, 414, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
