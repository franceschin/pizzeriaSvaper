package pizzeriaSvaper;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GraficaUtente {

	protected Shell shell;
	private Text insNome;
	private Text insPizza;
	private ListaPizza l;
	Grafica g;
	
	
	void setListaPizza(ListaPizza lp, Grafica g) {
		this.l = lp;
		this.g = g;
	}
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GraficaUtente window = new GraficaUtente();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(442, 225);
		shell.setText("Cliente");
		l = new ListaPizza(g);
		
		Label lblInserisciNome = new Label(shell, SWT.NONE);
		lblInserisciNome.setBounds(91, 21, 99, 15);
		lblInserisciNome.setText("INSERISCI NOME:");
		
		insNome = new Text(shell, SWT.BORDER);
		insNome.setBounds(184, 15, 133, 21);
		
		Label lblInserisciPizza = new Label(shell, SWT.NONE);
		lblInserisciPizza.setBounds(91, 71, 99, 15);
		lblInserisciPizza.setText("INSERISCI PIZZA:");
		
		insPizza = new Text(shell, SWT.BORDER);
		insPizza.setBounds(184, 65, 133, 21);
		
		
		Button btnConferma = new Button(shell, SWT.NONE);
		btnConferma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String stringa = insPizza.getText();
				g.setPizzeInCoda(stringa);
			}
		});
		btnConferma.setBounds(137, 135, 133, 53);
		btnConferma.setText("CONFERMA");
	}

}
