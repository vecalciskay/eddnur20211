package arboles.aritmetico;

import arboles.Identificable;

public abstract class ElementoAritmetico implements Identificable {


	@Override
	public String getId() {
		return String.valueOf(this.hashCode());
	}
}
