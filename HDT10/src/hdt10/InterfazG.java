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
public interface InterfazG<V,E> {
    public void add(V label);
    
    public void addEdge(V vtx1, V vtx2, E label);

    public void show();

    public int getIndex(V label);

    public V get(int label);
    
    public int getEdge(V label1, V label2);
    
    public boolean contains(V label);
    
    public int size();
}
