package Pages;

import Elements.PCAInformeElements;
import Setups.TestRule;
import org.openqa.selenium.support.PageFactory;

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
}
