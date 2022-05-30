package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entity.Jogo;

@ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private List<Jogo> listar;
	private List<Integer> v = new ArrayList<Integer>();
	Random aleatorio = new Random();

	public String salvar() {
		try {
			jogo.setV1(aleatorio.nextInt(30));
			jogo.setV2(aleatorio.nextInt(30));
			jogo.setV3(aleatorio.nextInt(30));
			jogo.setV4(aleatorio.nextInt(30));
			jogo.setV5(aleatorio.nextInt(30));
			jogo.setV6(aleatorio.nextInt(30));
			jogo.setV7(aleatorio.nextInt(30));
			jogo.setV8(aleatorio.nextInt(30));
			jogo.setV9(aleatorio.nextInt(30));
			jogo.setV10(aleatorio.nextInt(30));
			JogoDAO.salvar(jogo);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro realizado com sucesso."));
			jogo = new Jogo();
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", "Ocorreu um erro tente mais tarde"));
		}
		return null;
	}

	public String editar() {
		try {
			jogo.setV1(aleatorio.nextInt(30));
			jogo.setV2(aleatorio.nextInt(30));
			jogo.setV3(aleatorio.nextInt(30));
			jogo.setV4(aleatorio.nextInt(30));
			jogo.setV5(aleatorio.nextInt(30));
			jogo.setV6(aleatorio.nextInt(30));
			jogo.setV7(aleatorio.nextInt(30));
			jogo.setV8(aleatorio.nextInt(30));
			jogo.setV9(aleatorio.nextInt(30));
			jogo.setV10(aleatorio.nextInt(30));
			JogoDAO.editar(jogo);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro atualizado com sucesso."));
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ",
					"Desculpe ocorreu um erro ao realizar a atualizado do registro"));
		}
		return null;
	}

	public void excluir(Jogo j) {
		try {
			JogoDAO.excluir(j);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Excluido com sucesso."));
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", "Ocorreu um erro tente mais tarde"));
		}
	}
	
	public void pares(Jogo j) {
		v.add(j.getV1());
		v.add(j.getV2());
		v.add(j.getV3());
		v.add(j.getV4());
		v.add(j.getV5());
		v.add(j.getV6());
		v.add(j.getV7());
		v.add(j.getV8());
		v.add(j.getV9());
		v.add(j.getV10());
		try {
			List<Integer> response = v.stream().filter(data ->  data % 2 == 0).collect(Collectors.toList());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Números pares encontrados", response.toString()));

		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error"));
		}
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getListar() {
		listar = JogoDAO.listar();
		return listar;
	}

	public void setListar(List<Jogo> listar) {
		this.listar = listar;
	}

}
