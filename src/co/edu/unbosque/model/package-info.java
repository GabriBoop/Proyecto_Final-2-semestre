/**
 * Paquete que contiene la lógica de negocio y las entidades del sistema de
 * gestión del parqueadero.
 *
 * <p>Incluye las siguientes categorías de clases:</p>
 * <ul>
 *   <li><b>Vehículos:</b> {@code Vehiculo} (clase abstracta), {@code Carro},
 *       {@code Moto} y sus versiones DTO.</li>
 *   <li><b>Propietarios:</b> {@code Propietario} y {@code PropietarioDTO}.</li>
 *   <li><b>Registros y facturación:</b> {@code Registro}, {@code Factura},
 *       {@code Mensualidad} y sus respectivas versiones DTO.</li>
 *   <li><b>Tarifas:</b> {@code Tarifa} (clase abstracta), {@code TarifaPorHora}
 *       y {@code TarifaNocturnaFija}.</li>
 *   <li><b>Enumeraciones:</b> {@code FormaDeCobro} y {@code Jornada}.</li>
 *   <li><b>Servicios externos:</b> {@code InformacionPolicia}, que consulta el
 *       estado legal de un vehículo.</li>
 *   <li><b>Lógica principal:</b> {@code Parqueadero}, que coordina el ingreso y
 *       salida de vehículos, las mensualidades, las facturas y las alertas.</li>
 * </ul>
 *
 * <p>La persistencia de estas entidades se encuentra en el subpaquete
 * {@code co.edu.unbosque.model.persistence}.</p>
 */
package co.edu.unbosque.model;