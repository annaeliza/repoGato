package br.senai.sc.tii2014.n1.anna.cadastrogatos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senai.sc.tii2014.n1.anna.cadastrogatos.model.entity.Gato;

public class GatoDao extends Dao {
	
	
	private final String INSERT = "INSERT INTO gatos (nome, raca) values (?, ?)";
	private final String UPDATE = "UPDATE gatos SET nome=?, raca=? WHERE id=?";
	private final String DELETE = "DELETE FROM gatos WHERE id=?";
	private final String SELECT = "SELECT * FROM gatos";
	private final String SELECT_ID = "SELECT * FROM gatos WHERE id=?";
	
	public void salvar(Gato gato) throws Exception{
		if(gato.getId() == 0){
			inserir(gato);
		} else {
			alterar(gato);
		}
		
	}

	private void inserir(Gato gato) throws Exception {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, gato.getNome());
			ps.setString(2, gato.getRaca());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar cadastrar seu gato.");
		}
	}
	
	private void alterar(Gato gato){
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, gato.getNome());
			ps.setString(2, gato.getRaca());
			ps.setLong(3, gato.getId());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o update" + e);
		}
	}
	
	public void excluir (Long id) throws Exception{
		try {
			PreparedStatement ps = getConnection().prepareStatement(DELETE);
			ps.setLong(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o delete" + e);
			throw new Exception("Erro ao tentar excluir.");
		}
	}
	
	public List<Gato> listarTodos(){
		List<Gato> gatos = new ArrayList<Gato>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Gato gato = new Gato();
				gato.setNome(rs.getString("nome"));
				gato.setRaca(rs.getString("raca"));
				gato.setId(rs.getLong("id"));
				gatos.add(gato);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de gatos" + e);
		}
		return gatos;
	}
			
	public Gato buscaPorId(Long id){
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Gato gato = new Gato();
				gato.setNome(rs.getString("nome"));
				gato.setRaca(rs.getString("raca"));
				gato.setId(rs.getLong("id"));
				return gato;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de gatos." + e);
		}
		return null;
	}
			
			
			
}
