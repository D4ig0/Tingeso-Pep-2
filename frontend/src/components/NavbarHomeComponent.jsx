import React from 'react';
import { Button } from 'rsuite';
import { Link } from 'react-router-dom';
import "rsuite/dist/rsuite.min.css";

// STYLES
const titleStyles = {
  float: 'left',
  marginLeft: '4rem',
  fontFamily: 'Staatliches',
  fontWeight: 'bold',
  fontSize: '4rem',
  color: 'white',textDecoration: 'none',
  transition: 'none',
  


};

const backgroundStyles = {
  backgroundColor: '#83B8F7',
  height: '6rem',
  display: 'flex',
  justifyContent: 'space-between',
  alignItems: 'center',
  padding: '0 2rem',
};



const boton = {
  backgroundColor: 'transparent',
  border: 'none',
  padding: '20px',
  color: 'white',
  fontWeight: 'bold',
  fontsize: 'x-large',
  transform: 'rotate(-2deg)',
  fontFamily: 'Staatliches',
  fontSize: '1.4rem',
  width: '12rem',
  
}

const fondoBoton ={
  backgroundColor: 'black',
  width: '12rem',
  overflow: 'hidden',
  display: 'inline-block',
  borderRadius: '25px',
  boxShadow: '0 0 20px rgba(0, 0, 0, 0.5)',
  transform: 'rotate(2deg)',
  textAlign: 'center', 
  marginRight: '1rem', 
}

const NavbarHome = () => {
  return (
    <nav style={backgroundStyles}>
      <Link to="/" style={titleStyles}>MilkStgo</Link>
      <div>
          <div style={fondoBoton}>
          <Button href ='/proveedores'style={boton}> Proveedores</Button>
          </div>
          <div  style={fondoBoton}>
          <Button  href ='/subirArchivos' style={boton}>Subir Archivos</Button>
          </div>
          <div style={fondoBoton}>
          <Button href ='/generarPagos' style={boton}>Pagos</Button>
          </div>
      </div>
    </nav>
  );
};

export default NavbarHome;
