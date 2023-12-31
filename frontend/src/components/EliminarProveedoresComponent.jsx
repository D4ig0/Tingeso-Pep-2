import React, { Component } from 'react';
import ProveedorService from '../services/ProveedorService';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';

class EliminarProveedores extends Component {
  handleEliminar = () => {
    ProveedorService.eliminarProveedores();
    window.location.href = "/proveedores";
    alert("Se han eliminado todos los proveedores");
  };

  handleCancelar = () => {
    window.location.href = "/proveedores";
  };

  render() {
    return (
      <Container className="d-flex align-items-center justify-content-center ">
        <Row className="justify-content-center">
          <Col >
            <div className="text-center mb-5">
              <h4>¿Estás seguro que deseas eliminar todos los proveedores?</h4>
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
