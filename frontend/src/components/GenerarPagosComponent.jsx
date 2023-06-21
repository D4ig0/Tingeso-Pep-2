import PagoService from '../services/PagoService';
import React, { Component } from 'react';
import Tabla from './VisualizarPagosComponent';


class GenerarPagos extends Component {
    generarPagos = () => {
        PagoService.realizarCalculos()
        window.alert("Se han generado los pagos")
      };
      
       eliminarPagos = () => {
        PagoService.eliminarPagos()
        window.location.href = "/proveedores";
      };
      mostrarPagos = () => {
        window.location.href = "/mostrarPagos";
      };
  render() {
  return (
    <div >
      <button onClick={this.generarPagos}> Generar Pagos</button>
        <button onClick={ this.eliminarPagos}>Eliminar Pagos</button>
        <button onClick={ this.mostrarPagos}>Mostrar Pagos</button>
        
    </div>
  );
}
}
export default GenerarPagos;
