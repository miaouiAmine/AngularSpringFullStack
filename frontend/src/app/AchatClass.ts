export class AchatClass {
  idAchat:number;
  dateAchat: Date;
  idUser :number;
  idCoupon:number;
  prixCoupon:number
  soldeAvant :number;
  soldeApres :number;





  constructor(idAchat: number, dateAchat: Date, idCoupon: number, PrixCoupon: number, SoldeAvant: number, SoldeApres: number) {
    this.idAchat = idAchat;
    this.dateAchat = dateAchat;
    this.idCoupon = idCoupon;
    this.prixCoupon = PrixCoupon;
    this.soldeAvant = SoldeAvant;
    this.soldeApres = SoldeApres;
  }
}
