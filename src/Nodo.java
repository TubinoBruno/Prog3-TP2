
public class Nodo {
	private Integer info;
	private Nodo hd;
	private Nodo hi;

	public Nodo() {
		info = null;
		hd = null;
		hi = null;
	}

	public Nodo(Integer o) {
		setInfo(o);
		hi = null;
		hd = null;
	}
	public void setInfo(Integer o) {
		info = o;
	}

	public void setIzq(Nodo n) {
		this.hi = n;
	}

	public void setDer(Nodo n) {
		this.hd = n;
	}
	public Integer getInfo() {
		return info;
	}
	public Nodo getDer() {
		return hd;
	}
	public Nodo getIzq() {
		return hi;
	}
	public boolean noChilds(){
		return hi == null && hd == null; 
	}

	public boolean hasAChild() {
		if(hi == null){
			return hd != null;
		}
		return hd == null;
	}

	public Nodo getAChild() {
		if(hi != null){
			return hi;
		}
		return hd;
	}
}