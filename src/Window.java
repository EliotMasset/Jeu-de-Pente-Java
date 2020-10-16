import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Window extends JFrame implements ActionListener
{
	private ZoneDessin zone;
	Window(String s, Partie game)
	{
        super(s);
		setSize(850,870);
        setLocationRelativeTo(null);
		setResizable(false);
        FenetrePrincipal();
        Init_Menu();
		zone = new ZoneDessin(game);
		setContentPane(zone);
		addMouseListener(new Evenement(game));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void _repaint()
	{
		zone.repaint();
	}
    
    public void FenetrePrincipal()
    {}

    public void FenetrePente()
    {}

    public void Init_Menu()
    {
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);
		JMenuItem itemCharger =new JMenuItem("Charger");
		JMenuItem itemSave =new JMenuItem("Sauvegarder");
		JMenuItem itemQuitter =new JMenuItem("Quitter");
		//itemCharger.setActionCommand("menu_charger");
		//itemCharger.addActionListener(this);
		//itemSave.setActionCommand("menu_sauvegarder");
		//itemSave.addActionListener(this);
		itemQuitter.setActionCommand("menu_quitter");
		itemQuitter.addActionListener(this);
		menuFichier.add(itemCharger);
		menuFichier.add(itemSave);
		menuFichier.add(new JSeparator());
        menuFichier.add(itemQuitter);
	}

    public void actionPerformed(ActionEvent evenement)
	{
		if (evenement.getActionCommand().equals("menu_quitter"))
		{
			if( JOptionPane.showConfirmDialog(null,"Voulez vous quitter ?",
			"Quitter",
			JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION )
			{
				System.exit(0);
			}
        }
    }
}
