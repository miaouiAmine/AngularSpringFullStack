import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CouponClass} from "../CouponClass";
import {GiftCodeClass} from "../GiftCodeClass";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable({
  providedIn: 'root'
})
export class CouponService {
creeCouponUrl="http://localhost:8080/api/test/coupon/addCoupon";
allCouponUrl="http://localhost:8080/api/test/coupon/getAllCoupons";
deleteCouponUtl="http://localhost:8080/api/test/coupon/deleteCouponById/";
  updateURL="http://localhost:8080/api/test/coupon/updateStock/";
effectuerAchatUrl="http://localhost:8080/api/test/achat/effectuerAchat/";


coupon:CouponClass;
  couponT:CouponClass[];




  constructor(private http:HttpClient) { }

getAllCoupon():CouponClass[]{
  this.http.get(this.allCouponUrl).subscribe((res :CouponClass[])=>{
      this.couponT=res;
    }
  );
  return this.couponT;
}

  creeCoupon(coupon){
    this.http.post(this.creeCouponUrl,coupon,httpOptions).toPromise().then((data:any)=>{alert(data);})

  }


  deletCoupon(id){
    this.http.delete(this.deleteCouponUtl + id, httpOptions).subscribe().unsubscribe();
  }

  updateStock(id,stock){
    this.http.post(this.updateURL + id+"/"+stock,httpOptions).subscribe((res:string)=>{alert(res)}
    )
  }

  AchterCoupon(idU:number,idC:number){
    this.http.post(this.effectuerAchatUrl+idU+"/"+idC,httpOptions).subscribe((res:string)=>{alert(res)})
  }

}
