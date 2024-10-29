package uniandes.dpoo.hamburguesas.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoAjustadoTest {

    private ProductoAjustado productoAjustado1;
    private ProductoAjustado productoAjustado2;
    @BeforeEach
    void setUp() throws Exception {
        Ingrediente ketchup = new Ingrediente("ketchup", 1000);
        Ingrediente moztaza = new Ingrediente("moztaza", 1000);
        Ingrediente cebolla = new Ingrediente("cebolla", 2000);
        Ingrediente pepinillos = new Ingrediente("pepinillos", 1500);
        Ingrediente queso = new Ingrediente("queso", 5000);
        
        //Le hace falta a producto ajustado un metodo para agregar/eliminar ingrdientes
        
        ProductoMenu productoMenu1 = new ProductoMenu("hamburguesa", 10000);
        ProductoMenu productoMenu2 = new ProductoMenu("hotdog", 10000);
        
        productoAjustado1 = new ProductoAjustado(productoMenu1);
        productoAjustado2 = new ProductoAjustado(productoMenu2);
       
    }

    @Test
    void testgetPrecio() {
        assertEquals("10000", productoAjustado1.getPrecio());
        assertEquals("10000", productoAjustado2.getPrecio());
    }

    @Test
    void testgetNombre() {
        assertEquals("hamburguesa", productoAjustado1.getNombre());
        assertEquals("hotdog", productoAjustado2.getNombre());
    }
    @Test
    void testGenerarTextoFactura() {
        String stringPrueba1="hamburguesa            10000";
        String stringPrueba2="hotdog           10000";
        assertEquals(stringPrueba1, productoAjustado1.generarTextoFactura(),"No se crea la factura correctamente del producto ajustado");
        assertEquals(stringPrueba2, productoAjustado1.generarTextoFactura(),"No se crea la factura correctamente del producto ajustado");
        
    }


}