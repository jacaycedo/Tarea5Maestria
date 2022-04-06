package main;

import java.util.Comparator;

public class CaracterProbabilidadComparator implements Comparator<CaracterProbabilidad>
{
	@Override
	public int compare(CaracterProbabilidad a, CaracterProbabilidad b) {
		return a.getProbabilidad()<b.getProbabilidad()? -1 : a.getProbabilidad() == b.getProbabilidad()? 0 :1;
	}

}
