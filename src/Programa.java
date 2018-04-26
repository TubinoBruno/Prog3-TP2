import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		ArbolBusquedaBinaria arbol = new ArbolBusquedaBinaria();

		arbol.insertar(15);
		arbol.insertar(6);
		arbol.insertar(18);
		arbol.insertar(17);
		arbol.insertar(20);
		arbol.insertar(7);
		arbol.insertar(3);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(13);
		arbol.insertar(9);

		List<Integer> inOrder = arbol.inOrder();
		List<Integer> posOrder = arbol.posOrder();
		List<Integer> preOrder = arbol.preOrder();
		System.out.println("En orden:");
		for(int i = 0 ; i<inOrder.size() ; i++) {
			System.out.print(inOrder.get(i) + "\t");
		}
		System.out.println("En orden:");
		for(int i = 0 ; i<inOrder.size() ; i++) {
			System.out.print(inOrder.get(i) + "\t");
		}
		System.out.println(arbol.getMaxElem().getInfo());
		
		
		
	}

}
	
	