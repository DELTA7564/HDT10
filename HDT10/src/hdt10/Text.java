/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt10;

/**
  
 * @author Home
 */
import java.io.*;
public class Text{
    
    File doc;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    PrintWriter pw;
    InterfazG matriz = new Matrix();

    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       doc=new File(direccion); 
    }  
    
    public InterfazG arregloNombres() throws IOException{
        // Lectura del fichero
        fr = new FileReader (doc);
        br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            matriz.add(tmp[0]);
            matriz.add(tmp[1]);
        }
        return matriz;
    }
    
    public void write(String cadena) throws IOException{
        fw = new FileWriter(doc);
        pw = new PrintWriter(fw);
        pw.println(cadena);
    }
    
    public InterfazG matrizCostos() throws IOException{
        // Lectura del fichero
        fr = new FileReader (doc);
        br = new BufferedReader(fr);
        String linea;

        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            matriz.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return matriz;
    }
}
