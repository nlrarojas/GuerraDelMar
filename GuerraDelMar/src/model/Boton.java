/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Nelson
 */
public class Boton extends JButton implements ActionListener{
    //private final ArrayList <int[]> numeros;
    private static ArrayList<ArrayList> numeros = new ArrayList<>();
    private int posX;
    private int posY;
    private int ancho;
    private int alto;

    public Boton(int posX, int posY, int ancho, int alto) {
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
        
        init();
    }
    
    private void init(){
        setBounds(posX, posY, ancho, alto);
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String aux = String.valueOf(getLocation());
        aux = aux.substring(17,aux.length());
        numeros.add(convertir(aux));
        setBackground(Color.BLUE);
    }
    
    public ArrayList<Integer> convertir(String aux){
        int num1, num2;
        for (int i=0; i<aux.length(); i++){
            if (aux.substring(i,i+1).equals(",")){
                num1 = Integer.parseInt(aux.substring(0,i));
                num2 = Integer.parseInt(aux.substring(i+3,aux.length()-1));
                ArrayList<Integer> num = new ArrayList<>();
                num.add(num1/23);
                num.add(num2/23);
                return num;
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<ArrayList> getNumeros() {return numeros;}
    
    public void pintar(String color){
        switch (color) {
            case "rojo":
                setBackground(Color.red);
                break;
            case "verde":
                setBackground(Color.green);
                break;
            default:
                setBackground(Color.black);
                break;
        }
        setEnabled(false);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
}
