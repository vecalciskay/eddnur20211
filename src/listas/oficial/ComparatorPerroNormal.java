package listas.oficial;

import java.util.Comparator;

public class ComparatorPerroNormal implements Comparator<Perro> {

	@Override
	public int compare(Perro o1, Perro o2) {
		if (o2.getNombre().equals(o1.getNombre())) {
			if (o2.getEdad() == o1.getEdad())
				return 0;
			
			if (o2.getEdad() < o1.getEdad())
				return -1;
			
			if (o2.getEdad() > o1.getEdad())
				return 1;
		} 

		return o2.getNombre().compareTo(o1.getNombre());
	}

}
