import axios from "axios";


const CONTACT_API_BASE_URL = "http://localhost:8080/api/v1/ContactList";
class ContactServices {

        getContact(){
            return axios.get(CONTACT_API_BASE_URL);
        }

        createContact(ContactList){
            return axios.post(CONTACT_API_BASE_URL, ContactList);
            
        }

        deleteContact(ContactId){
            return axios.delete(CONTACT_API_BASE_URL + "/" + ContactId);
        }
        updateContact(contactList, ContactId){
            return axios.put(CONTACT_API_BASE_URL + '/' + ContactId, contactList);
        }
        getContactById(ContactId){
            return axios.get(CONTACT_API_BASE_URL + '/' + ContactId);
        }

}
export default new ContactServices()