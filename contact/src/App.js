import './App.css';
import ContactList from './components/contactList';
import Header from './components/header';
import AddContact from './components/addContact';
import 'bootstrap/dist/css/bootstrap.css';
import React,{useState,useEffect} from 'react';
import {Route,Routes,Switch} from 'react-router-dom';
import Home from './components/home';
import Footer from './components/footer';



// import ContactCard from './components/contactCard';

function App(){

  return (
  <div  className=''><Header/>
    <div className='App'>
     <div>
        <div className="container ">
              <div>
                  
                        <Routes>
                              <Route path='/' element={<Home/>}/>
                              <Route path='/addContact'  element={<AddContact/>}/>
                              <Route path='/ContactList' element={<ContactList/>}/>
                              {/* <Route path='/ContactCard' element={<ContactCard/>}/> */}
                              {/* <Route path='/updateContact/:id' element = {<UpdateContact/>}/> */}
                      </Routes>
              </div> 
        </div>
        </div>
    </div><Footer/>
    </div>
  );
}


export default App;
