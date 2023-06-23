import React, { Component } from 'react';
import PagoService from '../services/PagoService';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';

class EliminarProveedores extends Component {
  handleEliminar = () => {
    PagoService.eliminarPagos();
    window.location.href = "/generarPagos";
    alert("Se han eliminado todos los pagos");
  };

  handleCancelar = () => {
    window.location.href = "/generarPagos";
  };

  render() {
    return (
      <Container className="d-flex align-items-center justify-content-center ">
        <Row className="justify-content-center">
          <Col >
            <div className="text-center mb-5">
              <h4>¿Estás seguro que deseas eliminar todos los pagos?</h4>
              <Button className="mx-2" variant="danger" onClick={this.handleEliminar}>
                Sí
              </Button>
              <Button className="mx-2" variant="secondary" onClick={this.handleCancelar}>
                No
              </Button>
            </div>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default EliminarProveedores;
