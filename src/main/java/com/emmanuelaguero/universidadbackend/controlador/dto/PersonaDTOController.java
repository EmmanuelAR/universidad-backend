package com.emmanuelaguero.universidadbackend.controlador.dto;

import com.emmanuelaguero.universidadbackend.modelo.dto.PersonaDTO;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Alumno;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Empleado;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Persona;
import com.emmanuelaguero.universidadbackend.modelo.entidades.Profesor;
import com.emmanuelaguero.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.emmanuelaguero.universidadbackend.servicios.contratos.PersonaDAO;

public class PersonaDTOController extends GenericDTOController<Persona, PersonaDAO> {


    protected final AlumnoMapper alumnoMapper;


    public PersonaDTOController(PersonaDAO service, String nombre_Entidad, AlumnoMapper alumnoMapper) {
        super(service, nombre_Entidad);
        this.alumnoMapper = alumnoMapper;
    }

    public PersonaDTO altaPersona(Persona p){
        Persona personaEntidad = super.save(p);
        PersonaDTO dto =null;
        if(personaEntidad instanceof Alumno){
            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
        }else if(personaEntidad instanceof Profesor){
            //aplicamos mapper de profesor
        }else if(personaEntidad instanceof Empleado){
            //aplicamos mapper de emplead
        }
        return dto;
    }
}
