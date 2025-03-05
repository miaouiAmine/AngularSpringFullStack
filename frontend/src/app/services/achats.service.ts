import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AchatClass} from "../AchatClass";
import {GiftCodeClass} from "../GiftCodeClass";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class AchatsService {



  getAllAchUrl="http://localhost:8080/api/test/achat/getAllAchats";
  AchatParIDClientUrl="http://localhost:8080/api/test/achat/achatClientByIdUser/";
  AchatParIDCouponUrl="http://localhost:8080/api/test/achat/achatClientByIdCoupon/";

AchAll:AchatClass[];
getAllAchats():AchatClass[]{
  this.http.get(this.getAllAchUrl,httpOptions).subscribe((data:AchatClass[])=>{
    this.AchAll=data;
  })
  return this.AchAll;
}


AchClient:AchatClass[];
  getAchClient(idClient):AchatClass[]{
    this.http.get(this.AchatParIDClientUrl+idClient,httpOptions).subscribe((data:AchatClass[])=>{
      this.AchClient=data;
    })
    return this.AchClient;
  }

  AchCoupon:AchatClass[];
  getAchCoupon(idCoupon):AchatClass[]{
    this.http.get(this.AchatParIDCouponUrl+idCoupon,httpOptions).subscribe((data:AchatClass[])=>{
      this.AchCoupon=data;
    })
    return this.AchCoupon;
  }







  constructor(private http:HttpClient) { }
}
