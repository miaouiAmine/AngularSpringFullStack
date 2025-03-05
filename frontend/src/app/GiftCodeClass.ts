


export class GiftCodeClass {
  idCode:number;
  codeText: string;
  codeValue :number;
  dateDebut: Date;
  dateFin: Date;
  nbrUtilisation :number;
  nbrUtilisationMax:number;
  reductionParUtilisation:number;


  constructor(codeText: string, codeValue: number, dateDebut: Date, dateFin: Date, nbrUtilisation: number, nbrUtilisationMax: number, reductionParUtilisation: number) {
    this.codeText = codeText;
    this.codeValue = codeValue;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.nbrUtilisation = nbrUtilisation;
    this.nbrUtilisationMax = nbrUtilisationMax;
    this.reductionParUtilisation = reductionParUtilisation;
  }
}
