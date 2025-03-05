import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import {TokenStorageService} from "../auth/token-storage.service";
import {UserfunctionsService} from "../services/userfunctions.service";
import {UtilisationService} from "../services/utilisation-service.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  board: string;
  errorMessage: string;

  username:string;
userId:number;


  getUserSold(){
    let userName =this.Token.getUsername();
    this.userId= this.userF.getIdByName(userName);
    if(this.userId != -1 && this.userId != null){this.userF.getSold(this.userId)}

  }


  constructor(private userService: UserService,private Token:TokenStorageService,private userF:UserfunctionsService) { }











  ngOnInit() {
    this.userService.getUserBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );

  }
}
