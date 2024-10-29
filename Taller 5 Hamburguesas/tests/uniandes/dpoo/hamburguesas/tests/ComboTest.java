package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ComboTest {
	private Combo combo1;

    @BeforeEach
    void setUp() throws Exception {
        
    	String nombreCombo1="Chupamesta";
    	double descuento1= 0.90;
    	ProductoMenu productoMenu1 = new ProductoMenu("hamburguesa", 10000);
    	ProductoMenu productoMenu2 = new ProductoMenu("papas", 7000);
    	
    	ArrayList listaProductos1 = new ArrayList<>();
    	
    	listaProductos1.add(productoMenu1);
    	listaProductos1.add(productoMenu2);
    	
    	combo1= new Combo(nombreCombo1,descuento1,listaProductos1);    
    	}

    @Test
    void testGetNombre() {
        assertEquals("Chupamesta", combo1.getNombre());
    }
    @Test
    void testGetPrecio() {
        assertEquals(15300, combo1.getPrecio());
    }
    @Test
    void testGenerarTextoFactura() {
        
    	String stringPrueba ="Combo Chupamesta\n"
    			+ " Descuento: 0.9\n"
    			+ "            15300"+"\n";
    	
    	assertEquals(stringPrueba, combo1.generarTextoFactura());
    }
}
