import java.util.ArrayList;

public class EjercicioR868
{   
    ArrayList<Alumno> alumnosJuntos;

    public EjercicioR868() 
    {
        alumnosJuntos = new ArrayList<Alumno>();
    }

    public ArrayList<Alumno> obtenerAlumnosOrdenadorPorNotaMedia(ArrayList<Alumno> alumnosGrupo1, ArrayList<Alumno> alumnosGrupo2) 
    {
        int cont = 0;
        alumnosJuntos.addAll(alumnosGrupo1);
        alumnosJuntos.addAll(alumnosGrupo2);
        ArrayList<Alumno> copiaListadoAlumnos = new ArrayList(alumnosJuntos);
        ArrayList<Alumno> listadoAlumnosFinal = new ArrayList();
        while (copiaListadoAlumnos.size() > 0) {
            listadoAlumnosFinal.add(localizaMayorLoRetornaYLoBorra(copiaListadoAlumnos));
        }
        while (cont < listadoAlumnosFinal.size()) {
            if (listadoAlumnosFinal.get(cont).getMedia() < 5){
                listadoAlumnosFinal.remove(cont);
                cont--;
            }
            cont ++;
        }
        return listadoAlumnosFinal;
    }

    /**
     * A partir de un arraylist busca el mayor objeto y lo devuelve sin ese elemento
     */
    public Alumno localizaMayorLoRetornaYLoBorra(ArrayList<Alumno> coleccion)
    {
        Alumno alumnoConMayorNota = null;
        int posicionAlumnoConMayorNota = -1;
        double notaReferencia = 0;
        int posicion = 0;
        for (Alumno alumno : alumnosJuntos){
            if (alumno.getMedia() >= notaReferencia){
                notaReferencia = alumno.getMedia();
                alumnoConMayorNota = alumno;
                posicionAlumnoConMayorNota = posicion;
            }
            posicion++;
        }
        coleccion.remove(posicionAlumnoConMayorNota);
        return alumnoConMayorNota;
    }
}