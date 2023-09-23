package com.workshop.postal.service;

import com.workshop.postal.BusinessException;
import com.workshop.postal.CrearEnvioRequest;
import com.workshop.postal.models.Cliente;
import com.workshop.postal.models.Empleado;
import com.workshop.postal.models.Envio;
import com.workshop.postal.models.enums.EstadoEnvio;
import com.workshop.postal.models.enums.TipoEmpleado;
import com.workshop.postal.models.enums.TipoPaquete;
import com.workshop.postal.repository.ClienteRepository;
import com.workshop.postal.repository.EnvioRepository;
import com.workshop.postal.service.Interfaces.IEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.workshop.postal.repository.EmpleadoRepository;

@Service
public class EnvioService implements IEnvioService {




        @Autowired
        private EnvioRepository envioRepository;

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired
        private EmpleadoRepository empleadoRepository;

        @Transactional
        public Envio crearEnvio(CrearEnvioRequest request) throws BusinessException {
            // Validar si el cliente existe
            Cliente remitente = clienteRepository.findByCedula(request.getCedulaCliente());
            if (remitente == null) {
                throw new BusinessException("El cliente con cédula " + request.getCedulaCliente() + " no está registrado.");
            }

            // Calcular el tipo de paquete basado en el peso
            TipoPaquete tipoPaquete = calcularTipoPaquete(request.getPeso());

            // Calcular el valor del envío
            double valorEnvio = calcularValorEnvio(tipoPaquete);

            // Crear un nuevo envío
            Envio envio = new Envio();
            envio.setCliente(remitente);
            envio.setCiudadOrigen(request.getCiudadOrigen());
            envio.setCiudadDestino(request.getCiudadDestino());
            envio.setDireccionDestino(request.getDireccionDestino());
            envio.setNombrePersonaReceptor(request.getNombreRecibe());
            envio.setNumeroCelularReceptor(request.getCelular());
            envio.setValorEnvio(valorEnvio);
            envio.setEstadoEnvio(EstadoEnvio.RECIBIDO);

            // Guardar el envío en la base de datos y generar un número de guía
            envio = envioRepository.save(envio);

            // Generar número de guía (implementa lógica para generar un número único)

            String numeroGuia = generarNumeroGuia();
            envio.setNumeroGuia(numeroGuia);
            envioRepository.save(envio);

            return envio;
        }

        private TipoPaquete calcularTipoPaquete(double peso) {
            if (peso < 2) {
                return TipoPaquete.LIVIANO;
            } else if (peso < 5) {
                return TipoPaquete.MEDIANO;
            } else {
                return TipoPaquete.GRANDE;
            }
        }

        private double calcularValorEnvio(TipoPaquete tipoPaquete) {
            switch (tipoPaquete) {
                case LIVIANO:
                    return 30000;
                case MEDIANO:
                    return 40000;
                case GRANDE:
                    return 50000;
                default:
                    return 0;
            }
        }

       // private String generarNumeroGuia()


        @Transactional(readOnly = true)
        public Envio obtenerEnvioPorNumeroGuia(String numeroGuia) {
            return envioRepository.findByNumeroGuia(numeroGuia);
        }

        @Transactional
        public Envio actualizarEstadoEnvio(String numeroGuia, String estadoEnvio, Long cedulaEmpleado) throws BusinessException {
            // Validar si el empleado existe
            Empleado empleado = empleadoRepository.findByCedula(cedulaEmpleado);
            if (empleado == null) {
                throw new BusinessException("El empleado con cédula " + cedulaEmpleado + " no existe en nuestra compañía.");
            }

            // Obtener el envío por número de guía
            Envio envio = envioRepository.findByNumeroGuia(numeroGuia);
            if (envio == null) {
                throw new BusinessException("No se encontró un envío con el número de guía " + numeroGuia + ".");
            }

            // Validar si el empleado tiene permisos para actualizar el estado
            if (!empleado.getTipoEmpleado().equals(TipoEmpleado.REPARTIDOR) &&
                    !empleado.getTipoEmpleado().equals(TipoEmpleado.COORDINADOR)) {
                throw new BusinessException("El empleado no tiene permisos para actualizar el estado del paquete.");
            }

            // Validar las transiciones de estado permitidas
            if (envio.getEstadoEnvio().equals(EstadoEnvio.RECIBIDO) && !estadoEnvio.equals("EN RUTA")) {
                throw new BusinessException("No se puede cambiar el estado de RECIBIDO a " + estadoEnvio);
            } else if (envio.getEstadoEnvio().equals(EstadoEnvio.EN_RUTA) && !estadoEnvio.equals("ENTREGADO")) {
                throw new BusinessException("No se puede cambiar el estado de EN RUTA a " + estadoEnvio);
            }

            // Actualizar el estado del envío y guardarlo en la base de datos
            envio.setEstadoEnvio(EstadoEnvio.valueOf(estadoEnvio));
            envio = envioRepository.save(envio);

            return envio;
        }

        @Transactional(readOnly = true)
        public List<Envio> filtrarEnviosPorEstado(String estadoEnvio, Long cedulaEmpleado) throws BusinessException {
            // Validar si el empleado existe
            Empleado empleado = empleadoRepository.findByCedula(cedulaEmpleado);
            if (empleado == null) {
                throw new BusinessException("El empleado con cédula " + cedulaEmpleado + " no existe en nuestra compañía.");
            }

            // Validar si el empleado tiene permisos para filtrar envíos por estado
            if (!empleado.getTipoEmpleado().equals(TipoEmpleado.REPARTIDOR) &&
                    !empleado.getTipoEmpleado().equals(TipoEmpleado.COORDINADOR)) {
                throw new BusinessException("El empleado no tiene permisos para filtrar envíos por estado.");
            }

            return envioRepository.findByEstadoEnvio(EstadoEnvio.valueOf(estadoEnvio));
        }
    }


