package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShannonFano {

	public void entropiaPeorCaso(double cantidadCaracteres)
	{
		double peroCaso2 = Math.log(cantidadCaracteres)/Math.log(2);
		System.out.println("\t" + peroCaso2);
	}

	public void calcularCodigos(ArrayList<CaracterProbabilidad> lista)
	{
		Collections.sort(lista, new CaracterProbabilidadComparator().reversed());
		ArrayList<Integer> arregloLongitudes = new ArrayList<Integer>(lista.size());
		for (int i = 0; i < lista.size(); i++) 
		{
			double longitudN = Math.log((double) 1 / (double) lista.get(i).getProbabilidad()) / Math.log(2);
			Integer longitudRoof = (int) Math.ceil(longitudN);
			arregloLongitudes.add(longitudRoof);
		}

		ArrayList<String> bsf = new ArrayList<String>();
		if(arregloLongitudes.get(0) != null) 
		{
			bsf.add(aBinario(0, arregloLongitudes.get(0)));
		}
		for (int i = 1; i < arregloLongitudes.size(); i++) 
		{
			int di = arregloLongitudes.get(i) - arregloLongitudes.get(i-1);
			int temporal = (int) ((Integer.parseInt(bsf.get(i-1),2) + 1) * Math.pow(2, di));
			bsf.add(aBinario(temporal, arregloLongitudes.get(i)));
		}
		int totalBits = 0;
		for (int i = 0; i < bsf.size(); i++)
		{
			totalBits+= arregloLongitudes.get(i) * lista.get(i).getCantidad();
			String car = lista.get(i).getCaracter().equals("\n")?"\\n" : ""+lista.get(i).getCaracter();

			System.out.println("\t Caracter: '" + car 
					+ "' - Probabilidad: "+ lista.get(i).getProbabilidad() 
					+ " - T. Shannon: " + arregloLongitudes.get(i) 
					+ " - Codigo Bsf: " + bsf.get(i));
		}

		System.out.println("------------------------ Datos adicionales -------------------------");
		System.out.println("Entropia en el peor caso: ");
		entropiaPeorCaso(lista.size());
		System.out.println("Numero total de bits requeridos: ");
		System.out.println( "\t" + totalBits);
	}
	public void SF(ArrayList<CaracterProbabilidad> lista)
	{
		System.out.println("--------------------------------------------------------------------");
		System.out.println("------------------------ Shannon-Fano ------------------------------");
		System.out.println("---------------Calculo de codigos para compresión-------------------");
		calcularCodigos(lista);

	}

	public String aBinario(int num, int cantidadBits) 
	{
		int [] binary = new int[cantidadBits];
		int id = 0;
		while (num > 0) {
			binary[id++] = num % 2;
			num = num / 2;
		}
		String retorno ="";
		for (int i = binary.length-1; i >= 0; i--)
			retorno+=binary[i]+"";
		return retorno;
	}
}

