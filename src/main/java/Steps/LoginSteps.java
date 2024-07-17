package Steps;

import Pages.LoginPage;
import Pages.Page;
import Utils.ReportUtils;
import Utils.seleniumUtils;
import com.aventstack.extentreports.Status;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {
	LoginPage page = new LoginPage();
	
	@Dado("^que eu acesse o sistema \"([^\"]*)\"$")
	public void que_eu_acesse_o_sistema(String url) throws Throwable {
		page.acessaURL(url);
		ReportUtils.logMensagem(Status.INFO, "Dado que eu acesse o sistema '" + url + "'", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu valide a existência do campo CPF$")
	public void que_eu_valide_a_existencia_do_campo_cpf() throws Throwable {
		page.validaExistenciaCampoLogin();
		ReportUtils.logMensagem(Status.INFO, "E que eu valide a existência do campo CPF", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu preencha o campo cpf com \"([^\"]*)\"$")
	public void que_eu_preencha_o_campo_cpf_com(String valor) throws Throwable {
		Assertions.assertTrue(page.preencheCampoLogin(valor), "Teste Falhou! Não foi possível preencher o campo CPF.");
		ReportUtils.logMensagem(Status.INFO, "E que eu preencha o campo cpf com o valor '"+valor+"'", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu valide a existência do campo SENHA$")
	public void que_eu_valide_a_existencia_do_campo_senha() throws Throwable {
		page.validaExistenciaCampoSenha();
		ReportUtils.logMensagem(Status.INFO, "E que eu valide a existência do campo SENHA", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu preencha o campo senha com \"([^\"]*)\"$")
	public void que_eu_preencha_o_campo_senha_com(String valor) throws Throwable {
		page.preencheCampoSenha(valor);
		ReportUtils.logMensagem(Status.INFO, "E que eu preencha o campo senha com o valor '"+valor+"'", seleniumUtils.getScreenshotReport());

	}

	@Quando("^eu clico no botao acessar$")
	public void eu_clico_no_botao_acessar() throws Throwable {
	    page.clicaNoBotaoAcessar();
		ReportUtils.logMensagem(Status.INFO, "Quando eu clico no botão acessar'", seleniumUtils.getScreenshotReport());
	}

	@Então("^o sistema entra na pagina principal e exibe o logo do PCA$")
	public void o_sistema_entra_na_pagina_principal_e_exibe_o_logo_do_pca() throws Throwable {
		Assertions.assertTrue(page.validaExistenciaModalPaginaPrincipalAdminPCA(), "Erro! A modal da pagina principal não foi exibida.");
		ReportUtils.logMensagem(Status.INFO, "Então o sistema entra na pagina principal e exibe o logo do PCA'", seleniumUtils.getScreenshotReport());
	}
	
}
