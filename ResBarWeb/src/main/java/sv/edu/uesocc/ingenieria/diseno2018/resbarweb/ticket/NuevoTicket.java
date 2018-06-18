/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket;

import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.Orden;

/**
 *
 * @author Diana Magaña
 */
public class NuevoTicket {

    PrinterService printerService = new PrinterService();
    String ticket = "";

    public void TicketCocina(Orden orden) {
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
                ticket += "    " + detalleOrdenList.producto.nombre + "\t\t" + detalleOrdenList.cantidad + "   \n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   " + orden.comentario + "                             \n\n";
        ticket += "------------------------------------------------";

        printerService.printString("POS-80 (copy 1)", ticket);
        byte[] cutP = new byte[]{29, 'V', 1};
        printerService.printBytes("POS-80 (copy 1)", cutP);
    }

    public void TicketBebida(Orden orden) {
        ticket = "------------------------------------------------";
        ticket += "                  BEBIDA                        \n";
        ticket += " Cliente:   " + orden.cliente + "     Fecha: " + (orden.fecha.getYear()+1900) + "/" + orden.fecha.getMonth() + "/" + orden.fecha.getDay() + " \n";
        ticket += " N° Ticket: " + orden.idOrden + "                                 \n";
        ticket += " Mesa:      " + orden.mesa + "               Hora:  " + orden.fecha.getHours() + ":" + orden.fecha.getMinutes() + "     \n";
        ticket += "   ------------------------------------------   ";
        ticket += "  | Concepto                        Cantidad |  ";
        ticket += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            if (detalleOrdenList.producto.area == 'B' || detalleOrdenList.producto.area == 'b') {
                ticket += "    " + detalleOrdenList.producto.nombre + "\t\t" + detalleOrdenList.cantidad + "\n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   " + orden.comentario + "                             \n\n";
        ticket += "------------------------------------------------\n\n\n\n\n";

        printerService.printString("POS-80 (copy 1)", ticket);
        byte[] cutP = new byte[]{29, 'V', 1};
        printerService.printBytes("POS-80 (copy 1)", cutP);
    }

}
