package tralala;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cancion {

    public Cancion(String titulo) {
        super();
        this.titulo = titulo;
    }

    private String titulo;
    private String nombreArtistaoGrupo;
    private int duracion;
    private int fecha;
    private int precio;
    private String letra;
    private String URL;
    public Recomendacion recomendacion;

    public void registrarReproduccion() {
    }

    public static void canjearCanciones(Usuario usuario) {
        if (usuario.getPuntos() < 100) {
            System.out.println("No tienes suficientes puntos");
            return;
        }

        List<Cancion> favoritas = new ArrayList<>(usuario.getCancionesFavoritas());
        int maxCanciones = usuario.getPuntos() / 100;
        List<Cancion> cancionesACanjear = new ArrayList<>();

        while (cancionesACanjear.size() < maxCanciones && !favoritas.isEmpty()) {
            Cancion cancion = seleccionarCancion(favoritas);

            // Solo si no está ya en la colección
            if (!usuario.getColeccionPermanente().contains(cancion)) {
                cancionesACanjear.add(cancion);
                usuario.getColeccionPermanente().add(cancion);
                usuario.setPuntos(usuario.getPuntos() - 100);
            }

            // Siempre eliminamos de favoritas (aunque no se haya canjeado)
            usuario.getCancionesFavoritas().remove(cancion);
            favoritas.remove(cancion);
        }

        System.out.println(cancionesACanjear.size() + " canciones añadidas a tu colección permanente.");
    }


    public static Cancion seleccionarCancion(List<Cancion> disponibles) {
        return disponibles.get(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cancion cancion = (Cancion) obj;
        System.out.println("HOLA Y ADIOS");
        return titulo != null && titulo.equals(cancion.titulo);
    }

    @Override
    public int hashCode() {
        return titulo != null ? titulo.hashCode() : 0;
    }

    
    
    
}

