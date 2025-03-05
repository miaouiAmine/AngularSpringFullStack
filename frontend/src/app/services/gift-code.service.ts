import {Host, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, Subscription} from "rxjs";
import {GiftCodeClass} from "../GiftCodeClass";



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable({
  providedIn: 'root'
})
export class GiftCodeService{
allCodes:GiftCodeClass[];

  getAllCodesUrl= "http://localhost:8080/api/test/GiftCode/getAllGiftCodes";
  creeCodeUrl ="http://localhost:8080/api/test/GiftCode/creeGiftCode";
  RandomCodeUrl="http://localhost:8080/api/test/GiftCode/creeGiftCode/randomCode";
  deleteCodeUrl="http://localhost:8080/api/test/GiftCode/deleteGiftCode/";
  constructor(private http:HttpClient) {
  }


  getAllCodes():GiftCodeClass[]{
   this.http.get(this.getAllCodesUrl).subscribe((res :GiftCodeClass[])=>{
     this.allCodes=res;
     }
   );
   return this.allCodes;
}

creeCode(GiftCode : GiftCodeClass){
    this.http.post(this.creeCodeUrl,GiftCode,httpOptions).toPromise().then((data:any)=>{alert(data);})

}

RandomCodeR:string

  RandomCode():string{
     this.http.get(this.RandomCodeUrl).toPromise().then((data:string)=>{
         this.RandomCodeR=data;})

  return  this.RandomCodeR;
}

  deleteCodeById(id:number) {
    this.http.delete(this.deleteCodeUrl + id, httpOptions).subscribe().unsubscribe();


  }

}
