package com.swpu.warning.boundary;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.swpu.warning.daoimpl.numImpl;
import com.swpu.warning.entity.user;
public class boundary extends JPanel{
	 public static JLabel time = new JLabel("time");

	 public static JButton start = new JButton("Start");
	 private static JButton Stop = new JButton("Stop");
	 private static JButton End = new JButton("End");
	 
	 public static void main(String[] args) {
		 numImpl ni = new numImpl();
		 user u = null;
		 
		 
		 JFrame frame = new JFrame();
	     frame.setTitle("学习！！");
	     frame.setSize(350, 350);
	     frame.addWindowListener(new WindowAdapter() {
	       public void windowClosing(WindowEvent e) {
	         System.exit(0);
	       }
	     });
	    
	     
	     Thread t = new Thread(new Runnable(){  
	            public void run(){  
	            	ni.recharge();
	            }});  
	        t.start();  
	     
	     
	     
	     start.addActionListener(new ActionListener()
	     {
	         public void actionPerformed(ActionEvent e)
	         {
	        	
	        	 final Timer timer = new Timer();
	        	    TimerTask task = new TimerTask() {
	        	    	int tempInt = ni.start();
	        	  
	        	        @Override
	        	        public void run() {
	        	        	time.setText(Integer.toString(tempInt));
	        	        	tempInt-=1;
	        	        }
	        	    };
	        	    timer.schedule(task, 0, 1000);// 1秒一次
	         }
	     });
	     
	     End.addActionListener(new ActionListener()
	     {
	         public void actionPerformed(ActionEvent e)
	         {
	        	 int tempInt2 = Integer.parseInt(time.getText());
	        	 ni.end(tempInt2);
	        	 System.exit(0);
	         }
	     });
	     
	     Stop.addActionListener(new ActionListener()
	     {
	         public void actionPerformed(ActionEvent e)
	         {
	        	 
	        	 JOptionPane.showMessageDialog(null,"哎 没实现！");
	         }
	     });
	     
	     
	     
	     Container contentPane = frame.getContentPane();
	     contentPane.add(new boundary());
	     frame.show();
	     
	 }
	 public boundary() {
	     setLayout(new BorderLayout());

	     this.add(start,"Center");
	     this.add(End,"Center");
	     this.add(Stop,"Center");
	     this.add(time,"Center");

	     JPanel p = new JPanel();
	     p.setLayout(new GridLayout(5, 5));
	      
	    p.add(start);
	    p.add(End);
	    p.add(Stop);
	    p.add(time);
	    
	      
	      
	     add(p, "Center");
	   }
}