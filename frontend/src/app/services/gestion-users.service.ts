import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PortMonnaisClass} from "../PortMonnaisClass";
import {UserClass} from "../UserClass";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};




@Injectable({
  providedIn: 'root'
})
export class GestionUsersService {

  AllUsersUrl="http://localhost:8080/api/test/User/AllUsers";
  deleteUserUrl="http://localhost:8080/api/test/User/deleteUser/";

  AllPortMUrl="http://localhost:8080/api/test/portMonais/getAllPortm";
  BloquerPortUrl="http://localhost:8080/api/test/portMonais/bloquerPort/"
  ActiverPortUrl="http://localhost:8080/api/test/portMonais/activerPort/";





  constructor(private http:HttpClient) { }
PortT:PortMonnaisClass[];
  getAllPort():PortMonnaisClass[]{
this.http.get(this.AllPortMUrl).subscribe((res:PortMonnaisClass[])=>{
  this.PortT=res;
})
    return this.PortT;
  }

ActiverP(id:number){

    this.http.post(this.ActiverPortUrl+id,httpOptions).subscribe((res:string)=>{alert(res)})

}

BloquerP(id:number){

  this.http.post(this.BloquerPortUrl+id,httpOptions).subscribe((res:string)=>{alert(res)})

}

object:UserClass[];
getAllUsers(){
    this.http.get(this.AllUsersUrl).subscribe((data:UserClass[])=>{
      this.object=data;
    })
  return this.object;
}


deleteUser(id){
  this.http.delete(this.deleteUserUrl+id).subscribe((data:string)=>{alert(data)})
}


}
