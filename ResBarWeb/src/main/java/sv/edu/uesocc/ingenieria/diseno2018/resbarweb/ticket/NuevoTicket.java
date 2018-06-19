/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket;

import java.util.List;
import sv.edu.diseno.acceso.ManejadorParametros;
import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.Orden;
import sv.edu.diseno.definiciones.Parametro;

/**
 *
 * @author Diana Magaña
 */
public class NuevoTicket {

    public static final List<Parametro> parametros = ManejadorParametros.Obtener();

    public void TicketCocina(Orden orden) {
        PrinterService printerService = new PrinterService();
        String ticket = "";
        ticket = "------------------------------------------------";
        ticket += "                  COCINA                        \n";
        ticket += " Cliente:   " + orden.cliente + "     Fecha: " + (orden.fecha.getYear() + 1900) + "/" + orden.fecha.getMonth() + "/" + orden.fecha.getDay() + " \n";
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
                ticket += "    " + producto + "\t\t\t" + detalleOrdenList.cantidad + "   \n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   " + orden.comentario + "                             \n\n";
        ticket += "------------------------------------------------ \n\n\n\n";

        printerService.printString("POS-80 (copy 1)", ticket);
        byte[] cutP = new byte[]{29, 'V', 1};
        printerService.printBytes("POS-80 (copy 1)", cutP);
    }

    public void TicketBebida(Orden orden) {
        PrinterService printerService = new PrinterService();
        String ticket = "";
        ticket = "------------------------------------------------";
        ticket += "                  BEBIDA                        \n";
        ticket += " Cliente:   " + orden.cliente + "     Fecha: " + (orden.fecha.getYear() + 1900) + "/" + orden.fecha.getMonth() + "/" + orden.fecha.getDay() + " \n";
        ticket += " N° Ticket: " + orden.idOrden + "                                 \n";
        ticket += " Mesa:      " + orden.mesa + "               Hora:  " + orden.fecha.getHours() + ":" + orden.fecha.getMinutes() + "     \n";
        ticket += "   ------------------------------------------   ";
        ticket += "  | Concepto                        Cantidad |  ";
        ticket += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            if (detalleOrdenList.producto.area == 'B' || detalleOrdenList.producto.area == 'b') {
                String producto = "";
                producto += detalleOrdenList.producto.nombre;
                for (int i = detalleOrdenList.producto.nombre.length(); i < 20; i++) {
                    producto += " ";
                }
                ticket += "    " + producto + "\t\t\t" + detalleOrdenList.cantidad + "   \n";
            }
        }
        ticket += "   ------------------------------------------   ";
        ticket += "   Comentario:                                  \n";
        ticket += "   " + orden.comentario + "                             \n\n";
        ticket += "------------------------------------------------\n\n\n\n";

        printerService.printString("POS-80 (copy 1)", ticket);
        byte[] cutP = new byte[]{29, 'V', 1};
        printerService.printBytes("POS-80 (copy 1)", cutP);
    }

    public void TicketVenta(Orden orden) {
        PrinterService printerService = new PrinterService();
        String ticket = "";
        for (Parametro p : parametros) {
            ticket += p.nombre+": " +p.valor + "     \n";
        }
        ticket += "------------------------------------------------";
        ticket += "           Gracias por visitarnos               \n";
        ticket += "------------------------------------------------\n\n\n\n";
        ticket += " Cliente:   " + orden.cliente + "     Fecha: " + (orden.fecha.getYear() + 1900) + "/" + orden.fecha.getMonth() + "/" + orden.fecha.getDay() + " \n";
        ticket += " N° Ticket: " + orden.idOrden + "                                 \n";
        ticket += " Mesa:      " + orden.mesa + "               Hora:  " + orden.fecha.getHours() + ":" + orden.fecha.getMinutes() + "     \n";
        ticket += "   ------------------------------------------   ";
        ticket += "  | Concepto                        Cantidad |  ";
        ticket += "   ------------------------------------------   ";
        for (DetalleOrden detalleOrdenList : orden.detalleOrdenList) {
            String producto = "";
            producto += detalleOrdenList.producto.nombre;
            for (int i = detalleOrdenList.producto.nombre.length(); i < 20; i++) {
                producto += " ";
            }
            ticket += "    " + producto + "\t\t\t" + detalleOrdenList.producto.precio + "   \n";
        }
        ticket += "   ------------------------------------------   ";
        ticket += "  TOTAL:                                  \n";
        ticket += "   " + orden.total + "                             \n\n";
        ticket += "------------------------------------------------\n\n\n\n";
        System.out.println(ticket);
//        printerService.printString("POS-80 (copy 1)", ticket);
//        byte[] cutP = new byte[]{29, 'V', 1};
//        printerService.printBytes("POS-80 (copy 1)", cutP);
    }
}
