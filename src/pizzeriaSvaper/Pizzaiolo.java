package pizzeriaSvaper;

import pizzeriaSvaper.ListaPizza;

public class Pizzaiolo extends Thread {
	
	private ListaPizza l;
	private String name;
	private boolean libero = true;
	private Grafica g;
	
	
	public Pizzaiolo(ListaPizza l, String name, Grafica g){
		this.g = g;
		this.l = l;
		this.name = name;
	}
	
	public String getNameP(){
		return name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			String pizza = l.pizzaInLista();
			
			// prepara la pizza
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			l.pizzaPronta(pizza);
			/*
			if(l.pizzaInLista()){
				System.out.println("Pizza in cottura");
				synchronized(l){
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				l.preparoPizza();
			} else {
				System.out.println("Non ci sono le pizze");
				synchronized(l){
					try {
						l.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Arrivata la pizza");
			}*/
		}
	}

	
}