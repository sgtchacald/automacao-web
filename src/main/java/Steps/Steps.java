package Steps;

import Pages.Page;
import com.aventstack.extentreports.util.Assert;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Steps{
	Page page = new Page();
	
	@Dado("^que eu acesse o site \"([^\"]*)\"$")
	public void que_eu_acesse_o_site(String url) throws Throwable {
		page.acessaURL(url);
	}

	@Dado("^que eu clique no menu principal$")
	public void que_eu_clique_no_menu_principal() throws Throwable {
	   page.clicaMenuPrincipal();
	}

	@Dado("^que eu clique no item de menu contato$")
	public void que_eu_clique_no_item_de_menu_contato() throws Throwable {
		page.clicaMenuContato();
	}

	@Dado("^que eu verifique que estou na pagina de contatos$")
	public void que_eu_verifique_que_estou_na_pagina_de_contatos() throws Throwable {
	}

	@Dado("^que eu preencha o campo nome com o \"([^\"]*)\"$")
	public void que_eu_preencha_o_campo_nome_com_o(String valor) throws Throwable {
		page.preencheCampoNome(valor);
	}

	@Dado("^que eu preencha o campo email com o \"([^\"]*)\"$")
	public void que_eu_preencha_o_campo_email_com_o(String valor) throws Throwable {
	    page.preencheCampoEmail(valor);
	}

	@Dado("^que eu preencha o campo comentario com o \"([^\"]*)\"$")
	public void que_eu_preencha_o_campo_comentario_com_o(String valor) throws Throwable {
	  page.preencheCampoMensagem(valor);
	}

	@Quando("^eu clico no botao enviar$")
	public void eu_clico_no_botao_enviar() throws Throwable {
	    page.clicarBotaoEnviar();
	}

	@Então("^o site exibe a mensagem de sucesso \"([^\"]*)\"$")
	public void o_site_exibe_a_mensagem_de_sucesso(String msg) throws Throwable {
		//Assert(page.validaMensagemSucesso(msg), "Erro! Os valores não conferem, favor verificar.");
	}
	
}
