#language:pt
Funcionalidade: Acessar sistema PCA e Fazer Login

  @acessaSistemaPCA
  Esquema do Cenario: Acessa o sistema PCA, valida se os campos existem e faz login
    Dado que eu acesse o sistema <sistema>
    #E que eu valide todos os elementos da tela
    E que eu valide a existência do campo CPF
    E que eu preencha o campo cpf com <cpf>
    E que eu valide a existência do campo SENHA
    E que eu preencha o campo senha com <senha>
    Quando eu clico no botao acessar
    Então o sistema entra na pagina principal e exibe o logo do PCA
    
    Exemplos: 
    |sistema                        |cpf				|senha        |
    |"https://hpca.rj.gov.br/login" |"990.231.330-21"	|"Sublog123*" |
    |"https://hpca.rj.gov.br/login" |"990.231.330-22"	|"Sublog1237*" |
    |"https://hpca.rj.gov.br/login" |"990.231.330-21"	|"Sublog1236*" |
    |"https://hpca.rj.gov.br/login" |"990.231.330-21"	|"Sublog1236*" |
    |"https://hpca.rj.gov.br/login" |"990.231.330-21"	|"Sublog123.*" |
    |"https://hpca.rj.gov.br/login" |"990.231.330-21"	|"Sublog123c*" |

  
   
