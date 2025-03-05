import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../auth/token-storage.service";
import {AchatsService} from "../services/achats.service";
import {UserfunctionsService} from "../services/userfunctions.service";
import {AchatClass} from "../AchatClass";

@Component({
  selector: 'app-achats-perso',
  templateUrl: './achats-perso.component.html',
  styleUrls: ['./achats-perso.component.css']
})
export class AchatsPersoComponent implements OnInit {
name:string;
id:number;
achats:AchatClass[];

afichAchat(){
  this.name=this.Token.getUsername();
  this.id=this.UserF.getIdByName(this.name)
  this.achats=this.ach.getAchClient(this.id)
}
  constructor(private Token:TokenStorageService,private ach:AchatsService,private UserF:UserfunctionsService) { }





  ngOnInit() {
    this.name=this.Token.getUsername();
    this.id=this.UserF.getIdByName(this.name)
  }

}
