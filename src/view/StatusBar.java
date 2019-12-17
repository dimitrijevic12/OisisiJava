package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	JLabel status;
    JLabel clock;
    
	
    public StatusBar() {
    	
    	GridBagConstraints gbc = new GridBagConstraints();  
    	
    	GridBagLayout grid=new GridBagLayout();
    	
        this.setLayout(grid) ;
        //this.set
        status = new JLabel(" Studentska služba");
        status.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        gbc.ipadx=10;
        gbc.ipady=6;
        gbc.weighty=1.0;
        this.add(status,gbc);       
        
        clock = new JLabel();
        
        LocalDateTime myDateObj = LocalDateTime.now();   
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.");  
        
        String formattedDate = myDateObj.format(myFormatObj);  
        
        clock.setText(formattedDate);
        clock.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;  
        gbc.gridy = 0;  
        gbc.ipadx=10;
        gbc.ipady=6;
        gbc.weightx=1.0;
        gbc.anchor=GridBagConstraints.EAST;
        this.add(clock,gbc);
        Timer timer = new Timer(500, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	  clock.setText(myDateObj.now().format(myFormatObj));
          }
        });
        
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }
		
    

}
