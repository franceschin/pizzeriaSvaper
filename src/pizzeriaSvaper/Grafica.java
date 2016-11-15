package pizzeriaSvaper;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;

public class Grafica {

	protected Shell shell;

	private static List pizzeInCoda; 
	private static List pizzePronte; 
	private ListaPizza listaPizza;
	int NumeroPizze = 0;
	Pizzaiolo a;
	Pizzaiolo b;
	Grafica questa;
	Buffer bf;
	

	//Thread t1 = new Thread(p1);
	
	
	
	public static void main(String[] args) {
		try {
			Grafica window = new Grafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void open() {
		questa = this;
		listaPizza = new ListaPizza(this);
		a = new Pizzaiolo(listaPizza, "bubu", questa);
		b = new Pizzaiolo(listaPizza, "yoghi", questa);
		bf = new Buffer(listaPizza, a, b, questa);
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void setPizzeInCoda(String elemento) {
		pizzeInCoda.add(elemento);
		pizzeInCoda.update();
		bf.setPizza(elemento);
	}
	
	public List getPizzeInCoda() {
		return pizzeInCoda;
	}
	
	public void pizzaPronto(){
		
	}

	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(128, 0, 0));
		shell.setSize(561, 324);
		shell.setText("Pizzeria Svaper");
		Button btnApriPizzeria = new Button(shell, SWT.NONE);
		btnApriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a.start();
				b.start();
				System.out.println("Ciao sono "+a.getNameP());
				System.out.println("Ciao sono "+b.getNameP());
				/*t2.start();
				System.out.println("Ciao sono   il pizzaiolo 2");
				*/			
				
			}
		});
		
		pizzePronte = new List(shell, SWT.BORDER);
		pizzePronte.setBounds(194, 133, 144, 119);
		
		pizzeInCoda = new List(shell, SWT.BORDER);
		pizzeInCoda.setBounds(10, 133, 148, 119);
		
		btnApriPizzeria.setBounds(10, 38, 148, 56);
		btnApriPizzeria.setText("Apri Pizzeria");
		
		Button btnChiudiPizzeria = new Button(shell, SWT.NONE);
		btnChiudiPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a.stop();
				b.stop();
				System.out.println("Ho sarà bottega");				
			}
		});
		btnChiudiPizzeria.setBounds(194, 38, 144, 56);
		btnChiudiPizzeria.setText("Chiudi Pizzeria");
		
		Button btnArrivaUnCliente = new Button(shell, SWT.NONE);
		btnArrivaUnCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GraficaUtente gu = new GraficaUtente();
				//System.out.println(listaPizza);
				gu.setListaPizza(listaPizza, questa);
				gu.open();
				
				//richiamo l'interfaccia utente per inserire la pizza desiderata
				
				
				
			}
		});
		btnArrivaUnCliente.setBounds(361, 38, 149, 56);
		btnArrivaUnCliente.setText("Arriva un Cliente");
	
		
		Label lblPizze = new Label(shell, SWT.NONE);
		lblPizze.setBounds(46, 112, 68, 15);
		lblPizze.setText("Pizze in coda");
		
		
		
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		lblPizzePronte.setBounds(222, 112, 68, 15);
		lblPizzePronte.setText("Pizze pronte");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Grafica.class, "/pizzeriaSvaper/pizzeria.jpg"));
		lblNewLabel.setBounds(387, 133, 123, 119);
		
		
		listaPizza = new ListaPizza(this);

		
	}


	public void spostaPizza(String pizza) {
		Display.getDefault().asyncExec(new Runnable() {
            public void run() {
            	pizzeInCoda.remove(pizza);
        		pizzePronte.add(pizza);
            }
		 });
		
		
	}
}
