package claseepersona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

/**
 * Clase que representa a una persona Contiene informacion de cada una de ellas.
 *
 * @author Gonzalo
 */
class Persona {
    
    // Atributos
      /**
     *
     * @param nombre nombre de la Persona
     * @param apellidos Los apellidos de la Persona
     * @param fecha de nacimiento de la persona
     */
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;


  
    /**
     * Constructor con dos parametros
     *
     * @param nombre nombre de la persona
     * @param apellidos apellidos de la persona
     */
    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

    }
/**
 * constructor de 3 parametros
 * @param nombre nombre de la persona
 * @param apellidos apellidos de la persona
 * @param fechaNacimiento
 * @throws IllegalArgumentException Si alguna de estas cadenas estan vacias.
 */
    public Persona(String nombre, String apellidos, String fechaNacimiento) throws
            IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }

    }
/**
 * 
 * @return devuelve el valor actual del atributo "nombre" de la clase persona
 */
    public String getNombre() {
        return nombre;
    }
/**
 * 
 * @return devuelve el valor actual del atributo "apellidos" de la clase persona 
 */
    public String getApellidos() {
        return apellidos;
    }
/**
 * este metodo
 * @param separador recibe el caracter -
 * @throws lanza la excepcion si el separador es diferente a "-" o "/"
 * @return devuelve la fecha con el formato "dd-mm-yyyy"
 */
    public String getFechaNacimiento(char separador) {
        String fecha = null;
        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaNacimiento.getDayOfMonth(),
                        separador,
                        this.fechaNacimiento.getMonthValue(), separador, this.fechaNacimiento.getYear());
            }
            return fecha;
        }
    }
/**
 * 
 * @return Devuelve la fecha de nacimiento
 */
    public String getFechaNacimiento() {
        return getFechaNacimiento('-');
    }
/**
 * 
 * @param fechaNacimiento una cadena de caracteres con la fecha de nacimiento
 * @throws IllegalArgumentException  si la fecha no cumple con el formato o es una fecha invalida
 */
    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private LocalDate generarFecha(String fecha) {
        int dia;
        int mes;
        int anyo;
        if (!fecha.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")
                && !fecha.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {
            try {
                System.out.println("fecha");
                dia = Integer.parseInt(fecha.subSequence(0, 2).toString());
                mes = Integer.parseInt(fecha.subSequence(3, 5).toString());
                anyo = Integer.parseInt(fecha.subSequence(6, fecha.length()).toString());
                return LocalDate.of(anyo, mes, dia);
                
            } catch (NumberFormatException ex1) {

                throw new IllegalArgumentException();
            } catch (DateTimeException ex2) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public int getEdadEnFecha(){
        return getEdadEnFecha();
        
    }
    
    
    private int getEdadEnFecha(String cadenaFecha){
            LocalDate fechaActual = generarFecha(cadenaFecha);
        if (this.fechaNacimiento == null || fechaActual.isBefore(this.fechaNacimiento)) {
            return -1;
        }
        int edad = fechaActual.getYear() - this.fechaNacimiento.getYear();
        if (fechaActual.getMonthValue() < this.fechaNacimiento.getMonthValue()
                || (fechaActual.getMonthValue() == this.fechaNacimiento.getMonthValue()
                && fechaActual.getDayOfMonth() < this.fechaNacimiento.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }
    
}
