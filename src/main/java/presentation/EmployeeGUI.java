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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import business.*;


@SuppressWarnings("deprecation")
public class EmployeeGUI extends JFrame implements Observer {
	
	private Image img = new ImageIcon(getClass().getClassLoader().getResource("bk2.jpg")).getImage().getScaledInstance(710, 425, Image.SCALE_DEFAULT); 
	private DeliveryService ds;
	private JTextArea ta = new JTextArea();
	
	@Override
	public void update(Observable o, Object arg) {
		Map.Entry<Order, List<MenuItem>> newOrder = (Map.Entry<Order, List<MenuItem>>) arg;
		String msg = "Comanda id: "+newOrder.getKey().getOrderID()+'\n'+"Client : "+ds.getAccountById(newOrder.getKey().getClientID()).getUsername() +'\n'+"Produse comandate:"+'\n';
		for(MenuItem mi: newOrder.getValue()) {
			msg+="  "+mi.getName()+'\n';
		}
		ta.setText(msg);
	}
	
	
	public EmployeeGUI(DeliveryService ds) {
		this.ds = ds;
        
		JPanel content = new JPanel() {
            public void paintComponent(Graphics g) {
                 g.drawImage(img, 0, 0, this);
            }
        };
       
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS)); 
        content.setOpaque(false);
        
       
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(400,50)));
        ta.setPreferredSize(new Dimension(300,130));
        panel.add(ta);
        panel.add(Box.createRigidArea(new Dimension(400,50)));
        content.add(panel);
 
 
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Employee");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
