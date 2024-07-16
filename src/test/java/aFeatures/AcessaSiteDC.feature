#language:pt
Funcionalidade: Acessar site DiegoCordeiro

  @acessaSiteDiegoCordeiro
  Esquema do Cenario: Acessa site diegocordeiro.com.br e falha ao cadastrar um usuario
    Dado que eu acesse o site <site>
    E que eu clique no menu principal
    E que eu clique no item de menu contato
    E que eu verifique que estou na pagina de contatos
    E que eu preencha o campo nome com o <nome>
    E que eu preencha o campo email com o <email>
    E que eu preencha o campo comentario com o <comentario>
    Quando eu clico no botao enviar
    Então o site exibe a mensagem de sucesso <msg_sucesso>
    
    Exemplos: 
    |site                               |nome							|email                      |comentario									  |msg_sucesso				   |
    |"http://www.diegocordeiro.com.br" 	|"Diego dos Santos Cordeiro"	|"sgt.chacal.d@gmail.com"	|"Mensagem enviada por um teste automatizado" |"Email enviado com sucesso!"|
  
   
