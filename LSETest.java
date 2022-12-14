package ATIVIDADE1;

import java.util.Scanner;

public class LSETest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSEAluno turma = new LSEAluno();
        int op;
        Aluno al;
        String nome, matr;
        double media;
        LSEAluno copia = new LSEAluno();
        do {
            exibeMenu();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o nome do aluno: ");
                    nome = in.nextLine();
                    System.out.print("Informe a matrícula do aluno: ");
                    matr = in.nextLine();
                    al = new Aluno(matr, nome);
                    turma.inserirAluno(al);
                    break;
                case 2:
                    System.out.print("Informe o nome do aluno: ");
                    nome = in.nextLine();
                    System.out.print("Informe a matrícula do aluno: ");
                    matr = in.nextLine();
                    al = new Aluno(matr, nome);
                    turma.insertEnd(al);
                    break;
                case 3:
                    turma.exibir();
                    break;
                case 4:
                    System.out.println("Informe a matrícula do aluno:");
                    matr = in.nextLine();
                    turma.exibeAluno(matr);
                    break;
                case 5:
                    System.out.println("Informe a matrícula do aluno: ");
                    matr = in.nextLine();
                    turma.changeGrade(matr);
                    break;
                case 6:
                    System.out.println("Informe a matrícula do aluno: ");
                    matr = in.nextLine();
                    turma.changeAbsences(matr);
                    break;
                case 7:
                    System.out.println("Informe a matrícula do aluno: ");
                    matr = in.nextLine();
                    turma.removeAluno(matr);
                    break;
                case 8:
                    copia = turma.criarCopia();
                    break;
                case 9:
                    System.out.print("Informe o nome do aluno: ");
                    nome = in.nextLine();
                    System.out.print("Informe a matrícula do aluno: ");
                    matr = in.nextLine();
                    al = new Aluno(matr, nome);
                    copia.inserirAluno(al);
                    break;
                case 10:
                    copia.exibir();
                    break;
                case 0:
                    System.out.println("FIM");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 0);
    }

    public static void exibeMenu() {
        System.out.println("Opções");
        System.out.println("1 - Inserir um novo aluno no começo da lista");
        System.out.println("2 - Inserir um novo aluno no final da lista");
        System.out.println("3 - Exibir todos os alunos da lista");
        System.out.println("4 - Exibir os dados de um aluno");
        System.out.println("5 - Alterar a média de um aluno");
        System.out.println("6 - Alterar a quantidade de faltas de um aluno(a)");
        System.out.println("7 - Remover um aluno(a) da lista");
        System.out.println("8 - copiar lista");
        System.out.println("9 - adicionar aluno na cópia");
        System.out.println("10 - exibir copia");
        System.out.println("0 - Encerrar programa");
        System.out.print("Digite a opção desejada: ");
    }

}
