import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar elemento al inicio");
            System.out.println("2. Insertar elemento al final");
            System.out.println("3. Mostrar la lista hacia adelante");
            System.out.println("4. Mostrar la lista hacia atrás");
            System.out.println("5. Mostrar tamaño de la lista");
            System.out.println("6. Mostrar si la lista esta vacia");
            System.out.println("7. Buscar elemento por valor");
            System.out.println("8. Buscar elemento por indice");
            System.out.println("9. Borrar elemento de la lista");
            System.out.println("10. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar al inicio: ");
                    int elementoInicio = scanner.nextInt();
                    lista.insertarInicio(elementoInicio);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a insertar al final: ");
                    int elementoFinal = scanner.nextInt();
                    lista.insertarFinal(elementoFinal);
                    break;
                case 3:
                    System.out.println("Recorrido hacia adelante:");
                    lista.recorrerAdelante();
                    break;
                case 4:
                    System.out.println("Recorrido hacia atrás:");
                    lista.recorrerAtras();
                    break;
                case 5:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;
                case 6:
                    System.out.println("La lista está vacía: " + lista.isEmpty());
                    break;
                case 7:
                    if (lista.isEmpty()) {
                        System.out.println("La lista está vacía. No se pueden buscar elementos.");
                    } else {
                        System.out.print("Ingrese el valor a buscar: ");
                        int valorBuscado = scanner.nextInt();
                        Node<Integer> nodoValor = lista.elementoValor(valorBuscado);
                        if (nodoValor != null) {
                            System.out.println("Nodo encontrado: " + nodoValor.item);
                        } else {
                            System.out.println("El valor no se encuentra en la lista.");
                        }
                    }
                    break;

                case 8:
                    if (lista.isEmpty()) {
                        System.out.println("La lista está vacía. No se pueden buscar elementos.");
                    } else {
                        System.out.print("Ingrese el índice a buscar: ");
                        int indiceBuscado = scanner.nextInt();
                        Node<Integer> nodoIndice = lista.elementoIndice(indiceBuscado);
                        if (nodoIndice != null) {
                            System.out.println("Nodo encontrado en el índice " + indiceBuscado + ": " + nodoIndice.item);
                        } else {
                            System.out.println("El índice está fuera de rango.");
                        }
                    }
                    break;

                case 9:
                    System.out.print("Ingrese la posición del elemento a borrar: ");
                    int posicionBorrar = scanner.nextInt();
                    lista.deleteFromPosition(posicionBorrar);
                    System.out.println("Elemento en la posición " + posicionBorrar + " borrado correctamente.");
                    break;
                case 10:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        scanner.close();
    }
}