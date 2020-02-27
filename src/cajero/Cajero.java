package cajero;

import java.util.Scanner;
import java.util.Random;
public class Cajero {
    static boolean validar_contraseña(int contraseña) {
        Scanner sc = new Scanner(System.in);
        int cl, cl1, intentos=0;
        boolean valor_retorno;
       
        do {
            System.out.println ("Ingrese contraseña:");
            cl1 = sc.nextInt();

            if (cl1==contraseña) {  
                System.out.println ("Contraseña aceptada...");
                valor_retorno = true;
                intentos=3;
            }
            else {
                System.out.println ("Contraseña incorrecta. Intente de nuevo..");
                intentos++;
                valor_retorno = false;
            }
        } while (intentos<3);
        return valor_retorno;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random  rnd = new Random();
       
        boolean resp;
        String documento;
        int cl1=0;
        int cl2=0;
        double Deposito = 0;
        String contraseña="";
        int nocuenta=0;
        String cuenta="";
        String[][] cuentas = new String[5][5];
        //varchar cuentas[][];
        int i=0;
        int op=0;
        int op1=0;
        double retiro = 0;
        double saldo = 0;
        String nombre="";
       
        do {
            System.out.println ("\n\n"); 
            System.out.println ("  Bienvenidos a su Banco UT  ");
            System.out.println ("      MENU PRINCIPAL       ");
            System.out.println ("        Seleccione:        ");
            System.out.println ("   1-Crear Cuenta    ");
            System.out.println ("   2-Menu transacciones    ");
            System.out.println ("         3-Salir           ");
            
            System.out.print ("Seleccione opcion y pulse Enter : ");

            do {
                op = sc.nextInt();
            } while (op<1 && op>3);
           
            switch (op) {
                case 1:
                    System.out.println ("MENU DE APERTURA DE CUENTAS");
                    System.out.println ("Ingrese Nombre");
                    nombre = sc.next();
                    System.out.println ("Ingrese Nro Tarjeta");
                    documento  = sc.next();
                    do {
                            System.out.println ("Ingrese Clave para su nueva cuenta (Valor numerico)");
                            cl1 = sc.nextInt();
                            System.out.println ("Ingrese Nuevamente la Clave para su nueva cuenta (Valor numerico)");
                            cl2 = sc.nextInt();
                            if (cl1 != cl2) {
                                System.out.println ("Error de comprobación de la contraseña.  Intentelo nuevamente...");
                            }
                    }while (cl1 != cl2);                  
                   
                    nocuenta = rnd.nextInt(100);
                    System.out.println ("Ingrese monto deposito inicial:");
                    saldo = sc.nextDouble();
                    System.out.println ("Sr (a) :"+nombre);
                    System.out.println ("Su numero de cuenta es:"+nocuenta);                          
                    System.out.println ("Su saldo es:"+saldo);                          
                    System.out.println ("Pulse cualquier numero y Enter para continuar...");                          
                    op1 = sc.nextInt();
                    break;                  
                case 2:
                    System.out.println ("\n\n");
                    
                    System.out.println ("  Bienvenidos a su Banco UT  ");
                    System.out.println ("      MENU TRANSACCIONES      ");
                    System.out.println ("          1-Deposto:          ");
                    System.out.println ("          2-Retiro            ");
                    System.out.println ("      3-Consultar Saldo       ");
                    System.out.println ("      4-Cambio de clave       ");
                    System.out.println (" 5-Regresar al menu principal ");
                    System.out.print ("Digite opcion...:");
                    op1 = sc.nextInt();
                    switch (op1) {
                        case 1:
                            System.out.println ("Depositos:");
                            //resp = validar_contraseña(cl1);
                            if (validar_contraseña(cl1)) {
                                System.out.println ("Depositar a la cuenta "+cuenta+" De "+nombre);
                                System.out.println ("Ingrese valor Deposito:");
                                Deposito = sc.nextDouble();
                                if (Deposito>0) {
                                    saldo = saldo + Deposito;

                                    System.out.println ("Su nuevo saldo es de : "+saldo);
                                    System.out.println ("Gracias por utilizar nuestros servicios...");
                                }
                            }
                            else {
                                System.out.println ("No se pudo verificar la información suministrada...");
                            }
                            System.out.println ("Pulse cualquier numero y Enter para continuar...");                          
                            op1 = sc.nextInt();
                            break;
                        case 2:
                            System.out.println ("Retiros");
                            if (validar_contraseña(cl1)) {
                                System.out.println ("Ingrese valor a Retirar:");
                                retiro = sc.nextDouble();
                                if (retiro>0) {
                                    saldo = saldo - retiro;

                                    System.out.println ("Su nuevo saldo es de:"+saldo);
                                    System.out.println ("Gracias por utilizar nuestros servicios...");

                                    System.out.println ("Pulse cualquier numero y Enter para continuar...");                          
                                    op1 = sc.nextInt();
                                }
                            }
                            else {
                                System.out.println ("No se pudo verificar la información suministrada...");
                            }
                            break;
                   
                       
                        case 3:
                            System.out.println ("Consulta de saldo");
                            if (validar_contraseña(cl1)) {
                                System.out.println ("Su saldo es de:"+saldo);
                                System.out.println ("Gracias por utilizar nuestros servicios...");

                                System.out.println ("Pulse cualquier numero y Enter para continuar...");                          
                                op1 = sc.nextInt();
                            }
                            else {
                                System.out.println ("No se pudo verificar la información suministrada...");
                            }
                            break;
                           
                        case 4:
                            System.out.println ("Cambio de clave");
                            if (validar_contraseña(cl1)) {
                                System.out.println ("Cambio de clave de la cuenta "+nocuenta+" De "+nombre);

                                do {
                                    System.out.println ("Ingrese nueva Clave (Valor numerico)");
                                    cl1 = sc.nextInt();
                                    System.out.println ("Ingrese Nuevamente la nueva Clave (Valor numerico)");
                                    cl2 = sc.nextInt();
                                    if (cl1 != cl2) {
                                        System.out.println ("Error en la comprobación de la contraseña.  Intentelo nuevamente...");
                                    }
                                }while (cl1 != cl2);  
                                System.out.println ("Se ha asignado nueva clave a la cuenta ");
                            }
                            break;
                        default:
                        System.out.println ("Opcion no valida... Intente nuevamente");
                        break;
                    }
            }
        } while(op!=3);
        System.out.println ("Gracias por utilizar nuestros servicios...Hasta Pronto.");
    }  
}
