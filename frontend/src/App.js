import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NavbarHome from './components/NavbarHomeComponent';
import HomeComponent from './components/HomeComponent';
import CrearProveedor from './components/CrearProveedorComponent';
import ObtenerProveedores from './components/ObtenerProveedoresComponent';
import EliminarProveedores from './components/EliminarProveedoresComponent';
import SubirArchivos from './components/SubirArchivosComponent';
import GenerarPagos from './components/GenerarPagosComponent';
import MostrarPagos from './components/VisualizarPagosComponent';
import EliminarPagos from './components/EliminarPagosComponent';
import VisualizarNutricional from './components/VisualizarNutricionalComponent';
import VisualizarAcopio from './components/VisualizarAcopiosComponent';


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
          <Route path="/eliminarProveedores" element={<EliminarProveedores />} />
          <Route path="/subirArchivos" element={<SubirArchivos />} />
          <Route path="/generarPagos" element={<GenerarPagos />} />
          <Route path="/mostrarPagos" element={<MostrarPagos />} />
          <Route path="/eliminarPagos" element={<EliminarPagos />} />
          <Route path="/visualizarNutricional" element={<VisualizarNutricional />} />
          <Route path="/visualizarAcopio" element={<VisualizarAcopio />} />



          

        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
