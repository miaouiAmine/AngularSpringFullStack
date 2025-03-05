import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class UserfunctionsService {

SoldeUrl="http://localhost:8080/api/test/portMonais/getSoldeById/";
IdUserFromName="http://localhost:8080/api/test/User/UserIdFromName/";

useCodeUrl="http://localhost:8080/api/test/GiftCode/utiliseGiftCode/";
creePortUrl="http://localhost:8080/api/test/portMonais/CreePort/";

  constructor(private http:HttpClient) { }


  getSold(id){
    this.http.get(this.SoldeUrl+id).subscribe((res:string)=>{alert(res)})
  }



id:number;
  getIdByName(name):number{
    this.http.get(this.IdUserFromName+name).subscribe((res:number)=>{this.id=res})
    return this.id;
  }



  utiliserCode(Code:string,id:number){

    this.http.post(this.useCodeUrl+Code+"/"+id,httpOptions).subscribe((res:string)=>{alert(res)})

  }

creePortMonnais(id){
    this.http.post(this.creePortUrl+id,httpOptions).subscribe((res:string)=>{alert(res)})
}
}
