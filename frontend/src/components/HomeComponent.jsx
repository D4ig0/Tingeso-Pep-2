import React from 'react';
import ReactDOM from 'react-dom';
import { Carousel } from 'rsuite';

const HomeComponent = () => (
  <div style={{ width: '1000px', height: '1000px', margin: 'auto' }}>
    <Carousel className="custom-slider" interval={3000}>
      <img src="https://p4.wallpaperbetter.com/wallpaper/445/7/615/milk-cheese-pitcher-wallpaper-preview.jpg" style={{ width: '100%', height: 'auto' }} alt="Información Nutricional 1" />
      <img src="https://agqlabs.cl/wp-content/uploads/foto-nutricional-basica-1-1.jpg" style={{ width: '100%', height: 'auto' }} alt="Información Nutricional 2" />
    </Carousel>
  </div>
);

ReactDOM.render(<HomeComponent />, document.getElementById('root'));
export default HomeComponent;
