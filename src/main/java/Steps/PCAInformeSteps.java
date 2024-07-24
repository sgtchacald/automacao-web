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
		page.clicarMenuGestao();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no menu Gestão.", seleniumUtils.getScreenshotReport());
	}

	@E("^que eu clique no submenu Cadastro$")
	public void queEuCliqueNoSubmenuCadastro() throws Throwable {
		page.clicarItemMenuCadastrar();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no submenu Cadastro.", seleniumUtils.getScreenshotReport());
	}

	@Quando("^eu clico no botão Informes$")
	public void queEuCliqueNoBotaoInformes() throws Throwable {
		page.clicarBotaoInformes();
		ReportUtils.logMensagem(Status.INFO, "E que eu clique no botão Informes.", seleniumUtils.getScreenshotReport());
	}

	@Então("^o sistema exibe a tela de seleção de informes$")
	public void oSistemaExibeATelaDeSelecaoDeInformes() throws Throwable {
		Assertions.assertTrue(page.validaExistenciaElementosTelaSelecaoInforme(), "Erro! Não foi possível completar esse passo do teste.");

		ReportUtils.logMensagem(Status.INFO, "Então sistema exibe a tela de seleção de informes.", seleniumUtils.getScreenshotReport());
	}
	
}
