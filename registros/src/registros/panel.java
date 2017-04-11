/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Dimension;
public class panel extends JPanel
{
    public Cursor CursorPrograma;
     public Cursor CursorBoton;
    @Override
    public void paintComponent(Graphics g){
     Dimension tam=getSize();
     
    }
    
public static void main(String []args){
 panel pa=new panel();
 pa.setVisible(true);
}
}
