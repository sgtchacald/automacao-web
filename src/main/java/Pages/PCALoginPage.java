package Pages;

import Elements.PCALoginElements;
import Setups.TestRule;
import Utils.seleniumUtils;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PCALoginPage extends PCALoginElements {

	public PCALoginPage() {
		seleniumUtils.driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void acessaURL(String url) {
		driver.navigate().to(url);
	}

	public void validaExistenciaCampoLogin() {
		verificaExistenciaDeElementoNaTela(CAMPO_TXT_LABEL_LOGIN, 1);
	}

	public boolean preencheCampoLogin(String valor) {
		CAMPO_TXT_LOGIN.sendKeys(valor);
		CAMPO_TXT_SENHA.click();
		sleep(2000);
		String valorDoCampo = CAMPO_TXT_LOGIN.getText();
		if(StringUtils.isBlank(valorDoCampo)){
			return true;
		}
		return true;
	}

	public void validaExistenciaCampoSenha() {
		verificaExistenciaDeElementoNaTela(CAMPO_TXT_LABEL_SENHA, 1);
	}

	public void preencheCampoSenha(String valor) {
		CAMPO_TXT_SENHA.sendKeys(valor);
	}

	public void clicaNoBotaoAcessar(){
		verificaExistenciaDeElementoNaTela(BOTAO_ACESSAR, 1);
		BOTAO_ACESSAR.click();
	}

	public boolean validaExistenciaModalPaginaPrincipalAdminPCA(){
		boolean existeModal = verificaExistenciaDeElementoNaTela(MODAL_TELA_INICIAL_ADMINISTRACAO_PCA, 1);

		if(existeModal){
			MODAL_TELA_INICIAL_ADMINISTRACAO_PCA.click();
		}

		return existeModal;
	}

	public boolean fazAutenticacaoPCA() {
		try {
			this.acessaURL("https://hpca.rj.gov.br/login");
			this.validaExistenciaCampoLogin();
			this.preencheCampoLogin("033.478.067-51");
			this.validaExistenciaCampoSenha();
			this.preencheCampoSenha("Rejane@123");
			this.clicaNoBotaoAcessar();
			return true;
		}catch (Exception e){
			return false;
		}
	}
}
