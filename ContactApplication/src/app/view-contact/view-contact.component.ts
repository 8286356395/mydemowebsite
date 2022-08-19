import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { __param } from 'tslib';
import { ContactService } from '../services/contact.service';
import { MyContact } from '../models/myContact';
import { MyGroup } from '../models/myGroup';

@Component({
  selector: 'app-view-contact',
  templateUrl: './view-contact.component.html',
  styleUrls: ['./view-contact.component.css']
})
export class ViewContactComponent implements OnInit {

  public contactId:string |null=null;
  public loading:boolean=false;
  public contact : MyContact={} as MyContact;
  public errorMessage:string |null=null;
  public groups:MyGroup[]=[]as MyGroup[];



  constructor(private activatedRoute:ActivatedRoute,private contServices:ContactService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((__param)=>{
      this.contactId=__param.get('contactId')
    });
    if(this.contactId){
      this.loading=true;
      this.contServices.getContacts(this.contactId).subscribe((data:MyContact)=>{
        this.contact=data;
        this.loading=false;
        this.contServices.getGroups(data).subscribe((data:MyGroup[])=>{
          this.groups=data;
        })
      },
      (error)=>{
        this.errorMessage=error;
        this.loading=false;
      })
   
    }
    
    
    }
 

  public isNotEmpty(){
    return Object.keys(this.contact).length >0;
  } 

}