package pagrindas;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame implements ActionListener {

	public void actionPerformed(ActionEvent event){
		
		String elPastas = this.el.getText().toString();
		String name = this.vardas.getText().toString();
		String surName = this.pavardë.getText().toString();
		String menuo = this.menuoSar.getName().toString();
		JOptionPane.showMessageDialog(this, menuo, "Klaida", JOptionPane.ERROR_MESSAGE);	
		try{
			long mob = Long.parseLong(this.mob.getText());
		} catch(NumberFormatException klaidaTelefone) {
			JOptionPane.showMessageDialog(this, "Blogai ávestas telefonas " + mob.getText().toString(), "Klaida", JOptionPane.ERROR_MESSAGE);	
		}
		
		//String mob=this.mob.getText().toString();
		
		/*if(!validateName(name))
			JOptionPane.showMessageDialog(this, "Blogai ávestas vardas", "Klaida", JOptionPane.ERROR_MESSAGE);
		
		if(!validateSurName(surName))
			JOptionPane.showMessageDialog(this, "Blogai ávesta pavardë", "Klaida", JOptionPane.ERROR_MESSAGE);
		
		if(!validateTel(mob))
			JOptionPane.showMessageDialog(this, "Blogai ávestas telefono numeris", "Klaida", JOptionPane.ERROR_MESSAGE);
		
		if(!validateEmail(elPastas))
			JOptionPane.showMessageDialog(this, "Blogai ávestas paðtas", "Klaida", JOptionPane.ERROR_MESSAGE);
	*/}
	
	public static boolean validateName(String nameStr) { 
		final Pattern VALID_NAME = 
			    Pattern.compile("^[A-Z-]{3,30}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_NAME.matcher(nameStr);
		return matcher.find();
	}
	
	public static boolean validateSurName(String surNameStr) { 
		final Pattern VALID_SURNAME = 
			    Pattern.compile("^[A-Z-]{3,30}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_SURNAME.matcher(surNameStr);
		return matcher.find();
	}
	
	public static boolean validateTel(String telStr) { 
		final Pattern VALID_TEL = 
			    Pattern.compile("^[0-9]{8,12}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_TEL.matcher(telStr);
		return matcher.find();
	}

	public static boolean validateEmail(String emailStr) { 
		final Pattern VALID_EMAIL_ADDRESS_REGEX = 
				   Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
		
		TextField el; 
		TextField vardas;
		TextField pavardë;
		TextField mob;
		JComboBox menuoSar;
	
	public MainFrame(String title){
		
		Container vidus = getContentPane();
		setBounds(new Rectangle(0, 0, 300, 400));
		vidus.setLayout(new GridLayout(10, 1, 10, 10));
		vidus.setBackground(Color.lightGray);
		
		JPanel ivadas= new JPanel();
		ivadas.setBackground(Color.lightGray);
		ivadas.setForeground(Color.black);
		
		JPanel klausim1 = new JPanel(); 
		klausim1.setBorder(new TitledBorder("Vardas:"));
		this.vardas = new TextField("", 20);
		klausim1.add(vardas);
		vidus.add(klausim1);
		
		JPanel klausim2 = new JPanel();
		klausim2.setBorder(new TitledBorder("Pavardë:"));
		this.pavardë = new TextField("", 20);
		klausim2.add(pavardë);
		vidus.add(klausim2);
		
		JPanel klausim3 = new JPanel();
		klausim3.setBorder(new TitledBorder("Lytis:"));
		JRadioButton vyras = new JRadioButton("vyras");
		JRadioButton moteris = new JRadioButton("moteris");
		ButtonGroup bG = new ButtonGroup();
		bG.add(vyras);
		bG.add(moteris);
		klausim3.add(vyras); 
		klausim3.add(moteris);
		vidus.add(klausim3); 
		
		JPanel klausim4 = new JPanel();
		klausim4.setBorder(new TitledBorder("Gimimo data:"));
		String diena [] = new String[32];
		for(int i = 1; i < 32; i++){
		diena[i] = Integer.toString(i);
		}
		String menuo [] = new String[13];
		for(int i = 1; i < 13; i++){
		menuo[i] = Integer.toString(i);
		}
		String [] metai = new String[100];
		for(int i = 0; i < 100; i++){
		int metuPradzia = 1910 + i;
		metai[i] = Integer.toString(metuPradzia);
		}
		JComboBox dienaSar = new JComboBox(diena);
		this.menuoSar = new JComboBox(menuo);
		JComboBox metaiSar = new JComboBox(metai);
		dienaSar.setSelectedIndex(1);
		this.menuoSar.setSelectedIndex(1);
		metaiSar.setSelectedIndex(70);
		klausim4.add(dienaSar);
		klausim4.add(menuoSar);
		klausim4.add(metaiSar);
		vidus.add(klausim4);
		
		JPanel klausim5 = new JPanel();
		klausim5.setBorder(new TitledBorder("Mobilusis telefonas:"));
		this.mob = new TextField("86", 20);
		klausim5.add(mob);
		vidus.add(klausim5);
		
		JPanel klausim6 = new JPanel();
		klausim6.setBorder(new TitledBorder("Elektroninis paðtas:"));
		this.el = new TextField("", 20);
		klausim6.add(el);
		vidus.add(klausim6);
		
		JPanel klausim7 = new JPanel();
		klausim7.setBorder(new TitledBorder("Prisijungimo Vardas:"));
		TextField pv = new TextField("", 20);
		klausim7.add(pv);
		vidus.add(klausim7);
		
		JPanel klausim8 = new JPanel();
		klausim8.setBorder(new TitledBorder("Slaptaþodis:"));
		TextField sl = new TextField("", 20);
		klausim8.add(sl);
		vidus.add(klausim8);
		
		JPanel klausim10 = new JPanel();
		klausim10.setBorder(new TitledBorder("Man patinka:"));
		JCheckBox kebabai;
		JCheckBox pica;
		JCheckBox burgeriai;
		JCheckBox sushi;
		kebabai = new JCheckBox("kebabai");
		pica = new JCheckBox("pica");
		burgeriai = new JCheckBox("burgeriai");
		sushi = new JCheckBox("sushi");
		klausim10.add(kebabai);
		klausim10.add(pica);
		klausim10.add(burgeriai);
		klausim10.add(sushi);
		vidus.add(klausim10);
		String maistas = "";
		if (kebabai.isSelected()) {
		maistas += kebabai.getName().toString() + " ";
		}
		
		JPanel klausim9 = new JPanel();
		klausim9.setBorder(new TitledBorder("Duomenø patvirtinimas:"));
		JButton mygtukas=new JButton("Patvirtinimas");
		klausim9.add(mygtukas);
		vidus.add(klausim9);
		
		mygtukas.addActionListener(this);

		
	}	
		

}
