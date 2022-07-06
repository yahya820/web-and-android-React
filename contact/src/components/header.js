import React, { Component } from 'react';

export class Header extends Component {
  render() {
    return (
      <div className=''>
        <div style={{backgroundColor:'#e3f2fd', color:'white', textAlign:"center"}} className='navbar-brand navbar-dark bg-dark '>
            <div>
                <h1>Contact Manager</h1>
            </div>
        </div>
      </div>
    );
  }
}

export default Header;
