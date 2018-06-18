/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket;

import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.Orden;

/**
 *
 * @author Diana Magaña
 */
public class NewClass {

    public static void main(String[] args) {
        PrinterService printerService = new PrinterService();
        ManejadorOrden manejadorOrden = new ManejadorOrden();
        Orden orden = manejadorOrden.Obtener(1);

        String ticket;
        ticket = "------------------------------------------------";
        ticket += "                  COCINA                        \n";
        ticket += " Cliente:   " + orden.cliente + "     Fecha: " + (orden.fecha.getYear()+1900) + "/" + orden.fecha.getMonth() + "/" + orden.fecha.getDay() + " \n";
        ticket += " N° Ticket: " + orden.idOrden + "                                 \n";
        ticket += " Mesa:      " + orden.mesa + "               Hora:  " + orden.fecha.getHours() + ":" + orden.fecha.getMinutes() + "     \n";
        ticket += "   ------------------------------------------   ";
        ticket += "  | Concepto                        Cantidad |  ";
        ticket += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            if (detalleOrdenList.producto.area == 'C' || detalleOrdenList.producto.area == 'c') {
                String producto = "";
                producto += detalleOrdenList.producto.nombre;
                for (int i = detalleOrdenList.producto.nombre.length(); i < 20; i++) {
                    producto += " ";
                }
                ticket += "    "+producto +"\t\t\t"+ detalleOrdenList.cantidad + "   \n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   " + orden.comentario + "                             \n\n";
        ticket += "------------------------------------------------";

        printerService.printString("POS-80 (copy 1)", ticket);
        byte[] cutP = new byte[]{29, 'V', 1};
        printerService.printBytes("POS-80 (copy 1)", cutP);

        String ticket2;
        ticket2 = "------------------------------------------------";
        ticket2 += "                  BEBIDA                        \n";
        ticket2 += " Cliente:   " + orden.cliente + "     Fecha: " + (orden.fecha.getYear()+1900) + "/" + orden.fecha.getMonth() + "/" + orden.fecha.getDay() + " \n";
        ticket2 += " N° Ticket: " + orden.idOrden + "                                 \n";
        ticket2 += " Mesa:      " + orden.mesa + "               Hora:  " + orden.fecha.getHours() + ":" + orden.fecha.getMinutes() + "     \n";
        ticket2 += "   ------------------------------------------   ";
        ticket2 += "  | Concepto                        Cantidad |  ";
        ticket2 += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            if (detalleOrdenList.producto.area == 'B' || detalleOrdenList.producto.area == 'b') {
                String producto = "";
                producto += detalleOrdenList.producto.nombre;
                for (int i = detalleOrdenList.producto.nombre.length(); i < 20; i++) {
                    producto += " ";
                }
                ticket2 += "    "+producto +"\t\t\t"+ detalleOrdenList.cantidad + "   \n";
            }
        }
        ticket2 += "   ------------------------------------------   ";
        ticket2 += "   Comentario:                                  \n";
        ticket2 += "   " + orden.comentario + "                             \n\n";
        ticket2 += "------------------------------------------------\n\n\n\n\n";

        printerService.printString("POS-80 (copy 1)", ticket2);
        byte[] cutP2 = new byte[]{29, 'V', 1};
        printerService.printBytes("POS-80 (copy 1)", cutP2);

    }

    public void ContarString(String palabra) {

    }
}
