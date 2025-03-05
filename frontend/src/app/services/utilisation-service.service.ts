import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {GiftCodeClass} from "../GiftCodeClass";
import {UtilisationClass} from "../UtilisationClass";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable({
  providedIn: 'root'
})
export class UtilisationService{
AllUtil:UtilisationClass[];
UtilU:UtilisationClass[];
UtilCode:UtilisationClass[];
  private AllUtilUrl="http://localhost:8080/api/test/Utilisation/getAllUtilisation";
  private  UserUtilUrl="http://localhost:8080/api/test/Utilisation/utilisationClientById/";
  private  CodeUtilUrl="http://localhost:8080/api/test/Utilisation/utilisationCodeIdCode/";

  constructor(private http:HttpClient) { }


  getAllUtil():UtilisationClass[]{
    this.http.get(this.AllUtilUrl).subscribe((res :UtilisationClass[])=>{
        this.AllUtil=res;
      }
    );
    return this.AllUtil;
  }

  getAllUtilUser(id):UtilisationClass[]{
    this.http.get(this.UserUtilUrl + id,httpOptions).subscribe((res :UtilisationClass[])=>{
        this.UtilU=res;
      }
    );
    return this.UtilU;

  }
  getAllUtilCode(id):UtilisationClass[]{
    this.http.get(this.CodeUtilUrl + id,httpOptions).subscribe((res :UtilisationClass[])=>{
        this.UtilCode=res;
      }
    );
    return this.UtilCode;

  }

}
