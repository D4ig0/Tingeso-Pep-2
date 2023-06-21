import ProveedorService from '../services/ProveedorService';
import React, { Component } from 'react';
import '../styles/EliminarProveedores.css';

class EliminarProveedores extends Component {
    handleEliminar = () => {
        ProveedorService.eliminarProveedores()
        window.location.href = "/proveedores";
        alert("Se han eliminado todos los proveedores")
      };
      
       handleCancelar = () => {
        window.location.href = "/proveedores";
      };
  render() {
  return (
    <div class= "center">
      <p>¿Estás seguro que deseas eliminar todos los proveedores?</p>
      <button class= "eliminar" onClick={this.handleEliminar}> Sí</button>
      <button class= "eliminar" onClick={ this.handleCancelar}>No</button>
    </div>
  );
}
}
export default EliminarProveedores;
