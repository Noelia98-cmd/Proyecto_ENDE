package tralala;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;

    private String contraseña;

    private String email;

    private String listaAmigos;

    private Cancion[] listaFavoritos;

    private Cancion[] listaPermanente;

    private int puntos;

    public ArrayList<MetodosPago> asocia = new ArrayList<MetodosPago> ();

    public ArrayList<Cancion> favoritas = new ArrayList<Cancion> ();

    public ArrayList<Cancion> permanente = new ArrayList<Cancion> ();

    public void registrarse() {
    }

    public void añadirMetodoPago() {
    }

    public void añadirCancionFavorita() {
    }

    public void recomendarCancion() {
    }

    public void quitarCancion() {
    }

    public void verPuntos() {
    }

    public void reproducirCancionRecomendada() {
    }

    public void canjearPuntos() {
    }

    public void añadirAmigo() {
    }

    public void iniciarSesion() {
    }

    public void reproducirCancion() {
    }

	public int getPuntos() {
		// TODO Auto-generated method stub
		return puntos;
	}
	
	public ArrayList<Cancion> getCancionesFavoritas() {
		// TODO Auto-generated method stub
		return favoritas;
	}

	public List<Cancion> getColeccionPermanente() {
		// TODO Auto-generated method stub
		return permanente;
	}

	public void setPuntos(int i) {
		// TODO Auto-generated method stub
		this.puntos=i;
	}

	public void setFavoritas(ArrayList<Cancion> favoritas) {
		this.favoritas = favoritas;
	}
}
