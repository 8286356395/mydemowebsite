import { group } from '@angular/animations';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { MyContact } from '../models/myContact';
import { MyGroup } from '../models/myGroup';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

 // private baseUrl:string = 'https://localhost:4000';

  
  
  constructor(private http:HttpClient) { }
  // Get all data
  public getAllContacts() : Observable<MyContact[]>{
   // console.log(this.baseUrl);
         //let  dataUrl:string ='https://localhost:4000/contacts';
         //console.log(dataUrl);
          return this.http.get<MyContact[]>("http://localhost:4000/contacts").pipe(catchError(this.handleError))
     
  }
  //Get Single Data
  public getContacts(contactId:string) : Observable<MyContact>{
   // let dataUrl:string ='http://localhost:4000/contacts/contactId';
    return this.http.get<MyContact>("http://localhost:4000/contacts/"+contactId).pipe(catchError(this.handleError))
  }
  //Create Contact

  public CreateContacts(contact:MyContact): Observable<MyContact>{
  //  let dataUrl:string ='${this.baseUrl}/contacts';
    return this.http.post<MyContact>("http://localhost:4000/contacts/",contact).pipe(catchError(this.handleError))

  }

  //update Contacts
  public UpdateContacts(contact:MyContact ,contactId:string): Observable<MyContact>{
    //let dataUrl:string ='${this.baseUrl}/contacts/${contactId}';
    return this.http.put<MyContact>("http://localhost:4000/contacts/"+contactId,contact).pipe(catchError(this.handleError))

  }
   //delete contact

   public deleteContacts(contactId:string): Observable<MyContact>{
    let dataUrl:string ='${this.baseUrl}/contacts/${contactId}';
    return this.http.delete<MyContact>("http://localhost:4000/contacts/"+contactId).pipe(catchError(this.handleError))

   }


   // get all groups

   public getAllGroups() : Observable<MyGroup[]>{
    //let dataUrl:string ='${this.baseUrl}/groups';
    return this.http.get<MyGroup[]>("http://localhost:4000/groups").pipe(catchError(this.handleError))
}

// get single group

public getGroups(contact:MyContact) : Observable<MyGroup[]>{
 // let dataUrl:string ='${this.baseUrl}/groups/${contact.groupId}';
  return this.http.get<MyGroup[]>("http://localhost:4000/"+"groups/"+contact.groupId).pipe(catchError(this.handleError))
}
  //errorsolve

  public handleError(error:HttpErrorResponse){
    let errorMessage: string =''
    if(error.error instanceof ErrorEvent){
      errorMessage ='Error :${error.error.message}'
    }else{
      errorMessage='Status:${error.status} \n Message:${error.message}'
    }

    return throwError(errorMessage)
  };
  
}
