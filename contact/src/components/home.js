import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Image from '../image/images.png';
import App from '../App'

export class Home extends Component {
  render() {
    return (
      <div style={{marginLeft:"145px"}}>
        <Link to="/addContact">
          <button style={{borderRadius:'150px',marginLeft:'100px'}}>
            <img src={Image} style={{height: '300px',borderRadius:"150px"}}/>
          </button>
        </Link>
        <label style={{margin:"47px",marginLeft:"145px",fontSize:"30px"}}>
         <strong>Creating Contact</strong> 
        </label>
      </div>
    );
  }
}

export default Home;
