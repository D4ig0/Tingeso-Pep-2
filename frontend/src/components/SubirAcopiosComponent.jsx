import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import AcopioService from '../services/AcopioService';

class SubirAcopios extends Component {
  constructor() {
    super();
    this.state = {
      file: null
    };
  }

  handleFileChange = (event) => {
    this.setState({ file: event.target.files[0] });
  }

  uploadAcopio = () => {
    const { file } = this.state;
    if (file) {
      const formData = new FormData();
      formData.append('file', file);
      AcopioService.subirAcopio(formData)
        .then(res => {
          window.alert("Se subió correctamente el archivo de acopio");
        })
        .catch(error => {
          window.alert("Error al subir el archivo: " + error);
        });
    } else {
      window.alert("No se ha seleccionado ningún archivo.");
    }
  }

  render() {
    return (
      <Form>
        <Form.Group>
          <Form.Control
            type="file"
            onChange={this.handleFileChange}
          />
          
        </Form.Group>
        <Button variant="primary" onClick={this.uploadAcopio}>
          Subir archivo
        </Button>
      </Form>
    );
  }
}

export default SubirAcopios;

