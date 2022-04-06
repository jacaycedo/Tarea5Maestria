package main;

public class CaracterProbabilidad {

	private String caracter;
	private double probabilidad;
	private int cantidad; 

	public CaracterProbabilidad(String caracter, double probabilidad, int cantidad)
	{
		this.caracter = caracter;
		this.probabilidad = probabilidad;
		this.cantidad = cantidad;
	}

	public int getCantidad()
	{
		return cantidad;
	}
	public void setCantidad( int cantidad )
	{
		this.cantidad = cantidad;
	}
	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(double probabilidad) {
		this.probabilidad = probabilidad;
	}


}
