/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket;

import sv.edu.diseno.definiciones.DetalleOrden;
import static sv.edu.diseno.definiciones.DetalleOrden_.orden;
import sv.edu.diseno.definiciones.Orden;

/**
 *
 * @author Diana Magaña
 */
public class NuevoTicket {
    
    PrinterService printerService = new PrinterService();
    Orden imprimir = new Orden();
    
    public void ImprimirTicket(Orden orden){
        
        String ticket;
        ticket = "------------------------------------------------";
        ticket += "                  COCINA                        \n";
        ticket += " Cliente:   "+orden.cliente+"            Fecha: "+orden.fecha+"   \n";
        ticket += " N° Ticket: "+orden.idOrden+"                                 \n";
        ticket += " Mesa:      "+orden.mesa+"               Hora:  "+orden.fecha.getHours()+":"+orden.fecha.getMinutes()+"     \n";
        ticket += "   ------------------------------------------   ";
        ticket += "  | Concepto                        Cantidad |  ";
        ticket += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            if(detalleOrdenList.producto.area=='C'){
                ticket += "    "+detalleOrdenList.producto.nombre+"            "+detalleOrdenList.producto.precio+"   \n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   "+orden.comentario+"                             \n\n";
        ticket += "------------------------------------------------";
        ticket += "------------------------------------------------";
        ticket += "                  BEBIDA                        \n";
        ticket += " Cliente:   "+orden.cliente+"            Fecha: "+orden.fecha+"   \n";
        ticket += " N° Ticket: "+orden.idOrden+"                                 \n";
        ticket += " Mesa:      "+orden.mesa+"               Hora:  1:21 a.m     \n";
        ticket += "   ------------------------------------------   ";
        ticket += "  | Concepto                        Cantidad |  ";
        ticket += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            if(detalleOrdenList.producto.area=='B'){
                ticket += "    "+detalleOrdenList.producto.nombre+"            "+detalleOrdenList.producto.precio+"   \n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   "+orden.comentario+"                             \n\n";
        ticket += "------------------------------------------------\n\n\n\n\n";
        
        printerService.printString("POS-80 (copy 1)", ticket);

        byte[] cutP = new byte[]{29, 'V', 1};

        printerService.printBytes("POS-80 (copy 1)", cutP);
    }
    
}
