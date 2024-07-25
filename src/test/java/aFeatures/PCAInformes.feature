#language:pt
@TesteAutomatizadoPCA
Funcionalidade: PCA, manter informes

  @PCAInformeAcessaTelaSelecao
  Cenário: Acessa o sistema PCA, entra na tela de seleção de informes
    Dado que eu esteja autenticado no sistema PCA
    E que eu clique no menu Gestão
    E que eu clique no submenu Cadastro
    Quando eu clico no botão Informes
    Então o sistema exibe a tela de seleção de informes

  @PCAInformeFazUmCadastro
  Esquema do Cenário: Acessa o sistema PCA, entra na tela de seleção de informes
    Dado que eu esteja autenticado no sistema PCA
    E que eu clique no menu Gestão
    E que eu clique no submenu Cadastro
    E eu clico no botão Informes
    E o sistema exibe a tela de seleção de informes
    E que eu clique no botão criar
    E que eu valide os elementos da tela
    E que eu preencha o campo título com <titulo>
    E que eu preencha o campo data de expiração com <dtExpiracao>
    E que eu preencha o campo descrição com <descricao>
    E que eu clique no botão gravar
    E que eu clique sim na modal de confirmação
    Quando eu volto para a pagina principal
    Então o sistema deverá exibir a mensagem de informe <titulo>

    Exemplos:
      | titulo                       | dtExpiracao  | descricao                      |
      | "Titulo teste automatizado." | "26/07/2024" | "Descrição teste automatizado" |
   
