import PagoService from '../services/PagoService';
import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';

class GenerarPagos extends Component {
  generarPagos = () => {
    PagoService.realizarCalculos();
    window.alert("Se han generado los pagos");
  };

  eliminarPagos = () => {
    PagoService.eliminarPagos();
    window.location.href = "/eliminarPagos";
  };

  mostrarPagos = () => {
    window.location.href = "/mostrarPagos";
  };

  render() {
    return (
      <div className="text-center">
        <Button className="m-2" variant="primary" onClick={this.generarPagos}>
          Generar Pagos
        </Button>
        <Button className="m-2" variant="danger" onClick={this.eliminarPagos}>
          Eliminar Pagos
        </Button>
        <Button className="m-2" variant="info" onClick={this.mostrarPagos}>
          Mostrar Pagos
        </Button>
      </div>
    );
  }
}

export default GenerarPagos;
