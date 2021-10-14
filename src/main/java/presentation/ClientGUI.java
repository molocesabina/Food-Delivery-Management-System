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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class ClientGUI extends JFrame {
	private DeliveryService ds;
	private Account a;
	private Image img = new ImageIcon(getClass().getClassLoader().getResource("bk2.jpg")).getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
	private ListSelectionListener l;
	
	public ClientGUI(Account a, DeliveryService ds) {
			this.ds = ds;
			this.a = a;

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
	        
	        
	        panel.add(Box.createRigidArea(new Dimension(10,10)));
	    
	        
	        JTable t = createTable(ds.getMenu());
	        		
	        
	       
	        JPanel tabelPane = new JPanel();
	        tabelPane.add(Box.createRigidArea(new Dimension(30,30)));
	        tabelPane.setOpaque(false);
	        JScrollPane scroll = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	        t.setPreferredScrollableViewportSize(new Dimension(520, 90));
	        t.setCellSelectionEnabled(false);
			t.setColumnSelectionAllowed(false);
			t.setRowSelectionAllowed(true);
			t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
			
	        tabelPane.add(scroll);
	        tabelPane.add(Box.createRigidArea(new Dimension(30,30)));
	        panel.add(tabelPane);
	        
	        panel.add(Box.createRigidArea(new Dimension(10,10)));
	        
	        JPanel p1 = new JPanel();
	        p1.setOpaque(false);
	        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS)); 
	        
	        JPanel p1_2 = new JPanel();
	        p1_2.setOpaque(false);
	        p1_2.setLayout(new BoxLayout(p1_2,BoxLayout.X_AXIS)); 
	        
	        JPanel p1_2_umplu = new JPanel();
	        p1_2_umplu.setOpaque(false);
	        p1_2_umplu.add(Box.createRigidArea(new Dimension(50,5)));
	        
	        p1_2.add(p1_2_umplu);
	        
	        JPanel p1_2_1 = new JPanel();
	        p1_2_1.setOpaque(false);
	        p1_2_1.setLayout(new BoxLayout(p1_2_1,BoxLayout.Y_AXIS)); 
	        
	        JCheckBox checkBox1 = new JCheckBox("Title"); 
	        checkBox1.setOpaque(false);
	        checkBox1.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox1.setForeground(Color.DARK_GRAY); 
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox1);
	        
	        JCheckBox checkBox2 = new JCheckBox("Rating");  
	        checkBox2.setOpaque(false);
	        checkBox2.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox2.setForeground(Color.DARK_GRAY);
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox2);
	        
	        JCheckBox checkBox3 = new JCheckBox("Calories");  
	        checkBox3.setOpaque(false);
	        checkBox3.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox3.setForeground(Color.DARK_GRAY);
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox3);
	        
	        JCheckBox checkBox4 = new JCheckBox("Proteins");  
	        checkBox4.setOpaque(false);
	        checkBox4.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox4.setForeground(Color.DARK_GRAY);
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox4);
	        
	        JCheckBox checkBox5 = new JCheckBox("Fats");  
	        checkBox5.setOpaque(false);
	        checkBox5.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox5.setForeground(Color.DARK_GRAY);
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox5);
	        
	        JCheckBox checkBox6 = new JCheckBox("Sodium");  
	        checkBox6.setOpaque(false);
	        checkBox6.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox6.setForeground(Color.DARK_GRAY);
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox6);
	        
	        JCheckBox checkBox7 = new JCheckBox("Price");  
	        checkBox7.setOpaque(false);
	        checkBox7.setFont(new Font("Tahoma", Font.BOLD, 14));
	        checkBox7.setForeground(Color.DARK_GRAY);
	        p1_2_1.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_1.add(checkBox7);
	        
	        p1_2.add(p1_2_1);
	        
	        JPanel p1_2_2 = new JPanel();
	        p1_2_2.setOpaque(false);
	        p1_2_2.setLayout(new BoxLayout(p1_2_2,BoxLayout.Y_AXIS)); 
	        
	        JTextField txtTitle = new JTextField("");
	        txtTitle.setBorder(null);
	        txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtTitle.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtTitle);
	        
	        JTextField txtRating = new JTextField("");
	        txtRating.setBorder(null);
	        txtRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtRating.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtRating);
	        
	        JTextField txtCalories = new JTextField("");
	        txtCalories.setBorder(null);
	        txtCalories.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtCalories.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtCalories);
	        
	        JTextField txtProteins = new JTextField("");
	        txtProteins.setBorder(null);
	        txtProteins.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtProteins.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtProteins);
	        
	        JTextField txtFats = new JTextField("");
	        txtFats.setBorder(null);
	        txtFats.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtFats.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtFats);
	        
	        JTextField txtSodium = new JTextField("");
	        txtSodium.setBorder(null);
	        txtSodium.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtSodium.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtSodium);
	        
	        JTextField txtPrice = new JTextField("");
	        txtPrice.setBorder(null);
	        txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        txtPrice.setForeground(Color.BLACK);
	        p1_2_2.add(Box.createRigidArea(new Dimension(5,5)));
	        p1_2_2.add(txtPrice);
	        
	       
	        p1_2.add(p1_2_2);
	        
	        JPanel p1_2_umplu2 = new JPanel();
	        p1_2_umplu2.setOpaque(false);
	        p1_2_umplu2.add(Box.createRigidArea(new Dimension(60,10)));
	        
	        p1_2.add(p1_2_umplu2);
	        
	        p1.add(p1_2);
	        
	        JPanel p1_3 = new JPanel();
	        p1_3.setOpaque(false);
	        
	        List<MenuItem> menu2 = new ArrayList<>();
	        JTable t2 = createTable(menu2);
	        
	  
	        JButton search = new JButton("Search");
	        search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String title = null;
					if(checkBox1.isSelected()) {
						if(!txtTitle.getText().equals("")) {
							title = txtTitle.getText();
						} else {
							JOptionPane.showMessageDialog(null, "Dati title!");
						}
					}
					
					float rating = -1;
					if(checkBox2.isSelected()) {
						if(!txtRating.getText().equals("")) {
							rating = Float.parseFloat(txtRating.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Completati casutele corespunzatoare!");
						}
					}
					
					int calories = -1;
					if(checkBox3.isSelected()) {
						if(!txtCalories.getText().equals("")) {
							calories = Integer.parseInt(txtCalories.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Completati casutele corespunzatoare!");
						}
					}
					
					int proteins = -1;
					if(checkBox4.isSelected()) {
						if(!txtProteins.getText().equals("")) {
							proteins = Integer.parseInt(txtProteins.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Completati casutele corespunzatoare!");
						}
					}
					
					int fats = -1;
					if(checkBox5.isSelected()) {
						if(!txtFats.getText().equals("")) {
							fats = Integer.parseInt(txtFats.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Completati casutele corespunzatoare!");
						}
					}
					
					int sodium = -1;
					if(checkBox6.isSelected()) {
						if(!txtSodium.getText().equals("")) {
							sodium = Integer.parseInt(txtSodium.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Completati casutele corespunzatoare!");
						}
					}
					
					int price = -1;
					if(checkBox7.isSelected()) {
						if(!txtPrice.getText().equals("")) {
							price = Integer.parseInt(txtPrice.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Completati casutele corespunzatoare!");
						}
					}
				
					List<MenuItem> searched = ds.searchProducts(title,rating,calories,proteins,fats,sodium,price);
					DefaultTableModel m = (DefaultTableModel)t2.getModel();
					m.setRowCount(0);
					
					for(MenuItem mi: searched) {
						m.addRow(new Object[] {mi.getName(),mi.computeRating(),mi.computeCalories(),mi.computeProteins(),mi.computeFats(),mi.computeSodium(),mi.computePrice()});
					}
				}
	        });
	        search.setFont(new Font("Tahoma", Font.BOLD, 17));
	        search.setForeground(Color.DARK_GRAY);
	        p1_3.add(search);
	        
	        p1.add(p1_3);
	        
	       
	        
	        JPanel p1_4 = new JPanel();
	        p1_4.setOpaque(false);
	        JScrollPane scroll2 = new JScrollPane(t2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	        t2.setPreferredScrollableViewportSize(new Dimension(520, 90));
	        t2.setCellSelectionEnabled(false);
			t2.setColumnSelectionAllowed(false);
			t2.setRowSelectionAllowed(true);
			t2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
			
	        p1_4.add(scroll2);
	        
	        p1.add(p1_4);
	        
	        panel.add(p1);
	        
	        panel.add(Box.createRigidArea(new Dimension(10,30)));
	        JPanel p3 = new JPanel();
	        p3.setOpaque(false);
	        p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS)); 
	        
	        JPanel p3UmplStanga = new JPanel();
	        p3UmplStanga.setOpaque(false);
	        p3UmplStanga.add(Box.createRigidArea(new Dimension(10,10)));
	        p3.add(p3UmplStanga);
	        
	        JPanel panelButoane3 = new JPanel();
	        panelButoane3.setOpaque(false);
	        panelButoane3.setLayout(new GridLayout(5,1)); 
	        
	        JPanel panelLista = new JPanel();
	        JScrollPane scrollPane = new JScrollPane();	
			scrollPane.setBorder(null);
			scrollPane.setPreferredSize(new Dimension(200,150));
			panelLista.setOpaque(false);
			panelLista.add(scrollPane);
			DefaultListModel<String> model = new DefaultListModel<>();
			JList<String> mylist = new JList(model);
	        
	        JButton b5 = new JButton("ADD PRODUCT TO ORDER"); 
	        b5.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					if(!t.getSelectionModel().isSelectionEmpty()) {
						int row = t.getSelectedRow();
						Object o = t.getValueAt(row,0);
						
						model.addElement((String) o);
						scrollPane.setViewportView(mylist);
					    mylist.setLayoutOrientation(JList.VERTICAL);
					    t.clearSelection();
						
					} else if(!t2.getSelectionModel().isSelectionEmpty()){
						int row = t2.getSelectedRow();
						Object o = t2.getValueAt(row,0);
						
						model.addElement((String) o);
						scrollPane.setViewportView(mylist);
					    mylist.setLayoutOrientation(JList.VERTICAL);
					    t2.clearSelection();
					} else {
						JOptionPane.showMessageDialog(null, "Selectati un produs din tabele!");
					}
					
				}
	        });
	        b5.setFont(new Font("Tahoma", Font.BOLD, 15));
	        b5.setForeground(Color.DARK_GRAY);
	        panelButoane3.add(b5);
	        
	        
	        JTextField txtNewProduct = new JTextField("yyyy-MM-dd HH:mm");
	        txtNewProduct.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if(txtNewProduct.getText().equals("yyyy-MM-dd HH:mm"))
						txtNewProduct.setText("");
					else
						txtNewProduct.selectAll();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if(txtNewProduct.getText().equals(""))
						txtNewProduct.setText("yyyy-MM-dd HH:mm");
				}
			});
	        txtNewProduct.setBorder(null);
	        txtNewProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        txtNewProduct.setForeground(Color.GRAY);
	        panelButoane3.add(Box.createRigidArea(new Dimension(5,5)));
	        panelButoane3.add(txtNewProduct);
	        
	        panelButoane3.add(Box.createRigidArea(new Dimension(5,5)));
	        
	        JButton b6 = new JButton("PLACE ORDER"); 
	        b6.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					if(!txtNewProduct.getText().equals("") && !txtNewProduct.getText().equals("yyyy-MM-dd HH:mm")) {
						if(!model.isEmpty()) {
							List<MenuItem> prod = new ArrayList<>();
							int total = 0;
							for(int i=0;i<model.size();i++) {
								MenuItem mi = ds.getProduct(model.get(i));
				                prod.add(mi);
				                total+=mi.computePrice();
							}
							Order o = new Order(a.getId(),txtNewProduct.getText(),total);
							ds.placeOrder(o,prod);
							model.clear();
							txtNewProduct.setText("yyyy-MM-dd HH:mm");
							JOptionPane.showMessageDialog(null, "Comanda data!");
						} else {
							JOptionPane.showMessageDialog(null, "Adaugati produse la comamda!");
						}	
					} else {
						JOptionPane.showMessageDialog(null, "Dati data si ora comenzii!");
					}
					
				}
	        });
	        b6.setFont(new Font("Tahoma", Font.BOLD, 15));
	        b6.setForeground(Color.DARK_GRAY);
	        panelButoane3.add(b6);
	        
	        p3.add(panelButoane3);
	       
	       
			
	        p3.add(panelLista);
	        
	        panel.add(p3);
	        
	        JPanel p2 = new JPanel();
	        p2.setOpaque(false);
	        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS)); 
	        JButton back = new JButton("Back");
	        back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientGUI.this.dispose();
					//LogInGUI g = new LogInGUI(ds);
					//g.setVisible(true);
				}
	        });
	        back.setFont(new Font("Tahoma", Font.BOLD, 17));
	        back.setForeground(Color.DARK_GRAY);
	        p2.add(Box.createRigidArea(new Dimension(25,25)));
	        p2.add(back);
	        p2.add(Box.createRigidArea(new Dimension(25,25)));
	        panel.add(p2);
	       
	        content.add(panel);
	 
	 
	        this.setContentPane(content);
	        this.pack();
	        
	        this.setTitle("Client");
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		
		public static JTable createTable(List<MenuItem> menu) {
			String[] headOfTable = new String[7];
			headOfTable[0] = "Title";
			headOfTable[1] = "Rating";
			headOfTable[2] = "Calories";
			headOfTable[3] = "Proteins";
			headOfTable[4] = "Fats";
			headOfTable[5] = "Sodium";
			headOfTable[6] = "Price";
			Object[][] dataFromTable = dataFromTable = getDataTable(menu);
			DefaultTableModel m = new DefaultTableModel() {
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
			};
			m.setDataVector(dataFromTable, headOfTable);
			JTable t = new JTable(m);
			return t;
		}
		

		private static Object[][] getDataTable(List<MenuItem> menu) {
			if(menu.size()==0) {
				return null;
			}
		
			Object[][] dataFromTable = new Object[menu.size()][7];
			int i=0;
			for(MenuItem mi: menu) {
				dataFromTable[i][0] = mi.getName();	
				dataFromTable[i][1] = mi.computeRating();
				dataFromTable[i][2] = mi.computeCalories();	
				dataFromTable[i][3] = mi.computeProteins();	
				dataFromTable[i][4] = mi.computeFats();	
				dataFromTable[i][5] = mi.computeSodium();	
				dataFromTable[i][6] = mi.computePrice();	
				i++;
			}
			return dataFromTable;
		}

	}