export class CouponClass {
  idCoupon:number;
   prixCoupon:number;
   descCoupon:string;
   socCoupon:string;
   quantite:number;
   imageSource:string;


  constructor(prixCoupon: number, descCoupon: string, socCoupon: string, quantite: number, imageSource: string) {
    this.prixCoupon = prixCoupon;
    this.descCoupon = descCoupon;
    this.socCoupon = socCoupon;
    this.quantite = quantite;
    this.imageSource = imageSource;
  }
}
