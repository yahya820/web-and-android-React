import React, { Component } from 'react'
import ContactServices from '../services/contactServices';
import {Link,Route} from 'react-router-dom'
import AddContact from './addContact';


class ContactList extends Component {
     constructor(props) {
          super(props)

         this.state = {
                 contacts: []
         }
        this.addcontact = this.addcontact.bind(this);
        this.editContact = this.editContact.bind(this);
        this.deleteContact = this.deleteContact.bind(this);
        this.viewContact = this.viewContact.bind(this)
      }

      editContact(id){
        this.props.history.push(`/addContact/${id}`)
    }

    deleteContact(id){
        ContactServices.deleteContact(id).then( res => {
            this.setState({contacts: this.state.contacts.filter(ContactList => ContactList.id !== id)});
        });
    }
    viewContact(id){
        this.props.history.push(`/ContactCard/${id}`);
    }


      componentDidMount(){
           ContactServices.getContact().then((res) => {
            this.setState({ contacts: res.data});
        });
      }

    addcontact (){
      this.props.history.push("/addContact")
    }
    push = () => {
        this.props.history.push("addContact")
    }
    render() {
        return (
            <div>
                 <h2 className="text-center">Contact List</h2>
                    <Link to="/addContact"><button className='btn btn-primary'>Add Contact</button></Link>
                 <br/>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <tbody>
                                {
                                    this.state.contacts.map(
                                        ContactList => 
                                        <tr key = {ContactList.id} className=''>
                                             <td>{ ContactList.name} </td>
                                             <td>{ContactList.phone}</td>
                                             <td>{ContactList.email}</td>
                                             <td>{ContactList.address}</td>

                                               
                                             <td className='m-5'>
                                                <Link to="/updateConact/"> <button className="btn btn-info">Update </button></Link>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteContact(ContactList.id)} className="btn btn-danger">Delete </button>
                                                 {/* <button style={{marginLeft: "10px"}} onClick={ () => this.viewContact(ContactList.id)} className="btn btn-info">Update </button> */}
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ContactList;
