package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Principal {

	public static void main(String[] args)
	{
		String contenido = "";

		try (BufferedReader br = new BufferedReader( new FileReader( new File(args[0]))))
		{
			String temp = br.readLine();
			contenido += temp;
			while((temp = br.readLine()) != null )
			{
				contenido += "\n"+temp;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Para la cadena:\n'" + contenido +"'\nSe calcula: "  );
		char arr[] = contenido.toCharArray();
		Arrays.sort(arr);
		String ordenado = String.valueOf(arr);
		ArrayList<Character> caracteres = new ArrayList<Character>();
		ArrayList<Integer> numeroCaracteres = new ArrayList<Integer>();
		ArrayList<CaracterProbabilidad> listaCompleta = new ArrayList<CaracterProbabilidad>();

		char contado = ordenado.charAt(0);
		caracteres.add(contado);
		numeroCaracteres.add(1);
		int totalCaracteres = 1;
		int indiceLista = 0;
		for (int i = 1; i < ordenado.length(); i++) 
		{
			char actual = ordenado.charAt(i);
			if( actual != contado)
			{
				caracteres.add(actual);
				contado = actual;
				numeroCaracteres.add(1);
				indiceLista++;
				totalCaracteres++;
			}
			else
			{
				int cantidad = numeroCaracteres.get(indiceLista);
				numeroCaracteres.set(indiceLista, ++cantidad);
				totalCaracteres++;
			}
		}	

		System.out.println("Distribucion de caracteres en la cadena de texto:");
		for (int i = 0; i < caracteres.size(); i++)
		{
			String chara = caracteres.get(i) + "";
			double proba = (double)numeroCaracteres.get(i)/(double)totalCaracteres;
			CaracterProbabilidad cp = new CaracterProbabilidad(chara, proba, numeroCaracteres.get(i));
			listaCompleta.add(cp);
		}

		for (int i = 0; i < listaCompleta.size(); i++) 
		{
			String x = listaCompleta.get(i).getCaracter().equals("\n")?"\\n" : ""+listaCompleta.get(i).getCaracter();

			System.out.println("\t Caracter '" + x
					+ "' aparece " + numeroCaracteres.get(i) + " veces. P(" 
					+ (double)(listaCompleta.get(i).getProbabilidad() )+ ")");
		}
		ShannonFano shannonFano = new ShannonFano();
		shannonFano.SF(listaCompleta);
	}

}
