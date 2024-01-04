
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame  implements ActionListener {
    
    JButton back;
  //  String username;
    
    ViewPackage(String username)
    {
     //   this.username=username;
        setBounds(250,200,900,480);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("VIEW  PACKAGE  DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);
        
        
        // label username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        //username logineeed  
         JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        
        JLabel lblpackage=new JLabel("Package");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);
        
         JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        
        
        JLabel lblpersons=new JLabel("Total Persons ");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);
        
         JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,170,150,25);
        add(lblid);
        
         JLabel labelid=new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        
         JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,210,150,25);
        add(lblnumber);
        
         JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,250,150,25);
        add(lblphone);
        
         JLabel labelphone=new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
    
        
         JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(30,290,150,25);
        add(lblprice);
        
         JLabel labelprice=new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        
        
        back=new JButton("BACK");
        back.setBounds(150,370,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookeddetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,600,450);              //  use when setlayout is null
        add(image);
        
        try{
          Conn c=new Conn();
          String query= "select * from bookpackage where username = ' "+username+"' ";
          
          
          ResultSet rs =c.s.executeQuery(query);
          while(rs.next())
          {
              
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelpackage.setText(rs.getString("package"));
               labelprice.setText(rs.getString("price"));
               labelphone.setText(rs.getString("phone"));
               labelpersons.setText(rs.getString("persons"));
                
          }
          
    }
        catch(Exception e){}
       
        setVisible(true);
       
    }   
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== back)
        {
            setVisible(false);
     
        }
    }
    
    
    public static void main(String args[])
    {
        new ViewPackage("");
    }  
          
    
    
}
