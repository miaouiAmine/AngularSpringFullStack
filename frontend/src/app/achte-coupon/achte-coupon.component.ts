import { Component, OnInit } from '@angular/core';
import {CouponService} from "../services/coupon.service";
import {AchatsService} from "../services/achats.service";
import {TokenStorageService} from "../auth/token-storage.service";
import {CouponClass} from "../CouponClass";
import {UserfunctionsService} from "../services/userfunctions.service";

@Component({
  selector: 'app-achte-coupon',
  templateUrl: './achte-coupon.component.html',
  styleUrls: ['./achte-coupon.component.css']
})
export class AchteCouponComponent implements OnInit {
name:string;
idUser:number
  coupon:CouponClass[];
  AllCoupons(){
    this.coupon=this.coupS.getAllCoupon();
  }

  getSolde(){
    this.name=this.Token.getUsername();
    this.idUser=this.UU.getIdByName(this.name)
    this.userFuctions.getSold(this.idUser)
  }



  AchterCoupon(id:number){
    this.name=this.Token.getUsername();
    this.idUser=this.UU.getIdByName(this.name)
    this.coupS.AchterCoupon(this.idUser,id)
  }

  constructor(private coupS:CouponService,private achaS:AchatsService,private Token:TokenStorageService,private UU:UserfunctionsService,
              private userFuctions:UserfunctionsService) { }

  ngOnInit() {
    this.coupon=this.coupS.getAllCoupon();
    this.name=this.Token.getUsername();
    this.idUser=this.UU.getIdByName(this.name);

  }

}
