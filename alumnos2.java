/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda2;

/**
 *
 * @author ldiaz
 */
public class alumnos2 {
    
    private int [] telefonos = new int[3]; // Declaramos una array unidimensional de enteros para los telefonos
    private String[] nombres = new String[3]; // Declaramos una array unidimensional de String para los nombres
    private int posicion=0; // Declaramos un valor int para jugar con el indice del array
    private boolean acierto = false;
    
    public alumnos2() { // Creamos un constructor vacio
    }
    
    // Generamos metodos Getter y Setter en la clase para trabajar con sus datos.
    
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public void setTelefonos(int[] telefonos) {
        this.telefonos = telefonos;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public int getPosicion() {
        return posicion;
    }
    
    public int[] getTelefonos() {
        return telefonos;
    }

    public String[] getNombres() {
        return nombres;
    }
    
    public void introducirDatos(String nombre,  int telefono, int posicion){
        /*  Creamos un metodo que recibe unos parametros desde la clase principal como son el
            nombre, telefono y posicion(como indice del array), para rellenar el array de la
            clase alumnos.
        */
        
        this.nombres[posicion]= nombre;
        this.telefonos[posicion]=telefono;
        
    }
    
    
    public boolean mostrarTelefono(String nombres){
            boolean coincidencia = false;
            int indice;
            String variable_auxiliar;
            
            System.out.println(" ");
            System.out.println("El dato a buscar es: " + nombres);
            for(indice=0;indice<3;indice++){
                
                variable_auxiliar = this.nombres[indice];
                
                if (nombres.equalsIgnoreCase(variable_auxiliar)){
                    coincidencia = true;
                    System.out.println("Dato coincidente.");
                    System.out.println("Su telefono es " + this.telefonos[indice]);
                } 
                } // Fin de FOR.
        
            return coincidencia;
    } // Fin mostrarTelefono
    
    public void mostrarNombres(){
        for(int posicion=0;posicion<3;posicion++){
            
            if (this.nombres[posicion] == null){
                System.out.println(" ");
                System.out.println("LO SENTIMOS NO HAY DATOS EN LA TABLA TODAVIA.");
                System.out.println("Introduzca datos primero.");
                System.out.println(" ");
                break;
            }
            
            System.out.println("Los nombres de los alumnos son: " + this.nombres[posicion]);
        }
        // System.out.println("Compruebe de nuevo los datos que quiere mostrar.");
        System.out.println(" ");
        
    }
    
}
