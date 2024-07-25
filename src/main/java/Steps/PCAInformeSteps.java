package Steps;

import Pages.PCAInformePage;
import Utils.ReportUtils;
import Utils.seleniumUtils;
import com.aventstack.extentreports.Status;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class PCAInformeSteps {
	PCAInformePage page = new PCAInformePage();

	@Dado("^que eu clique no menu Gestão$")
	public void queEuCliqueNoMenuGestao() throws Throwable {
		this.page.clicarMenuGestao();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no menu Gestão.", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu clique no submenu Cadastro$")
	public void queEuCliqueNoSubmenuCadastro() throws Throwable {
		this.page.clicarItemMenuCadastrar();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no submenu Cadastro.", seleniumUtils.getScreenshotReport());
	}

	@Quando("^eu clico no botão Informes$")
	public void queEuCliqueNoBotaoInformes() throws Throwable {
		this.page.clicarBotaoInformes();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no botão Informes.", seleniumUtils.getScreenshotReport());
	}

	@Então("^o sistema exibe a tela de seleção de informes$")
	public void oSistemaExibeATelaDeSelecaoDeInformes() throws Throwable {
		Assertions.assertTrue(page.validaExistenciaElementosTelaSelecaoInforme(), "Erro! Não foi possível completar esse passo do teste.");
		ReportUtils.logMensagem(Status.INFO, "Então sistema exibe a tela de seleção de informes.", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu clique no botão criar")
	public void queEuCliqueNoBotaoCriar() throws Throwable {
		this.page.clicarBotaoCriar();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no botão criar.", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu valide os elementos da tela")
	public void queEuValideTodosOsElementosDaTela() throws Throwable {
		this.page.validaExistenciaElementosTelaCriarInformes();
		ReportUtils.logMensagem(Status.INFO, "E que eu valide os elementos da tela.", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu preencha o campo título com \"([^\"]*)\"$")
	public void queEuPreenchaOCampoTituloCom(String valor) throws Throwable {
		this.page.preencherCampoTitulo(valor);
		ReportUtils.logMensagem(Status.INFO, "E que eu preencha o campo título com '"+valor+"'", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu preencha o campo data de expiração com \"([^\"]*)\"$")
	public void queEuPreenchaOCampoDtExpiracaoCom(String valor) throws Throwable {
		this.page.preencherCampoDtExpiracao(valor);
		ReportUtils.logMensagem(Status.INFO, "E que eu preencha o campo data de expiração com '"+valor+"'", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu preencha o campo descrição com \"([^\"]*)\"$")
	public void queEuPreenchaOCampoDescricaoCom(String valor) throws Throwable {
		this.page.preencherCampoDescricao(valor);
		ReportUtils.logMensagem(Status.INFO, "E que eu preencha o campo Descricao com '"+valor+"'", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu clique no botão gravar")
	public void queEuCliqueNoBotaoGravar() throws Throwable {
		this.page.clicarBotaoGravar();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no botão gravar.", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu clique sim na modal de confirmação")
	public void queEuCliqueSimNaModalDeConfirmacao() throws Throwable {
		this.page.confirmarGravacaoRegistro();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique sim na modal de confirmação.", seleniumUtils.getScreenshotReport());
	}

	@E("^eu volto para a pagina principal")
	public void queEuVolteParaPaginaPrincipal() throws Throwable {
		this.page.voltarParaPaginaPrincipal();
		ReportUtils.logMensagem(Status.INFO, "Quando eu volto para a pagina principal.", seleniumUtils.getScreenshotReport());
	}

	@E("^o sistema deverá exibir a mensagem de informe \"([^\"]*)\"$")
	public void validaMensagemDeInforme(String valor) throws Throwable {
		Assertions.assertTrue(page.validarMensagemInformePaginaPrincipal(valor), "Erro! Não foi possível completar esse passo do teste.");
		ReportUtils.logMensagem(Status.INFO, "Então o sistema deverá exibir a mensagem de informe '"+valor+"'", seleniumUtils.getScreenshotReport());
	}
}
