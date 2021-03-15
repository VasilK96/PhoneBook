import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class GUI extends JFrame{
	 

	public GUI(String title) {
		super(title);
	}
	
	static ImageIcon img = new ImageIcon("../res/Contacts_Phone_Book-512.png");
	

	// TextFields for the form:
	static JTextField TFfirstName = new JTextField();
	static JTextField TFsurName = new JTextField();
	static JTextField TFmobileNumber = new JTextField();
	static JTextField TFhomeNumber = new JTextField();
	static JTextField TFworkNumber = new JTextField();
	static JTextField TFcompany = new JTextField();
	static JTextField TFposition = new JTextField();
	static JTextField TFaddress = new JTextField();
	
	// TextFields for the change section:
	static JTextField TFchange1 = new JTextField();
	static JTextField TFchange2 = new JTextField();
	
	// Buttons
	static JButton addRecordBtn = new JButton("Add new record");
	static JButton viewAllBtn = new JButton("Reset");
	static JButton viewBtn = new JButton("Search");
	static JButton removeBtn = new JButton("Remove record");
	static JButton changeBtn = new JButton("Change record");
	
	// Labels:
	static JLabel formSectionLabel = new JLabel("Form section:", SwingConstants.CENTER);
	static JLabel viewSectionLabel = new JLabel("View section:", SwingConstants.CENTER);
	static JLabel searchByCriteriaLabel = new JLabel("Search by criteria:", SwingConstants.CENTER);
	static JLabel nameCriteriaLabel = new JLabel("Name", SwingConstants.CENTER);
	static JLabel companyCriteriaLabel = new JLabel("Company", SwingConstants.CENTER);
	static JLabel jobCriteriaLabel = new JLabel("Job title", SwingConstants.CENTER);
	static JLabel resultLabel = new JLabel("Result:", SwingConstants.CENTER);
	
	static JLabel changeSectionLabel = new JLabel("Change section:", SwingConstants.CENTER);
	
	static JLabel changeLabel = new JLabel("change:", SwingConstants.CENTER);
	static JLabel changeToLabel = new JLabel("to:", SwingConstants.CENTER);
	
	static JLabel removeSectionLabel = new JLabel("Remove section:", SwingConstants.CENTER);
	
	// Form labels:
	static JLabel firstNameLabel = new JLabel("First name:",  SwingConstants.CENTER);
	static JLabel surNameLabel = new JLabel("Sur name:",  SwingConstants.CENTER);
	static JLabel mobileNumberLabel = new JLabel("Mobile number:",  SwingConstants.CENTER);
	static JLabel homeNumberLabel = new JLabel("Home number:",  SwingConstants.CENTER);
	static JLabel workNumberLabel = new JLabel("Work number:",  SwingConstants.CENTER);
	static JLabel companyLabel = new JLabel("Company:", SwingConstants.CENTER);
	static JLabel positionLabel = new JLabel("Position:", SwingConstants.CENTER);
	static JLabel addressLabel = new JLabel("Address:", SwingConstants.CENTER);
	
	
	// Scroll Pane + Table:
	static JTable table = new JTable();
	static JScrollPane resultPane = new JScrollPane(table);
	
	// Combo boxes:
	static JComboBox nameCombo = new JComboBox();
	static JComboBox companyCombo = new JComboBox();
	static JComboBox jobCombo = new JComboBox();
	static JComboBox changeCombo = new JComboBox();
	static JComboBox removeCombo = new JComboBox();
	
	// Panels:
	static JPanel formPanel = new JPanel();
	static JPanel formSubPanelTop = new JPanel();
	static JPanel formSubPanelCenter = new JPanel();
	static JPanel formSubPanelBottom = new JPanel();
	
	static JPanel viewPanel = new JPanel();
	static JPanel viewSubPanelTop = new JPanel();
	static JPanel viewSubPanelCenter = new JPanel();
	static JPanel viewSubPanelBottom = new JPanel();
	static JPanel viewSubPanelBottomPusher = new JPanel();
	
	static JPanel resultPanel = new JPanel();
	
	static JPanel changePanel = new JPanel();
	static JPanel changeSubBottomPanel = new JPanel();
	static JPanel changeSubTopPanel = new JPanel();
	
	static class MainClass{
		
		public static void main(String[] args) throws Exception {
			
				
			
			    // Set the title:
		    	GUI UI = new GUI("Phone book");
		    	
		    	UI.setIconImage(img.getImage());
		    	UI.setSize(1850, 700);
		        UI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    	
		        // new JLabels("") == Support labels ( Used for resizing or manipulating elements ).
		    	
		        // Global Layout:
		        UI.setLayout(new GridLayout(1, 3));
		        UI.add(formPanel);
		        UI.add(viewPanel);
		        UI.add(changePanel);
			    
		        
		        
		        // ========== Form Section ============
		        
		        
		        
		        // Form Section panel:
		        formPanel.setLayout(new BorderLayout());
		        formPanel.add(formSubPanelTop, BorderLayout.NORTH);
		        formPanel.add(formSubPanelCenter, BorderLayout.CENTER);
		        formPanel.add(formSubPanelBottom, BorderLayout.SOUTH);
		        
		        // Top form Sub panel:
		        formSubPanelTop.setLayout(new GridLayout(2, 1, 0, 40));
		        formSubPanelTop.setBackground(Color.black);
		        formSubPanelTop.add(new JLabel(""));
		        formSubPanelTop.add(formSectionLabel);
		        
		        // Center form Sub panel:
		        formSubPanelCenter.setLayout(new GridLayout(8, 2));
		        
		        
		        formSubPanelCenter.add(firstNameLabel); 
		        formSubPanelCenter.add(surNameLabel);
		        formSubPanelCenter.add(TFfirstName);
		        formSubPanelCenter.add(TFsurName);
		        
		        formSubPanelCenter.add(mobileNumberLabel);
		        formSubPanelCenter.add(homeNumberLabel);
		        formSubPanelCenter.add(TFmobileNumber);
		        formSubPanelCenter.add(TFhomeNumber);
		        
		        formSubPanelCenter.add(workNumberLabel);
		        formSubPanelCenter.add(companyLabel);
		        formSubPanelCenter.add(TFworkNumber);
		        formSubPanelCenter.add(TFcompany);
		        
		        formSubPanelCenter.add(positionLabel);
		        formSubPanelCenter.add(addressLabel);
		        formSubPanelCenter.add(TFposition);
		        formSubPanelCenter.add(TFaddress);
		        
		        // Bottom form Sub panel:
		        formSubPanelBottom.setLayout(new GridLayout(2, 3, 0, 40));
		        formSubPanelBottom.add(new JLabel(""));
		        formSubPanelBottom.add(addRecordBtn);
		        formSubPanelBottom.add(new JLabel(""));
		        formSubPanelBottom.add(new JLabel(""));
		        formSubPanelBottom.add(new JLabel(""));
		        formSubPanelBottom.add(new JLabel(""));
		        
		        
		        
		        // ========== View Section ===========
		        
		        
		        
		        viewPanel.setLayout(new BorderLayout());
		       
		        
		        // View sub panel - Top:
		        viewPanel.add(viewSubPanelTop, BorderLayout.NORTH);
		        viewSubPanelTop.setLayout(new GridLayout(3, 1, 0, 40));
		        
		        viewSubPanelTop.add(new JLabel(""));
		        viewSubPanelTop.add(viewSectionLabel);
		        viewSubPanelTop.add(searchByCriteriaLabel);
		        
		        
		        // View sub panel - Center:
		        viewPanel.add(viewSubPanelCenter, BorderLayout.CENTER);
		        viewSubPanelCenter.setLayout(new GridLayout(3, 3, 0, 20));
		        viewSubPanelCenter.add(nameCriteriaLabel);
		        viewSubPanelCenter.add(companyCriteriaLabel);
		        viewSubPanelCenter.add(jobCriteriaLabel);
		        
		        viewSubPanelCenter.add(nameCombo);
		        viewSubPanelCenter.add(companyCombo);
		        viewSubPanelCenter.add(jobCombo);
		        
		        viewSubPanelCenter.add(new JLabel(""));
		        viewSubPanelCenter.add(viewBtn);
		        viewSubPanelCenter.add(new JLabel(""));
		        
		        // View sub panel - Bottom:
		        viewPanel.add(viewSubPanelBottom, BorderLayout.SOUTH);
		        viewSubPanelBottom.setLayout(new BorderLayout());
		        // Result Pane Settings:
		        resultPane.setPreferredSize(new Dimension(250, 250));
		        viewSubPanelBottom.add(resultPane, BorderLayout.CENTER);	        
		        viewSubPanelBottom.add(viewSubPanelBottomPusher, BorderLayout.SOUTH);
		        
		        // Pusher:
		        viewSubPanelBottomPusher.setLayout(new GridLayout(2,1,0, 50 ));
		        viewAllBtn.setPreferredSize(new Dimension(50,50));
		        viewSubPanelBottomPusher.add(viewAllBtn);
		        viewSubPanelBottomPusher.add(new JLabel(""));
                
		        
		        
		        // ============ Change / Remove Section ============
		        
		        
		        
		        
		        // Divide change Panel into sub panels:
		        changePanel.setLayout(new BorderLayout());
		        changePanel.add(changeSubTopPanel, BorderLayout.NORTH);
		        changePanel.add(changeSubBottomPanel, BorderLayout.CENTER);
		        
		        // Change sub panel - top:
		        changeSubTopPanel.setLayout(new GridLayout(9, 1, 0, 30));
		        changeSubTopPanel.add(new JLabel(""));
		        changeSubTopPanel.add(changeSectionLabel);
		        changeSubTopPanel.add(changeCombo);
		        changeSubTopPanel.add(changeLabel);
		        changeSubTopPanel.add(TFchange1);
		        changeSubTopPanel.add(changeToLabel);
		        changeSubTopPanel.add(TFchange2);
		        changeSubTopPanel.add(changeBtn);
		        
		        changeSubBottomPanel.setLayout(new GridLayout(4, 1, 0, 10));
		        changeSubBottomPanel.add(removeSectionLabel);
		        changeSubBottomPanel.add(removeCombo);
		        changeSubBottomPanel.add(removeBtn);
		        changeSubBottomPanel.add(new JLabel(""));
		       
		        //color of panel 
		        formSubPanelTop.setBackground(Color.black);
		        formSubPanelCenter.setBackground(Color.black);
		        formSubPanelBottom.setBackground(Color.black);
		        
		        changePanel.setBackground(Color.black);
		        changeSubTopPanel.setBackground(Color.BLACK);
		        changeSubBottomPanel.setBackground(Color.black);
		        
		        viewSubPanelBottomPusher.setBackground(Color.GRAY);
		        viewSubPanelCenter.setBackground(Color.GRAY);
		        viewSubPanelTop.setBackground(Color.GRAY);
		        viewSubPanelBottom.setBackground(Color.GRAY);
		        
		        
		        //color of label
		        firstNameLabel.setForeground(Color.white);
		        surNameLabel.setForeground(Color.white);
		        mobileNumberLabel.setForeground(Color.white);
		        homeNumberLabel.setForeground(Color.white);
		        workNumberLabel.setForeground(Color.white);
		        companyLabel.setForeground(Color.white);
		        positionLabel.setForeground(Color.white);
		        addressLabel.setForeground(Color.white);
		        formSectionLabel.setForeground(Color.white);
		        changeLabel.setForeground(Color.white);
		        changeSectionLabel.setForeground(Color.white);
		        changeToLabel.setForeground(Color.white);
		        removeSectionLabel.setForeground(Color.white);
		        // =============== Events ==================
		        
		        ResultSet rs = null;
		        table.setModel(DatabaseUtil.getAllModel());
		        changeCombo.setModel(new DefaultComboBoxModel(Events.Columns));
		        
		        String query1 = "SELECT FNAME FROM MAIN_INFO";
		        String query2 = "SELECT COMPANY FROM ADDITIONAL_INFO";
		        String query3 = "SELECT JOB_TITLE FROM JOB_TITLE";
		        String query4 = "SELECT FNAME, LNAME, MOBILE FROM MAIN_INFO";
		        
		        // Fill the all combo boxes with result sets:
		        DatabaseUtil.addComboItems(rs, nameCombo, query1);
		        DatabaseUtil.addComboItems(rs, companyCombo, query2);
		        DatabaseUtil.addComboItems(rs, jobCombo, query3);
		        DatabaseUtil.addComboItems(rs, removeCombo, query4);
		        
		    	class AddRecord implements ActionListener{

					@Override
					public void actionPerformed(ActionEvent arg0){
                               Events.addRecord();	
                               table.setModel(DatabaseUtil.getAllModel());
                               
                               // On Refresh re-add the items in the combo boxes.
                               DatabaseUtil.removeComboItems(nameCombo);
                               DatabaseUtil.removeComboItems(companyCombo);
                               DatabaseUtil.removeComboItems(jobCombo);
                               DatabaseUtil.removeComboItems(removeCombo);
                               
                               try {
								DatabaseUtil.addComboItems(rs, nameCombo, query1);
								DatabaseUtil.addComboItems(rs, companyCombo, query2);
								DatabaseUtil.addComboItems(rs, jobCombo, query3);
								DatabaseUtil.addComboItems(rs, removeCombo, query4);
							   } catch (SQLException e1) {
							       e1.printStackTrace();
							   }
					}
		    	
		    	} 
		        
		    	class ViewByCriteria implements ActionListener{
		    		
		    		@Override
		    		public void actionPerformed(ActionEvent e) {
		    			
		    			
		    			  String fnameComboValue = nameCombo.getSelectedItem().toString();
		    			  String companyComboValue = companyCombo.getSelectedItem().toString();
		    			  String jobComboValue = jobCombo.getSelectedItem().toString();
		    			  
		    			  //Events.ViewByCriteria( fnameComboValue, companyComboValue, jobComboValue);
		    			
		    			  DatabaseUtil.removeComboItems(nameCombo);
                          DatabaseUtil.removeComboItems(companyCombo);
                          DatabaseUtil.removeComboItems(jobCombo);
                          DatabaseUtil.removeComboItems(removeCombo);
                          
                          try {
							DatabaseUtil.addComboItems(rs, nameCombo, query1);
							DatabaseUtil.addComboItems(rs, companyCombo, query2);
							DatabaseUtil.addComboItems(rs, jobCombo, query3);
							DatabaseUtil.addComboItems(rs, removeCombo, query4);
						   } catch (SQLException e1) {
						       e1.printStackTrace();
						   }
                          try {
							table.setModel(Events.ViewByCriteria( fnameComboValue, companyComboValue, jobComboValue));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
		    		}
		    	
		    	} 
		    	
		    	class ViewAll implements ActionListener{

		    		@Override
		    		public void actionPerformed(ActionEvent e) {
                        table.setModel(DatabaseUtil.getAllModel());
		    		}
		    	
		    	} 
		    	
		    	
		    	class Update implements ActionListener{

		    		@Override
		    		public void actionPerformed(ActionEvent e) {
		    			String changeTFValue1 = TFchange1.getText();
		    			String changeTFValue2 = TFchange2.getText();
		    			String changeComboValue = changeCombo.getSelectedItem().toString();
		    			
		    			
		    			
		    		}
		    	
		    	} 
		        
		    	class Remove implements ActionListener{

		    		@Override
		    		public void actionPerformed(ActionEvent e) {
		    			String removeComboValue = removeCombo.getSelectedItem().toString();
		    			Events.removeRecord(removeComboValue);  
		    			
		    			DatabaseUtil.removeComboItems(nameCombo);
                        DatabaseUtil.removeComboItems(companyCombo);
                        DatabaseUtil.removeComboItems(jobCombo);
                        DatabaseUtil.removeComboItems(removeCombo);
                        
                         try {
							DatabaseUtil.addComboItems(rs, nameCombo, query1);
							DatabaseUtil.addComboItems(rs, companyCombo, query2);
							DatabaseUtil.addComboItems(rs, jobCombo, query3);
							DatabaseUtil.addComboItems(rs, removeCombo, query4);
						   } catch (SQLException e1) {
						       e1.printStackTrace();
						   }
                         table.setModel(DatabaseUtil.getAllModel());
		    		}		    	
		    	} 
		        
		    	addRecordBtn.addActionListener(new AddRecord());
		        viewAllBtn.addActionListener(new ViewAll());
		        viewBtn.addActionListener(new ViewByCriteria());
		        changeBtn.addActionListener(new Update());
		        removeBtn.addActionListener(new Remove());
		      
		        	
		        UI.setVisible(true);
		        
		       
		    	
		} // End of Main Method
		
    

		private static JFrame getFrame() {
			
			return null;
		}
		
	} // End of MainClass
	
} // End of GUI2 Class
