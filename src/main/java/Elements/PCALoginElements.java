package Elements;

import Utils.seleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PCALoginElements extends seleniumUtils{

	@FindBy(xpath = "//*[contains(text(),'CPF do Usuário')]")
	public WebElement CAMPO_TXT_LABEL_LOGIN;

	@FindBy(id = "login")
	public WebElement CAMPO_TXT_LOGIN;

	@FindBy(xpath = "//*[contains(text(),'Senha')]")
	public WebElement CAMPO_TXT_LABEL_SENHA;

	@FindBy(id = "senha")
	public WebElement CAMPO_TXT_SENHA;

	@FindBy(id = "btn-login")
	public WebElement BOTAO_ACESSAR;

	@FindBy(xpath = "//*[contains(text(),'Fechar')]")
	public WebElement MODAL_TELA_INICIAL_ADMINISTRACAO_PCA;



	
}
