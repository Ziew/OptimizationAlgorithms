import java.awt.*;

import javax.swing.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class Test extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private Matrix matrix_ = new Matrix();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	final JFileChooser fc = new JFileChooser();
	private JTextField textField_15;


	public static void main(String[] args) {
		Test t = new Test();
	}

	public Test() {

		JFrame j = new JFrame();
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);
		j.setSize(400, 400);
		j.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 54, 374, 308);
		j.getContentPane().add(tabbedPane);

		JToolBar toolBar = new JToolBar();
		tabbedPane.addTab("SA", null, toolBar, null);

		JPanel panel = new JPanel();
		toolBar.add(panel);
		panel.setLayout(null);

		JLabel lblTmax = new JLabel("Lalg");
		lblTmax.setBounds(25, 7, 36, 15);
		panel.add(lblTmax);

		textField = new JTextField();
		textField.setText("4");
		textField.setBounds(79, 5, 114, 19);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("4");
		textField_1.setBounds(79, 36, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("wykonaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int LAlg = Integer.parseInt(textField.getText());
				int LBag = Integer.parseInt(textField_1.getText());
				int temp = Integer.parseInt(textField_2.getText());
				double n = Double.parseDouble(textField_3.getText());
				int num_it = Integer.parseInt(textField_4.getText());
				int PK = Integer.parseInt(textField_15.getText());

				Permutation perm = new Permutation(LAlg, LBag ,PK);
				IOptimizationAlgorithms SA = new SimulatedAnnealing(matrix_, perm, temp, num_it, n);
				SA.calculate();
			}
		});
		btnNewButton.setBounds(119, 240, 117, 25);
		panel.add(btnNewButton);

		textField_2 = new JTextField();
		textField_2.setText("1000");
		textField_2.setBounds(79, 67, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("0.9");
		textField_3.setBounds(79, 98, 114, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setText("1000");
		textField_4.setBounds(79, 129, 114, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblLbag = new JLabel("LBag");
		lblLbag.setBounds(25, 40, 36, 15);
		panel.add(lblLbag);

		JLabel lblTemperature = new JLabel("temp");
		lblTemperature.setBounds(25, 69, 36, 15);
		panel.add(lblTemperature);

		JLabel lblN = new JLabel("n");
		lblN.setBounds(25, 100, 14, 15);
		panel.add(lblN);

		JLabel lblNumit = new JLabel("num_it");
		lblNumit.setBounds(25, 131, 49, 15);
		panel.add(lblNumit);
		
		textField_15 = new JTextField();
		textField_15.setText("10");
		textField_15.setBounds(79, 160, 114, 19);
		panel.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblPk = new JLabel("PK");
		lblPk.setBounds(25, 158, 25, 15);
		panel.add(lblPk);

		JToolBar toolBar_1 = new JToolBar();
		tabbedPane.addTab("Tabu search", null, toolBar_1, null);

		JPanel panel_1 = new JPanel();
		toolBar_1.add(panel_1);
		panel_1.setLayout(null);

		textField_5 = new JTextField();
		textField_5.setBounds(110, 12, 114, 19);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(110, 53, 114, 19);
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(110, 93, 114, 19);
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(110, 131, 114, 19);
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel = new JLabel("LAlg");
		lblNewLabel.setBounds(39, 14, 70, 15);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("LBag");
		lblNewLabel_1.setBounds(39, 55, 70, 15);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("num_it");
		lblNewLabel_2.setBounds(39, 95, 70, 15);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("num_tabu");
		lblNewLabel_3.setBounds(39, 133, 70, 15);
		panel_1.add(lblNewLabel_3);

		JButton btnWykonaj = new JButton("wykonaj");
		btnWykonaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int LAlg = Integer.parseInt(textField_5.getText());
				int LBag = Integer.parseInt(textField_6.getText());
				int num_it = Integer.parseInt(textField_7.getText());
				int num_tabu = Integer.parseInt(textField_8.getText());
				int pk = Integer.parseInt(textField_15.getText());
				
				Permutation perm = new Permutation(LAlg, LBag, 3);
				TabuSearchAlgorithms TS = new TabuSearchAlgorithms(matrix_, perm, num_it, num_tabu);
				TS.calculate();
				
			}
		});
		btnWykonaj.setBounds(117, 240, 117, 25);
		panel_1.add(btnWykonaj);

		JToolBar toolBar_2 = new JToolBar();
		tabbedPane.addTab("Ant colony", null, toolBar_2, null);

		JPanel panel_2 = new JPanel();
		toolBar_2.add(panel_2);
		panel_2.setLayout(null);

		textField_9 = new JTextField();
		textField_9.setBounds(116, 12, 114, 19);
		panel_2.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(116, 43, 114, 19);
		panel_2.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(116, 74, 114, 19);
		panel_2.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(116, 105, 114, 19);
		panel_2.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(116, 136, 114, 19);
		panel_2.add(textField_13);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(116, 167, 114, 19);
		panel_2.add(textField_14);
		textField_14.setColumns(10);

		JButton btnNewButton_1 = new JButton("wykonaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int LAlg = Integer.parseInt(textField_9.getText());
				int LBag = Integer.parseInt(textField_10.getText());
				int num_ants = Integer.parseInt(textField_11.getText());
				int num_it = Integer.parseInt(textField_13.getText());
				double p = Double.parseDouble(textField_12.getText());
				double betha = Double.parseDouble(textField_14.getText());
				AntColonyOptimizationAlgorithms AC = new AntColonyOptimizationAlgorithms(LAlg, LBag, num_ants, p, num_it, matrix_, betha);
				AC.calculate();
			}
		});
		btnNewButton_1.setBounds(116, 240, 117, 25);
		panel_2.add(btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("LAlg");
		lblNewLabel_4.setBounds(40, 14, 70, 15);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("LBag");
		lblNewLabel_5.setBounds(40, 45, 70, 15);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("num_ants");
		lblNewLabel_6.setBounds(40, 76, 70, 15);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("p");
		lblNewLabel_7.setBounds(40, 107, 70, 15);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("num_it");
		lblNewLabel_8.setBounds(40, 138, 70, 15);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("betha");
		lblNewLabel_9.setBounds(40, 169, 70, 15);
		panel_2.add(lblNewLabel_9);

		JButton btnLoadMatrix = new JButton("Load matrix");
		btnLoadMatrix.setBounds(138, 17, 117, 25);
		btnLoadMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				try {

					int returnVal = fc.showOpenDialog(null);
					matrix_.loadMatrixFromFile(fc.getSelectedFile().getPath());

				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
			}
		});
		j.getContentPane().add(btnLoadMatrix);
		j.setVisible(true);
	}
}