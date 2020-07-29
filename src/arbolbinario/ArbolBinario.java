
package arbolbinario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ArbolBinario extends JFrame implements ActionListener{

    public JButton botonCrear  = new JButton("Crear arbol");
    public JButton botonInsertar = new JButton("Insertar en el arbol");
    public JButton botonRetirar  = new JButton("Retirar del arbol");
    public JButton botonReconstruir  = new JButton("Reconstruir arbol");
    
    public JLabel label  = new JLabel("Trabajo hecho por:");
    public JLabel label2 = new JLabel("Nombre: Daniel Alejandro Roa Palacios");
    public JLabel label3 = new JLabel("Codigo: 20171020077");
    public JLabel label4 = new JLabel("");
    public JLabel label5 = new JLabel("Ingresar numero(s) que desea añadir");
    public JLabel label6 = new JLabel("Recorrido Preorden: ");
    public JLabel label7 = new JLabel("Recorrido Inorden: ");
    public JLabel label8 = new JLabel("Recorrido Posorden: ");
    public JLabel label9 = new JLabel("Recorrido por niveles: ");
    public JLabel labelAviso = new JLabel("");
    
    public JLabel texto1 = new JLabel("Inorden: ");
    public JLabel texto2 = new JLabel("Recorrido: ");
    
    ButtonGroup  bg = new ButtonGroup();
    
    JRadioButton rb1 = new JRadioButton("Preorden");
    JRadioButton rb2 = new JRadioButton("PosOrden");
    
    public JTextField tfIngreso = new JTextField("5,7,36,4,1,8,69,41,75,3,9");
    public JTextField tfRetiro = new JTextField("5,7");
    public JTextField preOrden = new JTextField();
    public JTextField inOrden = new JTextField();
    public JTextField posOrden = new JTextField();
    public JTextField niveles = new JTextField();
    
    public JTextField entradaIn = new JTextField();
    public JTextField entradaRecorrido = new JTextField();
    
    private Arbol tree = null; 
    private List <Nodo> listaArbol = new ArrayList();
    private String entrada, cadenaNiveles = "";
    
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    
    public static void main(String[] args) {

        ArbolBinario ab = new ArbolBinario();
        ab.setSize(1300, 700);
        ab.setTitle("Arboles Binarios");
        ab.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ab.setVisible(true);
        
    }

    ArbolBinario(){
        
         Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        bg.add(rb1);
        bg.add(rb2);
        
        c.add(rb1);
        c.add(rb2);
        
        c.add(label);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
        c.add(label6);
        c.add(label7);
        c.add(label8);
        c.add(label9);
        c.add(labelAviso);
        
        c.add(tfIngreso);
        c.add(tfRetiro);
        c.add(preOrden);
        c.add(inOrden);
        c.add(posOrden);
        c.add(niveles);
        c.add(entradaIn);
        c.add(entradaRecorrido);
        c.add(texto1);
        c.add(texto2);
        
        c.add(botonInsertar);
        c.add(botonRetirar);
        c.add(botonCrear);
        c.add(botonReconstruir);
        
        c.add(scrollPane1);
        
        rb1.setBounds(1125, 150, 100, 20);
        rb1.setBackground(Color.LIGHT_GRAY);
        rb2.setBounds(1125, 175, 100, 20);
        rb2.setBackground(Color.LIGHT_GRAY);
        
        botonInsertar.addActionListener(this);
        botonRetirar.addActionListener(this);
        botonCrear.addActionListener(this);
        botonReconstruir.addActionListener(this);
        
        label.setBounds(20, 25, 200, 20);
        label2.setBounds(20, 50, 400, 20);
        label3.setBounds(20, 75, 200, 20);
        label4.setBounds(20, 100, 200, 20);
        label5.setBounds(900, 25, 300, 20);
        label6.setBounds(300, 50, 200, 20);
        label7.setBounds(300, 75, 200, 20);
        label8.setBounds(300, 100, 200, 20);
        label9.setBounds(300, 25, 200,20);
        labelAviso.setBounds(900,100,370,20);
        texto1.setBounds(830, 150, 200, 20);
        texto2.setBounds(830, 175, 200, 20);
        
        tfIngreso.setBounds(900, 50, 210, 20);
        tfRetiro.setBounds(900, 75, 210, 20);
        preOrden.setBounds(450, 50, 350, 20);
        inOrden.setBounds(450, 75, 350, 20);
        posOrden.setBounds(450, 100, 350, 20);
        niveles.setBounds(450, 25, 350, 20);
        entradaIn.setBounds(900, 150, 210, 20);
        entradaRecorrido.setBounds(900, 175, 210, 20);
        
        botonInsertar.setBounds(1125, 50, 145, 20);
        botonInsertar.setBackground(Color.green);
        botonRetirar.setBounds(1125, 75, 145, 20);
        botonRetirar.setBackground(Color.red);
        botonCrear.setBounds(1125, 25, 145, 20);
        botonCrear.setBackground(Color.blue);
        botonReconstruir.setBounds(1125, 125, 145, 20);
        botonReconstruir.setBackground(Color.ORANGE);
        
        scrollPane.setBounds(0, 200, 2500, 2500);
        scrollPane.setPreferredSize(new Dimension(2500, 2500));  
        scrollPane.setBackground(Color.LIGHT_GRAY);
        
        scrollPane1.setBounds(0, 200, 1280, 450);
        scrollPane1.setPreferredSize(new Dimension(1280, 450));
        scrollPane1.setBackground(Color.BLUE);
        
    }
    
    private boolean todoNull(List list) {
        
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
    
    public void listarArbol(List<Nodo> nodos, int nivel, int profundidad){
        
        if (nodos.isEmpty() || todoNull(nodos)){
        
            return;

        }
       
        int ubicacion = profundidad - nivel;
        List<Nodo> newNodes = new ArrayList<>();
        
        for (Nodo node : nodos) {
            if (node != null) {
                
                newNodes.add(node.getIzquierdo());
                newNodes.add(node.getDerecho());
                listaArbol.add(node.getIzquierdo());
                listaArbol.add(node.getDerecho());
                
                
            } else {
                
                newNodes.add(null);
                newNodes.add(null);
                listaArbol.add(null);
                listaArbol.add(null);
            
            }
        }
        
        listarArbol(newNodes, nivel + 1, profundidad);
            
    
    }
    
    void pintarArbol(){
        
        scrollPane.removeAll();
        
        int exponente = 0;
        int i=0;
        int j=0;
        double coorX = 1000;
        int coorY = 30;
        
        JLabel numeros[]=new JLabel[listaArbol.size()];
        
        while(i<listaArbol.size()){
        
            if(j >= Math.pow(2, exponente)){           
                
                exponente=exponente+1;
                j=0;
                coorY = coorY + 50;
                coorX = (int) ((2000/(Math.pow(2, (exponente + 1)))));
                
            }
            
            if(j != 0){
                
//                if(listaArbol.get(i) != null){
//                    System.out.print(listaArbol.get(i).getValor() + " Ubicado en: " + coorX + " + " + (2000/(Math.pow(2, (exponente) ))));
//                }
                coorX = ( coorX + (2000/(Math.pow(2, (exponente) ) )) );
                
//                if(listaArbol.get(i) != null){
//                    System.out.print(" = " + coorX);
//                    System.out.println(" ");
//                }
            }
            
            if(listaArbol.get(i) != null){
                
                
                numeros[i]= new JLabel(Integer.toString(listaArbol.get(i).getValor()));
                numeros[i].setBounds((int)coorX, coorY, 30, 30);
            
                JLabel img1 = new JLabel();
                
                int escala = (int) (500/((Math.pow(2, (exponente)))));
                
                if(listaArbol.get(i).getDerecho() != null){
                
                    
                    ImageIcon imgIcon = new ImageIcon(getClass().getResource("flecha.png"));
                    
                    Image imgEscalada = imgIcon.getImage().getScaledInstance(escala,30, Image.SCALE_SMOOTH);
                    Icon iconoEscalado = new ImageIcon(imgEscalada);
                    img1.setBounds((int)coorX+20 , coorY + 30, escala, 30);
                    img1.setIcon(iconoEscalado);
                    
                    scrollPane.add(img1);
            
                    
                } 
                
                img1 = new JLabel();
                
                if(listaArbol.get(i).getIzquierdo()!= null){
                
                    ImageIcon imgIcon = new ImageIcon(getClass().getResource("fder.png"));
            
                    Image imgEscalada = imgIcon.getImage().getScaledInstance(escala,30, Image.SCALE_SMOOTH);
                    Icon iconoEscalado = new ImageIcon(imgEscalada);
                    img1.setBounds((int)coorX-escala , coorY + 30, escala, 30);
                    img1.setIcon(iconoEscalado);
                    
                    scrollPane.add(img1);
                    
                }

                scrollPane.add(numeros[i]);
            
            
            } else {

                numeros[i]= new JLabel("");
                scrollPane.add(numeros[i]);

            }
            
            i++;
            j++;
        }
        
        scrollPane.repaint();
        scrollPane1.setViewportView(scrollPane);
        
    }
    
    void dibujar(){
        
        tree.setCadena("");
        inOrden.removeAll();
        inOrden.setText(tree.printInorder(tree.getRaiz()));
        
        tree.setCadena2("");
        posOrden.removeAll();
        posOrden.setText(tree.printPostOrder(tree.getRaiz()));
        
        tree.setCadena3("");
        preOrden.removeAll();
        preOrden.setText(tree.printPreOrder(tree.getRaiz()));
        
        List <Nodo> lista = new ArrayList();
        lista.add(tree.getRaiz());
        listaArbol = new ArrayList();
        listaArbol.add(tree.getRaiz());
        listarArbol(lista, 0, tree.getMax());
    
        cadenaNiveles = "";
        
        for(int i = 0; i < listaArbol.size(); i++){
        
            if(listaArbol.get(i) != null){
                
                cadenaNiveles = cadenaNiveles + listaArbol.get(i).getValor() +", ";
            
            }
            
        }
        
        niveles.removeAll();
        niveles.setText(cadenaNiveles);
        
        pintarArbol();
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource() == botonCrear){            

            tree =  new Arbol(); 
        
            labelAviso.setText("Arbol creado");
            
        } else if (e.getSource() == botonInsertar && tree != null){
            
            entrada = tfIngreso.getText() + " ";
            
            if(!entrada.equals(" ")){
            
                String temp="";

                for(int i=0;i<entrada.length();i++){

                    if(entrada.substring(i,i+1).equals(",")|| entrada.substring(i,i+1).equals(" ")){
                        
                        tree.setRaiz(tree.insertar(tree.getRaiz(), Integer.parseInt(temp)));
                        temp = "";

                    } else {

                        temp = temp + entrada.substring(i,i+1);

                    }

                }

                labelAviso.setText(tree.getAviso());
                
                dibujar();
                
                tree.setAviso("");
                
            } else {
            
                labelAviso.setText("Por favor llene los campos");
                
            }
            
        } else if (e.getSource() == botonRetirar && tree != null){
            
            entrada = tfRetiro.getText() + " ";
            
            if(!entrada.equals(" ")){
            
                String temp="";

                for(int i=0;i<entrada.length();i++){

                    if(entrada.substring(i,i+1).equals(",")|| entrada.substring(i,i+1).equals(" ")){

                        tree.setRaiz(tree.retirar(tree.getRaiz(), Integer.parseInt(temp)));
                        temp = "";

                    } else {

                        temp = temp + entrada.substring(i,i+1);

                    }

                }

                labelAviso.setText(tree.getAviso());
                
                dibujar();
                
                tree.setAviso("");
                
                } else {
            
                    
                    labelAviso.setText("Por favor llene bien los campos");
                
            }
            
        } else if(e.getSource() == botonReconstruir && rb1.isSelected()){
        
            tree = new Arbol();
            
            String [] cadenaInorden = entradaIn.getText().split(", ");
            String [] cadenaPreorden = entradaRecorrido.getText().split(", ");
            
            int [] lista1 = new int [cadenaInorden.length];
            int [] lista2 = new int [cadenaPreorden.length];
            
            for(int i = 0; i < cadenaPreorden.length; i++){
            
                lista1[i] = Integer.parseInt(cadenaInorden[i]);
                lista2[i] = Integer.parseInt(cadenaPreorden[i]);
                
            }
            
            tree.setRaiz(tree.construirArbolPre(lista1, lista2, 0, cadenaInorden.length - 1));
            
            dibujar();
 
        } else if(e.getSource() == botonReconstruir && rb2.isSelected()){
        
            tree = new Arbol();
            
            String [] cadenaInorden = entradaIn.getText().split(", ");
            String [] cadenaPosOrden = entradaRecorrido.getText().split(", ");
            
            int [] lista1 = new int [cadenaInorden.length];
            int [] lista2 = new int [cadenaPosOrden.length];
            
            for(int i = 0; i < cadenaPosOrden.length; i++){
            
                lista1[i] = Integer.parseInt(cadenaInorden[i]);
                lista2[i] = Integer.parseInt(cadenaPosOrden[i]);
                
            }
            
            int largo = cadenaInorden.length;
            
            tree.setRaiz(tree.construir(lista1, lista2, largo));
            
            dibujar();
            
        } else if (tree == null){
                
            labelAviso.setText("El arbol no existe, por favor creelo"); 
                    
        } 

    } 
    
}
// in 1, 3, 4, 5, 7, 8, 9, 36, 41, 69, 75
