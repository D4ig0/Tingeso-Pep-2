import React, { Component } from 'react';
import ProveedorService from '../services/ProveedorService';
import { Form, Button } from 'react-bootstrap';

class CrearProveedorComponent extends Component {
  constructor() {
    super();
    this.state = {
      nombre: '',
      codigo: '',
      categoria: '',
      retencion: ''
    };
  }

  changeNombreHandler = (event) => {
    this.setState({ nombre: event.target.value });
  }

  changeCodigoHandler = (event) => {
    this.setState({ codigo: event.target.value });
  }

  changeCategoriaHandler = (event) => {
    this.setState({ categoria: event.target.value });
  }

  changeRetencionHandler = (event) => {
    this.setState({ retencion: event.target.value });
  }

  saveProveedor = (e) => {
    e.preventDefault();
    ProveedorService.crearProveedor(this.state.nombre, this.state.codigo, this.state.categoria, this.state.retencion).then(res => {
      window.location.href = "/proveedores";
    });
  }

  render() {
    return (
      <div className="d-flex flex-column align-items-center justify-content-center">
        <h1 className="text-center">Crear Proveedor</h1>
        <div style={{ width: '1000px' }}></div>
        <Form style={{ width: '400px' }}>
          <Form.Group controlId="nombre">
            <Form.Label>Nombre</Form.Label>
            <Form.Control type="text" placeholder="Ingrese el nombre" onChange={this.changeNombreHandler} />
          </Form.Group>

          <Form.Group controlId="codigo">
            <Form.Label>Código</Form.Label>
            <Form.Control type="text" placeholder="Ingrese el código" minLength={5} maxLength={5} onChange={this.changeCodigoHandler} />
          </Form.Group>

          <Form.Group controlId="categoria">
            <Form.Label>Categoría</Form.Label>
            <Form.Control as="select" onChange={this.changeCategoriaHandler}>
              <option value="">Seleccione una categoría</option>
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
            </Form.Control>
          </Form.Group>

          <Form.Group controlId="retencion">
            <Form.Label>Retención</Form.Label>
            <Form.Control as="select" onChange={this.changeRetencionHandler}>
              <option value="">Seleccione una opción</option>
              <option value="Si">Si</option>
              <option value="No">No</option>
            </Form.Control>
          </Form.Group>

          <Button variant="primary" onClick={this.saveProveedor} className="mt-3">Crear Proveedor</Button>
        </Form>
      </div>
    );
  }
}

export default CrearProveedorComponent;
  