import React, { Component } from "react";
import Table from "react-bootstrap/Table";
import PagosService from "../services/PagoService";

class VisualizarPagosComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      pagos: [],
    };
  }

  componentDidMount() {
    PagosService.obtenerPagos()
      .then((response) => {
        this.setState({ pagos: response.data });
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div className="table-responsive">
        <Table className="table table-striped">
          <thead>
            <tr>
              <th>Quincena</th>
              <th>Código proveedor</th>
              <th>Nombre Proveedor</th>
              <th>TOTAL KILOS Leche</th>
              <th>Número días enviados de leche</th>
              <th>Promedio diario kilos leche</th>
              <th>% Variación leche</th>
              <th>% Grasa</th>
              <th>% Variación grasa</th>
              <th>% Solidos totales</th>
              <th>% Variación solidos totales</th>
              <th>Pago por Leche</th>
              <th>Pago por Grasa</th>
              <th>Pago por Solidos Totales</th>
              <th>Bonificación por Frecuencia</th>
              <th>Descuento Variación Leche</th>
              <th>Descuento Variación Grasa</th>
              <th>Descuento Variación Solidos Totales</th>
              <th>Pago TOTAL</th>
              <th>Monto Retención</th>
              <th>Monto FINAL</th>
            </tr>
          </thead>
          <tbody>
            {this.state.pagos.map((pago) => (
              <tr key={pago.codigo_proveedor}>
                <td>{pago.quincena}</td>
                <td>{pago.codigo_proveedor}</td>
                <td>{pago.nombre_proveedor}</td>
                <td>{pago.total_kls_leche}</td>
                <td>{pago.nro_dias_leche}</td>
                <td>{pago.promedio_diario_leche}</td>
                <td>{pago.variacion_leche}</td>
                <td>{pago.grasa}</td>
                <td>{pago.variacion_grasa}</td>
                <td>{pago.solidos_totales}</td>
                <td>{pago.variacion_solidos_totales}</td>
                <td>{pago.pago_leche}</td>
                <td>{pago.pago_grasa}</td>
                <td>{pago.pago_solido}</td>
                <td>{pago.frecuencia}</td>
                <td>{pago.dcto_variacion_leche}</td>
                <td>{pago.dcto_variacion_grasa}</td>
                <td>{pago.dcto_variacion_solidos_totales}</td>
                <td>{pago.pago_total}</td>
                <td>{pago.monto_retencion}</td>
                <td>{pago.monto_final}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    );
  }
}

export default VisualizarPagosComponent;
