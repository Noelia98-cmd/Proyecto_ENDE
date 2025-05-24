package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tralala.Cancion;
import tralala.Usuario;

public class CancionTest {

    private Usuario usuario;
    private Cancion cancion1;
    private Cancion cancion2;
    private Cancion cancion3;
//Inicio test
    @BeforeEach
    void setUp() {
        cancion1 = new Cancion("Canción 1");
        cancion2 = new Cancion("Canción 2");
        cancion3 = new Cancion("Canción 3");

        usuario = new Usuario();
        usuario.setPuntos(0);
        usuario.getCancionesFavoritas().clear();
        usuario.getColeccionPermanente().clear();
    }
//Test no tiene puntos
    @Test
    void testNoTienePuntosSuficientes() {
        usuario.setPuntos(80);
        usuario.getCancionesFavoritas().add(cancion1);

        Cancion.canjearCanciones(usuario);

        assertEquals(80, usuario.getPuntos());
        assertTrue(usuario.getCancionesFavoritas().contains(cancion1));
        assertTrue(usuario.getColeccionPermanente().isEmpty());
    }

    @Test
    void testCanjearUnaCancion() {
        usuario.setPuntos(100);
        usuario.getCancionesFavoritas().add(cancion1);

        Cancion.canjearCanciones(usuario);

        assertEquals(0, usuario.getPuntos());
        assertTrue(usuario.getColeccionPermanente().contains(cancion1));
        assertFalse(usuario.getCancionesFavoritas().contains(cancion1));
    }

    @Test
    void testCanjearMultiplesCanciones() {
        usuario.setPuntos(300);
        usuario.getCancionesFavoritas().add(cancion1);
        usuario.getCancionesFavoritas().add(cancion2);
        usuario.getCancionesFavoritas().add(cancion3);

        Cancion.canjearCanciones(usuario);

        assertEquals(0, usuario.getPuntos());
        assertTrue(usuario.getColeccionPermanente().contains(cancion1));
        assertTrue(usuario.getColeccionPermanente().contains(cancion2));
        assertTrue(usuario.getColeccionPermanente().contains(cancion3));
        assertTrue(usuario.getCancionesFavoritas().isEmpty());
    }

    @Test
    void testTienePuntosPeroNoFavoritas() {
        usuario.setPuntos(200);
        // No hay canciones favoritas

        Cancion.canjearCanciones(usuario);

        assertEquals(200, usuario.getPuntos());
        assertTrue(usuario.getColeccionPermanente().isEmpty());
        assertTrue(usuario.getCancionesFavoritas().isEmpty());
    }

    @Test
    void testCancionYaFueCanjeadaNoSeDuplica() {
        usuario.setPuntos(200);
        usuario.getCancionesFavoritas().add(cancion1);
        usuario.getColeccionPermanente().add(cancion1); // ya está

        Cancion.canjearCanciones(usuario);

        assertEquals(200, usuario.getPuntos()); // No se canjeó nada
        assertEquals(1, usuario.getColeccionPermanente().stream().filter(c -> c == cancion1).count());
        assertFalse(usuario.getCancionesFavoritas().contains(cancion1)); // debe eliminarse de favoritas
    }

}

