package Data;

public class StackMedicamento {

    private Nodo cima;

    private static class Nodo {
        Medicamento medicamento;
        Nodo siguiente;

        Nodo(Medicamento medicamento) {
            this.medicamento = medicamento;
            this.siguiente = null;
        }
    }

    public StackMedicamento() {
        cima = null;
    }

    public void push(Medicamento medicamento) {
        Nodo nuevo = new Nodo(medicamento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public Medicamento pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        Medicamento med = cima.medicamento;
        cima = cima.siguiente;
        return med;
    }

    public Medicamento peek() {
        if (isEmpty()) {
            return null;
        }
        return cima.medicamento;
    }

    public boolean isEmpty() {
        return cima == null;
    }
}
