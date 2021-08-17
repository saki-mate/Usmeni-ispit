package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.Pitanje;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DPitanja extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int brZamena=0;
	private final JPanel contentPanel = new JPanel();
	private static int grupa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPitanja dialog = new DPitanja(grupa);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public DPitanja(int grupa) throws IOException {
		DPitanja.grupa = grupa;
		setBounds(100, 100, 453, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Pitanje pitanje1 = Pitanje.izvuciPitanje(grupa);
		Pitanje pitanje2 = Pitanje.izvuciPitanje(grupa%2+1);
		
		JTextArea taPitanja = new JTextArea(""
				+ pitanje1
				+ "\n"
				+ pitanje2
				);
		taPitanja.setBounds(175, 37, 252, 76);
		contentPanel.add(taPitanja);
		
		
		
		JLabel lblPitanja = new JLabel("Vasa pitanja");
		lblPitanja.setBounds(10, 67, 139, 14);
		contentPanel.add(lblPitanja);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnZameni1 = new JButton("Zameni1");
				btnZameni1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(brZamena==1) {
							JOptionPane.showMessageDialog(btnZameni1, "Nemate vise zamena", "Info", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						taPitanja.setText(""
								+ Pitanje.izvuciPitanje(grupa)
								+ "\n"
								+ pitanje2
								);
						brZamena++;
					}
				});
				btnZameni1.setActionCommand("OK");
				buttonPane.add(btnZameni1);
				getRootPane().setDefaultButton(btnZameni1);
			}
			
			JButton btnZameni2 = new JButton("Zameni2");
			btnZameni2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(brZamena==1) {
						JOptionPane.showMessageDialog(btnZameni2, "Nemate vise zamena", "Info", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					taPitanja.setText(""
							+ pitanje1
							+ "\n"
							+ Pitanje.izvuciPitanje(grupa%2+1)
							);
					brZamena++;
				}
			});
			buttonPane.add(btnZameni2);
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
