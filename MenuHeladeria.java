import java.util.Scanner;

public class MenuHeladeria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double total = 0;
        StringBuilder ticket = new StringBuilder();
        boolean compraRealizada = false;
        
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║            HELADERIA DANNA Y MARIANA             ║");
        System.out.println("║                 ¡Bienvenido!                     ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        
        // WHILE principal
        while (true) {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│                 MENÚ PRINCIPAL                   │");
            System.out.println("├──────────────────────────────────────────────────┤");
            System.out.println("│ 1.  Ver sabores y comprar                       │");
            System.out.println("│ 2.  Personalizar helado completo                │");
            System.out.println("│ 3.  Ver promociones                             │");
            System.out.println("│ 4.  Información de la tienda                    │");
            System.out.println("│ 5.  Finalizar pedido y pagar                    │");
            System.out.println("│ 6.  Salir sin comprar                           │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("➤ Seleccione una opción (1-6): ");
            
            // IF para validar entrada
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar entrada inválida
                continue;
            }
            
            // SWITCH para menú principal
            switch (opcion) {
                case 1:
                    total = procesarCompraCompleta(scanner, total, ticket);
                    if (total > 0) {
                        compraRealizada = true;
                        System.out.println("Agregado al pedido. Total actual: $" + total);
                    }
                    break;
                    
                case 2:
                    total = procesarCompraCompleta(scanner, total, ticket);
                    if (total > 0) {
                        compraRealizada = true;
                        System.out.println("Agregado al pedido. Total actual: $" + total);
                    }
                    break;
                    
                case 3:
                    mostrarPromociones(scanner);
                    break;
                    
                case 4:
                    mostrarInformacion(scanner);
                    break;
                    
                case 5:
                    // IF para verificar si hay compra
                    if (compraRealizada && total > 0) {
                        System.out.println("\n╔══════════════════════════════════════════════════╗");
                        System.out.println("║                    COMPRA                        ║");
                        System.out.println("╠══════════════════════════════════════════════════╣");
                        
                        if (ticket.length() > 0) {
                            String[] lineas = ticket.toString().split("\n");
                            for (String linea : lineas) {
                                System.out.printf("║ %-46s ║\n", linea);
                            }
                        } else {
                            System.out.println("║              No hay productos agregados         ║");
                        }
                        
                        System.out.println("╠══════════════════════════════════════════════════╣");
                        System.out.printf("║ TOTAL: $%-38.2f ║\n", total);
                        System.out.println("╠══════════════════════════════════════════════════╣");
                        System.out.println("║            ¡TRANSACCIÓN COMPLETADA!              ║");
                        System.out.println("║         ¡Gracias por su compra!                  ║");
                        System.out.println("║         ¡Vuelva pronto!                          ║");
                        System.out.println("╚══════════════════════════════════════════════════╝");
                        
                        scanner.close();
                        return;
                    } else {
                        System.out.println("No hay productos en el pedido. Primero realice una compra.");
                    }
                    break;
                    
                case 6:
                    // IF para despedida diferente
                    if (compraRealizada) {
                        System.out.println("\n╔══════════════════════════════════════════════════╗");
                        System.out.println("║      ¡Gracias por su compra! Hasta pronto!       ║");
                        System.out.println("╚══════════════════════════════════════════════════╝");
                    } else {
                        System.out.println("\n╔══════════════════════════════════════════════════╗");
                        System.out.println("║      ¡Gracias por visitarnos! Hasta pronto!      ║");
                        System.out.println("╚══════════════════════════════════════════════════╝");
                    }
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Esta opción no válida. Intente nuevamente.");
            }
        }
    }
    
    // Método principal para procesar toda la compra
    public static double procesarCompraCompleta(Scanner scanner, double total, StringBuilder ticket) {
        double nuevoTotal = total;
        String sabor = seleccionarSabor(scanner);
        
        if (sabor != null) {
            double precioSabor = obtenerPrecioSabor(sabor);
            nuevoTotal += precioSabor;
            ticket.append("• Sabor: ").append(sabor).append(" - $").append(String.format("%.2f", precioSabor)).append("\n");
            
            String envase = seleccionarEnvase(scanner);
            double precioEnvase = obtenerPrecioEnvase(envase);
            nuevoTotal += precioEnvase;
            ticket.append("• Envase: ").append(envase).append(" - $").append(String.format("%.2f", precioEnvase)).append("\n");
            
            String topping = seleccionarTopping(scanner);
            double precioTopping = obtenerPrecioTopping(topping);
            nuevoTotal += precioTopping;
            ticket.append("• Topping: ").append(topping).append(" - $").append(String.format("%.2f", precioTopping)).append("\n");
            
            String bolas = seleccionarBolas(scanner);
            double precioBolas = obtenerPrecioBolas(bolas);
            nuevoTotal += precioBolas;
            if (precioBolas > 0) {
                ticket.append("• Bolas: ").append(bolas).append(" - $").append(String.format("%.2f", precioBolas)).append("\n");
            } else {
                ticket.append("• Bolas: ").append(bolas).append("\n");
            }
            
            System.out.println("🎉 ¡Helado completo agregado al pedido!");
        }
        
        return nuevoTotal;
    }
    
    // Métodos de selección con WHILE y SWITCH
    public static String seleccionarSabor(Scanner scanner) {
        while (true) {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│               🍨 ELIJA SU SABOR                  │");
            System.out.println("├──────────────────────────────────────────────────┤");
            System.out.println("│ 1. Chocolate....................... $ 5.000     │");
            System.out.println("│ 2. Vainilla........................ $ 5.000     │");
            System.out.println("│ 3. Fresa........................... $ 5.000     │");
            System.out.println("│ 4. Maracuyá........................ $ 5.000     │");
            System.out.println("│ 5. Lulo............................ $ 5.000     │");
            System.out.println("│ 6. ← Volver al menú principal                   │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print(" Elija un sabor (1-6): ");
            
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1: return "Chocolate";
                    case 2: return "Vainilla";
                    case 3: return "Fresa";
                    case 4: return "Maracuyá";
                    case 5: return "Lulo";
                    case 6: return null;
                    default: System.out.println("Esta opción no válida.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
    }
    
    public static String seleccionarEnvase(Scanner scanner) {
        while (true) {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│                 ELIJA SU ENVASE                 │");
            System.out.println("├──────────────────────────────────────────────────┤");
            System.out.println("│ 1. Cono............................. $ 0        │");
            System.out.println("│ 2. Vaso............................. $ 0        │");
            System.out.println("│ 3. Copa............................. $ 0        │");
            System.out.println("│ 4. ← Volver atrás                               │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("➤ Elija envase (1-4): ");
            
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1: return "Cono";
                    case 2: return "Vaso";
                    case 3: return "Copa";
                    case 4: return "Sin envase";
                    default: System.out.println("Esta opción no válida.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
    }
    
    public static String seleccionarTopping(Scanner scanner) {
        while (true) {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│               🎊 ELIJA TOPPINGS                  │");
            System.out.println("├──────────────────────────────────────────────────┤");
            System.out.println("│ 1. Chocolate líquido................ $ 1.000     │");
            System.out.println("│ 2. Gomitas.......................... $ 2.000     │");
            System.out.println("│ 3. Chispas de Colores............... $ 2.000     │");
            System.out.println("│ 4. Sin toppings...................... $0         │");
            System.out.println("│ 5. ← Volver atrás                               │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("➤ Elija topping (1-5): ");
            
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1: return "Chocolate líquido";
                    case 2: return "Gomitas";
                    case 3: return "Chispas de Colores";
                    case 4: return "Sin toppings";
                    case 5: return "Sin toppings";
                    default: System.out.println("Eata opción no válida.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
    }
    
    public static String seleccionarBolas(Scanner scanner) {
        while (true) {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│               🧊 ELIJA BOLAS                    │");
            System.out.println("├──────────────────────────────────────────────────┤");
            System.out.println("│ 1. 1 bola............................ $0         │");
            System.out.println("│ 2. 2 bolas (Promo)................... $ 5.000    │");
            System.out.println("│ 3. 3 bolas (Mega Promo).............. $ 10.000   │");
            System.out.println("│ 4. ← Volver atrás                               │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("➤ Elija cantidad (1-4): ");
            
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1: return "1 bola";
                    case 2: return "2 bolas";
                    case 3: return "3 bolas";
                    case 4: return "1 bola";
                    default: System.out.println("Esta opción no válida.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
    }
    
    // Métodos para obtener precios con IF
    public static double obtenerPrecioSabor(String sabor) {
        if (sabor.equals("Chocolate")) return 5.000;
        if (sabor.equals("Vainilla")) return 5.000;
        if (sabor.equals("Fresa")) return 5.000;
        if (sabor.equals("Maracuyá")) return 5.000;
        if (sabor.equals("Lulo")) return 5.000;
        return 0;
    }
    
    public static double obtenerPrecioEnvase(String envase) {
        if (envase.equals("Cono")) return 0;
        if (envase.equals("Vaso")) return 0;
        if (envase.equals("Copa")) return 0;
        return 0;
    }
    
    public static double obtenerPrecioTopping(String topping) {
        if (topping.equals("Chocolate líquido")) return 1.000;
        if (topping.equals("Gomitas")) return 2.000;
        if (topping.equals("Chipas de colores")) return 2.000;
        return 0;
    }
    
    public static double obtenerPrecioBolas(String bolas) {
        if (bolas.equals("2 bolas")) return 5.000;
        if (bolas.equals("3 bolas")) return 10.000;
        return 0;
    }
    
    public static void mostrarPromociones(Scanner scanner) {
        System.out.println("\n┌──────────────────────────────────────────────────┐");
        System.out.println("│                  PROMOCIONES ACTIVAS            │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│    2 bolas de helado por solo $ 5.000 extra      │");
        System.out.println("│    3 bolas de helado por solo $ 10.000 extra     │");
        System.out.println("│    Nota: Toppings con 10% de descuento en combos       │");
        System.out.println("└──────────────────────────────────────────────────┘");
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
    
    public static void mostrarInformacion(Scanner scanner) {
        System.out.println("\n┌──────────────────────────────────────────────────┐");
        System.out.println("│                   INFORMACIÓN                     │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│    Horario: Lunes a Domingo 10 AM - 5 PM         │");
        System.out.println("│    Ubicación: Calle 9 # 5-34 Sur                 │");
        System.out.println("│    Teléfono: 3005002020                          │");
        System.out.println("│    Email: dannaymarianaheladeria.@gmail.com      │");
        System.out.println("└──────────────────────────────────────────────────┘");
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
}