# Jokenpo

## Rodando a solução:
Ao baixar a solução, é possível rodá-la utilizando o comando gradle abaixo dentro de {CAMINHO DO DIRETÓRIO}/jokenpo. Após isso, é possível visualizar os jogadores em: http://localhost:8080/jokenpo/jogadores
```
gradle bootRun
```

## Adicionando Jogadores:
Jogadores podem ser adicionados através do método post seguindo a estrutura abaixo. As opções de jogadas são: ***pedra, papel, tesoura, lagarto, spock***.

```json
{
    "nome": "Fulado de Tal",
    "jogada": "pedra"
}
```

## Removendo Jogadores:
Jogadores podem ser removidos pelo seu id utilizando um método delete da forma: http://localhost:8080/jokenpo/{ID_DO_JOGADOR} 
