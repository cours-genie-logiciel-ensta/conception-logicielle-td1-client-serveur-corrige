
package automateClient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * * * This code was edited or generated using CloudGarden's Jigloo * *
 * SWT/Swing GUI Builder, which is free for non-commercial * * use. If Jigloo is
 * being used commercially (ie, by a corporation, * * company or business for
 * any purpose whatever) then you * * should purchase a license for each
 * developer using Jigloo. * * Please visit www.cloudgarden.com for details. * *
 * Use of Jigloo implies acceptance of these licensing terms. * * A COMMERCIAL
 * LICENSE HAS NOT BEEN PURCHASED FOR * * THIS MACHINE, SO JIGLOO OR THIS CODE
 * CANNOT BE USED * * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE. ## class
 * ClientGUI
 */
public class ClientGUI extends JFrame implements PropertyChangeListener {

	/**
	 * ## attribute sommenpoche
	 */
	private int sommenpoche; // ## attribute sommenpoche

	/**
	 * ## attribute sommetraitee
	 */
	private int sommetraitee; // ## attribute sommetraitee

	/**
	 * ## attribute typeoperation
	 */
	private String typeoperation; // ## attribute typeoperation

	/**
	 * ## link Quitter
	 */
	private JButton Quitter; // ## link Quitter

	/**
	 * ## link buttonGroup1
	 */
	private ButtonGroup buttonGroup1; // ## link buttonGroup1

	/**
	 * ## link jEdSaisie
	 */
	private JEditorPane jEdSaisie; // ## link jEdSaisie

	/**
	 * ## link jLabelSommenpoche
	 */
	private JLabel jLabelSommenpoche; // ## link jLabelSommenpoche

	/**
	 * ## link jLabelSommetraitee
	 */
	private JLabel jLabelSommetraitee; // ## link jLabelSommetraitee

	/**
	 * ## link jPanel2
	 */
	private JPanel jPanel2; // ## link jPanel2

	/**
	 * ## link jPanelNO
	 */
	private JPanel jPanelNO; // ## link jPanelNO

	/**
	 * ## link jPanelcentre
	 */
	private JPanel jPanelcentre; // ## link jPanelcentre

	/**
	 * ## link jPanelsud
	 */
	private JPanel jPanelsud; // ## link jPanelsud

	/**
	 * ## link jRadioButtonDepot
	 */
	private JRadioButton jRadioButtonDepot; // ## link jRadioButtonDepot

	/**
	 * ## link jRadioButtonRetrait
	 */
	private JRadioButton jRadioButtonRetrait; // ## link jRadioButtonRetrait

	/**
	 * ## link jTextArea1
	 */
	private JTextArea jTextArea1; // ## link jTextArea1

	/**
	 * ## link jTextAreaSommenpoche
	 */
	private JTextArea jTextAreaSommenpoche; // ## link jTextAreaSommenpoche

	/**
	 * ## link jTextFieldSommenpoche
	 */
	private JTextField jTextFieldSommenpoche; // ## link jTextFieldSommenpoche

	/**
	 * ## link monCompte
	 */
	protected Automate monCompte; // ## link monCompte

	/**
	 * ## link valider
	 */
	private JButton valider; // ## link valider

	// Constructors

	/**
	 * ## operation ClientGUI()
	 */
	public ClientGUI() {
		super();
		sommenpoche = 0;
		sommetraitee = 0;
		typeoperation = "retrait";

		initGUI();

	}

	/**
	 * ## operation getButtonGroup1()
	 */
	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	/**
	 * ## operation getJLabelSommenpoche()
	 */
	private JLabel getJLabelSommenpoche() {
		if (jLabelSommenpoche == null) {
			jLabelSommenpoche = new JLabel();
			jLabelSommenpoche.setFont(new java.awt.Font("Tahoma", 1, 14));
			jLabelSommenpoche.setText("Somme en poche");
			jLabelSommenpoche.setHorizontalTextPosition(SwingConstants.LEFT);
		}
		return jLabelSommenpoche;
	}

	/**
	 * ## operation getJLabelSommetraitee()
	 */
	private JLabel getJLabelSommetraitee() {
		if (jLabelSommetraitee == null) {
			jLabelSommetraitee = new JLabel();
			jLabelSommetraitee.setText("Somme � traiter");
			jLabelSommetraitee.setFont(new java.awt.Font("Tahoma", 1, 14));
			jLabelSommetraitee.setPreferredSize(new java.awt.Dimension(150, 40));
			jLabelSommetraitee.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return jLabelSommetraitee;
	}

	/**
	 * ## operation getJPanelNO()
	 */
	private JPanel getJPanelNO() {
		if (jPanelNO == null) {
			jPanelNO = new JPanel();
			jPanelNO.setPreferredSize(new java.awt.Dimension(193, 47));
			jPanelNO.setBackground(new java.awt.Color(255, 128, 128));
		}
		return jPanelNO;
	}

	/**
	 * ## operation getJTextFieldSommenpoche()
	 */
	public JTextField getJTextFieldSommenpoche() {
		if (jTextFieldSommenpoche == null) {
			jTextFieldSommenpoche = new JTextField();
			jTextFieldSommenpoche.setText(Integer.toString(this.getSommenpoche()));
			jTextFieldSommenpoche.setPreferredSize(new java.awt.Dimension(43, 43));
			jTextFieldSommenpoche.setFont(new java.awt.Font("Tahoma", 1, 14));
			jTextFieldSommenpoche.setHorizontalAlignment(SwingConstants.LEFT);
			jTextFieldSommenpoche.setEditable(false);
		}
		return jTextFieldSommenpoche;
	}

	/**
	 * ## operation getSommenpoche()
	 */
	public int getSommenpoche() {
		return sommenpoche;
	}

	/**
	 * ## operation getSommetraitee()
	 */
	public int getSommetraitee() {
		return sommetraitee;
	}

	/**
	 * ## operation getTypeoperation()
	 */
	public String getTypeoperation() {
		return typeoperation;
	}

	/**
	 * ## operation initGUI()
	 */
	private void initGUI() {
		ClientTCP clienttcp = new ClientTCP("localhost", 6666);
		monCompte = new Automate(clienttcp, 0);
		monCompte.getPropertyChangeSupport().addPropertyChangeListener(this);
		System.out.println(monCompte);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setForeground(new java.awt.Color(255, 0, 128));
			this.setLocationRelativeTo(null);
			this.setVisible(true);

			this.setFont(new java.awt.Font("Antique Olive", 0, 10));
			this.setTitle("Automate Banquaire");
			getContentPane().setBackground(new java.awt.Color(255, 128, 64));
			{
				jPanelsud = new JPanel();
				getContentPane().add(jPanelsud, BorderLayout.SOUTH);
				jPanelsud.setPreferredSize(new java.awt.Dimension(392, 36));
				jPanelsud.setBackground(new java.awt.Color(255, 128, 128));
				{
					valider = new JButton();
					jPanelsud.add(valider);
					valider.setText("Valider");
					valider.setBackground(new java.awt.Color(0, 128, 0));
					valider.setPreferredSize(new java.awt.Dimension(119, 22));
					valider.setSize(190, 30);
					valider.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent evt) {
							monCompte.connexionBanque();
							System.out.println("la somme � traiter " + jEdSaisie.getText());
							setSommenpoche(Integer.parseInt(jTextFieldSommenpoche.getText()));
							System.out.println("le type d'operation : " + getTypeoperation());
							if (getTypeoperation() == "retrait") {
								System.out.println(" somme trait�e en retrait " + jEdSaisie.getText());
								monCompte.demandeRetrait(Integer.parseInt(jEdSaisie.getText()));
							}
							if (getTypeoperation() == "depot") {
								System.out.println(" somme trait�e en depot " + jEdSaisie.getText());
								monCompte.demandeDepot(Integer.parseInt(jEdSaisie.getText()));

							}
							monCompte.deconnexionBanque();
							System.out.println(monCompte);
						}

					});
				}
				{
					Quitter = new JButton();
					jPanelsud.add(Quitter);
					Quitter.setText("Quitter");
					Quitter.setBackground(new java.awt.Color(0, 128, 0));
					Quitter.setPreferredSize(new java.awt.Dimension(111, 24));
					Quitter.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent evt) {
							System.exit(0);
						}

					});
				}
			}
			{
				jPanel2 = new JPanel();
				GridLayout jPanel2Layout = new GridLayout(2, 1);
				jPanel2Layout.setHgap(5);
				jPanel2Layout.setVgap(5);
				jPanel2Layout.setColumns(1);
				// jPanel2Layout.setRows(3);
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, BorderLayout.WEST);
				jPanel2.setPreferredSize(new java.awt.Dimension(200, 118));
				jPanel2.setBackground(new java.awt.Color(255, 128, 128));
				// jPanel2.setPreferredSize(new java.awt.Dimension(150, 80));

				// jPanel2.add(getJTextAreaSommenpoche());
				jPanel2.add(getJLabelSommenpoche());
				jPanel2.add(getJTextFieldSommenpoche());

			}

			{
				jPanelcentre = new JPanel();
				getContentPane().add(jPanelcentre, BorderLayout.CENTER);
				jPanelcentre.setForeground(new java.awt.Color(255, 128, 64));
				jPanelcentre.setBackground(new java.awt.Color(255, 128, 0));
				jPanelcentre.setPreferredSize(new java.awt.Dimension(150, 80));
				{
					jEdSaisie = new JEditorPane();

					jPanelcentre.add(getJLabelSommetraitee());
					jPanelcentre.add(jEdSaisie);
					jEdSaisie.setPreferredSize(new java.awt.Dimension(140, 37));
					jEdSaisie.setBackground(new java.awt.Color(181, 217, 38));
					jEdSaisie.setForeground(new java.awt.Color(0, 0, 128));
					jEdSaisie.setFont(new java.awt.Font("Antique Olive", 1, 20));
					jEdSaisie.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));

				}
			}
			{
				jPanelNO = new JPanel();
				GridLayout jPanelNOLayout = new GridLayout(3, 1);
				jPanel2.add(getJPanelNO());
				jPanelNOLayout.setHgap(5);
				jPanelNOLayout.setVgap(5);
				jPanelNOLayout.setColumns(1);
				jPanelNO.setLayout(jPanelNOLayout);
				getContentPane().add(jPanelNO, BorderLayout.EAST);

				{
					jTextArea1 = new JTextArea();
					// jPanel2.add(getJTextAreaSommenpoche());
					jPanelNO.add(jTextArea1);
					jTextArea1.setText("Choix de l'Op�ration");
					jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 14));
					jTextArea1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					jTextArea1.setWrapStyleWord(true);
					jTextArea1.setPreferredSize(new java.awt.Dimension(183, 38));
					jTextArea1.setBackground(new java.awt.Color(0, 128, 64));
				}

				// buttonGroup1=new ButtonGroup();
				{
					jRadioButtonRetrait = new JRadioButton();
					jRadioButtonRetrait.setText("Retrait");
					jRadioButtonRetrait.setBackground(new java.awt.Color(23, 238, 233));
					jRadioButtonRetrait.setFont(new java.awt.Font("Tahoma", 1, 11));
					jRadioButtonRetrait.setSelected(true);
					setTypeoperation("retrait");

				}
				jPanelNO.add(jRadioButtonRetrait);

				{
					jRadioButtonDepot = new JRadioButton();
					jPanelNO.add(jRadioButtonDepot);
					jRadioButtonDepot.setText("D�p�t");
					jRadioButtonDepot.setBackground(new java.awt.Color(128, 255, 0));
					jRadioButtonDepot.setFont(new java.awt.Font("Tahoma", 1, 11));
					jRadioButtonDepot.setSelected(false);

				}
				jPanelNO.add(jRadioButtonDepot);

				buttonGroup1 = new ButtonGroup();
				buttonGroup1.add(jRadioButtonDepot);

				jRadioButtonDepot.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jRadioButtonDepot.actionPerformed, event=" + evt);
						setTypeoperation("depot");
					}
				});

				getButtonGroup1().add(jRadioButtonRetrait);
				jRadioButtonRetrait.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jRadioButtonRetrait.actionPerformed, event=" + evt);
						setTypeoperation("retrait");
					}
				});
			}

			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// #]
		// #]
	}

	/**
	 * * @param sommenpoche ## operation setSommenpoche(int)
	 * 
	 * @param sommenpoche
	 */
	public void setSommenpoche(int sommenpoche) {
		this.sommenpoche = sommenpoche;
	}

	/**
	 * * @param sommetraitee ## operation setSommetraitee(int)
	 * 
	 * @param sommetraitee
	 */
	public void setSommetraitee(int sommetraitee) {
		this.sommetraitee = sommetraitee;
	}

	/**
	 * * @param typeoperation ## operation setTypeoperation(String)
	 * 
	 * @param typeoperation
	 */
	public void setTypeoperation(String typeoperation) {
		this.typeoperation = typeoperation;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() instanceof Automate) {
			if (evt.getPropertyName().equals("sommePoche")) {
				jTextFieldSommenpoche.setText(Integer.toString(((Automate) evt.getSource()).getSommePoche()));
			}
		}
	}

}
