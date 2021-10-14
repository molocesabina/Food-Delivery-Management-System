package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import business.*;
import data.Serializator;


public class LogInGUI extends JFrame{
	//private JPanel content;
	private Image img = new ImageIcon(getClass().getClassLoader().getResource("bk2.jpg")).getImage().getScaledInstance(710, 425, Image.SCALE_DEFAULT); 
	private DeliveryService ds;
	
	public LogInGUI(DeliveryService ds) {
		JPanel content = new JPanel() {
            public void paintComponent(Graphics g) {
                 g.drawImage(img, 0, 0, this);
            }
        };
       
        this.ds = ds;
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS)); 
        content.setOpaque(false);
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS)); 
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        p1.add(Box.createRigidArea(new Dimension(200,300)));
        
        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS)); 
        p2.add(Box.createRigidArea(new Dimension(25,25)));
        JTextField txtUsername = new JTextField("Username");
        txtUsername.setBorder(null);
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setPreferredSize(new Dimension(70,0));
        txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtUsername.getText().equals("Username"))
					txtUsername.setText("");
				else
					txtUsername.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
        p2.add(txtUsername);  
        
        p2.add(Box.createRigidArea(new Dimension(15,15)));
       
        JTextField txtPassword =new JPasswordField();
        txtPassword.setText("Password");
        txtPassword.setPreferredSize(new Dimension(70,0));
        txtPassword.setBorder(null);
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtPassword.setForeground(Color.BLACK);
        txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtPassword.getText().equals("Password"))
					txtPassword.setText("");
				else
					txtPassword.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtPassword.getText().equals(""))
					txtPassword.setText("Password");
			}
		});
        p2.add(txtPassword); 
        p2.add(Box.createRigidArea(new Dimension(25,25)));
        
        JPanel panelButoane = new JPanel();
        panelButoane.setOpaque(false);
        panelButoane.setLayout(new BoxLayout(panelButoane,BoxLayout.Y_AXIS)); 
        panelButoane.add(Box.createRigidArea(new Dimension(25,25)));
        JButton b3 = new JButton("Register");
        b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ds.addAccount(new Account(txtUsername.getText(),txtPassword.getText(),"client"));
				JOptionPane.showMessageDialog(null, "Inregistrare reusita!");
			}
    
        });
        b3.setFont(new Font("Tahoma", Font.BOLD, 17));
        b3.setForeground(Color.BLACK);
        panelButoane.add(b3); 
        panelButoane.add(Box.createRigidArea(new Dimension(15,15)));
        
        JButton b4 = new JButton("  Log In  ");
        b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account a = ds.getAccount(txtUsername.getText());
				if(a == null) {
					JOptionPane.showMessageDialog(null, "Username sau parola gresita!");
				} else {
					//LogInGUI.this.dispose();
					if(a.getRole().equals("admin")) {
						AdministratorGUI adgui = new AdministratorGUI(ds);
						adgui.setVisible(true);
					} else if(a.getRole().equals("employee")) {
						EmployeeGUI empgui = new EmployeeGUI(ds);
						ds.addObserver(empgui);
						empgui.setVisible(true);
					} else { 
						ClientGUI clgui = new ClientGUI(a,ds);
						clgui.setVisible(true);
					}
				}
			}
    
        });
        b4.setFont(new Font("Tahoma", Font.BOLD, 17));
        b4.setForeground(Color.BLACK);
        panelButoane.add(b4);
        
        ///////
        /*
        JButton b5 = new JButton("  Serialize ");
        b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serializator s = new Serializator();
			    s.serialize(ds);
			}
    
        });
        b5.setFont(new Font("Tahoma", Font.BOLD, 17));
        b5.setForeground(Color.BLACK);
        panelButoane.add(b5);*/
        
        ////////////////////////
        
        p2.add(panelButoane); 
        
        
        
        p2.add(Box.createRigidArea(new Dimension(25,25)));
        
        JPanel p3 = new JPanel();
        p3.setOpaque(false);
        p3.add(Box.createRigidArea(new Dimension(200,300)));
        
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        content.add(panel);
        //content.add(panelButon);
 
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Food Delivery");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

	}

}
