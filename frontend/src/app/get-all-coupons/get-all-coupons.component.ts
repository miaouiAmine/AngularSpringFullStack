import { Component, OnInit } from '@angular/core';
import {CouponService} from "../services/coupon.service";
import {CouponClass} from "../CouponClass";

@Component({
  selector: 'app-get-all-coupons',
  templateUrl: './get-all-coupons.component.html',
  styleUrls: ['./get-all-coupons.component.css']
})
export class GetAllCouponsComponent implements OnInit {

coupon:CouponClass[];

idCp:number;
newStock:number;



suppCoupon(idCoup : number){
  this.coupS.deletCoupon(idCoup)
  this.coupon=this.coupS.getAllCoupon()
  location.reload()
}

getAllCoupons(){
  this.coupon=this.coupS.getAllCoupon()
}

  updateStock(){
  if(this.newStock==undefined||this.newStock==null||this.newStock<0)
  alert("enter un valeur non negative")
    else if(this.idCp==null||this.idCp==undefined||this.idCp<=0)
      alert("ID invalide")
    else this.coupS.updateStock(this.idCp,this.newStock);
this.ReloadPage()
}

ReloadPage(){
  location.reload();
}

  constructor(private coupS:CouponService) { }

  ngOnInit() {
    this.coupon=this.coupS.getAllCoupon()
  }


}
