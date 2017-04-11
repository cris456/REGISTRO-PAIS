/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;


public class formularioRegistro  extends JFrame implements ActionListener{

    private JLabel titulo;
    private JLabel pais;
    private JLabel codigo;
    private JLabel idioma;
    private JLabel capital;
    private JTextField ingresarPais;
    private JTextField ingresarCodigo;
    private JTextField ingresarIdioma;
    private JTextField ingresarCapital;
    private JButton nuevo;
    private JButton guardar;
    private JButton atras;
    private JButton mostrar;
    private JButton salir;
    public formularioRegistro(){
        titulo=new JLabel("Registro de Pais"); 
         titulo.setBounds(310,10,300,50);
         titulo.setFont(new Font("Verdana",Font.BOLD,25));
         titulo.setForeground(Color.BLUE);
        pais=new JLabel("Nombre:");
         pais.setBounds(150,70,300,50);
         pais.setFont(new Font("Verdana",Font.BOLD,23));
        codigo=new JLabel("Codigo:");
         codigo.setBounds(150,120,300,50);
         codigo.setFont(new Font("Verdana",Font.BOLD,23));
        idioma=new JLabel("Idioma:");
         idioma.setBounds(150,170,300,50);
         idioma.setFont(new Font("Verdana",Font.BOLD,23));
        capital=new JLabel("Capital:");
         capital.setBounds(150,220,300,50);
         capital.setFont(new Font("Verdana",Font.BOLD,23));
        ingresarPais=new JTextField("");
         ingresarPais.setBounds(280,70,300,40);
         ingresarPais.setFont(new Font("Verdana",Font.BOLD,23));
         ingresarPais.setHorizontalAlignment(JTextField.CENTER);
        ingresarCodigo=new JTextField("");
         ingresarCodigo.setBounds(280,120,300,40);
         ingresarCodigo.setFont(new Font("Verdana",Font.BOLD,23));
         ingresarCodigo.setHorizontalAlignment(JTextField.CENTER);
        ingresarIdioma=new JTextField("");
         ingresarIdioma.setBounds(280,170,300,40);
         ingresarIdioma.setFont(new Font("Verdana",Font.BOLD,23));
         ingresarIdioma.setHorizontalAlignment(JTextField.CENTER);
         ingresarCapital=new JTextField("");
         ingresarCapital.setBounds(280,220,300,40);
         ingresarCapital.setFont(new Font("Verdana",Font.BOLD,23));
         ingresarCapital.setHorizontalAlignment(JTextField.CENTER);
        guardar=new JButton("Guardar");
         guardar.setBounds(240,300,150,60); 
         guardar.setFont(new Font("Verdana",Font.BOLD,15));
        nuevo=new JButton("Nuevo");
         nuevo.setBounds(450,300,150,60);
         nuevo.setFont(new Font("Verdana",Font.BOLD,15));
        mostrar=new JButton("Mostrar Lista");
         mostrar.setBounds(240,380,150,60);
         mostrar.setFont(new Font("Verdana",Font.BOLD,15));
        salir=new JButton("Salir");
         salir.setBounds(450,380,150,60);
         salir.setFont(new Font("Verdana",Font.BOLD,15));
        add(titulo);
        add(pais);
        add(codigo);
        add(idioma);
        add(capital);
        add(ingresarPais);
        add(ingresarCodigo);
        add(ingresarIdioma);
        add(ingresarCapital);
        add(guardar);
        add(nuevo);
        add(salir);
        add(mostrar);
        add(new panel());
        nuevo.addActionListener(this);
        guardar.addActionListener(this);
        salir.addActionListener(this);
        mostrar.addActionListener(this);
         setSize(900,500);
         setTitle("Registro Pais");
         setVisible(true);
         setResizable(false);
         setLocationRelativeTo(null);
    }
    
    
    public void actionPerformed(ActionEvent e){
     try {
         
         if(e.getSource()==nuevo){
             ingresarPais.setText(""); 
             ingresarCodigo.setText("");
             ingresarIdioma.setText("");
             ingresarCapital.setText("");
             ingresarPais.requestFocus();
         }else{
           
                 if(e.getSource()==guardar){
                 conectar cc =new conectar();
                 Connection cn=cc.conexion();
                 String pais,codigo,idioma,capital;
                 String sql="";
                 pais=ingresarPais.getText();
                 codigo=ingresarCodigo.getText();
                 idioma=ingresarIdioma.getText();
                 capital=ingresarCapital.getText();
                 System.out.println(pais+" "+codigo+" "+idioma+" "+capital);
                 sql="INSERT INTO registropaises(codigoPais,nombrePais,idiomaPais,capitalPais) VALUES(?,?,?,?)";
                 System.out.println(sql+"--");
                 PreparedStatement pst=cn.prepareStatement(sql);
                 pst.setString(1, codigo);
                 pst.setString(2, pais);
                 pst.setString(3, idioma);
                 pst.setString(4, capital);
                 int n=pst.executeUpdate();
                 System.out.println(sql+"--"+n);
                 
                 System.out.println(n);
                    if(n>0){
                    JOptionPane.showMessageDialog(null,"Guardado Correctamente");
                    }else{
                    JOptionPane.showMessageDialog(null,"No guardado");
                    }
                 }else{
                     if(e.getSource()==mostrar){
                         listaPaises lista=new listaPaises();
                         lista.setVisible(true);
                     }else{
                         if(e.getSource()==salir){
                              System.exit(0);
                         }
                     }
                     
                     
                 }
             
             
         }
      }catch(Exception ers){
   
     }
      
   }
   public static void main(String []args){
        new formularioRegistro();
    }
         
}


