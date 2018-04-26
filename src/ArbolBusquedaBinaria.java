import java.util.ArrayList;
import java.util.List;

public class ArbolBusquedaBinaria {
	private Nodo raiz;

	public ArbolBusquedaBinaria() {
		this.raiz = new Nodo();
	}

	public ArbolBusquedaBinaria(Integer _o) {
		this.raiz.setInfo(_o);
	} 

	public Object getRoot() {
		return this.raiz.getInfo();
	}
	public boolean esVacio(){
		return (raiz==null);
	}

	public boolean insertar( Integer o) {
		return insertar(this.raiz, o);
	}


	public boolean insertar(Nodo _n, Integer _o) {
		if(_n != null) {
			if(_n.getInfo() != null) {
				if(_n.getInfo().equals(_o)) {
					return false;
				}
				else if(_o.compareTo(_n.getInfo()) < 0) {
					if(_n.getIzq() == null) {
						_n.setIzq(new Nodo(_o));
						return true;
					}
					else {
						return insertar(_n.getIzq(), _o);
					}
				}
				else {
					if(_n.getDer() == null) {
						_n.setDer(new Nodo(_o));
						return true;
					}
					else {
						return insertar(_n.getDer(), _o);
					}
				}
			}
			else {
				_n.setInfo(_o);
				return true;
			}
		}
		else {
			_n = new Nodo(_o);
			return true;
		}
	}

	public boolean hasElement(Integer _o) {
		return this.hasElement(this.raiz, _o);
	}

	public boolean hasElement(Nodo _n, Integer _o) {
		if (_n != null) {
			if(_n.getInfo().equals(_o)) {
				return true;
			}
			else if (_o.compareTo(_n.getInfo()) < 0) {
				return hasElement(_n.getIzq(), _o);
			}
			else {
				return hasElement(_n.getDer(), _o);
			}
		}

		return false;
	}

	public List<Integer> preOrder() {
		return preOrder(this.raiz);
	}

	private List<Integer> preOrder(Nodo _n) {
		List <Integer> retorno = new ArrayList<Integer>();

		if(_n.getInfo() != null) {
			retorno.add(_n.getInfo());
			if(_n.getIzq() != null) {
				retorno.addAll(preOrder(_n.getIzq()));
			}
			if(_n.getDer() != null) {
				retorno.addAll(preOrder(_n.getDer()));
			}
			return retorno;
		}
		return null;
	}

	public List<Integer> posOrder(){
		return posOrder(this.raiz);
	}

	private List<Integer> posOrder(Nodo _n){
		List<Integer> retorno = new ArrayList<Integer>();

		if(_n.getInfo() != null) {
			if(_n.getIzq() != null) {
				retorno.addAll(posOrder(_n.getIzq()));
			}
			if(_n.getDer() != null) {
				retorno.addAll(posOrder(_n.getDer()));
			}
			retorno.add(_n.getInfo());

			return retorno;
		}

		return null;
	}

	public List<Integer> inOrder(){
		return inOrder(this.raiz);
	}

	private List<Integer> inOrder(Nodo _n){
		List<Integer> retorno = new ArrayList<Integer>();

		if(_n.getInfo() != null) {
			if(_n.getIzq() != null) {
				retorno.addAll(inOrder(_n.getIzq()));
			}

			retorno.add(_n.getInfo());

			if(_n.getDer() != null) {
				retorno.addAll(inOrder(_n.getDer()));
			}

			return retorno;
		}

		return null;
	}
	public boolean delete(int elem){

		int infoRaiz = raiz.getInfo();

		if(hasElement(elem)){
			if(infoRaiz == elem){
				raiz = null;
				System.out.println("aa");

				return true;
			}
			return delete(raiz, elem);
		}
		return false;
	}
	public Nodo getMaxElem() {

		if(!esVacio()){
			return getMaxElem(raiz); 
		}
		return null;
	}

	private Nodo getMaxElem(Nodo currentNode) {

		if(currentNode.getDer() != null){
			return getMaxElem(currentNode.getDer());
		}
		return currentNode;
	}
	private boolean delete(Nodo n, Integer elem) {

		Nodo der = n.getIzq();
		Nodo izq = n.getDer();

		if(n.getInfo() > elem){
			if(izq.getInfo() == elem){
				n.setIzq(removeNodo(izq));	
				return true;
			}
			else{
				return delete(izq, elem);
			}
		}
		else{
			if(der.getInfo() == elem){
				n.setDer(removeNodo(der));
				return true;
			}
			else{
				return delete(der, elem);				
			}
		}

	}
	private Nodo removeNodo(Nodo targetNode) {
		if(targetNode.noChilds()){
			return null;
		}
		if(targetNode.hasAChild()){
			return targetNode.getAChild();
		}
		Nodo nmi = getNodoMayorIzquierdo(targetNode.getIzq());
		delete(targetNode, nmi.getInfo());
		nmi.setIzq(targetNode.getIzq());
		nmi.setDer(targetNode.getDer());
		return nmi;
	}
	private Nodo getNodoMayorIzquierdo(Nodo node) {

		if(node.getDer() == null){
			return node;
		}
		return getNodoMayorIzquierdo(node.getDer());
	}


}
