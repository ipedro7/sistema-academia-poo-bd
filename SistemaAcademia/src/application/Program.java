package application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dao.AlunoDAO;
import dao.AulaDAO;
import dao.InstrutorDAO;
import dao.PlanoDAO;
import dao.InscricaoAulaDAO;
import dao.FrequenciaDAO;
import model.entities.Aluno;
import model.entities.Aula;
import model.entities.Instrutor;
import model.entities.Plano;
import model.entities.InscricaoAula;
import model.entities.Frequencia;

/**
 * Classe principal do sistema de academia.
 * Responsável por iniciar a aplicação e gerenciar os menus
 * de interação com o usuário, como alunos, instrutores,
 * planos, aulas, inscrições, frequências e relatórios.
 *
 * @author Pedro
 * @author Wendel
 */
public class Program {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método responsável por iniciar o sistema.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("\n=== Sistema Academia ===");
            System.out.println("1 - Gerenciar alunos");
            System.out.println("2 - Gerenciar instrutores");
            System.out.println("3 - Gerenciar Planos");
            System.out.println("4 - Gerenciar aulas");
            System.out.println("5 - Gerenciar inscrições");
            System.out.println("6 - Controle de frequência");
            System.out.println("7 - Relatórios");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            try {
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1:
                        menuAlunos();
                        break;
                    case 2:
                        menuInstrutor();
                        break;
                    case 3:
                        menuPlanos();
                        break;
                    case 4:
                        menuAulas();
                        break;
                    case 5:
                        menuInscricoes();
                        break;
                    case 6:
                        menuFrequencias();
                        break;
                    case 7:
                        menuRelatorios();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        sc.close();
    }

    // aluno
    private static void menuAlunos() {
        int opc = -1;
        AlunoDAO dao = new AlunoDAO();

        while (opc != 0) {
            System.out.println("== Gerenciar alunos ==");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        Aluno aluno = new Aluno();
                        System.out.println("=== Inserindo aluno ===");
                        System.out.println("CPF (11 digitos): ");
                        aluno.setCpf(sc.nextLine());
                        System.out.println("Nome: ");
                        aluno.setNome(sc.nextLine());
                        System.out.println("Telefone: ");
                        aluno.setTelefone(sc.nextLine());
                        System.out.println("Data de nascimento: ");
                        aluno.setDataNascimento(
                                LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        System.out.println("E-mail: ");
                        aluno.setEmail(sc.nextLine());
                        System.out.println("CEP: ");
                        aluno.setCep(sc.nextLine());
                        dao.adicionar(aluno);
                        System.out.println("Aluno inserido com sucesso!");
                        break;
                    case 2:
                        List<Aluno> lista = dao.listar();
                        for (Aluno a : lista) {
                            System.out.println(a.getCpf() + " - " + a.getNome() + " - " + a.getEmail());
                        }
                        break;
                    case 3:
                        Aluno att = new Aluno();
                        System.out.println("=== Atualizando aluno ===");
                        System.out.println("CPF (11 digitos): ");
                        att.setCpf(sc.nextLine());
                        System.out.println("Nome: ");
                        att.setNome(sc.nextLine());
                        System.out.println("Telefone: ");
                        att.setTelefone(sc.nextLine());
                        System.out.println("Data de nascimento: ");
                        att.setDataNascimento(
                                LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        System.out.println("E-mail: ");
                        att.setEmail(sc.nextLine());
                        System.out.println("CEP: ");
                        att.setCep(sc.nextLine());
                        dao.atualizar(att);
                        System.out.println("Aluno atualizado com sucesso!");
                        break;
                    case 4:
                        System.out.println("=== Excluindo aluno ===");
                        System.out.println("CPF do aluno para excluir: ");
                        dao.excluir(sc.nextLine());
                        System.out.println("Aluno excluido!");
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // instrutor
    private static void menuInstrutor() {
        int opc = -1;
        InstrutorDAO dao = new InstrutorDAO();

        while (opc != 0) {
            System.out.println("== Gerenciar instrutores ==");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        Instrutor instrutor = new Instrutor();
                        System.out.println("=== Inserindo instrutor ===");
                        System.out.println("CPF (11 digitos): ");
                        instrutor.setCpf(sc.nextLine());
                        System.out.println("Nome: ");
                        instrutor.setNome(sc.nextLine());
                        System.out.println("Telefone: ");
                        instrutor.setTelefone(sc.nextLine());
                        System.out.println("Email: ");
                        instrutor.setEmail(sc.nextLine());
                        System.out.println("Especialidade: ");
                        instrutor.setEspecialidade(sc.nextLine());
                        System.out.println("Horario de trabalho: ");
                        instrutor.setHorarioTrabalho(sc.nextLine());
                        System.out.print("Salario: ");
                        String sal = sc.nextLine();
                        if (!sal.isEmpty())
                            instrutor.setSalario(new BigDecimal(sal));
                        dao.adicionar(instrutor);
                        System.out.println("Instrutor inserido com sucesso!");
                        break;
                    case 2:
                        List<Instrutor> lista = dao.listar();
                        for (Instrutor i : lista) {
                            System.out
                                    .println(i.getIdFuncionario() + " - " + i.getNome() + " - " + i.getEspecialidade());
                        }
                        break;
                    case 3:
                        Instrutor att = new Instrutor();
                        System.out.println("=== Atualizando instrutor ===");
                        System.out.print("ID do instrutor a atualizar: ");
                        att.setIdFuncionario(Integer.parseInt(sc.nextLine()));
                        System.out.print("Novo CPF: ");
                        att.setCpf(sc.nextLine());
                        System.out.print("Novo Nome: ");
                        att.setNome(sc.nextLine());
                        System.out.print("Novo Telefone: ");
                        att.setTelefone(sc.nextLine());
                        System.out.print("Novo Email: ");
                        att.setEmail(sc.nextLine());
                        System.out.print("Nova Especialidade: ");
                        att.setEspecialidade(sc.nextLine());
                        System.out.print("Novo Horario: ");
                        att.setHorarioTrabalho(sc.nextLine());
                        System.out.print("Novo Salario: ");
                        String nsal = sc.nextLine();
                        if (!nsal.isEmpty())
                            att.setSalario(new BigDecimal(nsal));
                        dao.atualizar(att);
                        System.out.println("Instrutor atualizado com sucesso!");
                        break;
                    case 4:
                        System.out.println("=== Excluindo instrutor ===");
                        System.out.println("ID do instrutor para excluir: ");
                        dao.excluir(Integer.parseInt(sc.nextLine()));
                        System.out.println("Instrutor excluido!");
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // planos
    private static void menuPlanos() {
        int opc = -1;
        PlanoDAO dao = new PlanoDAO();

        while (opc != 0) {
            System.out.println("== Gerenciar planos ==");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        Plano plano = new Plano();
                        System.out.println("=== Inserindo plano ===");
                        System.out.print("Nome: ");
                        plano.setNome(sc.nextLine());
                        System.out.print("Descricao: ");
                        plano.setDescricao(sc.nextLine());
                        System.out.print("Valor (ex 99.90): ");
                        plano.setValor(new BigDecimal(sc.nextLine()));
                        System.out.print("Duracao (meses): ");
                        String dur = sc.nextLine();
                        if (!dur.isEmpty())
                            plano.setDuracao(Integer.parseInt(dur));
                        dao.adicionar(plano);
                        System.out.println("Plano inserido com sucesso!");
                        break;
                    case 2:
                        List<Plano> lista = dao.listar();
                        for (Plano p : lista) {
                            System.out.println(p.getIdPlano() + " - " + p.getNome() + " - " + p.getValor());
                        }
                        break;
                    case 3:
                        Plano att = new Plano();
                        System.out.println("=== Atualizando plano ===");
                        System.out.println("ID do plano a atualizar: ");
                        att.setIdPlano(Integer.parseInt(sc.nextLine()));
                        System.out.println("Novo nome: ");
                        att.setNome(sc.nextLine());
                        System.out.println("Nova descrição");
                        att.setDescricao(sc.nextLine());
                        System.out.println("Novo valor");
                        att.setValor(new BigDecimal(sc.nextLine()));
                        System.out.println("Nova duração (meses): ");
                        String duracao = sc.nextLine();
                        if (!duracao.isEmpty())
                            att.setDuracao(Integer.parseInt(duracao));
                        dao.atualizar(att);
                        System.out.println("Plano atualizado!");
                        break;
                    case 4:
                        System.out.println("ID do plano a excluir: ");
                        dao.excluir(Integer.parseInt(sc.nextLine()));
                        System.out.println("Plano excluido!");
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

    }

    // aulas
    private static void menuAulas() {
        int opc = -1;
        AulaDAO dao = new AulaDAO();

        while (opc != 0) {
            System.out.println("== Gerenciar aulas ==");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        Aula aula = new Aula();
                        System.out.println("=== Inserindo aula ===");
                        System.out.println("Nome: ");
                        aula.setNome(sc.nextLine());
                        System.out.println("Descrição: ");
                        aula.setDescricao(sc.nextLine());
                        System.out.println("Duração: ");
                        String dur = sc.nextLine();
                        if (!dur.isEmpty())
                            aula.setDuracao(Integer.parseInt(dur));
                        System.out.println("Horário (dd/MM/yyyy HH:mm): ");
                        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                        aula.setHorario(LocalDateTime.parse(sc.nextLine(), formatador));
                        System.out.print("Max Alunos: ");
                        String max = sc.nextLine();
                        if (!max.isEmpty())
                            aula.setCapacidadeMaximaAlunos(Integer.parseInt(max));
                        dao.adicionar(aula);
                        break;
                    case 2:
                        List<Aula> lista = dao.listar();
                        for (Aula a : lista) {
                            System.out.println(a.getIdAula() + " - " + a.getNome() + " - " + a.getHorario());
                        }
                        break;
                    case 3:
                        Aula att = new Aula();
                        System.out.println("=== Atualizando aula ===");
                        System.out.println("ID do plano a atualizar: ");
                        att.setIdAula(Integer.parseInt(sc.nextLine()));
                        System.out.println("Novo nome: ");
                        att.setNome(sc.nextLine());
                        System.out.println("Nova descrição");
                        att.setDescricao(sc.nextLine());
                        System.out.println("Nova duração: ");
                        String ndur = sc.nextLine();
                        if (!ndur.isEmpty())
                            att.setDuracao(Integer.parseInt(ndur));
                        System.out.println("Novo horário (dd/MM/yyyy HH:mm): ");
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                        att.setHorario(LocalDateTime.parse(sc.nextLine(), format));
                        System.out.print("Novo Max Alunos: ");
                        String nmax = sc.nextLine();
                        if (!nmax.isEmpty())
                            att.setCapacidadeMaximaAlunos(Integer.parseInt(nmax));
                        dao.atualizar(att);
                        System.out.println("Aula atualizada!");
                        break;
                    case 4:
                        System.out.println("ID da aula a excluir: ");
                        dao.excluir(Integer.parseInt(sc.nextLine()));
                        System.out.println("Aula excluida!");
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

    }

    // inscricoes
    private static void menuInscricoes() {
        int opc = -1;
        InscricaoAulaDAO dao = new InscricaoAulaDAO();

        while (opc != 0) {
            System.out.println("== Gerenciar inscrições ==");
            System.out.println("1 - Inscrever aluno em aula");
            System.out.println("2 - Cancelar inscrição");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        InscricaoAula inscricao = new InscricaoAula();

                        Aluno aluno = new Aluno();
                        Aula aula = new Aula();

                        System.out.println("=== Inscrever aluno em aula ===");
                        System.out.println("CPF do aluno: ");
                        aluno.setCpf(sc.nextLine());

                        System.out.println("ID da aula: ");
                        aula.setIdAula(Integer.parseInt(sc.nextLine()));

                        inscricao.setAluno(aluno);
                        inscricao.setAula(aula);

                        dao.adicionar(inscricao);

                        System.out.println("Aluno inscrito na aula com sucesso!");
                        break;
                    case 2:
                        System.out.println("=== Cancelar inscrição ===");
                        System.out.println("CPF do aluno: ");
                        String cpfAluno = sc.nextLine();

                        System.out.println("ID da aula: ");
                        Integer idAula = Integer.parseInt(sc.nextLine());

                        dao.excluir(cpfAluno, idAula);

                        System.out.println("Inscrição cancelada com sucesso!");
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

    }

    // frequencias
    private static void menuFrequencias() {
        int opc = -1;
        FrequenciaDAO dao = new FrequenciaDAO();

        while (opc != 0) {
            System.out.println("== Controle de frequência ==");
            System.out.println("1 - Registrar entrada de aluno");
            System.out.println("2 - Listar frequências");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        Frequencia frequencia = new Frequencia();
                        Aluno aluno = new Aluno();

                        System.out.println("=== Registrar entrada do aluno ===");

                        System.out.println("CPF do aluno: ");
                        aluno.setCpf(sc.nextLine());
                        frequencia.setAluno(aluno);

                        System.out.println("Data de entrada (dd/MM/yyyy): ");
                        frequencia.setDataEntrada(
                                LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        System.out.println("Hora de entrada (HH:mm): ");
                        frequencia.setHoraEntrada(
                                LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm")));

                        dao.adicionar(frequencia);

                        System.out.println("Frequência registrada com sucesso!");
                        break;

                    case 2:
                        List<Frequencia> lista = dao.listar();

                        if (lista.isEmpty()) {
                            System.out.println("Nenhuma frequência cadastrada.");
                        } else {
                            System.out.println("=== Frequências registradas ===");
                            for (Frequencia f : lista) {
                                System.out.println(
                                        "ID: " + f.getIdFrequencia()
                                                + " | Aluno: " + f.getAluno().getCpf()
                                                + " | Data: " + f.getDataEntrada()
                                                + " | Hora: " + f.getHoraEntrada());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // relatorios
    private static void menuRelatorios() {
        int opc = -1;

        while (opc != 0) {
            System.out.println("== Relatórios ==");
            System.out.println("1 - Relatório de frequência por aluno e período");
            System.out.println("2 - Relatório de ocupação das aulas");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            opc = Integer.parseInt(sc.nextLine());

            try {
                switch (opc) {
                    case 1:
                        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

                        System.out.println("=== Relatório de frequência do aluno ===");
                        System.out.println("CPF do aluno: ");
                        String cpfAluno = sc.nextLine();

                        System.out.println("Data inicial (dd/MM/yyyy): ");
                        LocalDate dataInicio = LocalDate.parse(
                                sc.nextLine(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        System.out.println("Data final (dd/MM/yyyy): ");
                        LocalDate dataFim = LocalDate.parse(
                                sc.nextLine(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        List<Frequencia> frequencias = frequenciaDAO.listarPorAlunoPeriodo(
                                cpfAluno,
                                dataInicio,
                                dataFim);

                        if (frequencias.isEmpty()) {
                            System.out.println("Nenhuma frequência encontrada para esse período.");
                        } else {
                            System.out.println("=== Frequências encontradas ===");

                            for (Frequencia f : frequencias) {
                                System.out.println(
                                        "ID: " + f.getIdFrequencia()
                                                + " | CPF do aluno: " + f.getAluno().getCpf()
                                                + " | Data: " + f.getDataEntrada()
                                                + " | Hora: " + f.getHoraEntrada());
                            }

                            System.out.println("Total de visitas no período: " + frequencias.size());
                        }
                        break;

                    case 2:
                        AulaDAO aulaDAO = new AulaDAO();
                        InscricaoAulaDAO inscricaoDAO = new InscricaoAulaDAO();

                        List<Aula> aulas = aulaDAO.listar();

                        if (aulas.isEmpty()) {
                            System.out.println("Nenhuma aula cadastrada.");
                        } else {
                            System.out.println("=== Ocupação das aulas ===");

                            for (Aula aula : aulas) {
                                int totalInscritos = inscricaoDAO.contarInscricoesPorAula(aula.getIdAula());

                                System.out.println(
                                        "Aula: " + aula.getNome()
                                                + " | ID: " + aula.getIdAula()
                                                + " | Inscritos: " + totalInscritos
                                                + "/" + aula.getCapacidadeMaximaAlunos());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}