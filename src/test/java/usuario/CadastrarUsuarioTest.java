package usuario;

import env.WebDriverManager;
import org.junit.jupiter.api.*;
import pages.aplicacao.AplicacaoPage;
import pages.usuario.CadastrarUsuarioPage;
import valueObjects.usuario.FormCadastrarUsuario;

@Tag("Usuario")
public class CadastrarUsuarioTest {

    private CadastrarUsuarioPage page;

    public CadastrarUsuarioTest() {
        page = new CadastrarUsuarioPage();
    }

    @BeforeAll
    public static void inicializa() {
        WebDriverManager.initWebDriver();
        new AplicacaoPage().acessar("http://www.aprendendotestar.com.br/treinar-automacao.php");
        WebDriverManager.maximize();
    }

    /**
     * EU COMO usuário da aplicaçãoa
     * DESEJO  preencher os campos "Usuário", "Senha" e "Nome"
     * PARA QUE seja realizado o meu cadastro
     */
    @Test
    @DisplayName("Cenário 01 - Tela 01 - Realizar o cadastro do usuário com sucesso")
    public void cadastrarUsuarioComSucesso() {
        FormCadastrarUsuario form = new FormCadastrarUsuario(
                "karina.hellen",
                "teste1234",
                "Karina Hellen");

        page.enviar(form);

        Assertions.assertTrue(true);
    }

    /**
     * EU COMO usuário da aplicação
     * DESEJO  visualizar os campos inicialmente vazios
     * PARA QUE seja possível inicializar o preenchimento dos campos
     */
    @Test
    @DisplayName("Cenário 02 - Tela 01 - Validar se os campos inicialmente estão vazios")
    public void validarValoresIniciaisFormulario() {

        Assertions.assertEquals("", page.getValorCampoUsuario());
        Assertions.assertEquals("", page.getValorCampoSenha());
        Assertions.assertEquals("", page.getValorCampoNome());
    }

    /**
     * EU COMO usuário da aplicação
     * DESEJO  visualizar os nomes dos campos com a ortografia correta
     * PARA QUE seja claro o entendimento dos dados solicitados
     */
    @Test
    @DisplayName("Cenário 03 - Tela 01 - Validar se o nome dos campos estão corretos")
    public void validarLabelsFormulario() {

        Assertions.assertEquals("Usuário", page.getLabelCampoUsuario());
        Assertions.assertEquals("Senha", page.getLabelCampoSenha());
        Assertions.assertEquals("Nome", page.getLabelCampoNome());
        Assertions.assertEquals("Enviar", page.getLabelBotaoEnviar());
        Assertions.assertEquals("Clique aqui", page.getLabelAtualizar());
    }

    /**
     * EU COMO usuário da aplicação
     * DESEJO  visualizar o alerta de obrigatoriedade quando o campo "Usuário" não estiver preenchido
     * PARA QUE o usuário possa preencher todos os campos corretamente
     */
    @Test
    @DisplayName("Cenário 04 - Tela 02 - Validar mensagem de campo obrigatório quando o campo usuário não está preenchido")
    public void validarMensagemCampoUsuarioNaoPreenchido() {
        FormCadastrarUsuario form = new FormCadastrarUsuario(
                "",
                "teste123",
                "Karina Hellen");

        page.enviar(form);

        Assertions.assertEquals("Preencha este campo.", page.getMensagemCampoObrigatorioUsuario());
    }

    /**
     * EU COMO usuário da aplicação
     * DESEJO  visualizar o alerta de obrigatoriedade quando o campo "Senha" não estiver preenchido
     * PARA QUE o usuário possa preencher todos os campos corretamente
     */
    @Test
    @DisplayName("Cenário 05 - Tela 03 - Validar mensagem de campo obrigatório quando o campo senha não está preenchido")
    public void validarMensagemCampoSenhaNaoPreenchido() {
        FormCadastrarUsuario form = new FormCadastrarUsuario(
                "karina.hellen",
                "",
                "Karina Hellen");

        page.enviar(form);

        Assertions.assertEquals("Preencha este campo.", page.getMensagemCampoObrigatorioSenha());
    }

    /**
     * EU COMO usuário da aplicação
     * DESEJO  visualizar o alerta de "Existem campos em branco" quando o campo "Nome" não estiver preenchido
     * PARA QUE o usuário possa preencher todos os campos corretamente
     */
    @Test
    @DisplayName("Cenário 06 - Tela 04 - Validar mensagem quando somente o campo nome não estiver preenchido ")
    public void validarMensagemCampoUsuarioSenhaNaoPreenchido() {
        FormCadastrarUsuario form = new FormCadastrarUsuario(
                "karina.hellen",
                "teste1234",
                "");

        page.enviar(form);

        Assertions.assertEquals("Existem campos em branco.", page.getLabelCamposEmBranco());
    }
}

