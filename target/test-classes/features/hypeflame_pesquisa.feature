# language: pt
@hypeflame
@pesquisa
Funcionalidade: Validar pesquisa da hypeflame


Cenário: Validar pesquisa de artigos com muitos resultados
  Dado que estou na home da hypeflame
  E clico em buscar
  Quando escrevo um valor que retorna muitos resultados
  E clico em enviar
  Então muitos resultados são retornados

Cenário: Validar pesquisa sem retorno de artigos e verificar layout
  Dado que estou na home da hypeflame
  E clico em buscar
  Quando escrevo um valor que não retorna resultados
  E clico em enviar
  Então nenhum resultado é retornado
  E o sistema avisa que não houve resultados
