import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import contactServices from '../services/contactServices';
import ContactList from './contactList';
export class AddContact extends Component {

   constructor(props){
      super(props)
   
         this.state= {
            name :"",
            email:"",
            address :"",
            phone:""
         }
      
      this.changename = this.changename.bind(this);
      this.changeEmail = this.changeEmail.bind(this);
      this.saveContact = this.saveContact.bind(this);
      this.changeAddress = this.changeAddress.bind(this)
      this.changePhone = this.changePhone.bind(this)
      
   }

   saveContact = (e) => {
      if (this.state.name === "" || this.state.phone=== "" || this.state.email === '' || this.state.address===''){
         alert("YOU MUST HAVE FILL ALL COMPONENT")
         e.preventDefault()
      }
         else {
            let contactList = {name : this.state.name, email : this.state.email, address: this.state.address,phone:this.state.phone};
      console.log('ContactList =>' + JSON.stringify(contactList));

      contactServices.createContact(contactList).then((res) =>{
         this.props.history.save('/ContactList');
      });
   }
   }

   changename = (event) =>{
      this.setState({name: event.target.value})
   }


   changeEmail = (event) => {
      this.setState({email: event.target.value})
   }

   changeAddress = (event) =>{
      this.setState({address: event.target.value})
   }

   changePhone =(event)=>{
      this.setState({phone: event.target.value})
   }
   
 

  render() {
    return (
      <div className='coatiner-fluid'>
        <h2>Add Contact</h2>
        <form className='form' onSubmit={this.add}>
           <div className='form-group'>
              <label>Name</label>
              <input type='text' className='form-control' 
              name='name'
              onChange={this.changename}
              value={this.state.name}/>
           </div>
           <div className='form-group'>
              <label>Phone</label>
              <input type='number' className='form-control'
              value={this.state.phone}
              onChange={this.changePhone}/>
           </div>
           <div className='form-group'>
              <label>Email</label>
              <input type='email' className='form-control'
              name='email'
              onChange={this.changeEmail}
              value={this.state.email}/>
           </div>
           <div className='form-group'>
              <label>Address</label>
              <input type='text' className='form-control' 
              value={this.state.address}
              onChange={this.changeAddress}/>
           </div>
           <Link to='/ContactList'><button className='btn btn-primary m-5' onClick={this.saveContact} >Save</button></Link>
            <Link to='/'><button className='btn btn-danger m-5 '>Cancel</button></Link>
        </form>
      </div>
    );
  }
}

export default AddContact;
