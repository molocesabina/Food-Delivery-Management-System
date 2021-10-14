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
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import business.*;

public class ReportsGUI extends JFrame{
	
	private DeliveryService ds;
	private Image img = new ImageIcon(getClass().getClassLoader().getResource("bk2.jpg")).getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
	
	public ReportsGUI(DeliveryService ds) {
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
        
        panel.add(Box.createRigidArea(new Dimension(15,15)));
        
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS)); 
        
        p1.add(Box.createRigidArea(new Dimension(30,30)));
        
        JPanel txtFieldsPanel1 = new JPanel();
        txtFieldsPanel1.setLayout(new BoxLayout(txtFieldsPanel1,BoxLayout.Y_AXIS)); 
        txtFieldsPanel1.setOpaque(false);
        

        
        JTextField txtStart = new JTextField("Start Hour (HH:mm)");
        txtStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtStart.getText().equals("Start Hour (HH:mm)"))
					txtStart.setText("");
				else
					txtStart.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtStart.getText().equals(""))
					txtStart.setText("Start Hour (HH:mm)");
			}
		});
        txtStart.setBorder(null);
        txtStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtStart.setForeground(Color.GRAY);
        txtFieldsPanel1.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel1.add(txtStart);
             
        JTextField txtEnd = new JTextField("End Hour (HH:mm)");
        txtEnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtEnd.getText().equals("End Hour (HH:mm)"))
					txtEnd.setText("");
				else
					txtEnd.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtEnd.getText().equals(""))
					txtEnd.setText("End Hour (HH:mm)");
			}
		});
        txtEnd.setBorder(null);
        txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtEnd.setForeground(Color.GRAY);
        txtFieldsPanel1.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel1.add(txtEnd);
        
        DefaultListModel<String> model1 = new DefaultListModel<>();
        
        JButton gen1 = new JButton("GENERATE");
        gen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.clear();
				List<Order> rez = ds.report1(txtStart.getText(), txtEnd.getText());
				for(Order o : rez) {
					model1.addElement("OrderID: "+o.getOrderID()+" time: "+o.getTime());
				}
				
			}
        });
        gen1.setFont(new Font("Tahoma", Font.BOLD, 14));
        gen1.setForeground(Color.DARK_GRAY);
        txtFieldsPanel1.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel1.add(gen1);
        txtFieldsPanel1.add(Box.createRigidArea(new Dimension(10,10)));
        
     
        p1.add(txtFieldsPanel1);
        p1.add(Box.createRigidArea(new Dimension(20,20)));
        
        JPanel panelLista1 = new JPanel();
        panelLista1.setOpaque(false);
        JScrollPane scrollPane1 = new JScrollPane();	
		scrollPane1.setBorder(null);
		scrollPane1.setPreferredSize(new Dimension(200,150));
		panelLista1.setOpaque(false);
		panelLista1.add(scrollPane1);
		
		JList<String> mylist1 = new JList(model1);
		scrollPane1.setViewportView(mylist1);
	    mylist1.setLayoutOrientation(JList.VERTICAL);
		
		p1.add(panelLista1);
        p1.add(Box.createRigidArea(new Dimension(30,30)));
        
        panel.add(p1);
        panel.add(Box.createRigidArea(new Dimension(30,30)));
       
        
        
        ////////////////////////////////////////////////////
        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS)); 
        
        p2.add(Box.createRigidArea(new Dimension(30,30)));
        
        JPanel txtFieldsPanel2 = new JPanel();
        txtFieldsPanel2.setLayout(new BoxLayout(txtFieldsPanel2,BoxLayout.Y_AXIS)); 
        txtFieldsPanel2.setOpaque(false);
        

        
        JTextField txtTimesProdOrd = new JTextField("Products ordered more than ?");
        txtTimesProdOrd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtTimesProdOrd.getText().equals("Products ordered more than ?"))
					txtTimesProdOrd.setText("");
				else
					txtTimesProdOrd.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtTimesProdOrd.getText().equals(""))
					txtTimesProdOrd.setText("Products ordered more than ?");
			}
		});
        txtTimesProdOrd.setBorder(null);
        txtTimesProdOrd.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimesProdOrd.setForeground(Color.GRAY);
        
        txtFieldsPanel2.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel2.add(txtTimesProdOrd);
             
        DefaultListModel<String> model2 = new DefaultListModel<>();
		JList<String> mylist2 = new JList(model2);
		
	    mylist2.setLayoutOrientation(JList.VERTICAL);
	    
        JButton gen2 = new JButton("GENERATE");
        gen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model2.clear();
				List<MenuItem> rez = ds.report2(Integer.parseInt(txtTimesProdOrd.getText()));
				for(MenuItem o : rez) {
					model2.addElement(o.getName());
				}
				
			}
        });
        gen2.setFont(new Font("Tahoma", Font.BOLD, 14));
        gen2.setForeground(Color.DARK_GRAY);
        txtFieldsPanel2.add(Box.createRigidArea(new Dimension(20,20)));
        txtFieldsPanel2.add(gen2);
        txtFieldsPanel2.add(Box.createRigidArea(new Dimension(10,10)));
        
     
        p2.add(txtFieldsPanel2);
        p2.add(Box.createRigidArea(new Dimension(20,20)));
        
        JPanel panelLista2 = new JPanel();
        panelLista2.setOpaque(false);
        
        JScrollPane scrollPane2 = new JScrollPane();	
		scrollPane2.setBorder(null);
		scrollPane2.setPreferredSize(new Dimension(200,150));
		scrollPane2.setViewportView(mylist2);
		panelLista2.setOpaque(false);
		panelLista2.add(scrollPane2);
		
		
		p2.add(panelLista2);
        p2.add(Box.createRigidArea(new Dimension(30,30)));
        
        panel.add(p2);
        panel.add(Box.createRigidArea(new Dimension(30,30)));
       
        ////////
        
        JPanel p3 = new JPanel();
        p3.setOpaque(false);
        p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS)); 
        
        p3.add(Box.createRigidArea(new Dimension(30,30)));
        
        JPanel txtFieldsPanel3 = new JPanel();
        txtFieldsPanel3.setLayout(new BoxLayout(txtFieldsPanel3,BoxLayout.Y_AXIS)); 
        txtFieldsPanel3.setOpaque(false);
        

        
        JTextField txtNbOrders = new JTextField("Clients ordered more than ? times");
        txtNbOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtNbOrders.getText().equals("Clients ordered more than ? times"))
					txtNbOrders.setText("");
				else
					txtNbOrders.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtNbOrders.getText().equals(""))
					txtNbOrders.setText("Clients ordered more than ? times");
			}
		});
        txtNbOrders.setBorder(null);
        txtNbOrders.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtNbOrders.setForeground(Color.GRAY);
        txtFieldsPanel3.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel3.add(txtNbOrders);
             
        JTextField txtValue = new JTextField("Value of the order more than ?");
        txtValue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtValue.getText().equals("Value of the order more than ?"))
					txtValue.setText("");
				else
					txtValue.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtValue.getText().equals(""))
					txtValue.setText("Value of the order more than ?");
			}
		});
        txtValue.setBorder(null);
        txtValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtValue.setForeground(Color.GRAY);
        txtFieldsPanel3.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel3.add(txtValue);
        
    	DefaultListModel<String> model3 = new DefaultListModel<>();
		JList<String> mylist3 = new JList(model3);
        JButton gen3 = new JButton("GENERATE");
        gen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model3.clear();
				List<Account> rez = ds.report3(Integer.parseInt(txtNbOrders.getText()), Integer.parseInt(txtValue.getText()));
				for(Account o : rez) {
					model3.addElement("id: "+o.getId()+" username: "+o.getUsername());
				}
			}
        });
        gen3.setFont(new Font("Tahoma", Font.BOLD, 14));
        gen3.setForeground(Color.DARK_GRAY);
        txtFieldsPanel3.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel3.add(gen3);
        txtFieldsPanel3.add(Box.createRigidArea(new Dimension(10,10)));
        
     
        p3.add(txtFieldsPanel3);
        p3.add(Box.createRigidArea(new Dimension(20,20)));
        
        JPanel panelLista3 = new JPanel();
        panelLista3.setOpaque(false);
        JScrollPane scrollPane3 = new JScrollPane();	
		scrollPane3.setBorder(null);
		scrollPane3.setPreferredSize(new Dimension(200,150));
		panelLista3.setOpaque(false);
		panelLista3.add(scrollPane3);
	
		scrollPane3.setViewportView(mylist3);
	    mylist3.setLayoutOrientation(JList.VERTICAL);
		
		p3.add(panelLista3);
        p3.add(Box.createRigidArea(new Dimension(30,30)));
        
        panel.add(p3);
        panel.add(Box.createRigidArea(new Dimension(30,30)));
        
        
        //////
        JPanel p4 = new JPanel();
        p4.setOpaque(false);
        p4.setLayout(new BoxLayout(p4,BoxLayout.X_AXIS)); 
        
        p4.add(Box.createRigidArea(new Dimension(30,30)));
        
        JPanel txtFieldsPanel4 = new JPanel();
        txtFieldsPanel4.setLayout(new BoxLayout(txtFieldsPanel4,BoxLayout.Y_AXIS)); 
        txtFieldsPanel4.setOpaque(false);
        

        
        JTextField txtDay = new JTextField("Products ordered in this day (yyyy-MM-dd)");
        txtDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtDay.getText().equals("Products ordered in this day (yyyy-MM-dd)"))
					txtDay.setText("");
				else
					txtDay.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtDay.getText().equals(""))
					txtDay.setText("Products ordered in this day (yyyy-MM-dd)");
			}
		});
        txtDay.setBorder(null);
        txtDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtDay.setForeground(Color.GRAY);
        
        txtFieldsPanel4.add(Box.createRigidArea(new Dimension(10,10)));
        txtFieldsPanel4.add(txtDay);
             
        DefaultListModel<String> model4 = new DefaultListModel<>();
		JList<String> mylist4 = new JList(model4);
        JButton gen4 = new JButton("GENERATE");
        gen4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model4.clear();
				Map<MenuItem, Integer> rez = ds.report4(txtDay.getText());
				List<MenuItem> menu = new ArrayList<>(rez.keySet());
				for(MenuItem m : menu) {
					model4.addElement(m.getName()+" ordered "+rez.get(m));
				}
			}
        });
        gen4.setFont(new Font("Tahoma", Font.BOLD, 14));
        gen4.setForeground(Color.DARK_GRAY);
        txtFieldsPanel4.add(Box.createRigidArea(new Dimension(20,20)));
        txtFieldsPanel4.add(gen4);
        txtFieldsPanel4.add(Box.createRigidArea(new Dimension(10,10)));
        
     
        p4.add(txtFieldsPanel4);
        p4.add(Box.createRigidArea(new Dimension(20,20)));
        
        JPanel panelLista4 = new JPanel();
        panelLista4.setOpaque(false);
        JScrollPane scrollPane4 = new JScrollPane();	
		scrollPane4.setBorder(null);
		scrollPane4.setPreferredSize(new Dimension(200,150));
		panelLista4.setOpaque(false);
		panelLista4.add(scrollPane4);
		
		scrollPane4.setViewportView(mylist4);
	    mylist2.setLayoutOrientation(JList.VERTICAL);
		
		p4.add(panelLista4);
        p4.add(Box.createRigidArea(new Dimension(30,30)));
        
        panel.add(p4);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        
        JPanel pb = new JPanel();
        pb.setOpaque(false);
        pb.setLayout(new BoxLayout(pb,BoxLayout.Y_AXIS)); 
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportsGUI.this.dispose();
				AdministratorGUI g = new AdministratorGUI(ds);
				g.setVisible(true);
			}
        });
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setForeground(Color.DARK_GRAY);
        pb.add(Box.createRigidArea(new Dimension(5,5)));
        pb.add(back);
        pb.add(Box.createRigidArea(new Dimension(5,5)));
        panel.add(pb);
        
        content.add(panel);
 
 
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Administrator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
