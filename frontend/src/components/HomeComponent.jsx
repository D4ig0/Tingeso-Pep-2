import React from 'react';
import ReactDOM from 'react-dom';
import { Carousel } from 'rsuite';

const HomeComponent  = () => (
  <Carousel className="custom-slider">
    <img src="https://via.placeholder.com/600x250/8f8e94/FFFFFF?text=1" height="250" alt="Slide 1" />
    
  </Carousel>
);

ReactDOM.render(<HomeComponent  />, document.getElementById('root'));
export default HomeComponent;