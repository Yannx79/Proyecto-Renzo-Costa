/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Producto;
import Controladores.ControladorData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Testing {

    public static void main(String[] args) {
        ControladorData cd = new ControladorData();
        LinkedList<Producto> lp = cd.instanciarListaProducto();
        Set<Producto> ap = new TreeSet<Producto>();
        Iterator<Producto> itp = lp.iterator();
        boolean comparacion[] = {false, false, false, false, true, false};
        Producto.setComparacion(comparacion);

        while (itp.hasNext()) {
            Producto p = itp.next();
            ap.add(p);
//            if (itp.hasNext()) {
//                p.set
//            }
        }

        Iterator<Producto> itpa = ap.iterator();
        while (itpa.hasNext()) {
            System.out.println(itpa.next().toString());
        }
        System.out.println(ap.size());;
    }

}
