package uniandes.dpoo.hamburguesas.tests;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class PedidoTest {
	
	private static Pedido pedido1;
    private static Pedido pedido2;
    private static File archivoFactura;
	
	public static void vaciarArchivo(File archivo) throws FileNotFoundException {
	        PrintWriter writer = new PrintWriter(archivo);
	        writer.close();
	    	}

	public static void borrarArchivo(File archivo){
	        try {
	            vaciarArchivo(archivo);
	        } catch (FileNotFoundException e) {
	            System.err.println("No se pudo encontrar el archivo: " + e.getMessage());
	        }
	}
	
	public String leerArchivoComoString(File archivo) throws IOException {
	            StringBuilder contenido = new StringBuilder();

	            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	                String linea;
	                while ((linea = br.readLine()) != null) {
	                    contenido.append(linea).append("\n");
	                }
	            }

	            return contenido.toString().trim();
	 
	}
   
    @BeforeAll
    static void setUp() {
    	 ProductoMenu productoMenu1 = new ProductoMenu("hamburguesa", 10000);
         ProductoMenu productoMenu2 = new ProductoMenu("hotdog", 10000);
         ProductoMenu productoMenu3 = new ProductoMenu("soda", 7000);
         ProductoMenu productoMenu4 = new ProductoMenu("sundae", 9000);
         
    	 pedido1 = new Pedido("Cliente 1", "Direccion 1");
    	 pedido2 = new Pedido("Cliente 2", "Direccion 2");
    	 
    	 pedido1.agregarProducto(productoMenu1);
    	 pedido1.agregarProducto(productoMenu2);
    	 pedido2.agregarProducto(productoMenu3);
    	 pedido2.agregarProducto(productoMenu4);
    	 archivoFactura =new File("data/factura.txt"); 
    }

    @AfterAll
    static void tearDown() {
        Pedido.numeroPedidos = 0;
        borrarArchivo(archivoFactura);
    }


    @Test
    void testNumeroPedidos() {
    
        assertEquals(0, pedido1.getIdPedido());
        assertEquals(1, pedido2.getIdPedido());
    }

    @Test
    void testgetPrecios() {
    	
    	int precio1 = 20000;
        int precio2 = 16000;
        double IVA = 0.19;

        int precioIVA1 = (int) (precio1 * IVA);  
        int precioIVA2 = (int) (precio2 * IVA);
    	
    	int precioTotal1= precioIVA1+precio1;
    	int precioTotal2=precioIVA2+precio2;
    
        assertEquals(precioTotal1,pedido1.getPrecioTotalPedido());
        assertEquals(precioTotal2,pedido2.getPrecioTotalPedido());

    }
    @Test
    void testgenerarTextoFactura() {
    	
    	int precio1 = 20000;
        double IVA = 0.19;

        int precioIVA1 = (int) (precio1 * IVA);  
    	
    	int precioTotal1= precioIVA1+precio1;
    	
    	String pedido1C ="Cliente 1";
    	String pedido1D ="Direccion 1";
    	
    	ProductoMenu productoMenu1 = new ProductoMenu("hamburguesa", 10000);
        ProductoMenu productoMenu2 = new ProductoMenu("hotdog", 10000);
        ArrayList<Producto> productos = new ArrayList<>(Arrays.asList(productoMenu1, productoMenu2));;
         
    	
    	StringBuffer sb = new StringBuffer( );

        sb.append( "Cliente: " + pedido1C + "\n" );
        sb.append( "Dirección: " + pedido1D + "\n" );
        sb.append( "----------------\n" );

        for( Producto item : productos )
        {
            sb.append( item.generarTextoFactura( ) );
        }

        sb.append( "----------------\n" );
        sb.append( "Precio Neto:  " + precio1+ "\n" );
        sb.append( "IVA:          " + precioIVA1+ "\n" );
        sb.append( "Precio Total: " + precioTotal1 + "\n" );

        String stringPrueba=sb.toString( );
    	
    	assertEquals(stringPrueba,pedido1.generarTextoFactura());
    	
    }
    @Test
    void testguardarFactura() throws IOException{
    	
    	int precio1 = 20000;
        double IVA = 0.19;

        int precioIVA1 = (int) (precio1 * IVA);  
    	
    	int precioTotal1= precioIVA1+precio1;
    	
    	String pedido1C ="Cliente 1";
    	String pedido1D ="Direccion 1";
    	
    	ProductoMenu productoMenu1 = new ProductoMenu("hamburguesa", 10000);
        ProductoMenu productoMenu2 = new ProductoMenu("hotdog", 10000);
        ArrayList<Producto> productos = new ArrayList<>(Arrays.asList(productoMenu1, productoMenu2));;
         
    	
    	StringBuffer sb = new StringBuffer( );

        sb.append( "Cliente: " + pedido1C + "\n" );
        sb.append( "Dirección: " + pedido1D + "\n" );
        sb.append( "----------------\n" );

        for( Producto item : productos )
        {
            sb.append( item.generarTextoFactura( ) );
        }

        sb.append( "----------------\n" );
        sb.append( "Precio Neto:  " + precio1+ "\n" );
        sb.append( "IVA:          " + precioIVA1+ "\n" );
        sb.append( "Precio Total: " + precioTotal1);

        String stringPrueba=sb.toString( );
        
        pedido1.guardarFactura(archivoFactura);
        String stringComparar = leerArchivoComoString(archivoFactura);
    	
        assertEquals(stringPrueba,stringComparar);
    	
    }
    
}