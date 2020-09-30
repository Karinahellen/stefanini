package pages.aplicacao;

import env.WebDriverManager;

public class AplicacaoPage {

    public void acessar(String url) {
        WebDriverManager.getWebDriver().get(url);
    }
}
