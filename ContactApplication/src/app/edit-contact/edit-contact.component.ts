import { Component, OnInit } from '@angular/core';
import { MyContact } from '../models/myContact';
import { MyGroup } from '../models/myGroup';
import { ActivatedRoute, Router } from '@angular/router';
import { __param } from 'tslib';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {

  public  loading :boolean =false;
  public contactId: string | null =null;
  public contact :MyContact ={} as MyContact;
  public errorMessage :string | null=null;
  public group:MyGroup[]=[] as MyGroup[];

  constructor(private ActivatedRoute:ActivatedRoute,private contServices:ContactService,private router:Router) { }

  ngOnInit(): void {
    this.ActivatedRoute.paramMap.subscribe((__param)=>{
      this.contactId = __param.get('contactId')
    });
    if(this.contactId){
      this.contServices.getContacts(this.contactId).subscribe((data:MyContact)=>{
        this.contact = data;
        this.loading =false;
        this.contServices.getAllGroups().subscribe((data:MyGroup[])=>{
          this.group=data;

        })

      },(error)=>{
        this.errorMessage =error;
        this.loading=false;
      }
      )
    }
  }
  submitUpdate(){
    if(this.contactId){
    this.contServices.UpdateContacts(this.contact, this.contactId).subscribe((data:MyContact)=>
    {this.router.navigate(['/']).then();
  },(error)=>{
            this.errorMessage =error;
            this.router.navigate(['/contacts/edit/${this.contactId}']).then();
  })
    }

  }

}
