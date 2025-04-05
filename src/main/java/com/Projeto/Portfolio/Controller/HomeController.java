package com.Projeto.Portfolio.Controller;


import com.Projeto.Portfolio.Model.Contact;
import com.Projeto.Portfolio.Model.Imagem;
import com.Projeto.Portfolio.Model.Project;
import com.Projeto.Portfolio.Resources.Skill;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome(HttpServletRequest request){
        String titulo= "Sistema de controle de fluxo de trabalho";
        String descricao = """
                Este sistema foi desenvolvido para automatizar e gerenciar o fluxo completo de ocorrências técnicas, desde o registro inicial até a geração de relatórios profissionais em PDF. A plataforma conta com um robusto sistema de segurança implementado através do Spring Security, garantindo autenticação segura de usuários com todas as funcionalidades essenciais, incluindo criação de contas, login protegido e recuperação de senha.
                
                O painel principal apresenta um dashboard intuitivo que exibe dados estratégicos em tempo real. Através de visualizações gráficas, os usuários podem acompanhar o volume mensal de acionamentos e a distribuição percentual por tipo de ocorrência, permitindo uma análise rápida e eficiente do desempenho operacional.
                
                Na barra de navegação superior, os usuários encontram acesso a todas as funcionalidades principais. O módulo de ocorrências oferece três visões distintas: "Em Andamento", que lista todos os casos abertos; "Cadastrar", para registro de novas ocorrências; e "Consultar", que proporciona acesso ao histórico completo. Cada seção foi cuidadosamente projetada para otimizar o fluxo de trabalho dos operadores.
                
                O sistema também inclui módulos dedicados para gestão de prestadores de serviço e clientes. Na área de prestadores, é possível cadastrar novos profissionais, editar informações existentes e definir valores para cada tipo de serviço oferecido. Já no módulo de clientes, os usuários podem registrar novos contratantes e manter seus dados sempre atualizados.
                
                A gestão de usuários conta com funcionalidades diferenciadas por nível de acesso. Todos os usuários podem alterar suas senhas e realizar logout, enquanto os administradores possuem privilégios adicionais. Estes incluem a aprovação de novos cadastros através da tela "Solicitação de Usuário", onde cada novo registro é analisado antes da ativação, e acesso à lista completa de usuários do sistema.
                
                O processo de cadastro de ocorrências foi projetado para capturar todas as informações relevantes de forma estruturada. Os campos incluem dados do cliente, solicitante, informações de contato, tipo de ocorrência, detalhes do veículo envolvido, prestadores designados e uma descrição completa do caso. Após o registro, cada ocorrência recebe automaticamente o status "Em Andamento", ficando visível tanto na lista de casos ativos quanto no histórico geral.
                
                Durante o tratamento da ocorrência, os usuários têm duas opções principais: atualizar as informações mantendo o mesmo status ou finalizar o caso, o que altera seu status para "Finalizado" e o remove da lista de ocorrências ativas. Esse fluxo bem definido garante um acompanhamento preciso de cada caso.
                
                A tela de consulta apresenta uma tabela organizada com todas as ocorrências registradas no sistema. Por padrão, são exibidos os 5 registros mais recentes, com opção de ajustar a paginação para até 20 itens por página. A visualização inclui dados essenciais como número de protocolo, data de criação, informações do cliente e solicitante, tipo de ocorrência e placa do veículo. Uma coluna especial de ações oferece funcionalidades diferenciadas conforme o perfil do usuário - enquanto operadores comuns podem apenas visualizar os registros, administradores têm acesso adicional a edição e geração de relatórios.
                
                O módulo de relatórios representa um dos diferenciais mais valiosos do sistema. Nele, o operador responsável registra uma descrição detalhada da ocorrência, que posteriormente é revisada e aprimorada por um administrador. A plataforma também permite o upload de múltiplas imagens comprobatórias, que são automaticamente organizadas no documento final. Ao concluir o processo, o sistema gera um relatório profissional em formato PDF, contendo todas as informações relevantes, imagens perfeitamente redimensionadas e um layout padronizado que reflete a identidade da organização.
                
                Esta solução foi desenvolvida para otimizar processos, reduzir erros e garantir a padronização na documentação técnica, proporcionando maior eficiência operacional e qualidade no atendimento aos clientes.""";

        List<Skill> listSkill = Arrays.asList(Skill.JAVA, Skill.SPRINGBOOT, Skill.SPRINGJPA, Skill.SPRINGSECURITY, Skill.POSTGRESQL, Skill.THYMELEAF, Skill.JAVASCRIPT, Skill.BOOTSTRAP, Skill.HTML);
        List<String> caminhoProject1 = getCaminhoImagem("controle_fluxo_trabalho", 14);
        Project project1 = preenchendoProjects(titulo,descricao,caminhoProject1,listSkill);

        String titulo2= "Desafio Alura";
        String descricao2= "Desenvolvi um sistema para importação e análise de transações bancárias, com foco na identificação de movimentações suspeitas. A plataforma permite a importação de arquivos no formato CSV ou XML, que são processados e armazenados no banco de dados através de DTOs (Data Transfer Objects), garantindo uma integração eficiente e segura dos dados.\n" +
                "\n" +
                "O sistema conta com um módulo de análise que identifica as transações potencialmente suspeitas com base em critérios pré-definidos. Todas as transações individuais acima de 100 mil sao sinalizadas como suspeitas. As contas que receberam mais de 1 milhão no período analisado, bem como agências com movimentação total superior a R$ 1 bilhão no mês.\n" +
                "\n" +
                "Para garantir a segurança e o controle de acesso, o sistema foi integrado ao Spring Security, oferecendo autenticação robusta e proteção contra acessos não autorizados.";
        List<Skill> listSkill2 = Arrays.asList(Skill.JAVA, Skill.SPRINGBOOT, Skill.SPRINGJPA, Skill.SPRINGSECURITY, Skill.POSTGRESQL, Skill.THYMELEAF, Skill.BOOTSTRAP, Skill.HTML);
        List<String> caminhoProject2 = getCaminhoImagem("desafio_alura", 6);
        Project project2 = preenchendoProjects(titulo2, descricao2, caminhoProject2, listSkill2);

        String titulo3 = "MUDI";

        String descricao3="Este projeto consiste em um sistema onde vendedores podem cadastrar produtos com informações detalhadas, como imagem, descrição, características e site de origem. Os compradores, por sua vez, têm a possibilidade de fazer ofertas, incluindo o valor que estão dispostos a pagar e a data de entrega desejada.\n" +
                "\n" +
                "O vendedor recebe todas as ofertas relacionadas a um determinado produto e tem a liberdade de aprovar ou reprovar cada uma delas. O sistema também oferece um acompanhamento do status do pedido, que pode ser: Aguardando aprovação, Aprovado ou Entregue. Além disso, há uma seção dedicada aos \"Últimos produtos\", onde são exibidos todos os itens já vendidos.\n" +
                "\n" +
                "O principal objetivo desse sistema é facilitar a compra de produtos internacionais, funcionando como uma ponte entre compradores e viajantes. Pessoas que estão fora do país podem atuar como intermediárias, trazendo produtos sob demanda para clientes locais.\n" +
                "\n" +
                "Vale ressaltar que este projeto foi desenvolvido como um exercício de aprendizado, utilizando o framework Spring Boot para aprimorar conhecimentos em desenvolvimento de sistemas.";
        List<Skill> listSkill3 = Arrays.asList(Skill.JAVA,Skill.SPRINGBOOT,Skill.SPRINGSECURITY,Skill.SPRINGJPA,Skill.SPRINGMVC,Skill.POSTGRESQL,Skill.THYMELEAF,Skill.BOOTSTRAP,Skill.HTML);
        List<String> caminhoProject3 = getCaminhoImagem("mudi",6);
        Project project3 = preenchendoProjects(titulo3,descricao3,caminhoProject3,listSkill3);

        Contact contact = new Contact();
        contact.setEmail("pardini1992@gmail.com");
        contact.setTelefone("(11) 98187-4361");
        List<Project> listProjects = new ArrayList<>();
        listProjects.add(project1);
        listProjects.add(project2);
        listProjects.add(project3);

        request.setAttribute("email",contact.getEmail());
        request.setAttribute("telefone",contact.getTelefone());
        request.setAttribute("projects",listProjects);
        return "home";
    }
    public Imagem criarImagem(String caminho, String tipo, String nome){
        Imagem imagem = new Imagem();
        try {
            // Modificado: Usando ClassPathResource para acessar o arquivo
            ClassPathResource resource = new ClassPathResource("static/imagens/" + caminho);
            try (InputStream inputStream = resource.getInputStream()) {
                byte[] imageBytes = inputStream.readAllBytes();
                imagem.setDados(imageBytes);
                imagem.setTipo(tipo);
                imagem.setNome(nome);
                imagem.setDadosbase64(convertImageToBase64(imageBytes));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar imagem: " + caminho, e);
        }
        return imagem;
    }

    public Project preenchendoProjects(String titulo,String descricao,List<String> caminhoImagens,List<Skill> listSkill){
        List<Imagem> listaImagem = new ArrayList<>();
        for(int i=0;i<caminhoImagens.size();i++){
            Imagem imagemSrc = criarImagem(caminhoImagens.get(i),"jpg","img"+i);
            listaImagem.add(imagemSrc);
        }
        Project projectSrc = new Project(titulo,descricao,"http://google.com",listaImagem);
        projectSrc.setListSkill(listSkill);

        return projectSrc;
        /*Imagem imagem0 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/login.png","jpg","images (1)");
        Imagem imagem1 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/criarConta.png","jpg","images");
        Imagem imagem2 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/esqueceuSenha.png","jpg","volvo");
        Imagem imagem3 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/alteracaoSenha.png","jpg","volvo");
        Imagem imagem4 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/home.png","jpg","branco");
        Imagem imagem5 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/aprovacaoUsuario.png","jpg","images (1)");
        Imagem imagem6 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/cadastroAgentes.png","jpg","images");
        Imagem imagem7 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/cadastroOcorrencia.png","jpg","volvo");
        Imagem imagem8 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/consultarOcorrencia.png","jpg","images (1)");
        Imagem imagem9 = criarImagem("src/main/java/com/Projeto/Portfolio/imagens/controle_fluxo_trabalho/exemploOcorrenciaPreenchida.png","jpg","images (1)");
      //  List<Imagem> listaImagem = Arrays.asList(imagem0,imagem1,imagem2,imagem3,imagem5,imagem5,imagem6,imagem7,imagem9,imagem9);

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
                "http://google.com", listaImagem);*/

    }

    public List<String> getCaminhoImagem(String pasta,int tamanho){
        List<String> caminhos = new ArrayList<>();
        for (int i = 1; i <= tamanho; i++) {
            // Modificado: Retorna apenas o caminho relativo
            caminhos.add(pasta + "/" + i + ".png");
        }
        return caminhos;
    }


    public String convertImageToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

}
