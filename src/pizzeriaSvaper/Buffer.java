package pizzeriaSvaper;

public class Buffer{
	ListaPizza l;
	Pizzaiolo a;
	Pizzaiolo b;
	Grafica g;
	
	public Buffer (ListaPizza l, Pizzaiolo a, Pizzaiolo b, Grafica g){
		this.l = l;
		this.a = a;
		this.b = b;
		this.g = g;
	}
	
	public void pizzaFinita(){
		
	}
	
	public void setPizza(String pizza){
		l.ordinaPizza(pizza);
	}
	
	public void setListaPizza(ListaPizza l){
		this.l = l;
	}
	
	public void run(){
	}
}
