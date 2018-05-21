package sac.millennium.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import sac.millennium.dao.IAreaFuncionalDAO;
import sac.millennium.dao.IUsuarioDAO;
import sac.millennium.dao.impl.AreaFuncionalSqlserverDAOImpl;
import sac.millennium.dao.impl.UsuarioSqlserverDAOImpl;
import sac.millennium.model.AreaFuncional;
import sac.millennium.model.Gerencia;
import sac.millennium.model.GerenciaCentral;
import sac.millennium.model.Usuario;
import sac.millennium.service.IAreaFuncionalService;
import sac.millennium.service.IUsuarioService;
import sac.millennium.service.impl.AreaFuncionalServiceImpl;
import sac.millennium.service.impl.UsuarioServiceImpl;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private IUsuarioDAO daoUsuario = new UsuarioSqlserverDAOImpl();
	private IUsuarioService servUsuario = new UsuarioServiceImpl(daoUsuario);
	private Usuario usuarioSeleccionado = new Usuario();

	private IAreaFuncionalDAO daoAreaFunc = new AreaFuncionalSqlserverDAOImpl();
	private IAreaFuncionalService servAreaFunc = new AreaFuncionalServiceImpl(daoAreaFunc);

	private GerenciaCentral gerencia_ce;
	/*
	 * private GerenciaCentral ge_central; private AreaFuncional areaFunc;
	 */
	private List<Usuario> listaUsuario;
	private List<GerenciaCentral> listaGerenciaCentral;
	private List<Gerencia> listaGerencia;
	private List<AreaFuncional> listaAreaFuncional;

	@PostConstruct
	public void init() {
		listaUsuario = new ArrayList<>();
		listaGerenciaCentral = new ArrayList<>();
		listaGerencia = new ArrayList<>();
		listaAreaFuncional = new ArrayList<>();
		listarTodo();
		usuarioSeleccionado = new Usuario();
		gerencia_ce = new GerenciaCentral();
	}

	public UsuarioBean() {
		usuarioSeleccionado = new Usuario();
	}

	private void listarTodo() {
		listaUsuario = servUsuario.findAll();

	}

	public void registrar() {
		servUsuario.create(usuarioSeleccionado);
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Usuario Edited", ((Usuario) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Usuario) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<GerenciaCentral> getListaGerenciaCentral() {
		return listaGerenciaCentral;
	}

	public void setListaGerenciaCentral(List<GerenciaCentral> listaGerenciaCentral) {
		this.listaGerenciaCentral = listaGerenciaCentral;
	}

	public List<Gerencia> getListaGerencia() {
		return listaGerencia;
	}

	public void setListaGerencia(List<Gerencia> listaGerencia) {
		this.listaGerencia = listaGerencia;
	}

	public List<AreaFuncional> getListaAreaFuncional() {

		return listaAreaFuncional;
	}

	public void setListaAreaFuncional(List<AreaFuncional> listaAreaFuncional) {
		this.listaAreaFuncional = listaAreaFuncional;
	}

	public GerenciaCentral getGerencia_ce() {
		return gerencia_ce;
	}

	public void setGerencia_ce(GerenciaCentral gerencia_ce) {
		this.gerencia_ce = gerencia_ce;
	}
}
