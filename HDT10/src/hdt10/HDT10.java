/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt10;

/**
 *
 * @author Home
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HDT10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        AlgoritmoF floyd = new AlgoritmoF();
        floyd.ShortWay();
        boolean run = true;
        int menu = 0;
        
        System.out.println("Grafos de ciudades");
        while(run){
            System.out.println("Menu:");
            System.out.println("1) Ruta más corta");
            System.out.println("2) Centro del grafo");
            System.out.println("3) Terminar");
            menu = entrada.nextInt();
            
            if(menu==1){
                floyd.ShortWay();
                System.out.println("Ingrese el nombre de la ciudad de salida");
                String ciudad1 = entrada.next(); 
                System.out.println("Ingrese el nombre de la ciudad de destino");
                String ciudad2 = entrada.next();
                if(floyd.graff.contains(ciudad1)&&floyd.graff.contains(ciudad2)){
                    System.out.println("\nLa distancia minima es: "+floyd.graff.getEdge(ciudad1, ciudad2)+".");
                    if(floyd.graff.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("La ruta es: "+ciudad1);
                        floyd.Mid(floyd.graff.getIndex(ciudad1), floyd.graff.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            if(menu==2){
                floyd.Center();
            }
            
            if(menu==4){
                run = false;
            }
        }
    }
    
}
