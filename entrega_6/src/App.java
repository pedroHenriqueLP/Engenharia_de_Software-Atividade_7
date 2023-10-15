import java.util.*;
import classes.*;

public class App {

    private static Camera camera = new Camera(1, "12:00 - 13/10/2023", "19:00 - 13/10/2023");
    private static Garagem garagem = new Garagem(false, 60, 12);

    public static void limpar_Tela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static List<Pessoa> inquilinos = new ArrayList<>();

    public static void cadastrar_Inquilino(Scanner scanner) {
        System.out.println("Cadastrando novo inquilino.");
        System.out.println("Por favor, insira as informações abaixo.");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Número do Apartamento: ");
        int n_apartamento = scanner.nextInt();


        System.out.print("Quantidade de Veículos: ");
        int qtd_veiculos = scanner.nextInt();


        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        scanner.nextLine();


        Pessoa novoInquilino = new Pessoa(nome, cpf, n_apartamento, qtd_veiculos, genero);
        inquilinos.add(novoInquilino);
        System.out.println("Novo inquilino cadastrado com sucesso: " + novoInquilino.getNome() + "\n");
    }

    public static void fazer_Login(Scanner scanner) {
        System.out.println("Digite o CPF: ");
        String cpfInput = scanner.next();
        System.out.println("Digite o número do apartamento: ");
        int n_apartamentoInput = scanner.nextInt();

        boolean found = false;
        Pessoa inquilinoEncontrado = null;
        for (Pessoa inquilino : inquilinos) {
            if (inquilino.getCpf().equals(cpfInput) && inquilino.getN_apartamento() == n_apartamentoInput) {
                found = true;
                inquilinoEncontrado = inquilino;
                break;
            }
        }

        if (found) {
            System.out.println("Olá, " + inquilinoEncontrado.getNome() + "!");
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("Selecione uma opção:");
                System.out.println("1. Requisitar Vagas");
                System.out.println("2. Atribuir Veiculo");
                System.out.println("3. Voltar ao Menu");

                int opcaoLogado = scanner.nextInt();
                switch (opcaoLogado) {
                    case 1:
                        inquilinoEncontrado.requisitar_Vagas();
                        break;
                    case 2:
                        inquilinoEncontrado.atribuir_Veiculo(scanner);
                        break;
                    case 3:
                        System.out.println("Retornando ao menu inicial.");
                        loggedIn = false;
                        limpar_Tela();
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            }
        } else {
            System.out.println("Credenciais inválidas. Retornando para o menu inicial. \n\n");
        }
    }

    public static void login_ADM(Scanner scanner) {
        System.out.print("Usuário: ");
        String usuario = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();

        if (usuario.equals("admin") && senha.equals("admin123")) {
            limpar_Tela();
            boolean logado = true;
            while (logado == true) {
                System.out.println("Login bem-sucedido. Bem-vindo, Administrador!");
                System.out.println("Escolha uma das opcoes:");
                System.out.println("1. Abrir/Fechar portão.");
                System.out.println("2. Exibir gravações das câmeras.");
                System.out.println("3. Voltar ao Menu Inicial");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        garagem.interagir_Portao(scanner);
                        limpar_Tela();
                        break;

                    case 2:
                        camera.exibir_Filmagem(scanner);
                        limpar_Tela();
                        break;

                    case 3:
                        limpar_Tela();
                        logado = false;
                        break;

                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        } else {
            System.out.println("Credenciais inválidas. Retornando para o menu inicial. \n\n");
        }
    }

    public static void mostrar_Inquilinos() {
        if (inquilinos.isEmpty()) {
            System.out.println("Nenhum inquilino cadastrado.");
        } else {
            System.out.println("Lista de inquilinos cadastrados:");
            for (Pessoa inquilino : inquilinos) {
                System.out.println("Nome: " + inquilino.getNome());
                System.out.println("CPF: " + inquilino.getCpf());
                System.out.println("Número do Apartamento: " + inquilino.getN_apartamento());
                System.out.println("Quantidade de Veículos: " + inquilino.getQtd_veiculos());
                System.out.println("Gênero: " + inquilino.getGenero());
                System.out.println("---------------------------------------");
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Pessoa porteiro = new Pessoa("Pedro", "16060618600", 0, 0, "M");
        inquilinos.add(porteiro);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Bem-vindo ao sistema de estacionamento!");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar Inquilino");
            System.out.println("2. Login - Inquilinos");
            System.out.println("3. Login - ADM");
            System.out.println("4. Sair");
            System.out.println("5. [PARA TESTES] Listar Inquilinos");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    limpar_Tela();
                    System.out.println("Você escolheu cadastrar inquilino.");
                    cadastrar_Inquilino(scanner);
                    break;

                case 2:
                    limpar_Tela();
                    System.out.println("Você escolheu fazer Login.");
                    fazer_Login(scanner);
                    break;

                case 3:
                    limpar_Tela();
                    System.out.println("Você escolheu Login ADM. \n");
                    login_ADM(scanner);
                    break;

                case 4:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    running = false;
                    break;

                case 5:
                    limpar_Tela();
                    System.out.println("Você escolheu listar inquilinos:\n");
                    mostrar_Inquilinos();
                    break;

                default:
                    limpar_Tela();
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida. \n");
                    break;
            }
        }
        scanner.close();
    }
}