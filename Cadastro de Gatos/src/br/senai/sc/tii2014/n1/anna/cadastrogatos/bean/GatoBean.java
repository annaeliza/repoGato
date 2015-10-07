package br.senai.sc.tii2014.n1.anna.cadastrogatos.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.tii2014.n1.anna.cadastrogatos.model.GatoRn;
import br.senai.sc.tii2014.n1.anna.cadastrogatos.model.entity.Gato;

@ManagedBean
public class GatoBean {
	
	private List<Gato> gatos;
	private Gato gato;
	private GatoRn rn;
	
	@PostConstruct
	public void init(){
		rn = new GatoRn();
		gato = new Gato();
	}
	
	public List<Gato> getGatos(){
		if(gatos == null){
			gatos = rn.Listar();
		}
		return gatos;
	}
	public void setGatos(List<Gato> gatos){
		this.gatos = gatos;		
	}

	public Gato getGato() {
		return gato;
	}

	public void setGato(Gato gato) {
		this.gato = gato;
	}
	
	public String salvar(){
		try {
			rn.salvar(gato);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} 
		return "listarGatos";
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		try {
			rn.excluir(id);
			gatos = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.parseLong(idParam);
		gato = rn.buscarPorId(id);
		return "cadastroGatos";
	}
	

}
