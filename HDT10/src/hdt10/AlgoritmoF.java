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



public class AlgoritmoF {
    
    Text txt= new Text();
    Matrix graff;
    int[][] nodos;
    int[] max;
    int centro;
    int minimo=10000;
    

    public AlgoritmoF(){
        
        try {
            txt.obtenerArchivo("datos.txt");
            txt.arregloNombres(); 
            graff = (Matrix) txt.matrizCostos(); 
            nodos = new int[25][25]; 
            max = new int[25];
            
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        
        for(int n=0;n<txt.matriz.size();n++){
            for(int m=0;m<txt.matriz.size();m++){
                nodos[n][m]=10000;
            }
        }
    }
    
    public void ShortWay(){
        for(int k=0;k<graff.size();k++){
            for(int i=0;i<graff.size();i++){
                for(int j=0;j<graff.size();j++){
                    if(graff.getEdge(graff.get(i),graff.get(j))>(graff.getEdge(graff.get(i), graff.get(k))+graff.getEdge(graff.get(k), graff.get(j)))){
                        graff.addEdge(graff.get(i), graff.get(j), (graff.getEdge(graff.get(i), graff.get(k))+graff.getEdge(graff.get(k), graff.get(j))));
                        nodos[i][j]=k;
                    }
                }
            }
        }
        
    }

    public void Center(){
        ShortWay();
        int n=0;       
        for(int i=0;i<graff.size();i++){
            for(int j=0;j<graff.size()-1;j++){
                int num1=graff.getEdge(graff.get(j), graff.get(i));
                n=j;
                n++;
                int num2=graff.getEdge(graff.get(n), graff.get(i));
                if(num1>num2){
                    max[i]=num1;
                }
                else{
                    max[i]=num2;
                }
            }
            n++;
        }
        for(int i=0;i<graff.size();i++){
            int num1=max[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println("\nEl centro del grafo es: "+graff.get(centro)+"\n");
        
        
    }
    
    public void Mid(int num1, int num2){
        if(nodos[num1][num2]!=10000){
            Mid(num1,nodos[num1][num2]);
            System.out.print(", "+graff.get(nodos[num1][num2]));
            Mid(nodos[num1][num2],num2);
            return;
        }
        else return;
           
    }
}