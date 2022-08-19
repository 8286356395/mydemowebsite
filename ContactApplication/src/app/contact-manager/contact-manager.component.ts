import { Component, OnInit } from '@angular/core';

import { ContactService } from '../services/contact.service';
import { MyContact } from '../models/myContact';


@Component({
  selector: 'app-contact-manager',
  templateUrl: './contact-manager.component.html',
  styleUrls: ['./contact-manager.component.css']
})
export class ContactManagerComponent implements OnInit {

  public loading :boolean=false;
  public contacts:MyContact[]=[];
  public errorMesssage:string | null = null;
  

  constructor(private cantService:ContactService) { }

  ngOnInit(): void {
    this.getAllContactData();
   
  }
  getAllContactData(){

    this.loading=true;
    this.cantService.getAllContacts().subscribe((data:MyContact[]) =>
    {
      this.contacts=data;
      this.loading=false;
   
    },(error)=>{
      this.errorMesssage=error;
      this.loading=false;
    });
    

  }

  deleteContact(contactId:string | undefined){
    if(contactId){
      this.cantService.deleteContacts(contactId).subscribe((data:{})=>{
        this.getAllContactData();
      },(error)=>{
        this.errorMesssage=error;
        this.loading= false;

      })
    }
  
  }

}
