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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import business.*;


public class AdministratorGUI extends JFrame {
	private DeliveryService ds;
	private Image img = new ImageIcon(getClass().getClassLoader().getResource("bk2.jpg")).getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
	private ListSelectionListener l;
	
	public AdministratorGUI(DeliveryService ds) {
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
        
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS)); 
        
        JPanel txtFieldsPanel = new JPanel();
        txtFieldsPanel.setLayout(new BoxLayout(txtFieldsPanel,BoxLayout.X_AXIS)); 
        txtFieldsPanel.setOpaque(false);
        
        JPanel lblPanel = new JPanel();
        lblPanel.setLayout(new BoxLayout(lblPanel,BoxLayout.Y_AXIS)); 
        lblPanel.setOpaque(false);
        
       
        JPanel actualFieldPanel = new JPanel();
        actualFieldPanel.setLayout(new BoxLayout(actualFieldPanel,BoxLayout.Y_AXIS)); 
        actualFieldPanel.setOpaque(false);
        
        JPanel umplutPanel = new JPanel();
        umplutPanel.add(Box.createRigidArea(new Dimension(50,50)));
        umplutPanel.setOpaque(false);
        
        JLabel lblTitle = new JLabel("            Title ");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(10,10)));
        lblPanel.add(lblTitle);
        
        JTextField txtTitle = new JTextField();
        txtTitle.setBorder(null);
        txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtTitle.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(15,15)));
        actualFieldPanel.add(txtTitle);
        
        JLabel lblRating = new JLabel("            Rating ");
        lblRating.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblRating.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        lblPanel.add(lblRating);
        
        JTextField txtRating = new JTextField();
        txtRating.setBorder(null);
        txtRating.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtRating.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(txtRating);
        
        JLabel lblCalories = new JLabel("            Calories ");
        lblCalories.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblCalories.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        lblPanel.add(lblCalories);
        
        
        JTextField txtCalories = new JTextField();
        txtCalories.setBorder(null);
        txtCalories.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtCalories.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(txtCalories);
        
        JLabel lblProteins = new JLabel("            Proteins");
        lblProteins.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblProteins.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        lblPanel.add(lblProteins);
        
        JTextField txtProteins = new JTextField();
        txtProteins.setBorder(null);
        txtProteins.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtProteins.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(txtProteins);
        
        JLabel lblFats = new JLabel("            Fats");
        lblFats.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblFats.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        lblPanel.add(lblFats);
        
        JTextField txtFats = new JTextField();
        txtFats.setBorder(null);
        txtFats.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtFats.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(txtFats);
        
        JLabel lblSodium = new JLabel("            Sodium");
        lblSodium.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblSodium.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        lblPanel.add(lblSodium);
        
        JTextField txtSodium = new JTextField();
        txtSodium.setBorder(null);
        txtSodium.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtSodium.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(txtSodium);
        
        JLabel lblPrice = new JLabel("            Price");
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblPrice.setForeground(Color.DARK_GRAY);
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        lblPanel.add(lblPrice);
        
        JTextField txtPrice = new JTextField();
        txtPrice.setBorder(null);
        txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtPrice.setForeground(Color.GRAY);
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(txtPrice);
        
        
        lblPanel.add(Box.createRigidArea(new Dimension(5,5)));
        actualFieldPanel.add(Box.createRigidArea(new Dimension(5,5)));
    
        
        txtFieldsPanel.add(lblPanel);
        txtFieldsPanel.add(actualFieldPanel);
        txtFieldsPanel.add(umplutPanel);
        p1.add(txtFieldsPanel);
        
        JPanel butoanePanel = new JPanel();
        butoanePanel.setOpaque(false);
        
        JTable t = createTable(ds.getMenu());
        		
        butoanePanel.add(Box.createRigidArea(new Dimension(50,50)));
        JButton b1 = new JButton("IMPORT"); 
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ds.importBaseProducts();
				List<MenuItem> menu = ds.getMenu();
				
				DefaultTableModel m = (DefaultTableModel)t.getModel();
				for(MenuItem mi: menu) {
					m.addRow(new Object[] {mi.getName(),mi.computeRating(),mi.computeCalories(), mi.computeProteins(),mi.computeFats(),mi.computeSodium(),mi.computePrice()});
				}
			}
        });
        b1.setFont(new Font("Tahoma", Font.BOLD, 17));
        b1.setForeground(Color.DARK_GRAY);
        butoanePanel.add(b1);
        
        butoanePanel.add(Box.createRigidArea(new Dimension(30,50)));
        JButton b2 = new JButton("ADD");
        b2.setFont(new Font("Tahoma", Font.BOLD, 17)); 
        b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTitle.getText().equals("") && !txtRating.getText().equals("") && !txtCalories.getText().equals("") && !txtProteins.getText().equals("") && !txtFats.getText().equals("") && !txtSodium.getText().equals("") && !txtPrice.getText().equals("")) {
					BaseProduct bp = new BaseProduct(txtTitle.getText(),Float.parseFloat(txtRating.getText()),Integer.parseInt(txtCalories.getText()),Integer.parseInt(txtProteins.getText()),Integer.parseInt(txtFats.getText()),Integer.parseInt(txtSodium.getText()),Integer.parseInt(txtPrice.getText()));
					ds.addProduct(bp);
					DefaultTableModel m = (DefaultTableModel)t.getModel();
					m.addRow(new Object[] {txtTitle.getText(),Float.parseFloat(txtRating.getText()),Integer.parseInt(txtCalories.getText()),Integer.parseInt(txtProteins.getText()),Integer.parseInt(txtFats.getText()),Integer.parseInt(txtSodium.getText()),Integer.parseInt(txtPrice.getText())});
				} else {
					JOptionPane.showMessageDialog(null, "Completati corect campurile!");
				}

			}
        });
        b2.setForeground(Color.DARK_GRAY);
        butoanePanel.add(b2);
        
        
        
        butoanePanel.add(Box.createRigidArea(new Dimension(30,50)));
        JButton b3 = new JButton("MODIFY");
        b3.setFont(new Font("Tahoma", Font.BOLD, 17)); 
        b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!t.getSelectionModel().isSelectionEmpty()) {
					if(!txtTitle.getText().equals("") && !txtRating.getText().equals("") && !txtCalories.getText().equals("") && !txtProteins.getText().equals("") && !txtFats.getText().equals("") && !txtSodium.getText().equals("") && !txtPrice.getText().equals("")) {
						int row = t.getSelectedRow();
						Object o = t.getValueAt(row,0);
						MenuItem mi = ds.getProduct((String) o);
						BaseProduct newBP = new BaseProduct(txtTitle.getText(),Float.parseFloat(txtRating.getText()),Integer.parseInt(txtCalories.getText()),Integer.parseInt(txtProteins.getText()),Integer.parseInt(txtFats.getText()),Integer.parseInt(txtSodium.getText()),Integer.parseInt(txtPrice.getText()));
						ds.modifyProduct((String) o, newBP);
						
						DefaultTableModel m = (DefaultTableModel)t.getModel();
						m.setValueAt(newBP.getName(), row, 0);
						m.setValueAt(newBP.computeRating(), row, 1);
						m.setValueAt(newBP.computeCalories(), row, 2);
						m.setValueAt(newBP.computeProteins(), row, 3);
						m.setValueAt(newBP.computeFats(), row, 4);
						m.setValueAt(newBP.computeSodium(), row, 5);
						m.setValueAt(newBP.computePrice(), row, 6);
					}
				}
			}
        });
        b3.setForeground(Color.DARK_GRAY);
        butoanePanel.add(b3);
        
        butoanePanel.add(Box.createRigidArea(new Dimension(30,50)));
        JButton b4 = new JButton("DELETE"); 
        b4.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(!t.getSelectionModel().isSelectionEmpty()) {
					int row = t.getSelectedRow();
					Object o = t.getValueAt(row,0);
					MenuItem mi = ds.getProduct((String) o);
				    ds.deleteProduct(mi);
					DefaultTableModel m = (DefaultTableModel)t.getModel();
					t.getSelectionModel().removeListSelectionListener(l);
					m.removeRow(row);
					t.getSelectionModel().addListSelectionListener(l);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selectati clientul pe care vreti sa-l stergeti!");
				}
			}
        });
        b4.setFont(new Font("Tahoma", Font.BOLD, 17));
        b4.setForeground(Color.DARK_GRAY);
        butoanePanel.add(b4);
        
        butoanePanel.add(Box.createRigidArea(new Dimension(30,50)));
        JButton b7 = new JButton("REPORTS"); 
        b7.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				AdministratorGUI.this.dispose();
				ReportsGUI repgui = new ReportsGUI(ds);
				repgui.setVisible(true);
				
			}
        });
        b7.setFont(new Font("Tahoma", Font.BOLD, 17));
        b7.setForeground(Color.DARK_GRAY);
        butoanePanel.add(b7);
        butoanePanel.add(Box.createRigidArea(new Dimension(50,50)));
        p1.add(butoanePanel);
        
       
        JPanel tabelPane = new JPanel();
        tabelPane.add(Box.createRigidArea(new Dimension(50,50)));
        tabelPane.setOpaque(false);
        JScrollPane scroll = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        t.setPreferredScrollableViewportSize(new Dimension(520, 90));
        t.setCellSelectionEnabled(false);
		t.setColumnSelectionAllowed(false);
		t.setRowSelectionAllowed(true);
		t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		l = new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int row = t.getSelectedRow(); 
                txtTitle.setText(t.getModel().getValueAt(row, 0).toString());
                txtRating.setText(t.getModel().getValueAt(row, 1).toString());
                txtCalories.setText(t.getModel().getValueAt(row, 2).toString());
                txtProteins.setText(t.getModel().getValueAt(row, 3).toString());
                txtFats.setText(t.getModel().getValueAt(row, 4).toString());
                txtSodium.setText(t.getModel().getValueAt(row, 5).toString());
                txtPrice.setText(t.getModel().getValueAt(row, 6).toString());			    
            }
        }; 
        t.getSelectionModel().addListSelectionListener(l);
        //t.setFillsViewportHeight(true);
        tabelPane.add(scroll);
        tabelPane.add(Box.createRigidArea(new Dimension(50,50)));
        p1.add(tabelPane);
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
        
        JButton b5 = new JButton("ADD BASE PRODUCT"); 
        b5.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(!t.getSelectionModel().isSelectionEmpty()) {
					int row = t.getSelectedRow();
					Object o = t.getValueAt(row,0);
					
					model.addElement((String) o);
					scrollPane.setViewportView(mylist);
				    mylist.setLayoutOrientation(JList.VERTICAL);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selectati un produs din tabel!");
				}
				
			}
        });
        b5.setFont(new Font("Tahoma", Font.BOLD, 17));
        b5.setForeground(Color.DARK_GRAY);
        panelButoane3.add(b5);
        
        
        JTextField txtNewProduct = new JTextField("New product name");
        txtNewProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtNewProduct.getText().equals("New product name"))
					txtNewProduct.setText("");
				else
					txtNewProduct.selectAll();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtNewProduct.getText().equals(""))
					txtNewProduct.setText("New product name");
			}
		});
        txtNewProduct.setBorder(null);
        txtNewProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtNewProduct.setForeground(Color.GRAY);
        panelButoane3.add(Box.createRigidArea(new Dimension(5,5)));
        panelButoane3.add(txtNewProduct);
        
        panelButoane3.add(Box.createRigidArea(new Dimension(5,5)));
        
        JButton b6 = new JButton("CREATE NEW PRODUCT"); 
        b6.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(!txtNewProduct.getText().equals("") && !txtNewProduct.getText().equals("New product name")) {
					if(!model.isEmpty()) {
						List<MenuItem> prod = new ArrayList<>();
						for(int i=0;i<model.size();i++) {
							MenuItem mi = ds.getProduct(model.get(i));
			                prod.add(mi);
						}
						CompositeProduct cp = new CompositeProduct(txtNewProduct.getText(),prod);
						ds.addProduct(cp);
						DefaultTableModel m = (DefaultTableModel)t.getModel();
						m.addRow(new Object[] {txtNewProduct.getText(),cp.computeRating(),cp.computeCalories(),cp.computeProteins(),cp.computeFats(),cp.computeSodium(),cp.computePrice()});
						model.clear();
						txtNewProduct.setText("New product name");
						JOptionPane.showMessageDialog(null, "Produs creat cu succes!");
					} else {
						JOptionPane.showMessageDialog(null, "Adaugati produse pentru noul produs!");
					}	
				} else {
					JOptionPane.showMessageDialog(null, "Denumiti produsul nou!");
				}
				
			}
        });
        b6.setFont(new Font("Tahoma", Font.BOLD, 17));
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
				AdministratorGUI.this.dispose();
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
        
        this.setTitle("Administrator");
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
