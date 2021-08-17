package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import logika.Verifikacija;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GlavniProgram {

	private JFrame frame;
	private JTextField tfBri;
	private JTextField tfPrezime;
	private JTextField tfIme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProgram window = new GlavniProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBri = new JLabel("Unesite indeks");
		lblBri.setBounds(42, 52, 106, 14);
		frame.getContentPane().add(lblBri);
		
		JLabel lblIme = new JLabel("Unesite ime");
		lblIme.setBounds(42, 77, 106, 14);
		frame.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Unesite prezime");
		lblPrezime.setBounds(42, 102, 106, 14);
		frame.getContentPane().add(lblPrezime);
		
		tfBri = new JTextField();
		tfBri.setToolTipText("");
		tfBri.setBounds(158, 49, 86, 20);
		frame.getContentPane().add(tfBri);
		tfBri.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(158, 74, 86, 20);
		frame.getContentPane().add(tfPrezime);
		tfPrezime.setColumns(10);
		
		tfIme = new JTextField();
		tfIme.setBounds(158, 99, 86, 20);
		frame.getContentPane().add(tfIme);
		tfIme.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(158, 157, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bri = tfBri.getText();
				String ime = tfIme.getText();
				String prz = tfPrezime.getText();
				
				try {
					if(!Verifikacija.verifikujIndeks(bri)){
						JOptionPane.showMessageDialog(btnOK, "Greska, Pogresan format indeksa", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					else if(!Verifikacija.verifikujPredispitne(bri)){
						int odg = JOptionPane.showConfirmDialog(btnOK, "Nemate dovoljno bodova na predispitnim\n"
										+ "Da li zelite da se prijavite za popravni isit", "Odabir", 0);
						
						if(odg==JOptionPane.YES_OPTION) {
							DPrijavaPismenogIspita dppi = new DPrijavaPismenogIspita();
							dppi.setVisible(true);
						}

					}
					else if(!Verifikacija.verifikujPodatke(bri))
						JOptionPane.showMessageDialog(btnOK, "Greska, ovaj student ne postoji u bazi.", "Greska", JOptionPane.ERROR_MESSAGE);
					else {
						JOptionPane.showMessageDialog(btnOK, "Dobrodosli na ispit " + ime + " " + prz, "Dobrodoslica", JOptionPane.INFORMATION_MESSAGE);
						
						DOdabirGrupe og = new DOdabirGrupe();
						og.setVisible(true);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnOK.setBounds(42, 157, 89, 23);
		frame.getContentPane().add(btnOK);
	}
}
