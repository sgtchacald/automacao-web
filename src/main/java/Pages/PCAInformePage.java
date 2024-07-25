package Pages;

import Elements.PCAInformeElements;
import Setups.TestRule;
import Utils.ReportUtils;
import Utils.seleniumUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PCAInformePage extends PCAInformeElements {

	public PCAInformePage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public boolean  validaExistenciaElementosTelaSelecaoInforme() {
		boolean elementoExiste = true;

		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_INFORMES, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_RESULTADO, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_TITULO, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_SITUACAO, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_DATA_PUBLICACAO, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_DATA_EXPIRACAO, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_CONTEUDO_DO_INFORME, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(TXT_LABEL_BTN_CRIAR, 0);
		elementoExiste = verificaExistenciaDeElementoNaTela(BTN_CRIAR, 0);

		return elementoExiste;
	}

	public void clicarMenuGestao() {
		esperaElemento(ITEM_MENU_GESTAO,3);
		ITEM_MENU_GESTAO.click();
	}

	public void clicarItemMenuCadastrar() {
		esperaElemento(ITEM_MENU_CADASTRAR,3);
		ITEM_MENU_CADASTRAR.click();
	}

	public void clicarBotaoInformes() {
		BTN_INFORMES.click();
	}

	public void clicarBotaoCriar() {
		BTN_CRIAR.click();
	}

	public void validaExistenciaElementosTelaCriarInformes() {
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_CRIAR, 0);
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_INFORME, 0);
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_TITULO, 0);
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_DT_EXPIRACAO, 0);
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_PUBLICAR, 0);
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_DESCRICAO, 0);
		verificaExistenciaDeElementoNaTela(this.TXT_LABEL_CAD_GRAVAR, 0);
		verificaExistenciaDeElementoNaTela(this.CAMPO_TITULO, 0);
		verificaExistenciaDeElementoNaTela(this.CAMPO_DT_EXPIRACAO, 0);
		verificaExistenciaDeElementoNaTela(this.CAMPO_DESCRICAO, 0);
		verificaExistenciaDeElementoNaTela(this.BTN_GRAVAR, 0);
	}

	public void preencherCampoTitulo(String valor) {
		this.CAMPO_TITULO.sendKeys(valor);
	}

	public void preencherCampoDtExpiracao(String valor) {
		this.CAMPO_DT_EXPIRACAO.sendKeys(valor);
	}

	public void preencherCampoDescricao(String valor) {
		this.CAMPO_DESCRICAO.sendKeys(valor);
	}

	public void clicarBotaoGravar() {
		this.BTN_GRAVAR.click();
	}

	public void voltarParaPaginaPrincipal() {
		this.ICONE_HOME.click();
	}

	public void confirmarGravacaoRegistro() {
		this.MODAL_BTN_SIM.click();
	}

	public boolean validarMensagemInformePaginaPrincipal(String valor) {
		boolean existeElementoMensagemInforme = esperaElemento(this.MENSAGEM_INFORME_PAGINA_PRINCIPAL, 3);
		boolean existeItemInformeCadastrado = false;

		if(existeElementoMensagemInforme) {
			List<WebElement> informeList = this.MENSAGENS_INFORME_PAGINA_PRINCIPAL;

			if (informeList != null && !informeList.isEmpty()) {
				for (WebElement informe : informeList) {
					String txtInforme = "";
					int posicao = informe.getText().indexOf(" - ");
					txtInforme = informe.getText().substring(posicao +3);
					if (txtInforme.contains(valor)) {
						existeItemInformeCadastrado = true;
						break;
					}
				}
			}
		}

		return existeElementoMensagemInforme && existeItemInformeCadastrado;
	}
}
