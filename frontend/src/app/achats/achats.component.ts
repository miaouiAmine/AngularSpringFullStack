import { Component, OnInit } from '@angular/core';
import {AchatsService} from "../services/achats.service";
import {AchatClass} from "../AchatClass";

@Component({
  selector: 'app-achats',
  templateUrl: './achats.component.html',
  styleUrls: ['./achats.component.css']
})
export class AchatsComponent implements OnInit {
idClient:number;
idCoupon:number;
Var:string;


  AchCli:AchatClass[];
  afficherAchatClient(idClient){
    if(idClient==null||idClient==undefined||idClient<=0)alert("Entere un ID Valid");
    else{
      this.AchCli=this.ach.getAchClient(idClient);
    }
  }


AchCoup:AchatClass[];
  afficherAchatCoupon(idCoupon){
    if(idCoupon==null||idCoupon==undefined||idCoupon<=0)alert("Entere un ID Valid");
    else{
      this.AchCoup=this.ach.getAchCoupon(idCoupon);
    }
  }


  AchAll:AchatClass[];
  TousAchats(){

    this.AchAll=this.ach.getAllAchats();
  }

  constructor(private ach:AchatsService) { }


  ngOnInit() {
  }

}
