import java.util.Scanner; // ✅ Aquí nunca lleva llaves

public class Menu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("____________________________");
        System.out.println("=== MENÚ DEL RESTAURANTE ===");
        System.out.println("____________________________");
        System.out.println("1. Hamburguesa - $15.000");
        System.out.println("2. Pizza - $20.000");
        System.out.println("3. Perro Caliente - $10.000");
        System.out.println("4. Ensalada - $12.000");
        System.out.println("5. Salir");
        System.out.println("____________________________");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.println("____________________________");
            System.out.println("Elegiste Hamburguesa. Total: $15.000");
        }
        if (opcion == 2) {
            System.out.println("____________________________");
            System.out.println("Elegiste Pizza. Total: $20.000");
        }
        if (opcion == 3) {
            System.out.println("____________________________");
            System.out.println("Elegiste Perro Caliente. Total: $10.000");
        }
        if (opcion == 4) {
            System.out.println("____________________________");
            System.out.println("Elegiste Ensalada. Total: $12.000");
        }
        if (opcion == 5) {
            System.out.println("____________________________");
            System.out.println("Gracias por venir. ¡Hasta pronto!");
        }
        if (opcion < 1 || opcion > 5) {
            System.out.println("____________________________");
            System.out.println("Opción no válida, intenta otra vez.");
        }

        sc.close();
    }
}
