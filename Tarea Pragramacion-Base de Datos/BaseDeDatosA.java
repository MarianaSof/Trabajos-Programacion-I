import java.util.Scanner;

public class BaseDeDatosA {
    // Arreglos simples para almacenar datos
    static String[] nombres = new String[25];
    static float[] salarios = new float[25];
    static char[] sexos = new char[25];
    static String[] cargos = new String[25];
    static int cantidad = 0; // cantidad de empleados registrados

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n____________________________");
            System.out.println("| ===== MENÚ PRINCIPAL ==== |");
            System.out.println("____________________________");
            System.out.println("| 1. Crear                  |");
            System.out.println("| 2. Leer                   |");
            System.out.println("| 3. Editar                 |");
            System.out.println("| 4. Borrar                 |");
            System.out.println("| 5. Terminar               |");
            System.out.println("____________________________");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    crearEmpleado(sc);
                    break;
                case 2:
                    leerEmpleados();
                    break;
                case 3:
                    editarEmpleado(sc);
                    break;
                case 4:
                    borrarEmpleado(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    // CRUD
    public static void crearEmpleado(Scanner sc) {
        if (cantidad >= 25) {
            System.out.println("No se pueden ingresar más empleados (límite 25).");
            return;
        }
        System.out.print("Ingrese nombre: ");
        nombres[cantidad] = sc.nextLine();
        System.out.print("Ingrese salario: ");
        salarios[cantidad] = sc.nextFloat();
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese sexo (M/F): ");
        sexos[cantidad] = sc.nextLine().charAt(0);
        System.out.print("Ingrese cargo: ");
        cargos[cantidad] = sc.nextLine();

        cantidad++;
        System.out.println("Empleado agregado exitosamente.");
    }

    public static void leerEmpleados() {
        if (cantidad == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("\n=================== LISTA DE EMPLEADOS =====================");
        // Encabezados con formato tipo tabla
        System.out.printf("%-4s | %-15s | %-10s | %-6s | %-15s%n",
                        "ID", "Nombre", "Salario", "Sexo", "Cargo");
        System.out.println("--------------------------------------------------------------");

        // Filas de empleados
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%-4d | %-15s | %-10.2f | %-6c | %-15s%n",
                            (i+1), nombres[i], salarios[i], sexos[i], cargos[i]);
        }
        System.out.println("==============================================================");
    }

    public static void editarEmpleado(Scanner sc) {
        leerEmpleados();
        if (cantidad == 0) return;

        System.out.print("Ingrese el número de empleado a editar: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();

        if (idx < 0 || idx >= cantidad) {
            System.out.println("Empleado no válido.");
            return;
        }

        int opcionEditar;
        do {
            System.out.println("\n--- Menú de Edición ---");
            System.out.println("1. Editar Nombre");
            System.out.println("2. Editar Salario");
            System.out.println("3. Editar Sexo");
            System.out.println("4. Editar Cargo");
            System.out.println("5. Salir de edición");
            System.out.print("Seleccione una opción: ");
            opcionEditar = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcionEditar) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    nombres[idx] = sc.nextLine();
                    System.out.println("Nombre actualizado.");
                    break;
                case 2:
                    System.out.print("Nuevo salario: ");
                    salarios[idx] = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Salario actualizado.");
                    break;
                case 3:
                    System.out.print("Nuevo sexo (M/F): ");
                    sexos[idx] = sc.nextLine().charAt(0);
                    System.out.println("Sexo actualizado.");
                    break;
                case 4:
                    System.out.print("Nuevo cargo: ");
                    cargos[idx] = sc.nextLine();
                    System.out.println("Cargo actualizado.");
                    break;
                case 5:
                    System.out.println("Saliendo del menú de edición...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionEditar != 5);
    }

    public static void borrarEmpleado(Scanner sc) {
        leerEmpleados();
        if (cantidad == 0) return;

        System.out.print("Ingrese el número de empleado a borrar: ");
        int idx = sc.nextInt() - 1;

        if (idx < 0 || idx >= cantidad) {
            System.out.println("Empleado no válido.");
            return;
        }

        // Desplazar todos los elementos a la izquierda
        for (int i = idx; i < cantidad - 1; i++) {
            nombres[i] = nombres[i+1];
            salarios[i] = salarios[i+1];
            sexos[i] = sexos[i+1];
            cargos[i] = cargos[i+1];
        }
        cantidad--;

        System.out.println("Empleado eliminado correctamente.");
    }
}

