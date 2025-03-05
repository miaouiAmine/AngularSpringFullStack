import { Component, OnInit } from '@angular/core';
import {CouponService} from "../services/coupon.service";

@Component({
  selector: 'app-AjouterCoupon',
  templateUrl: './ajouter-coupon.component.html',
  styleUrls: ['./ajouter-coupon.component.css']
})
export class AjouterCouponComponent implements OnInit {

  idCoupon:number;
  prixCoupon:number;
  descCoupon:string;
  socCoupon:string;
  quantite:number;
  imageSource:string;

  coupon={

    prixCoupon: 10000,
    descCoupon : "coupon",
    socCoupon: "socite coupon",
    quantite: 10,
    imageSource : 'https://www.google.com/search?q=coupon%20image%' +
      '20line&tbm=isch&hl=fr&hl=fr&tbs&rlz=1C1CHBD_frTN754TN754&ved=0' +
      'CAEQpwVqFwoTCIDDq-_GhOoCFQAAAAAdAAAAABAC&biw=1349&bih=657#imgrc=7YdGFgJaLVyFlM',
  }



  ajtCoupon(){
    if(this.prixCoupon==null||this.descCoupon==""||this.socCoupon==""||this.quantite==null||this.imageSource=="")
    alert("tous les chemps sont obligatoires");
    else if(this.prixCoupon<1) alert("prix invalide");
    else if(this.quantite<0) alert("quantite invalide");

    else{
      this.coupon.descCoupon=this.descCoupon;
    this.coupon.socCoupon=this.socCoupon;
    this.coupon.quantite=this.quantite;
    this.coupon.prixCoupon=this.prixCoupon;
    this.coupon.imageSource=this.imageSource;
    this.CoupS.creeCoupon(this.coupon);}
  }
  constructor(private  CoupS:CouponService) { }

  ngOnInit() {
  }

}
