export class UtilisationClass {
  idUtilisation:number;
  dateUtilisation :Date;

  idUser:number;
  idCode:number;
  codeText:String;

  valeurAjouter:number;

  soldeAvant:number;

  soldeApres:number;


  constructor(dateUtilisation: Date, idUser: number, idCode: number, codeText: String, valeurAjouter: number, soldeAvant: number, soldeApres: number) {
    this.dateUtilisation = dateUtilisation;
    this.idUser = idUser;
    this.idCode = idCode;
    this.codeText = codeText;
    this.valeurAjouter = valeurAjouter;
    this.soldeAvant = soldeAvant;
    this.soldeApres = soldeApres;
  }
}
