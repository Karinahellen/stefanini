package pages.usuario;

import env.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import valueObjects.usuario.FormCadastrarUsuario;

public class CadastrarUsuarioPage {

    private WebDriver driver;

    public CadastrarUsuarioPage() {
        driver = WebDriverManager.getWebDriver();
    }

    public void enviar(FormCadastrarUsuario form) {

        WebElement formulario = driver.findElement(By.tagName("form"));

        WebElement campoUsuario = getCampoUsuario();
        campoUsuario.sendKeys(form.usuario);

        WebElement campoSenha = getCampoSenha();
        campoSenha.sendKeys(form.senha);

        WebElement campoNome = getCampoNome();
        campoNome.sendKeys(form.nome);

        getBotaoEnviar().click(); // Clicar no botão "Enviar"
    }

    public String getValorCampoUsuario(){
        return getCampoUsuario().getText();
    }

    public String getValorCampoSenha(){
        return getCampoSenha().getText();
    }

    public String getValorCampoNome(){
        return getCampoNome().getText();
    }

    public String getLabelCampoUsuario(){
        return driver.findElement(By.xpath("//td[contains(.,'Usuário')]")).getText();
    }

    public String getLabelCampoSenha(){
        return driver.findElement(By.xpath("//td[contains(.,'Senha')]")).getText();
    }

    public String getLabelCampoNome(){
        return driver.findElement(By.xpath("//td[contains(.,'Nome:')]")).getText();
    }

    public String getLabelBotaoEnviar(){
        return getBotaoEnviar().getAttribute("value");
    }

    public String getLabelAtualizar(){
        return driver.findElement(By.xpath("//a[contains(.,'Clique aqui')]")).getText();
    }

    public String getMensagemCampoObrigatorioUsuario(){
        return getCampoUsuario().getAttribute("validationMessage");
    }

    public String getMensagemCampoObrigatorioSenha(){
        return getCampoSenha().getAttribute("validationMessage");
    }

    public String getLabelCamposEmBranco(){
        return driver.findElement(By.xpath("//td[contains(.,'Existem campos em branco.')]")).getText();
    }

    private WebElement getCampoUsuario() {
        return driver.findElement(By.name("form_usuario"));
    }

    private WebElement getCampoSenha() {
        return driver.findElement(By.name("form_senha"));
    }

    private WebElement getCampoNome() {
        return driver.findElement(By.name("form_nome"));
    }

    private WebElement getBotaoEnviar(){
        return driver.findElement(By.xpath("//input[@value='Enviar']"));
    }
}
