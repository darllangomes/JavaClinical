package negocio;

import java.io.Serializable;
import java.time.LocalDate;

public class Cirurgia {

    private String id;
    private Paciente paciente;  // Atributo tipo Paciente;
    private Medico medico;  // Atributo tipo Medico
    private boolean marcada;
    private LocalDate data;
    private String tipoCirurgia;

    public Cirurgia(String id, Paciente paciente, Medico medico, boolean marcada) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.marcada = marcada;
    }

    public Cirurgia() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    public void setTipoCirurgia(String tipoCirurgia) {
        this.tipoCirurgia = tipoCirurgia;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString() {
        return "Cirurgia:\nid: " + id + "\n" + paciente + "\n" + medico;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cirurgia other = (Cirurgia) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (marcada != other.marcada) {
            return false;
        }
        if (medico == null) {
            if (other.medico != null) {
                return false;
            }
        } else if (!medico.equals(other.medico)) {
            return false;
        }
        if (paciente == null) {
            if (other.paciente != null) {
                return false;
            }
        } else if (!paciente.equals(other.paciente)) {
            return false;
        }
        return true;
    }
}
