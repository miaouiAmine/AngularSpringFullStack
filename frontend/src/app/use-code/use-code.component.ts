import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";
import {TokenStorageService} from "../auth/token-storage.service";
import {UserfunctionsService} from "../services/userfunctions.service";
import {UtilisationClass} from "../UtilisationClass";
import {UtilisationService} from "../services/utilisation-service.service";
import {el} from "@angular/platform-browser/testing/src/browser_util";

@Component({
  selector: 'app-use-code',
  templateUrl: './use-code.component.html',
  styleUrls: ['./use-code.component.css']
})
export class UseCodeComponent implements OnInit {
  codeText: string;

  constructor(private userService: UserService, private Token: TokenStorageService, private userF: UserfunctionsService  ,private UU:UtilisationService) {
}
utiCode:boolean=true;

  userId: number;

  Reload() {
    location.reload();
  }
  aficherSolde() {
    let userName = this.Token.getUsername();
    this.userId = this.userF.getIdByName(userName);
    if (this.userId != -1 && this.userId != null) {
      this.userF.getSold(this.userId)
    }
  }
UtilU:UtilisationClass[];

  afficherHstoCode(){
    let userName =this.Token.getUsername();
    let id= this.userF.getIdByName(userName);
    this.UtilU=this.UU.getAllUtilUser(id);

  }
  CodeText:string;
  name:string;
  id:number;
  utiliserCode(){
    if(this.CodeText!=""){
      this.name=this.Token.getUsername();
this.id= this.userF.getIdByName(this.name);
      if(this.CodeText==null||this.CodeText==undefined) alert("chain vide")
      else
      this.userF.utiliserCode(this.CodeText,this.id);

    }
  }




  ngOnInit() {
    this.name=this.Token.getUsername();
    this.id=this.userF.getIdByName(this.name);
  }
}

