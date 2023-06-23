import React, { Component } from 'react';
import SubirAcopios from './SubirAcopiosComponent';
import SubirNutricionales from './SubirNutricionalesComponent';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';

class SubirArchivos extends Component {
  handleVisualizarAcopio = () => {
    window.location.href = "/visualizarAcopio";
  };

  handleVisualizarNutricional = () => {
    window.location.href = "/visualizarNutricional";}

  render() {
    return (
      <Container className="text-center">
        <Row className="justify-content-center">
          <Col md={6} className="bg text-white p-3" style={{ background: '#94ACA9' }}>
            <h3>Subir Archivo de Acopios</h3>
            <p>El archivo debe ser formato CSV con el siguiente nombre:</p>
            <p>'Acopio.csv' </p>
            <SubirAcopios />
            <Button variant="secondary" onClick={this.handleVisualizarAcopio}>
              Visualizar Acopio
            </Button>
          </Col>
        </Row>
        <Row className="justify-content-center mt-3">
          <Col md={6} className="bg text-white p-3" style={{ background: '#94ACA9' }}>
            <h3>Subir Archivos de Información Nutricional</h3>
            <p>El archivo debe ser formato CSV con el siguiente nombre:</p>
            <p>'Nutricional.csv' </p>
            <SubirNutricionales />
            <Button variant="secondary" onClick={this.handleVisualizarNutricional}>
              Visualizar Nutricional
            </Button>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default SubirArchivos;
