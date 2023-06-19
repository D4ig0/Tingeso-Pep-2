import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NavbarHome from './components/NavbarHomeComponent';
import HomeComponent from './components/HomeComponent';
import CrearProveedor from './components/CrearProveedorComponent';
import ObtenerProveedores from './components/ObtenerProveedoresComponent';


function App() {
  return (
    <BrowserRouter>
      <div>
        <NavbarHome />
        <Routes>
          <Route path="/home" element={<HomeComponent />} />
          <Route path="/proveedores" element={<ObtenerProveedores />} />
          <Route path="/" element={<HomeComponent />} />
          <Route path="/crearProveedor" element={<CrearProveedor />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
