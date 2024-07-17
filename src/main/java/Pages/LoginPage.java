package Pages;

import Elements.LoginElements;
import Setups.TestRule;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginElements {

	public LoginPage() {
		driver = TestRule.getDriver();
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
		return verificaExistenciaDeElementoNaTela(MODAL_TELA_INICIAL_ADMINISTRACAO_PCA, 1);
	}

}
