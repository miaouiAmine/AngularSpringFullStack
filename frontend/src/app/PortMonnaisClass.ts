export class PortMonnaisClass {


  idPortMonnais : number;
  idUser:number;


  solde:number;


  etat:String;


  constructor(idUser: number, solde: number, etat: String) {
    this.idUser = idUser;
    this.solde = solde;
    this.etat = etat;
  }
}
