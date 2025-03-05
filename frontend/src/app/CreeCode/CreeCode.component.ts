import {Component, Input, OnInit} from '@angular/core';
import {GiftCodeClass} from "../GiftCodeClass";

import { TokenStorageService } from '../auth/token-storage.service';
import {GiftCodeService} from "../services/gift-code.service";
import {isUndefined} from "util";

@Component({
  selector: 'app-CreeCode',
  templateUrl: './CreeCode.component.html',
  styleUrls: ['./CreeCode.component.css']
})
export class CreeCodeComponent implements OnInit {
@Input()
  codeText: string;
  codeValue :number;
  dateDebut: Date;
  dateFin: Date;
  nbrUtilisation :number;
  reductionParUtilisation:number;
  d1= new Date();
  d2= new Date();

GiftPost = {
  idCode:1,
  codeText: 'a',
  codeValue : 100,
  dateDebut: this.d1,
  dateFin: this.d2,
  nbrUtilisation : 10,
  nbrUtilisationMax: 10,
  reductionParUtilisation:10
}
s:string;
  private dd: Date;
  private df: Date;
  generateCode(){
    this.s= this.GiftCodeService.RandomCode();
    this.codeText=this.s;
  }

 testValid(){
   this.dd=new Date(this.dateDebut);
   this.df=new Date(this.dateFin);
   if(this.codeText==""||this.codeValue==null||this.dateFin<this.dateDebut||this.nbrUtilisation==null||this.reductionParUtilisation==null||this.dateFin==undefined||this.dateDebut==undefined)
     alert("tous les chemps sont obligatoires  \n" +
       "Date debut doit etre inferieur a Date fin");

   else if(this.codeValue!<=0||this.nbrUtilisation<=0||this.reductionParUtilisation<0)
     alert("valeur minimum do code = 1  \n" +
       "valeur minimal de nombre d utilisation = 1 \n" +
       "valeur minimal de reduction par utilisation = 0 \n")
else if(this.reductionParUtilisation!=0 && this.codeValue!=this.nbrUtilisation*this.reductionParUtilisation)
  alert("Valeur Code = nb utilisation * reduction par utilisation")

 else if(this.dd.getTime()>this.df.getTime()) alert("date debut supperieur a date fin")



   else{
  this.GiftPost.codeValue=this.codeValue;
   this.GiftPost.codeText=this.codeText;
   this. GiftPost.reductionParUtilisation=this.reductionParUtilisation;
   this.GiftPost.nbrUtilisation=this.nbrUtilisation;
   this.GiftPost.nbrUtilisationMax=this.nbrUtilisation;
   this.GiftPost.dateFin=this.dateFin;
   this.GiftPost.dateDebut=this.dateDebut;
 this.GiftCodeService.creeCode(this.GiftPost);}

 }

  constructor(private token: TokenStorageService,private GiftCodeService:GiftCodeService) {

  }

  ngOnInit() {

}

}
