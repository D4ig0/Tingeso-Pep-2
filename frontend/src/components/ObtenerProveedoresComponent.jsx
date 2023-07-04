import React, { Component } from 'react';
import ProveedorService from '../services/ProveedorService';
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
    ProveedorService.obtenerProveedores().then((res) => {
      this.setState({
        proveedores: res.data
      });
    });
  }

  renderProveedores() {
    if (!Array.isArray(this.state.proveedores)) {
      return null;
    }

    return this.state.proveedores.map((proveedor) => (
      <tr key={proveedor.codigo}>
        <td>{proveedor.nombre}</td>
        <td>{proveedor.codigo}</td>
        <td>{proveedor.categoria}</td>
        <td>{proveedor.retencion}</td>
      </tr>
    ));
  }

  render() {
    return (
      <div className="container">
        <div className="mt-3 mb-3 d-flex justify-content-between">
          <Link to="/crearProveedor">
            <Button variant="primary">Crear Proveedor</Button>
          </Link>

          <Link to="/eliminarProveedores">
            <Button variant="primary">Eliminar Proveedores</Button>
          </Link>
        </div>

        <h1>Lista de Proveedores</h1>
        <table className="table">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Codigo</th>
              <th>Categoria</th>
              <th>Retencion</th>
            </tr>
          </thead>
          <tbody>{this.renderProveedores()}</tbody>
        </table>
      </div>
    );
  }
}

export default ObtenerProveedoresComponent;
