import React, { Component } from 'react';
import '../styles/SubirArchivos.css';
import SubirAcopios from './SubirAcopiosComponent';
import SubirNutricionales from './SubirNutricionalesComponent';

class SubirArchivos extends Component {
  

  render() {
    return (
      <div class= 'center'>
        
        <SubirAcopios />
        <SubirNutricionales />
      </div>
    );
  }
}

export default SubirArchivos;
