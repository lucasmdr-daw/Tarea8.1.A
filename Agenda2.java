/*
 1º)   Hacer un programa que crea una clase Agenda con 10 nombres de alumnos  con
 su número de teléfono,  y con los siguientes métodos:

-         Cargar los datos de los 10 alumnos.

-         Consulta del teléfono de un alumno determinado

Crea una clase menú con dos opciones que llame a cada uno de los métodos.
 */

package agenda2;
import java.io.BufferedReader; // Uso del bufferreader en vez de scanner
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author ldiaz
 */
public class Agenda2 {
    
    
    public static class ErrorPersonalizado extends Exception{ // Clase personalizada que muestra mensajes de error personalizado en los try-catch
        public ErrorPersonalizado(String textoError){
            super(textoError);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        boolean opcion_correcta = false, salida_programa = false, telefono_correcto = false, coincidencia = false;
        String respuesta_buffer;
        String nombre;
        int opcion_menu = 0, posicion, telefono = 0;
        
        BufferedReader respuestas = new BufferedReader(new InputStreamReader(System.in));    
        alumnos2 datos_alumnos = new alumnos2(); // Creamos un objeo nuevo datos_alumnos de la clase alumnos2
        
        do{ // Presenta en pantalla un menu y controla que las opciones elegidas son las correctas con try-catch, cada vez que se acaba el proceso de una opcion vuelve a presntar el menu
            System.out.println(" ");
            System.out.println("-------------- MENU --------------");
            System.out.println("1.-Introducir los datos de los alumnos.");
            System.out.println("2.-Consultar telefono de alumno.");
            System.out.println("3.-Salir del programa.");
            System.out.print(" ");
            do{ // Repite la preunta de eleccion de respuesta hasta que los valores sean correctos    
                try{ // Controla las excepciones para la eleccion del menu y sino son correctas vuelve a repetir por el bucle DO
                    System.out.print("Indicame una opcion [de 1 a 3]: ");

                    respuesta_buffer = respuestas.readLine(); // 
                    opcion_menu = Integer.parseInt(respuesta_buffer); // Coinvierte a Int la respuesta de buffer read
                    opcion_correcta = true; // si puede convertir el numero prosigue y sale del DO
                    
                    // Desde aqui controla que el numero elegido no sea superio o inferior a los valores del menu o volvera al DO inicial
                    if( opcion_menu < 0 || opcion_menu == 0 || opcion_menu > 3){
                        System.out.println("Ha elegido una opcion no valida.");
                        System.out.println(" ");
                        opcion_correcta = false;
                    }

                }catch(NumberFormatException error01){
                    System.out.println(" Ha introducido algun caracter en vez de numneros.");
                    System.out.println(" Vuelva a intentarlo.");
                    System.out.println(" ");
                    opcion_correcta = false;
                }catch (Exception e){
                    System.out.println("Error no contemplado todavia " + e);
                    System.out.println("Indiquelo al programador.");
                    System.out.println(" ");
                    opcion_correcta = false;
                }
            } while (opcion_correcta == false);

            switch(opcion_menu){
                case 1: // Introduccion de datos del usuario y asignacion al array
                    for (posicion=0;posicion<3;posicion++){ // Bucle FOR que va preguntando datos hasta el tamaño del array para pasar por parametro los valores de nombre alumno y telefono.
                        System.out.println(" ");
                        System.out.print("Dime el nombre del alumno[" + (posicion + 1)+ "]: "); // Se le suma + 1 a posicion, pero solo tiene valor para presentar en pantalla y que no empiece por 0
                        nombre = respuestas.readLine(); // asigna el valor a la variable string nombre
                        
                        do { // Control con DO, que el valor del telefono introducido es un valor correcto o volvera a hacer la pregunta.
                            try{ // Control de excepciones de que los datos para el entero Telefono son correctos.
                                System.out.print("Dime el telefono del alumno ("+ (posicion + 1)+") " + nombre + " : ");
                                telefono = Integer.parseInt(respuestas.readLine()); // Convierte el valor String de entrada del usuario a Entero y lo asigna a la variable telefono
                                
                                if (telefono <= 0){ // Controla que telefono no sea ni 0 ni negativo
                                    System.out.println(" ");
                                    throw new ErrorPersonalizado(" El telefono no puede ser un numero negativo.");
                                }
                                
                                telefono_correcto = true; // Si los cambios y respuestas son correctas sale del DO
                            } catch (NumberFormatException error00){
                                System.out.println(" ");
                                System.out.println(" Ha introducido caracteres en vez de numeros o un valor numerico no valido.");
                                System.out.println(" Vuelva a intentarlo.");
                                System.out.println(" ");
                                telefono_correcto = false;
                            }catch (ErrorPersonalizado error01){ // Gestion del error personaliado que indica que el tamaño del valor no es de 4
                                System.out.println(error01.getMessage());
                                System.out.println(" ");
                                telefono_correcto = false;
                            } // Fin de excepciones    
                        } while (telefono_correcto == false); // FIN DO
                    
                        datos_alumnos.introducirDatos(nombre, telefono, posicion);  // Hacemos una llamada al metodo introducirDatos de la clase alumnos, pasandole los parametros
                                                                                    // hasta completar el tamaño del array    
                    } // Fin FOR
                    salida_programa = false; // Vuelve al menu principal
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.print("Dime el nombre del alumno para ver su telefono: ");
                
                    nombre = respuestas.readLine();
                    coincidencia = datos_alumnos.mostrarTelefono(nombre);
                
                    if (coincidencia == false){
                        System.out.println(" ");
                        System.out.println("NO HAY COICIDENCIAS EN LOS DATOS BUSCADOS");
                        datos_alumnos.mostrarNombres();
                    }
                    salida_programa = false;
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("PROGRAMA TERMINADO A PETICION DEL USUARIO.");
                    System.out.println("(C) Lucas Manuel Diaz Rodriguez 2020-2021");
                    salida_programa = true; // Vuelve al menu Principal
                    break;

            }
        } while (salida_programa == false);
    
    
    } // FIN PUBLIC STATIC VOID
    
} // FIN PUBLIC CLASS Agenda2
