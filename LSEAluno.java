package ATIVIDADE1;

import java.util.Scanner;

public class LSEAluno {
    private LSENode primeiro;

    // Métodos públicos
    public boolean isEmpty() {
        // testa de a lista está vazia
        if (this.primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("LISTA VAZIA");
        } else {
            LSENode aux = this.primeiro;
            this.primeiro = null;
            aux = aux.getProx();
            this.primeiro = aux;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("LISTA VAZIA");
        } else if (this.primeiro.getProx() == null) {
            this.primeiro = null;
        } else {
            LSENode aux = this.primeiro;
            LSENode previous = aux;
            while (aux.getProx() != null) {
                previous = aux;
                aux = aux.getProx();
            }
            previous.setProx(null);
        }
    }

    public void insertEnd(Aluno al) {
        LSENode novo = new LSENode(al);
        LSENode aux;
        LSENode result = this.buscar(al);
        if (result != null) {
            System.out.println("Aluno já existe na lista!");
        } else {
            if (isEmpty()) {
                this.primeiro = novo;
            } else {
                aux = this.primeiro;
                while (aux.getProx() != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novo);

            }
        }

    }

    public void inserirAluno(Aluno al) {
        // insere um novo aluno no início de lista de alunos
        LSENode novo;
        LSENode result = this.buscar(al);
        if (result != null) {
            System.out.println("Aluno já existe na lista!");
        } else {
            novo = new LSENode(al);
            if (this.isEmpty()) {
                this.primeiro = novo;

            } else {
                novo.setProx(this.primeiro);
                this.primeiro = novo;
            }
        }

    }

    private LSENode buscar(Aluno al) {
        LSENode aux;
        if (this.isEmpty()) {
            return null;
        } else {
            aux = this.primeiro;
            while (aux != null) {
                if (aux.getInfo().compareTo(al) == 0) {
                    return aux;
                } else {
                    aux = aux.getProx();
                }
            }
            return null;
        }
    }

    public void exibir() {
        // exibe o conteúdo de todos os nós da lista
        LSENode aux;
        if (this.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            aux = this.primeiro;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void exibeAluno(String matr) {
        Aluno al = new Aluno(matr);
        LSENode result = buscar(al);

        if (result != null) {
            System.out.println("Informações do Aluno: ");
            System.out.println(result.getInfo());
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public void changeGrade(String matr) {
        double newGrade;
        Scanner s = new Scanner(System.in);
        Aluno aux = new Aluno(matr);
        LSENode result = buscar(aux);

        if (result != null) {
            System.out.println("Informe a média do aluno: ");
            newGrade = s.nextDouble();
            result.getInfo().setMedia(newGrade);
            System.out.println("Média alterada!");
        } else {
            System.out.println("Aluno não encontrado");
        }

    }

    public void changeAbsences(String matr) {
        Scanner s = new Scanner(System.in);
        Aluno al = new Aluno(matr);
        LSENode result = buscar(al);
        int absent;
        if (result != null) {
            System.out.println("Informe o número de ausências: ");
            absent = s.nextInt();
            result.getInfo().setFaltas(absent);
            System.out.println("Faltas alteradas!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void removeAluno(String matr) {
        Aluno al = new Aluno(matr);

        if (this.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            LSENode aux = this.primeiro;
            LSENode previous;
            while (aux.getInfo().compareTo(al) != 0) {
                previous = aux;
                aux = aux.getProx();

            }
            previous.setProx(aux.getProx());
            System.out.println("Aluno removido!");

        }
    }

}
