import { Component, OnInit } from '@angular/core';
import {GestionUsersService} from "../services/gestion-users.service";
import {PortMonnaisClass} from "../PortMonnaisClass";
import {UserClass} from "../UserClass";



@Component({
  selector: 'app-gestion-utilisateurs',
  templateUrl: './gestion-utilisateurs.component.html',
  styleUrls: ['./gestion-utilisateurs.component.css']
})
export class GestionUtilisateursComponent implements OnInit {
  Ports:PortMonnaisClass[];

Var : string;


  constructor(private gestUsers:GestionUsersService) { }
ReloadPage(){
    location.reload();
}

  getAllPort(){
    this.Ports=this.gestUsers.getAllPort();
    this.Users =this.gestUsers.getAllUsers();
  }

Activer(id:number){
    this.gestUsers.ActiverP(id);
    this.ReloadPage()
}

Bloquer(id:number){
    this.gestUsers.BloquerP(id);
  this.ReloadPage()
}

Users:UserClass[];
getAllUsers(){
  this.Ports=this.gestUsers.getAllPort();
  this.Users =this.gestUsers.getAllUsers();

}

  deleteUser(id:number){
this.gestUsers.deleteUser(id);
}


  ngOnInit() {
  this.Ports=this.gestUsers.getAllPort();
    this.Users =this.gestUsers.getAllUsers();
  }

}
