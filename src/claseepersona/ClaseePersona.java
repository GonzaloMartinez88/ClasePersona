
package claseepersona;

import java.util.Scanner;


public class ClaseePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreAlumno;
        String apellidoAlumno;
        String fechaAlumno;
        String fechaNacimiento;
        Persona persona;
        int numPersConFecha;
        int numPersSinFecha;
        String cadenaNuevaFecha;
        boolean fechaCorrecta;
        numPersConFecha = sc.nextInt();
        numPersSinFecha = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= numPersConFecha; i++) {
            nombreAlumno = sc.nextLine();
            apellidoAlumno = sc.nextLine();
            fechaAlumno = sc.nextLine();
            try {
                persona = new Persona(nombreAlumno, apellidoAlumno, fechaAlumno);
                fechaNacimiento = persona.getFechaNacimiento();
                System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos()
                        + ", nacido el " + fechaNacimiento.substring(0, 2) + " del "
                        + fechaNacimiento.substring(3, 5) + " de " + fechaNacimiento.substring(6));
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }
        for (int i = 0; i < 10; i++) {
            
        }
        for (int i = 1; i <= numPersSinFecha; i++) {
            nombreAlumno = sc.nextLine();
            apellidoAlumno = sc.nextLine();
            try {
                persona = new Persona(nombreAlumno, apellidoAlumno);
                fechaNacimiento = persona.getFechaNacimiento();
                System.out.println("Procesado: " + persona.getNombre() + " "
                        + persona.getApellidos() + ", nacido el " + fechaNacimiento);

                if (i == numPersSinFecha) {
                    fechaCorrecta = false;
                    cadenaNuevaFecha = sc.nextLine();
                    while (!fechaCorrecta) {
                        try {
                            persona.setFechaNacimiento(cadenaNuevaFecha);
                            fechaNacimiento = persona.getFechaNacimiento();
                            fechaCorrecta = true;
                            System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos()
                                    + ", nacido el " + fechaNacimiento.substring(0, 2) + " del "
                                    + fechaNacimiento.substring(3, 5) + " de " + fechaNacimiento.substring(6));
                        } catch (IllegalArgumentException ex1) {
                            System.out.println("Fecha Incorrecta");
                            cadenaNuevaFecha = sc.nextLine();
                        }
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }
    }
}
