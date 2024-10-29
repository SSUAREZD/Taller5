package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

class RestauranteTest {

	
	static Restaurante restaurante;
	static File archivoMenu;
	static File archivoCombos;
	static File archivoIngredientes;
	
	
	@BeforeAll
    static void setUp() throws NumberFormatException, HamburguesaException, IOException {
    	restaurante = new Restaurante();
    	archivoMenu= new File("data/menu.txt");
		archivoCombos= new File("data/combos.txt");
		archivoIngredientes= new File("data/ingredientes.txt");
		restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
	}
		
	
	@Test
	void testCargarInformacionRestauranteExceptions() throws NumberFormatException, HamburguesaException, IOException {
	    File archivoIngredientesError = new File("data/ingredientesError.txt");
	    File archivoMenuError = new File("data/menuError.txt");
	    File archivoCombosErrorRepetido = new File("data/combosErrorR.txt");
	    File archivoCombosErrorFaltante = new File("data/combosErrorF.txt");

	    // 1. Probar excepción de ingrediente repetido
	    try {
	        restaurante.cargarInformacionRestaurante(archivoIngredientesError, archivoMenu, archivoCombos);
	        System.out.println("Error: No se lanzó excepción de ingrediente repetido cuando debía.");
	    } catch (IngredienteRepetidoException excepcionI) {
	        System.out.println("Excepción de ingrediente repetido lanzada exitosamente");
	    }
	    // 2. Probar excepción en el menú
	    try {
	        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenuError, archivoCombos);
	        System.out.println("Error: No se lanzó excepción de producto repetido cuando debía.");
	    } catch (ProductoRepetidoException excepcionM) {
	        System.out.println("Excepción de producto repetido lanzada exitosamente");
	    } catch (IngredienteRepetidoException excepcionM) {
	        System.out.println("Excepción de ingrediente repetido lanzada exitosamente en menu");
	    }
	    // 3. Probar excepción de combos repetidos
	    try {
	        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombosErrorRepetido);
	        System.out.println("Error: No se lanzó excepción de combo repetido cuando debía.");
	    } catch (ProductoRepetidoException excepcionCombo) {
	        System.out.println("Excepción de combo repetido lanzada exitosamente");
	    } catch (IngredienteRepetidoException excepcionM) {
	        System.out.println("Excepción de ingrediente repetido lanzada exitosamente en combo");
	    }
			
	 }
			
			
		
}


