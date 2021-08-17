package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DOdabirGrupe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DOdabirGrupe dialog = new DOdabirGrupe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DOdabirGrupe() {
		setBounds(100, 100, 452, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGrupa = new JLabel("Koju grupu pitanja zelite?");
			lblGrupa.setBounds(37, 33, 162, 14);
			contentPanel.add(lblGrupa);
		}
		
		JCheckBox cb1 = new JCheckBox("1");
		cb1.setBounds(205, 29, 97, 23);
		contentPanel.add(cb1);
		
		JCheckBox cb2 = new JCheckBox("2");
		cb2.setBounds(321, 29, 97, 23);
		contentPanel.add(cb2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(cb1);
		bg.add(cb2);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int grupa = 0;
						if(cb1.isSelected()) 
							grupa = 1;
						else
							grupa = 2;
						
						DPitanja dp;
						try {
							dp = new DPitanja(grupa);
							dp.setVisible(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
