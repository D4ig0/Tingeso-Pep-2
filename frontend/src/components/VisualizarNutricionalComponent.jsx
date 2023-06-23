import React, { Component } from 'react';
import NutricionalService from '../services/NutricionalService';
import Table from 'react-bootstrap/Table';

class VisualizarNutricional extends Component {
  constructor() {
    super();
    this.state = {
      nutricionales: [],
    };
  }

  componentDidMount() {
    NutricionalService.obtenerNutricional()
      .then((response) => {
        this.setState({ nutricionales: response.data });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div className="container">
        <h1>Tabla de información nutricional</h1>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>Código</th>
              <th>Grasa</th>
              <th>Sólidos</th>
            </tr>
          </thead>
          <tbody>
            {this.state.nutricionales.map((nutricional) => (
              <tr key={nutricional.codigo}>
                <td>{nutricional.codigo}</td>
                <td>{nutricional.grasa}</td>
                <td>{nutricional.solidos}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    );
  }
}

export default VisualizarNutricional;
