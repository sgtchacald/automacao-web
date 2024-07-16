package Pages;

import org.openqa.selenium.support.PageFactory;

import Elements.Elements;
import Setups.TestRule;

public class Page extends Elements{

	public Page() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void acessaURL(String url) {
		driver.navigate().to(url);		
	}
	
	public void clicaMenuPrincipal() {
		esperaElemento(MENU_PRINCIPAL, 5);
		MENU_PRINCIPAL.click();
	}
	
	public void clicaMenuContato() {
		esperaElemento(ITEM_MENU_CONTATO, 5);
		ITEM_MENU_CONTATO.click();
	}
	
	public void preencheCampoNome(String valor){
		esperaElemento(CAMPO_TXT_NOME, 5);
		CAMPO_TXT_NOME.sendKeys(valor);
	}
	
	public void preencheCampoEmail(String valor){
		esperaElemento(CAMPO_TXT_EMAIL, 5);
		CAMPO_TXT_EMAIL.sendKeys(valor);
	}
	
	public void preencheCampoMensagem(String valor){
		esperaElemento(CAMPO_TXT_MENSAGEM, 5);
		CAMPO_TXT_MENSAGEM.sendKeys(valor);
	}
	
	public void clicarBotaoEnviar(){
		BOTAO_ENVIAR.click();
	}
	
	public boolean validaMensagemSucesso(String msg) {
		boolean retorno = false;
		if (LABEL_MENSAGEM_SUCESSO.isDisplayed() && LABEL_MENSAGEM_SUCESSO.getText().equalsIgnoreCase(msg)) {
			retorno = true;
		}
		return retorno;
	}
	
	
}
