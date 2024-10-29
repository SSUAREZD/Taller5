package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class ProductoMenuTest {

    private ProductoMenu productoMenu1;

    @BeforeEach
    void setUp() throws Exception {
        productoMenu1 = new ProductoMenu("hamburguesa", 10000);
    }

    @Test
    void testGetNombre() {
        assertEquals("hamburguesa", productoMenu1.getNombre());
    }
    @Test
    void testGetPrecio() {
        assertEquals(10000, productoMenu1.getPrecio());
    }
    @Test
    void testGenerarTextoFactura() {
        
    	String stringPrueba ="hamburguesa\n"
    			+ "            10000"+"\n"; 
    	
    	assertEquals(stringPrueba, productoMenu1.generarTextoFactura());
    }
}