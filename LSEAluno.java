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

    public void inserirAluno(Aluno al) {
        // insere um novo aluno no início de lista de alunos
        LSENode novo;
        novo = new LSENode(al);
        if (this.isEmpty()) {
            this.primeiro = novo;

        } else {
            novo.setProx(this.primeiro);
            this.primeiro = novo;
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

}
