package com.workshop.postal.service.Interfaces;
import com.workshop.postal.BusinessException;
import com.workshop.postal.CrearEnvioRequest;
import com.workshop.postal.models.Envio;

import java.util.List;
public interface IEnvioService {




        Envio crearEnvio(CrearEnvioRequest request) throws BusinessException;

        Envio obtenerEnvioPorNumeroGuia(String numeroGuia);

        Envio actualizarEstadoEnvio(String numeroGuia, String estadoEnvio, Long cedulaEmpleado) throws BusinessException;

        List<Envio> filtrarEnviosPorEstado(String estadoEnvio, Long cedulaEmpleado) throws BusinessException;
    }


