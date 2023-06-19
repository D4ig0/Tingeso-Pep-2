import React, { Component } from 'react';
import ProveedorService from '../services/ProveedorService';
import Table from 'rsuite/Table';
import { Button } from 'rsuite';
import { Link } from 'react-router-dom';
import { Column, HeaderCell, Cell } from 'rsuite-table';

// styles

const table = {
  display: 'flex',
  flexDirection: 'column',
  marginTop: '2rem',
  height: '100%',
  marginLeft: '3rem',
  alignItems: 'center',
  justifyContent: 'center',
};
const tamanio = {
  width: '100%',
};
const columnStyles = {
  backgroundColor: '#BCC0B8',
};
const buttonContainer = {
  display: 'flex',
  justifyContent:'center',
  marginBottom: '1rem',
};

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
      <div style={table}>
        <div style={tamanio}>
          <div style={buttonContainer}>
            <Link to="/crearProveedor">
              <Button appearance="primary">Crear Proveedor</Button>
            </Link>
          </div>
          <div style={buttonContainer}>
            <Link to="/eliminarProveedores">
              <Button appearance="primary">Eliminar Proveedores</Button>
            </Link>
          </div>
          <h1>Lista de Proveedores</h1>
          <Table data={this.state.proveedores} autoHeight={true}>
            <Column style={columnStyles} width={150}>
              <HeaderCell>Codigo</HeaderCell>
              <Cell dataKey="codigo" />
            </Column>
            <Column style={columnStyles} width={150}>
              <HeaderCell>Nombre</HeaderCell>
              <Cell dataKey="nombre" />
            </Column>
            <Column style={columnStyles} width={150}>
              <HeaderCell>Categoria</HeaderCell>
              <Cell dataKey="categoria" />
            </Column>
            <Column style={columnStyles} width={150}>
              <HeaderCell>Retencion</HeaderCell>
              <Cell dataKey="retencion" />
            </Column>
            <Column style={columnStyles} width={150}>
              <HeaderCell>Pagos</HeaderCell>
              <Cell dataKey="codigo"></Cell>
            </Column>
          </Table>
        </div>
      </div>
    );
  }
}

export default ObtenerProveedoresComponent;
