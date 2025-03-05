import { Component, OnInit } from '@angular/core';
import {GiftCodeClass} from "../GiftCodeClass";
import {GiftCodeService} from "../services/gift-code.service";





@Component({
  selector: 'app-all-codes',
  templateUrl: './all-codes.component.html',
  styleUrls: ['./all-codes.component.css']
})
export class AllCodesComponent implements OnInit {
Code : GiftCodeClass[];

  getAllCodes(){

    this.Code=this.GiftCodeService.getAllCodes();
  }


  ReloadPage(){
    window.location.reload();
  }

  deleteCode(idCode: number){
    this.GiftCodeService.deleteCodeById(idCode);
    this.Code=this.GiftCodeService.getAllCodes();
    location.reload();
  }


  constructor(private GiftCodeService:GiftCodeService) {}

  ngOnInit() {
    this.Code=this.GiftCodeService.getAllCodes();
  }

}
