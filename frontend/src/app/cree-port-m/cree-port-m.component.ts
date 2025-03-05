import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../auth/token-storage.service";
import {UserfunctionsService} from "../services/userfunctions.service";

@Component({
  selector: 'app-cree-port-m',
  templateUrl: './cree-port-m.component.html',
  styleUrls: ['./cree-port-m.component.css']
})
export class CreePortMComponent implements OnInit {

id:number;
  name:string;

  creePort(){
    this.name =this.Token.getUsername();
    this.id= this.US.getIdByName(this.name);
    this.US.creePortMonnais(this.id);
  }



  constructor(private Token:TokenStorageService , private US:UserfunctionsService) { }

  ngOnInit() {
    this.name=this.Token.getUsername();
    this.id=this.US.getIdByName(this.name);
  }

}
