import React, { Component } from 'react';
import ProveedorService from '../services/ProveedorService';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';

class ObtenerProveedoresComponent extends Component {
  constructor() {
    super();
    this.state = {
      proveedores: [],
    };
  }

  componentDidMount() {
    ProveedorService.obtenerProveedores()
      .then((response) => {
        this.setState({ proveedores: response.data });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div className="container">
        <div className="mt-3 mb-3">
          <Link to="/crearProveedor">
            <Button variant="primary">Crear Proveedor</Button>
          </Link>
        </div>
        <div className="mt-3 mb-3">
          <Link to="/eliminarProveedores">
            <Button variant="primary">Eliminar Proveedores</Button>
          </Link>
        </div>
        <h1>Lista de Proveedores</h1>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>Codigo</th>
              <th>Nombre</th>
              <th>Categoria</th>
              <th>Retencion</th>
            </tr>
          </thead>
          <tbody>
            {this.state.proveedores.map((proveedor) => (
              <tr key={proveedor.codigo}>
                <td>{proveedor.codigo}</td>
                <td>{proveedor.nombre}</td>
                <td>{proveedor.categoria}</td>
                <td>{proveedor.retencion}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    );
  }
}

export default ObtenerProveedoresComponent;
