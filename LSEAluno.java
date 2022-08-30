package ATIVIDADE1;

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
        Aluno al = primeiro;
        al.setMatricula(matr);
        LSENode resultado = buscar(al);
        if ( resultado != null) {
            System.out.println(resultado.getInfo());
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void changeGrade(String matr, double nota) {
        Aluno aux = new Aluno();
        aux.setMatricula(matr);
        LSENode result = buscar(aux);

        if (result != null) {
            result.getInfo().setMedia(nota);
        } else {
            System.out.println("Aluno não encontrado");
        }

    }

}
