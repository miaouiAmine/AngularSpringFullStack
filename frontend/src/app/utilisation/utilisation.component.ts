import { Component, OnInit } from '@angular/core';
import {UtilisationService} from "../services/utilisation-service.service";
import {UtilisationClass} from "../UtilisationClass";

@Component({
  selector: 'app-utilisation',
  templateUrl: './utilisation.component.html',
  styleUrls: ['./utilisation.component.css']
})
export class UtilisationComponent implements OnInit {
idCode:number;
idUser:number;
Util:UtilisationClass[];
UtilU:UtilisationClass[];
UtilC:UtilisationClass[];
Var:string;




getAllUtil(){

  this.Util=this.UtiService.getAllUtil()

}
getUtilUser(){
  if(this.idUser==undefined) alert("type d ID incorrect");
  else
  this.UtilU=this.UtiService.getAllUtilUser(this.idUser)
}



getUtilCode(){

  if(this.idCode==undefined) alert("type d ID incorrect");
  else
    this.UtilC=this.UtiService.getAllUtilCode(this.idCode);

}

relP(){
  location.reload()
}


  constructor(private UtiService:UtilisationService) { }

  ngOnInit() {

  }

}
