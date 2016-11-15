package pizzeriaSvaper;

import java.util.ArrayList;

public class ListaPizza {
	public int pizza;
	Grafica g;

	ArrayList<String> l = new ArrayList<String>();

	public ListaPizza(Grafica g) {
		this.g = g;
	}

	public synchronized String pizzaInLista() {
		while (l.size() == 0) {
			System.out.println("Non ho pizze da fare");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String pizza = l.remove(0);
		;
		notifyAll();
		return pizza;
	}

	public synchronized void pizzaPronta(String pizza) {
		// l.remove(0);
		// System.out.println("Pizza pronta");
		g.spostaPizza(pizza);
		notifyAll();
	}

	public synchronized void ordinaPizza(String p) {
		l.add(p);
		System.out.println("pizza ordinata " + p);
		notifyAll();
	}

}
