package com.Projeto.Portfolio.Controller;

import com.Projeto.Portfolio.Model.Contact;
import com.Projeto.Portfolio.Model.Imagem;
import com.Projeto.Portfolio.Model.Project;
import com.Projeto.Portfolio.Resources.Skill;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome(HttpServletRequest request){
        Contact contact = new Contact();
        Imagem imagem0 = criarImagem("src/main/resources/static/img/sinistro/login.png","jpg","images (1)");
        Imagem imagem1 = criarImagem("src/main/resources/static/img/sinistro/criarConta.png","jpg","images");
        Imagem imagem2 = criarImagem("src/main/resources/static/img/sinistro/esqueceuSenha.png","jpg","volvo");
        Imagem imagem3 = criarImagem("src/main/resources/static/img/sinistro/alteracaoSenha.png","jpg","volvo");
        Imagem imagem4 = criarImagem("src/main/resources/static/img/sinistro/home.png","jpg","branco");
        Imagem imagem5 = criarImagem("src/main/resources/static/img/sinistro/aprovacaoUsuario.png","jpg","images (1)");
        Imagem imagem6 = criarImagem("src/main/resources/static/img/sinistro/cadastroAgentes.png","jpg","images");
        Imagem imagem7 = criarImagem("src/main/resources/static/img/sinistro/cadastroOcorrencia.png","jpg","volvo");
        Imagem imagem8 = criarImagem("src/main/resources/static/img/sinistro/consultarOcorrencia.png","jpg","images (1)");
        Imagem imagem9 = criarImagem("src/main/resources/static/img/sinistro/exemploOcorrenciaPreenchida.png","jpg","images (1)");
        imagem0.setDadosbase64(convertImageToBase64(imagem0.getDados()));
        imagem1.setDadosbase64(convertImageToBase64(imagem1.getDados()));
        imagem2.setDadosbase64(convertImageToBase64(imagem2.getDados()));
        imagem3.setDadosbase64(convertImageToBase64(imagem3.getDados()));
        imagem4.setDadosbase64(convertImageToBase64(imagem4.getDados()));
        imagem5.setDadosbase64(convertImageToBase64(imagem5.getDados()));
        imagem6.setDadosbase64(convertImageToBase64(imagem6.getDados()));
        imagem7.setDadosbase64(convertImageToBase64(imagem7.getDados()));
        imagem8.setDadosbase64(convertImageToBase64(imagem8.getDados()));
        imagem9.setDadosbase64(convertImageToBase64(imagem9.getDados()));
        List<Imagem> listaImagem = new ArrayList<Imagem>();
        listaImagem.add(imagem0);
        listaImagem.add(imagem1);
        listaImagem.add(imagem2);
        listaImagem.add(imagem3);
        listaImagem.add(imagem4);
        listaImagem.add(imagem5);
        listaImagem.add(imagem6);
        listaImagem.add(imagem7);
        listaImagem.add(imagem8);
        listaImagem.add(imagem9);
        Project projects = new Project("Sistema de controle de fluxo de trabalho", """
                Este sistema foi desenvolvido para automatizar e gerenciar o fluxo completo de ocorrências técnicas, desde o registro inicial até a geração de relatórios profissionais em PDF. A plataforma conta com um robusto sistema de segurança implementado através do Spring Security, garantindo autenticação segura de usuários com todas as funcionalidades essenciais, incluindo criação de contas, login protegido e recuperação de senha.
                
                O painel principal apresenta um dashboard intuitivo que exibe dados estratégicos em tempo real. Através de visualizações gráficas, os usuários podem acompanhar o volume mensal de acionamentos e a distribuição percentual por tipo de ocorrência, permitindo uma análise rápida e eficiente do desempenho operacional.
                
                Na barra de navegação superior, os usuários encontram acesso a todas as funcionalidades principais. O módulo de ocorrências oferece três visões distintas: "Em Andamento", que lista todos os casos abertos; "Cadastrar", para registro de novas ocorrências; e "Consultar", que proporciona acesso ao histórico completo. Cada seção foi cuidadosamente projetada para otimizar o fluxo de trabalho dos operadores.
                
                O sistema também inclui módulos dedicados para gestão de prestadores de serviço e clientes. Na área de prestadores, é possível cadastrar novos profissionais, editar informações existentes e definir valores para cada tipo de serviço oferecido. Já no módulo de clientes, os usuários podem registrar novos contratantes e manter seus dados sempre atualizados.
                
                A gestão de usuários conta com funcionalidades diferenciadas por nível de acesso. Todos os usuários podem alterar suas senhas e realizar logout, enquanto os administradores possuem privilégios adicionais. Estes incluem a aprovação de novos cadastros através da tela "Solicitação de Usuário", onde cada novo registro é analisado antes da ativação, e acesso à lista completa de usuários do sistema.
                
                O processo de cadastro de ocorrências foi projetado para capturar todas as informações relevantes de forma estruturada. Os campos incluem dados do cliente, solicitante, informações de contato, tipo de ocorrência, detalhes do veículo envolvido, prestadores designados e uma descrição completa do caso. Após o registro, cada ocorrência recebe automaticamente o status "Em Andamento", ficando visível tanto na lista de casos ativos quanto no histórico geral.
                
                Durante o tratamento da ocorrência, os usuários têm duas opções principais: atualizar as informações mantendo o mesmo status ou finalizar o caso, o que altera seu status para "Finalizado" e o remove da lista de ocorrências ativas. Esse fluxo bem definido garante um acompanhamento preciso de cada caso.
                
                A tela de consulta apresenta uma tabela organizada com todas as ocorrências registradas no sistema. Por padrão, são exibidos os 5 registros mais recentes, com opção de ajustar a paginação para até 20 itens por página. A visualização inclui dados essenciais como número de protocolo, data de criação, informações do cliente e solicitante, tipo de ocorrência e placa do veículo. Uma coluna especial de ações oferece funcionalidades diferenciadas conforme o perfil do usuário - enquanto operadores comuns podem apenas visualizar os registros, administradores têm acesso adicional a edição e geração de relatórios.
                
                O módulo de relatórios representa um dos diferenciais mais valiosos do sistema. Nele, o operador responsável registra uma descrição detalhada da ocorrência, que posteriormente é revisada e aprimorada por um administrador. A plataforma também permite o upload de múltiplas imagens comprobatórias, que são automaticamente organizadas no documento final. Ao concluir o processo, o sistema gera um relatório profissional em formato PDF, contendo todas as informações relevantes, imagens perfeitamente redimensionadas e um layout padronizado que reflete a identidade da organização.
                
                Esta solução foi desenvolvida para otimizar processos, reduzir erros e garantir a padronização na documentação técnica, proporcionando maior eficiência operacional e qualidade no atendimento aos clientes.""",
                "http://google.com", listaImagem);

        projects.setListSkill(Arrays.asList(Skill.JAVA,Skill.SPRINGBOOT,Skill.SPRINGJPA,Skill.SPRINGSECURITY,Skill.POSTGRESQL,Skill.THYMELEAF,Skill.JAVASCRIPT,Skill.BOOTSTRAP,Skill.HTML));

        contact.setEmail("pardini1992@gmail.com");
        contact.setTelefone("(11) 98187-4361");
        List<Project> listProjects = new ArrayList<>();
        listProjects.add(projects);
        listProjects.add(projects);
        request.setAttribute("email",contact.getEmail());

        request.setAttribute("telefone",contact.getTelefone());
        request.setAttribute("projects",listProjects);
        return "home";
    }
    public Imagem criarImagem(String caminho,String tipo,String nome){
        Imagem imagem = new Imagem();
        try {
            byte[] testeImagem = imagem.getImageBytes(caminho);
            imagem.setDados(testeImagem);
            imagem.setTipo(tipo);
            imagem.setNome(nome);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imagem;
    }
    public String convertImageToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

}
