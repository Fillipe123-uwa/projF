 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="model.Usuario"%>
   
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>Confirmação da Consulta</title>      
    </head>
    <body>
        <div class="container">
            <div class="header">
                <img src="img/saude.png" alt="saude">
            </div>
            <h2>Confirmação da Consulta</h2>
            <form method="post">
                <label for="nome">Nome do Paciente:</label>
                <input type="text" id="nome" name="nome" placeholder="Nome do paciente" required>

                <label for="cpf">CPF:</label>
                <input type="text" id="cpf" name="cpf" placeholder="XXXXX.XXXXX.XXXXX-XXXX" required>

                <div class="row">
                    <div>
                        <label for="data">Dia da Consulta:</label>
                        <input type="date" id="data" name="data" required>
                    </div>
                    <div>
                        <label for="hora">Horário:</label>
                        <input type="time" id="hora" name="hora" required>
                    </div>
                </div>

                <label for="observacoes">Observações sobre o Paciente:</label>
                <textarea id="observacoes" name="observacoes" rows="3" placeholder="Digite informações adicionais"></textarea>

                <label for="valorTotal">Valor Total da Consulta:</label>
                <input type="text" id="valorTotal" name="valorTotal" placeholder="R$ 0,00" readonly>
                <input type="submit" value="Confirmar" class="btn btn-danger">
                <div>
                    <a href="index.html" class="btn btn-danger"> alterar </a>
                </div>
            </form>
        </div>
    </body>
</html>
