import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class bmi extends JFrame {

	private JPanel contentPane;
	private JTextField feetTextField;
	private JTextField inchesTextField;
	private JTextField weightTextField;
	private JTextField bmiTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bmi frame = new bmi();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocation(580,150);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bmi() {
		setTitle("BMI Calculation Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heightLabel = new JLabel("Your Height");
		heightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		heightLabel.setBounds(24, 49, 74, 13);
		heightLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(heightLabel);
		
		feetTextField = new JTextField();
		feetTextField.setHorizontalAlignment(SwingConstants.CENTER);
		feetTextField.setBounds(121, 38, 85, 30);
		contentPane.add(feetTextField);
		feetTextField.setColumns(10);
		
		inchesTextField = new JTextField();
		inchesTextField.setHorizontalAlignment(SwingConstants.CENTER);
		inchesTextField.setBounds(250, 38, 85, 30);
		contentPane.add(inchesTextField);
		inchesTextField.setColumns(10);
		
		JLabel ftLabel = new JLabel("Feet");
		ftLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ftLabel.setBounds(148, 78, 45, 13);
		contentPane.add(ftLabel);
		
		JLabel inchesLabel = new JLabel("Inches");
		inchesLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		inchesLabel.setBounds(272, 78, 45, 13);
		contentPane.add(inchesLabel);
		
		JLabel weightLabel = new JLabel("Your Weight");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		weightLabel.setBounds(24, 140, 74, 13);
		contentPane.add(weightLabel);
		
		weightTextField = new JTextField();
		weightTextField.setHorizontalAlignment(SwingConstants.CENTER);
		weightTextField.setBounds(121, 132, 85, 30);
		contentPane.add(weightTextField);
		weightTextField.setColumns(10);
		
		JLabel kgLabel = new JLabel("Kg");
		kgLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		kgLabel.setBounds(216, 140, 45, 13);
		contentPane.add(kgLabel);
		
		JLabel commentsLabel = new JLabel("");
		commentsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		commentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		commentsLabel.setBounds(41, 342, 304, 30);
		contentPane.add(commentsLabel);
		
		JButton calculateBtn = new JButton("Calculate Your BMI");
		calculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double feet, inches, kilogram;
				double height, bmi;
				
				try {
					
					feet = Double.parseDouble(feetTextField.getText());
					inches = Double.parseDouble(inchesTextField.getText());
					kilogram = Double.parseDouble(weightTextField.getText());
					
					height = (feet * 12) + inches;
					height = (height * 2.54) / 100;
					
					bmi = kilogram / (height * height);
					
					bmiTextField.setText(new DecimalFormat("##.##").format(bmi));
					
					if(bmi < 18.5) {
						commentsLabel.setText("You are UnderWeight");
					} 
					else if(bmi >= 18.5 && bmi <= 24.9) {
						commentsLabel.setText("Your weight is Normal");
					}
					else if(bmi > 24.9 && bmi <= 29.9) {
						commentsLabel.setText("You are OverWeight");
					}
					else {                                         // bmi > 29.9
						commentsLabel.setText("You are Obese");
					}
					
				} catch(Exception e1) {
					bmiTextField.setText("");
					commentsLabel.setText("Please chech required TextFields");
				}
				
			}
		});
		calculateBtn.setFont(new Font("Arial Black", Font.PLAIN, 24));
		calculateBtn.setForeground(new Color(255, 255, 255));
		calculateBtn.setBackground(new Color(0, 51, 255));
		calculateBtn.setBounds(24, 213, 333, 41);
		contentPane.add(calculateBtn);
		
		JLabel bmiLabel = new JLabel("Your BMI");
		bmiLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmiLabel.setBounds(24, 299, 74, 13);
		contentPane.add(bmiLabel);
		
		bmiTextField = new JTextField();
		bmiTextField.setHorizontalAlignment(SwingConstants.CENTER);
		bmiTextField.setBounds(121, 291, 85, 30);
		contentPane.add(bmiTextField);
		bmiTextField.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feetTextField.setText("");
				inchesTextField.setText("");
				weightTextField.setText("");
				bmiTextField.setText("");
				commentsLabel.setText("");
			}
		});
		clearBtn.setFont(new Font("Arial Black", Font.PLAIN, 18));
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setBackground(new Color(153, 51, 204));
		clearBtn.setBounds(41, 408, 95, 35);
		contentPane.add(clearBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setForeground(new Color(255, 255, 255));
		exitBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
		exitBtn.setBackground(new Color(255, 0, 0));
		exitBtn.setBounds(250, 408, 95, 35);
		contentPane.add(exitBtn);
	}
}
