import java.util.Scanner;

    public class Menu3{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
             int opcionPrincipal = 0;

             while (opcionPrincipal !=3) {
                System.out.println("-------------------------");
                System.out.println("   MENÚ PRINCIPAL        ");
                System.out.println("-------------------------");
                System.out.println("  1 - Menu de productos  ");
                System.out.println("  2 - Menu de compras    ");
                System.out.println("  3 - Terminar           ");
                System.out.println("-------------------------");
                System.out.println("   ¿Cuál es su opción?   ");
                System.out.println("-------------------------");
                opcionPrincipal = sc.nextInt();

                if (opcionPrincipal == 1){
                    int opcionProducto = 0;
                    while (opcionProducto !=2){

                        System.out.println("-------------------------");
                        System.out.println("    MENÚ DE PRODUCTOS    ");
                        System.out.println("-------------------------");
                        System.out.println("     1 - Cafe Latte      ");
                        System.out.println("     2. Volver al menu   ");
                        System.out.println("-------------------------");
                        System.out.println("     Elija su opcion     ");
                        System.out.println("-------------------------");
                        opcionProducto = sc.nextInt();

                        if (opcionProducto == 1){
                            System.out.println("-------------------------");
                            System.out.println(" Elegiste un cafe Latte  ");
                            System.out.println("-------------------------");
                        }
                            else if (opcionProducto == 2){
                                System.out.println("-----------------------------");
                                System.out.println(" Volviendo al menu principal ");
                                System.out.println("-----------------------------");
                            }
                                else {
                                    System.out.println(" Opción no válida ");
                                }
                    }
                }
                if (opcionPrincipal == 2){
                    int opcionCompra = 0;
                    while (opcionCompra !=3){

                        System.out.println("-------------------------------");
                        System.out.println("     MENÚ DE COMPRAS           ");
                        System.out.println("-------------------------------");
                        System.out.println("  1 - Comprar una unidad       ");
                        System.out.println("  2 - Comprar dos unidades     ");
                        System.out.println("  3 - Volver al menú principal "); 
                        System.out.println("-------------------------------");
                        System.out.println("     Elige tu opcion           ");
                        System.out.println("-------------------------------");
                        opcionCompra = sc.nextInt();

                        if (opcionCompra == 1){
                            System.out.println("-----------------------------");
                            System.out.println(" Elegiste comprar una unidad ");
                            System.out.println("-----------------------------");

                        }
                            else if (opcionCompra == 2){
                                System.out.println("-------------------------------");
                                System.out.println(" Elegiste comprar dos unidades ");
                                System.out.println("-------------------------------");
                            }
                                else if (opcionCompra == 3){
                                    System.out.println("-----------------------------");
                                    System.out.println(" Volviendo al menú principal ");
                                    System.out.println("-----------------------------");
                                }
                                    else {
                                        System.out.println(" Opción no válida ");
                                    }

                    }
                }
                if (opcionPrincipal == 3){
                    System.out.println("-------------------------------");
                    System.out.println(" Gracias por usar este sistema ");
                    System.out.println("-------------------------------");
                }
                if (opcionPrincipal < 1 || opcionPrincipal > 3){
                    System.out.println(" Opción no válida ");
                }
             }
             sc.close();
        }
    }