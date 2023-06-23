import React, { Component } from 'react';
import AcopioService from '../services/AcopioService';
import Table from 'react-bootstrap/Table';

class VisualizarNutricional extends Component {
    constructor() {
        super();
        this.state = {
            acopios: [],
        };
    }

    componentDidMount() {
        AcopioService.obtenerAcopios()
      .then((response) => {
            this.setState({ acopios: response.data });
        })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        return (
            <div className="container">
                <h1>Tabla de información de acopios</h1>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Fecha</th>
                            <th>Kilos de Leche</th>
                            <th>Turno respectivo</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.acopios.map((acopio) => (
                            <tr key={acopio.codigo}>
                                <td>{acopio.codigo}</td>
                                <td>{acopio.fecha}</td>
                                <td>{acopio.kls_leche}</td>
                                <td>{acopio.turno}</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default VisualizarNutricional;
