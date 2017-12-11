/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author Facundo
 */
public class ImprimirFactura {
    public static final String CHUNK = "";
    
    public static void PDF(String tipo, String cliente, Double total, List<DetalleFactura> unosDetalles) throws FileNotFoundException, DocumentException, IOException{
    
        Document documento = new Document();
        OutputStream file =  new FileOutputStream(new File("Factura.pdf"));
        
        
        PdfWriter.getInstance(documento, file).setInitialLeading(20);
        documento.open();
        
        //Parrafo
        Paragraph encabezado = new Paragraph("Facturacion \n",FontFactory.getFont("arial",25,Font.ITALIC));
        
        encabezado.setAlignment(Element.ALIGN_CENTER);
        
        documento.add(encabezado);
        
        Paragraph saltolinea = new Paragraph();
        
        saltolinea.add("\n\n");
        
        documento.add(saltolinea);
        
        Paragraph Datos = new Paragraph("Tipo: " +tipo+"                "+ "Cliente: "+cliente,FontFactory.getFont("arial",20,Font.BOLD));
        
        Datos.setAlignment(Element.ALIGN_LEFT);
        
        documento.add(Datos);
        
        saltolinea.add("\n\n");
        
        documento.add(saltolinea);
        

        
        //Tabla
        PdfPTable tabla = new PdfPTable(3);
        
        //Añadimos los títulos a la tabla. 
        Paragraph columna1 = new Paragraph("Reserva Habitacion");
        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(15);
        tabla.addCell(columna1);

        Paragraph columna2 = new Paragraph("Cantidad");
        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(15);
        tabla.addCell(columna2);

        Paragraph columna3 = new Paragraph("Subtotal");
        columna3.getFont().setStyle(Font.BOLD);
        columna3.getFont().setSize(15);
        tabla.addCell(columna3);
        
        for (int i = 0; i < unosDetalles.size(); i++) {
            tabla.addCell(unosDetalles.get(i).getDescripcion());
            int cantidad = unosDetalles.get(i).getCantidad();
            String cant = String.valueOf(cantidad);
            tabla.addCell(cant);
            Double subtotal = unosDetalles.get(i).getSubtotal();
            String sub = String.valueOf(subtotal);
            tabla.addCell(sub);
        }
        documento.add(tabla);
        
        saltolinea.add("\n");
        
        documento.add(saltolinea);
        
        Paragraph Total = new Paragraph("Total: "+total,FontFactory.getFont("arial",20,Font.BOLD));
        
        Total.setAlignment(Element.ALIGN_LEFT);
        
        documento.add(Total);
        
        documento.close();
        file.close();
        
    }
    
    
}
