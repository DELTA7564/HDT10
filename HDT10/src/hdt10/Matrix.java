/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt10;

import java.util.Vector;

/**
 *
 * @author Home
 */
public class Matrix<V,E> implements InterfazG<V,E>{
    private int[][] arist = new int[25][25];
    private Vector vert = new Vector();
    
    public Matrix(){
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arist[i][j]=0;
                }
                else{
                    arist[i][j]=10000;
                }
            }
        }
    }
    
     @Override
    public void add(V label) {       
        if(!vert.contains(label)){
            vert.add(label);
        }
    }
    
    @Override
    public void addEdge(V vtx1, V vtx2, E label) {
        int i = vert.indexOf(vtx1);
        int j = vert.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        arist[i][j]=peso;
    }
    
    @Override
    public void show(){
        for(int a=0;a<vert.size();a++){
            for(int b=0;b<vert.size();b++){
                System.out.print(""+arist[a][b]+" ");
            }
            System.out.println("");
        }
    }

    @Override
    public int size(){
        return vert.size();
    }
    

    @Override
    public int getEdge(V label1, V label2){
        return arist[vert.indexOf(label1)][vert.indexOf(label2)];
    }
    
    @Override
    public V get(int label){
        return (V)vert.get(label);
    }
    
    @Override
    public int getIndex(V label){
        return vert.indexOf(label);
    }
    
    public boolean contains(V label){
        return vert.contains(label);
    }
    
}
