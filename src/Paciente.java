import java.time.LocalTime;

public class Paciente {
    String nome;
    Urgencia urgencia;
    LocalTime chegada;


    public Paciente(String nome, Urgencia urgencia, LocalTime chegada) {
        this.nome = nome;
        this.urgencia = urgencia;
        this.chegada = chegada;
    }

    public String toString(){
        return String.format(
                """
                        Paciente: %s\s
                        Urgencia: %s\s
                        Chegada: %s"""
                , nome, urgencia, chegada);
    }
}
