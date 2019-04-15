/*
 * MeeseDrinkMachine.java
 * Author: Aaron Meese
 * Date: 4/13/19
 * 
 * This is an applet that allows the user to 
 * interact with a simulated vending machine.
 * They can input money, purchase from a finite
 * amount of drinks, and receive their change.
 * 
 * PLEASE NOTE: I spent a lot of time on this 
 * making it pretty and creative in an attempt
 * to earn bonus, but for the life of me I 
 * cannot figure out how to run an applet in 
 * the web browser. I followed the example PDF
 * EXACTLY and even that would not run for me, 
 * but I would really appreciate it if you could
 * explain why this isn't working for me and still
 * run my code in Eclipse to see how well it works.
 * 
 */

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;

public class MeeseDrinkMachine extends JApplet implements FocusListener {
	// Define graphic and audible components
	JTextField moneyInput = new JTextField("      Enter money here", 12);
	ImageIcon cokeImage = new ImageIcon(new ImageIcon("coke.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
	JLabel coke = new JLabel("Coca Cola - $0.75");
	JButton cokeButton = new JButton(cokeImage);
	ImageIcon pepperImage = new ImageIcon(new ImageIcon("pepper.png").getImage().getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH));
	JLabel pepper = new JLabel("Dr. Pepper - $0.75");
	JButton pepperButton = new JButton(pepperImage);
	ImageIcon lemonImage = new ImageIcon(new ImageIcon("sprite.png").getImage().getScaledInstance(55, 30, java.awt.Image.SCALE_SMOOTH));
	JLabel lemon = new JLabel("Lemon-lime Soda - $0.75");
	JButton lemonButton = new JButton(lemonImage);
	ImageIcon waterImage = new ImageIcon(new ImageIcon("water.png").getImage().getScaledInstance(30, 35, java.awt.Image.SCALE_SMOOTH));
	JLabel water = new JLabel("Bottled Water - $1.00");
	JButton waterButton = new JButton(waterImage);
	int cokeCount = 10, pepperCount = 10, lemonCount = 10, waterCount = 10;
	JLabel change = new JLabel("Change: $0.00");
	ImageIcon changeImage = new ImageIcon(new ImageIcon("change.png").getImage().getScaledInstance(50, 30, java.awt.Image.SCALE_SMOOTH));
	// NOTE: This is extremely ugly currently, but I can't seem to find an easy way to fix it. Before I just didn't have
	// a change button, but that wasn't realistic at all. I have to make the image wide to give the button its own row.
	JButton changeButton = new JButton(changeImage);
	
	AudioClip success, failure, changeSound;
	
	public void init() {
		setLayout(new FlowLayout());
		this.setSize(150, 410);
		moneyInput.addFocusListener(this);
		
		// Set button and text field tooltips
		cokeButton.setToolTipText("Purchase a Coca Cola");
		pepperButton.setToolTipText("Purchase a Dr. Pepper");
		lemonButton.setToolTipText("Purchase a Lemon-lime Soda");
		waterButton.setToolTipText("Purchase a Bottled Water");
		changeButton.setToolTipText("Get your change");
		moneyInput.setToolTipText("Enter money here");
		
		// Set mnemonics
		cokeButton.setMnemonic(KeyEvent.VK_C);
		pepperButton.setMnemonic(KeyEvent.VK_P);
		lemonButton.setMnemonic(KeyEvent.VK_L);
		waterButton.setMnemonic(KeyEvent.VK_W);
		changeButton.setMnemonic(KeyEvent.VK_E);
		
		try {
			success = Applet.newAudioClip(new File("success.wav").toURI().toURL());
			failure = Applet.newAudioClip(new File("failure.wav").toURI().toURL());
			changeSound = Applet.newAudioClip(new File("change.wav").toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		// Adds all components to the applet display
		add(moneyInput);
		add(coke);
		add(cokeButton);
		add(pepper);
		add(pepperButton);
		add(lemon);
		add(lemonButton);
		add(water);
		add(waterButton);
		add(changeButton);
		add(change);
		
		cokeButton.addActionListener(event -> {
			if (cokeCount > 0) {
				if (enoughMoney(.75)) {
					cokeCount--;
				}
			} else {
				outOfDrink("Coca Cola");
			}
		});
		pepperButton.addActionListener(event -> {
			if (pepperCount > 0) {
				if (enoughMoney(.75)) {
					pepperCount--;
				}
			} else {
				outOfDrink("Dr. Pepper");
			}
		});
		lemonButton.addActionListener(event -> {
			if (lemonCount > 0) {
				if (enoughMoney(.75)) {
					lemonCount--;
				}
			} else {
				outOfDrink("Lemon-lime Soda");
			}
		});
		waterButton.addActionListener(event -> {
			if (waterCount > 0) {
				if (enoughMoney(1.00)) {
					waterCount--;
				}
			} else {
				outOfDrink("Bottled Water");
			}
		});
		changeButton.addActionListener(event -> {
			try {
				setChange("Change: $" + String.format("%.2f", Double.parseDouble(moneyInput.getText())));
				moneyInput.setText("");
				changeSound.play();
			} catch (NumberFormatException e) {
				// Ignores error
				setChange("Change: $0.00");
			}
		});
	}
	
	// Display warning that the selected drink is out of stock
	public void outOfDrink(String drink) {
		JOptionPane.showMessageDialog(null, "This machine is out of " + drink + "! Please pick something else.", 
				"Alert", JOptionPane.WARNING_MESSAGE);
	}
	
	/*
	 * This is a terrible way of doing things, because instead of just returning
	 * what the name suggests the function also handles everything else about 
	 * success or failure except decrementing the specified count, but I preferred 
	 * it to having large portions of repeated code in the ActionListeners.
	 */
	public boolean enoughMoney(double cost) {
		try {
			// Removes a possible leading dollar sign from the input field
			String currentMoney = moneyInput.getText();
			int index = currentMoney.indexOf('$');
			if (index != -1) {
				currentMoney.substring(index);
				moneyInput.setText(currentMoney);
			}
			
			double money = Double.parseDouble(0 + moneyInput.getText());
			if (money >= cost) {
				success.play();
				
				// Rounds the change to conventional money terms (2 decimal places)
				moneyInput.setText("" + String.format("%.2f", money - cost));
				return true;
			} else {
				failure.play();

				setChange("Please enter enough \n money for that \n purchase.");
				return false;
			}
			
		} catch (NumberFormatException e) {
			failure.play();
			
			setChange("Please enter a valid \n amount of money.");
			return false;
		}
	}
	
	// Allows the \n to actually create a new line and centers the text
	public void setChange(String string) {
		change.setText("<html><div style='text-align:center;'>" + string.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</div></html>");
	}
	
	// Allows the user to enter money without having to worry about interfering instructions
	@Override
	public void focusGained(FocusEvent e) {
		if (moneyInput.getText().equals("      Enter money here")) {
			moneyInput.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (moneyInput.getText().equals("")) {
			moneyInput.setText("      Enter money here");
		}
	}
}
