package br.senai.sc.tii2014.n1.anna.cadastrogatos.model;

import java.util.List;

import br.senai.sc.tii2014.n1.anna.cadastrogatos.dao.GatoDao;
import br.senai.sc.tii2014.n1.anna.cadastrogatos.model.entity.Gato;



public class GatoRn {

	private GatoDao dao;
	
	public GatoRn() {
		dao = new GatoDao();
	}
	
	public void salvar(Gato gato) throws Exception{
		if(gato.getNome().trim().isEmpty()){
			throw new Exception("O nome do gato � obrigat�rio.");
		}
		if (gato.getRaca().trim().isEmpty()){
			throw new Exception("A ra�a do gato � obrigat�ria.");
		}
		dao.salvar(gato);
	}
	
	public List<Gato> Listar(){
		return dao.listarTodos();
	}

	public Gato buscarPorId(Long id){
		return dao.buscaPorId(id);
	}
	
	public void excluir(Long id) throws Exception{
		dao.excluir(id);
	}
}
