package ATIVIDADE1;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

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
                System.out.println("Aluno inserido!");

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
                System.out.println("Aluno inserido!");
            } else {
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                System.out.println("Aluno inserido!");
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
        } else if (this.primeiro.getProx() == null) {
            if (this.primeiro.getInfo().compareTo(al) == 0) {
                this.primeiro = null;
                System.out.println("Aluno removido!!!!!!!!!!!!");
            } else {
                System.out.println("Aluno não encontrado!!!!!!!!!!!!!");
            }

        } else {
            LSENode aux = this.primeiro;
            LSENode anterior = aux;
            if (this.primeiro.getInfo().compareTo(al) == 0) {
                this.primeiro = this.primeiro.getProx();
                System.out.println("Aluno removido!2");
            } else {
                while (aux != null) {
                    if (aux.getInfo().compareTo(al) == 0) {
                        anterior.setProx(aux.getProx());
                        System.out.println("Aluno removido!");
                        break;
                    }
                    anterior = aux;
                    aux = aux.getProx();
                }
                if (aux == null) {
                    System.out.println("Aluno não encontrado.");
                }

            }

        }
    }

    public LSEAluno criarCopia() {
        LSEAluno copy = new LSEAluno();

        if (this.isEmpty()) {
            System.out.println("LISTA VAZIA");
            return copy;
        }

        LSENode aux = this.primeiro;
        Aluno al, al1;
        while (aux != null) {
            al = aux.getInfo;
            al1 = new Aluno(al.getMatricula(), al.getNome());
            al1.setFaltas(al.getFaltas());
            al1.setMedia(al.getMedia());
            copy.insertEnd(al1);
            aux = aux.getProx();
        }

        return copy;
    }

}
