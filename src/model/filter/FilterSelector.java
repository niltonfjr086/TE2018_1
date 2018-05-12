package model.filter;

import java.lang.reflect.Field;

public class FilterSelector<T> {
	
	private T t;
	
	private int limite;
	private int pagina;
	
	
	public FilterSelector(T t, int limite, int pagina) {
		super();
		this.t = t;
		this.limite = limite;
		this.pagina = pagina;
	}

	public boolean withFilter() {
		
		
		Class<? extends Object> c = this.t.getClass();
		String s = c.getSimpleName();
		
		Field[] fields = c.getDeclaredFields();
		
		for(Field f : fields) {
			System.out.println(f.getName());
		}
		
//		if (this.idProduto > 0) {
//			return true;
//		}
//		if ((this.nomeProduto != null) && (this.nomeProduto.trim().length() > 0)) {
//			return true;
//		}
//		if (this.dataInicioCadastro != null) {
//			return true;
//		}
//		if (this.dataFimCadastro != null) {
//			return true;
//		}
		return false;
	}
}
